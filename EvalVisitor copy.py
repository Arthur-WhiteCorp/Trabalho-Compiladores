from MiniCVisitor import MiniCVisitor
from MiniCParser import MiniCParser


class EvalVisitor(MiniCVisitor):

  def __init__(self):
    self.symbol_table = {}
    self.function_names={}
    self.contador=0
    self.erros = []
    self.escope = "global"

  def visitProgram(self, ctx: MiniCParser.ProgramContext):
    self.symbol_table[self.escope] = {}
    result = super().visitProgram(ctx)
    print("Erros encontrados:", self.erros)  # mostrar lista de erros depois de visita
    return result


  def add_error(self, message, ctx):
    line = ctx.start.line
    self.erros.append(f"Line {line}: {message} ")

  def visitFunction_body(self, ctx: MiniCParser.Function_bodyContext):
    #aqui pega o nome da funcao
    self.escope = ctx.parentCtx.getChild(1).getChild(0).getText()
    self.symbol_table[self.escope] = {}
    return super().visitFunction_body(ctx)

  def visitFunction_definition(self, ctx: MiniCParser.Function_definitionContext):
    lista=list(ctx.getChildren())
    # print("Posicoes")
    #print([(i,j.getText()) for i,j in enumerate(lista)])
    tipo_funcao = ctx.getChild(0).getText()
    print("TIPOS=",tipo_funcao)
    #'factorial(intn)'
    nome_funcao = ctx.getChild(1).getText().split('(')[0]

    if nome_funcao in self.symbol_table:
      self.add_error(f" 1- Error function '{nome_funcao}' already declared.", ctx)
    else:
      self.function_names[nome_funcao] = tipo_funcao
    return self.visitChildren(ctx)

  def visitFunction_header(self, ctx: MiniCParser.Function_headerContext):
    return self.visitChildren(ctx)
  
  
  # Verificar declaração de variáveis
  def visitData_definition(self, ctx: MiniCParser.Data_definitionContext):
    print("ESSE É O VISIT DATA DEFINITION")
    l = list(ctx.getChildren())
    tipo = l[0].getText()
    if (str(ctx.parentCtx.parentCtx.__class__.__name__) == "ProgramContext"):  # verifica se está no escopo global
      for i in range(1, len(l), 2):
        nome = l[i].getText()
        if nome in self.symbol_table["global"]:
          self.add_error(f" 1- Error variable '{nome}' already declared.", ctx)
        else:
          self.symbol_table["global"][nome] = tipo
    else:
      for i in range(1, len(l), 2):
        nome = l[i].getText()
        if nome in self.symbol_table[self.escope]:
          self.add_error(f"2 -Error variable '{nome}' already declared.", ctx)
        else:
          self.symbol_table[self.escope][nome] = tipo
    return self.visitChildren(ctx)
  
  # Verificar compatibilidade dos tipos nas expressões
  
  def visitAtribuicao(self, ctx: MiniCParser.AtribuicaoContext):
    jaDeuErro=False # flag indicando se já ocorreu algum erro
    print("ESSE É O VISIT ATRIBUICAO")
    nome1 = ctx.getChild(0).getText()
    variableExists = False

    for key in self.symbol_table:
      if nome1 in self.symbol_table[key]:
        variableExists = True
        break
    if not variableExists:
      self.add_error(f"3 - Error variable '{nome1}' not declared.", ctx)
      jaDeuErro=True
   
    tipo1=None
    for escopos in self.symbol_table:
      for vars in self.symbol_table[escopos]:
        if nome1 == vars:
          tipo1 = self.symbol_table[escopos][vars]
          
    lista=list(ctx.getChildren())
    self.contador+=1
    print(self.contador)
    print("Lista de filhos:", [i.getText() for i in lista])
    
    #-------------------------MARCA--------------------------------------
    tipo2=None
    # ver se é função ou variavel, pega  pra ver se tem parentese, se tem parentese pode ser expressao ou funcao
    nome_intermediario = ctx.getChild(2).getText()
    index_parenteses = nome_intermediario.find('(') # procura por algum parentese
    #se for diferente de -1 achou, se for diferente de 0 tem algo antes então é uma função
    eh_funcao=False
    if index_parenteses != -1 and index_parenteses != 0:
      eh_funcao=True
    #nome formatado
    nome2=nome_intermediario.split('(')[0]

    if eh_funcao and nome2 not in self.function_names:
      self.add_error(f"3 - Error function '{nome2}' not declared.", ctx)
      jaDeuErro=True
    elif eh_funcao and nome2 in self.function_names:
      tipo2 = self.function_names[nome2]

    print("Nome2=",nome2)
    #print(type(nome2))
    if nome2.isdigit():
      print("Nome2 é um dígito")
      tipo2 = 'int'
    #se o tamanho eh 3 entao eh um caractere entre aspas simples 'a', se o caractere eh menor igual a 127 ele pertence a tabela ascii
    #se ele colocar um caractere que nao eh ascii vai continuar None e ai tem que botar esse tipo de erro
    elif len(nome2) == 3 and nome2[0] == "'" and nome2[2] == "'" and ord(nome2[1]) <=127:
      tipo2 = 'char'
     
    variableExists=False
    for key in self.symbol_table:
      if nome2 in self.symbol_table[key]:
        variableExists = True
        break
    if not variableExists and tipo2 is None and not jaDeuErro:
      self.add_error(f"10 - Error variable '{nome2}' not declared.", ctx)
      jaDeuErro = True # erro de var não declarada

    
    for escopos in self.symbol_table:
      for vars in self.symbol_table[escopos]:
        if nome2 == vars:
          tipo2 = self.symbol_table[escopos][vars]
    

    print(f"Tipo 1: {tipo1} e Tipo 2: {tipo2}\n")

    #se o tipo 2 existe ele eh char ou int
    if tipo2 is not None and (tipo1) != (tipo2) and not jaDeuErro:
      self.add_error(f"14 - Error incompatible types '{tipo1}' and '{tipo2}'", ctx)
    elif tipo2 is None and not jaDeuErro:
      self.add_error("6 - Error unknown expression", ctx)
    # print("Dicionarios")
    # print(self.symbol_table)
    # print(self.function_names)
    return self.visitChildren(ctx)


  def visitStatement(self,ctx: MiniCParser.StatementContext):
    print("ENTROU NO  (Visit Statement)")
    lista=list(ctx.getChildren())


    #print('Lista separada: ', lista )
    print('Itens da lista: ', [(i , j.getText()) for i,j in enumerate(lista)])
    print(ctx.start.line)

    return self.visitChildren(ctx)


  def visitAdicao(self, ctx: MiniCParser.AdicaoContext):
    print("--- ESTAMOS NO VISIT ADIÇÃO!!!! --- ")
    print([i.getText() for i in list(ctx.getChildren())])

    #var, literal, funcao
    tipo1=None
    #ver se eh funcao ou variavel, pega  pra ver se tem parentese, se tem parentese pode ser expressao ou funcao
    nome_intermediario = ctx.getChild(2).getText()
   
    #factorial (int n)
    index_parenteses = nome_intermediario.find('(')
  
    #se for diferente de -1 achou, se for diferente de 0 tem algo antes entao eh funcao
    #a_b(5+2)
    eh_funcao=False
    if index_parenteses != -1 and index_parenteses != 0:
      eh_funcao=True
  
    #nome formatado
    nome1 = nome_intermediario.split('(')[0]
  
    if eh_funcao and nome1 not in self.function_names:
      self.add_error(f"3 - Error function '{nome1}' not declared.", ctx)
      return self.visitChildren(ctx)
    elif eh_funcao and nome1 in self.function_names:
      tipo1 = self.function_names[nome1]
  
  
  
    #print(type(nome1))
    if nome1.isdigit():
      tipo1 = 'int'
    #se o tamanho eh 3 entao eh um caractere entre aspas simples 'a', se o caractere eh menor igual a 127 ele pertence a tabela ascii
    #se ele colocar um caractere que nao eh ascii vai continuar None e ai tem que botar esse tipo de erro
    elif len(nome1) == 3 and nome1[0] == "'" and nome1[2] == "'" and ord(nome1[1]) <=127:
      tipo1 = 'char'
  
  
    variableExists=False
    for key in self.symbol_table:
      if nome1 in self.symbol_table[key]:
        variableExists = True
        break
    if not variableExists and tipo1 is None:
      self.add_error(f"10 - Error variable '{nome1}' not declared.", ctx)
      return self.visitChildren(ctx)
  
  
    for escopos in self.symbol_table:
      for vars in self.symbol_table[escopos]:
        if nome1 == vars:
          tipo1 = self.symbol_table[escopos][vars]
  
  #-------------------------------- MARCO ADIÇÃO 2------------------------
    tipo2=None
    #ver se eh funcao ou variavel, pega  pra ver se tem parentese, se tem parentese pode ser expressao ou funcao
    nome_intermediario = ctx.getChild(2).getText()
    #factorial (int n)
    index_parenteses = nome_intermediario.find('(')
  
    #se for diferente de -1 achou, se for diferente de 0 tem algo antes entao eh funcao
    #a_b(5+2)
    eh_funcao=False
    if index_parenteses != -1 and index_parenteses != 0:
      eh_funcao=True
  
    #nome formatado
    nome2=nome_intermediario.split('(')[0]
  
    if eh_funcao and nome2 not in self.function_names:
      self.add_error(f"3 - Error function '{nome2}' not declared.", ctx)
      return self.visitChildren(ctx)
    elif eh_funcao and nome2 in self.function_names:
      tipo2 = self.function_names[nome2]
  
  
  
  
    #print(type(nome2))
    if nome2.isdigit():
    
      tipo2 = 'int'
    #se o tamanho eh 3 entao eh um caractere entre aspas simples 'a', se o caractere eh menor igual a 127 ele pertence a tabela ascii
    #se ele colocar um caractere que nao eh ascii vai continuar None e ai tem que botar esse tipo de erro
    elif len(nome2) == 3 and nome2[0] == "'" and nome2[2] == "'" and ord(nome2[1]) <=127:
      tipo2 = 'char'
  
  
    variableExists=False
    for key in self.symbol_table:
      if nome2 in self.symbol_table[key]:
        variableExists = True
        break
    if not variableExists and tipo2 is None:
      self.add_error(f"10 - Error variable '{nome2}' not declared.", ctx)
      return self.visitChildren(ctx)
  
  
    for escopos in self.symbol_table:
      for vars in self.symbol_table[escopos]:
        if nome2 == vars:
          tipo2 = self.symbol_table[escopos][vars]
  
  
    #print("tipos 1  e 2 = ",tipo1,tipo2)
    #print("---")
  
    #se o tipo 2 existe ele eh char ou int
    if tipo2 is not None and (tipo1) != (tipo2):
      self.add_error(f"4 - Error incompatible types '{tipo1}' and '{tipo2}'", ctx)
    elif tipo2 is None:
      self.add_error("6 - Error unknown expression", ctx)
  
    #print("Dicionarios")
    #print(self.symbol_table)
    #print(self.function_names)
  
    return self.visitChildren(ctx)

from MiniCVisitor import MiniCVisitor
from MiniCParser import MiniCParser

class EvalVisitor(MiniCVisitor):

  def __init__(self):
    self.symbol_table = {}
    self.function_names={}
    self.linhas = {} # dicionário para salvar a informação das linhas do código
    self.contador=0
    self.erros = []
    self.escope = "global"
    self.unarios = [] # vetor para armazenar os unários

  def avaliacaoExpressao(self, numero_linha,tipo1,conteudo):
      #(5/2+fatorial(n)-c)
    for item in conteudo:
        simbolos=['=', '+', '-=', '*=', '/=', '%=', '==', '!=', '<=', '>=', '>', '<', '+', '-', '*', '/', '%']
        simbolos.append('(')
        simbolos.append(')')
        if item in simbolos: continue

        #FUNCAO
        tipo2=None
        nome_intermediario=item
        index_parenteses=nome_intermediario.find('(')
      

  def avaliacaoLinhaInteira(self,dicio) :
    # percorrer dict e analisar cada elemento do vetor
    for numero_linha, conteudo in dicio.items():

      #ESQUERDA
      print(f'Linha {numero_linha}')
      #todo mundo  que eh impar vai rodar
      #o primeiro determina a direita
      #d = 5 + 20 + 30 * 2 + fat(5+2);
      # print("primeiro cara a esquerda=",conteudo[0])
      nome1 = conteudo[0]

      print("Nome1=",nome1)

      variableExists=False
      for key in self.symbol_table:
        if nome1 in self.symbol_table[key]:
          variableExists = True
          break
      if not variableExists:
        self.add_error_alt(f"3 - Error variable '{nome1}' not declared.", numero_linha)
        continue

      tipo1=None
      for escopos in self.symbol_table:
         for vars in self.symbol_table[escopos]:
             if  nome1 ==  vars:
                 tipo1 = self.symbol_table[escopos][vars]

      print('Tipo1 = ',tipo1)

      #DIREITA
      #pula se for o primeiro ou se for simbolo terminal
      for item in conteudo:
        # vamos analisar os itens do vetor
        # Verificando o identificador da direita
        
        if item == nome1: continue
        simbolos=['=', '+', '-=', '*=', '/=', '%=', '==', '!=', '<=', '>=', '>', '<', '+', '-', '*', '/', '%']
        if item in simbolos: continue
        
        #FUNCAO
        tipo2=None
        nome_intermediario=item
        index_parenteses=nome_intermediario.find('(')

        eh_funcao=False
        #ele existe mas nao  eh o primeiro
        if index_parenteses > 0:
          eh_funcao=True
        elif index_parenteses == 0:
          print("Nome_expressao=",nome_intermediario)                                                
          self.avaliacaoExpressao(numero_linha,tipo1,nome_intermediario)

        nome2=nome_intermediario.split('(')[0]

        if eh_funcao and nome2 not in self.function_names:
          self.add_error_alt(f"3 -  Error function '{nome2}' not declared",numero_linha)
          continue
        elif eh_funcao and nome2 in self.function_names:
          tipo2=self.function_names[nome2]

        print("Nome2=",nome2)

        #LITERAL
        if nome2.isdigit():
          tipo2='int'
        elif len(nome2) == 3 and nome2[0] == "'" and nome2[2] == "'" and ord(nome2[1]) <=127:
          tipo2='char'

        #VARIAVEL
        variableExists=False
        for key in self.symbol_table:
          if nome2 in self.symbol_table[key]:
            variableExists=True
            break
        if not variableExists and tipo2 is None:
          self.add_error_alt(f"10- Error variable '{nome2} not declared'",numero_linha)
          continue

        for escopos in self.symbol_table:
          for vars in self.symbol_table[escopos]:
            if nome2 == vars:
              tipo2 = self.symbol_table[escopos][vars]

        print(f"Tipo 1: {tipo1} e Tipo 2: {tipo2}\n")

        if tipo2 is not None and tipo1 != tipo2:
          self.add_error_alt(f"14 - Error incompatible types '{tipo1}' and '{tipo2}'",numero_linha)
        elif tipo2 is None:
          self.add_error_alt(f"6 - Error unknow expression",numero_linha)


  # processamento dos unários
  def __del__(self):
    #print("Sera=?",self.unarios) # na esquerda a linha, na direita o conteudo

    dicio = {}

    for chave, valor in self.unarios:
      if chave not in dicio:
        dicio[chave] = []
      dicio[chave].append(valor)

    print('DICIO', dicio)

    self.avaliacaoLinhaInteira(dicio)

    for k in self.erros:
      print(k)




  def visitProgram(self, ctx: MiniCParser.ProgramContext):
    self.symbol_table[self.escope] = {}
    result = super().visitProgram(ctx)
    return result


  def add_error(self, message, ctx):
    line = ctx.start.line
    self.erros.append(f"Line {line}: {message} ")

  def add_error_alt(self, message, line):
    self.erros.append(f"Line {line}: {message} ")

  def visitFunction_body(self, ctx: MiniCParser.Function_bodyContext):
    # aqui seleciona o nome da funcao
    self.escope = ctx.parentCtx.getChild(1).getChild(0).getText()
    self.symbol_table[self.escope] = {}
    return super().visitFunction_body(ctx)

  def visitFunction_definition(self, ctx: MiniCParser.Function_definitionContext):
    lista=list(ctx.getChildren())
    # print("Posicoes")
    # print([(i,j.getText()) for i,j in enumerate(lista)])
    tipo_funcao = ctx.getChild(0).getText()
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

  def visitBinary(self, ctx: MiniCParser.BinaryContext):
    l = list(ctx.getChildren())
    print([i.getText() for i in l])
    print('Contexto: ', str(ctx.__class__.__name__))
    
    for i in range(len(l)):
      if str(l[i].__class__.__name__) == "BinaryContext" and l[i].getChildCount() > 1:
        print("Expressão Binária: ")
        l2 = l[i]
        print(l2.getText())
        self.visit(l2)
      else:
        print('Expressão Unária: ')
        l2 = l[i]
        print(l2.getText())
        
        self.unarios.append((ctx.start.line,l2.getText())) # o vetor tem tuplas com a informação da linha

    return 
  

 
  

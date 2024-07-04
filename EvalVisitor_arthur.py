from MiniCVisitor import MiniCVisitor
from MiniCParser import MiniCParser

class AddressOutput():
  def __init__(self):
    self.translation = ""
    self.count = 1
  def addDataDefinition(self,dataDef):
    variables = dataDef.split(",")
    text = variables[0]
    listSize = len(variables)
    if text.find("int") == 0:
      variables[0] = text[3:]
      lasVarSize = len(variables[listSize-1])
      variables[listSize-1] = variables[listSize-1][0:lasVarSize-1] 
      type = text[0:3]
    elif text.find("char") == 0:
      variables[0] = text[4:]
      lasVarSize = len(variables[listSize-1])
      variables[listSize-1] = variables[listSize-1][0:lasVarSize-1]
      type = text[0:4]      
   
    for var in variables:
      self.translation += type + " "
      self.translation += var + ";"
      self.translation += "\n"
    print(self.translation)
  def addBinary(self,lineVector:list,lineNum:int):
    myLine = []
    symbols = ['=', '+', '-=', '*=', '/=', '%=', '==', '!=', '<=', '>=', '>', '<', '+', '-', '*', '/', '%']
    translation = ""
    for item in lineVector:
      if item[0] == lineNum:
        myLine.append(item)
    finalVar = myLine[0][1]
    size = len(myLine) 
   
    for operando in range(3,size,2):
      pos1 = myLine[operando-1][1]
      pos2 = myLine[operando][1]
      pos3 = myLine[operando+1][1]
      if operando == 3:    
        translation += 'T' + str(self.count) +" " +'=' + " " + pos1 + " " + pos2 + " " + pos3 + "\n"
        self.count += 1
      elif operando+2 < size:
        translation += 'T' + str(self.count)+ " " +'=' + " " + 'T' + str(self.count-1)+ " " + pos2 + " " + pos3 + "\n"
        self.count += 1
      else:
        translation += finalVar+ " " + myLine[1][1] + " " + 'T' + str(self.count-1)+ " " + pos2 + " " + pos3 + "\n"
    print(myLine)
    print(translation)
class EvalVisitor(MiniCVisitor):

  def __init__(self):
    self.symbol_table = {} #variaveis e seus escopos
    self.function_names={} #nome de funcoes e tipos de funcoes
    self.linhas = {} # dicionário para salvar a informação das linhas do código
    self.function_args = {} # nome e argumentos de uma função
    self.contador=0
    self.erros = []
    self.escope = "global"
    self.unarios = [] # vetor para armazenar os unários
    self.translator = AddressOutput()
    self.binaryControler = 0
  def avaliacaoExpressao(self, numero_linha,tipo1,conteudo):
      #(5/2+f(n)-c)
    for item in conteudo:
        simbolos=['=', '+', '-=', '*=', '/=', '%=', '==', '!=', '<=', '>=', '>', '<', '+', '-', '*', '/', '%']
        simbolos.append('(')
        simbolos.append(')')
        if item in simbolos: continue

        #FUNCAO
        tipo2=None
        nome_intermediario=item
        index_parenteses=nome_intermediario.find('(')

  
  def avaliacaoFuncao(self,numero_linha:int,chamada_da_funcao:str):
    # 'factorial(n,2,dec,'2'))'
    #chamada
    eh_mesmo_tamanho = False
    nome_funcao = chamada_da_funcao.split('(')[0]
    numero_de_argumentos_chamada=chamada_da_funcao.count(',')+1


    #declaracao
    tipos_original = self.function_args[nome_funcao] # pega os tipos que devem estar nos argumentos
    numero_de_argumentos_declaracao=len(tipos_original)

    #erros
    #quantidade de argumentos
    if numero_de_argumentos_chamada != numero_de_argumentos_declaracao:
      self.add_error_alt(f"Expected '{numero_de_argumentos_declaracao}' args but received '{numero_de_argumentos_chamada}' in the '{nome_funcao}' function",numero_linha)
    else:
      eh_mesmo_tamanho = True
      
    #argumentos = chamada_da_funcao.split('(')[1].split(')') # argumentos passados para a função quando foi chamada
    primeiro_parentese=chamada_da_funcao.find('(')
    ultimo_parentese = chamada_da_funcao.rfind(')')

    argumentos=''
    for i in range(primeiro_parentese+1,ultimo_parentese):
      argumentos += chamada_da_funcao[i]      

    argumentos = argumentos.split(',')
    
    # del argumentos[0]
    # del argumentos[-1]
#    print("ARGUMENTOOOOOOOOOOOS: ", argumentos)
    args_individuais = [a.strip() for arg in argumentos for a in arg.split(',')]

#    print("ARGS INDIVIDUAIS: ", args_individuais)

    if eh_mesmo_tamanho:
      for i in range(len(args_individuais)):
#        print("Arg atual",args_individuais[i])
        # if arg.isdigit():
        #   print('Achei um numero inteiro: ', arg)
        # else:
        #   print('Não é inteiro: ', arg)
        tipo2 = None
        #FUNCAO
        nome_intermediario=args_individuais[i]
#        print('Nome intermediário: ', nome_intermediario)
        index_parenteses=nome_intermediario.find('(')

        eh_funcao=False
        #ele existe mas nao  eh o primeiro
        if index_parenteses > 0:
#          print("Detectou que eh funcao")
          eh_funcao=True
        elif index_parenteses == 0:
          pass

        nome2=nome_intermediario.split('(')[0]
#        print("NOME2: ",nome2)

        if eh_funcao and nome2 not in self.function_names:
          self.add_error_alt(f"Error function '{nome2}' not declared",numero_linha)
          continue
        elif eh_funcao and nome2 in self.function_names:
          tipo2=self.function_names[nome2]
          # sei que é uma função declarada, agora vamos verificar a lista de args
          #print("CASO RECURSIVO",nome_intermediario)
          #self.avaliacaoFuncao(numero_linha,nome_intermediario)


        #LITERAL
        if nome2.isdigit():
          tipo2 = 'int'
        elif len(nome2) == 3 and nome2[0] == "'" and nome2[2] == "'" and ord(nome2[1]) <=127:
          tipo2 = 'char'

        
        #variavel
        variableExists=False
        for key in self.symbol_table:
          if nome2 in self.symbol_table[key]:
            variableExists = True
            break
        if not variableExists and tipo2 is None:
          self.add_error_alt(f"Error variable '{nome2}' not declared.", numero_linha)
          continue

        
        for escopos in self.symbol_table:
          for vars in self.symbol_table[escopos]:
            if nome2 ==  vars:
              tipo2 = self.symbol_table[escopos][vars]
          

        #ultima coisa
        if tipo2 != tipos_original[i]:
          self.add_error_alt(f"Expected type '{tipos_original[i]}' but received '{tipo2}' in position {i+1} in function '{nome_funcao}'", numero_linha)



  def avaliacaoLinhaInteira(self,dicio) :
    # percorrer dict e analisar cada elemento do vetor
    for numero_linha, conteudo in dicio.items():

      #ESQUERDA

      #----funcao
      tipo1=None
      nome_intermediario=conteudo[0]
      index_parenteses=nome_intermediario.find('(')

      eh_funcao=False

      if index_parenteses>0:
        eh_funcao=True
      elif index_parenteses==0:
        #self.avaliacaoExpressao(numero_linha,)
        #nao posso avaliar, esse return depende do tipo da funcao em que ele encontra
        pass


      nome1=nome_intermediario.split('(')[0]
       
      if  eh_funcao and nome1 not in self.function_names:
        self.add_error_alt(f"Error function '{nome1}' not declared", numero_linha)
      elif eh_funcao and nome1 in self.function_names:
        tipo1=self.function_names[nome1]
        self.avaliacaoFuncao(numero_linha,conteudo[0])


      #--literal
      if nome1.isdigit():
        tipo1='int'
      elif len(nome1) == 3 and nome1[0] == "'" and nome1[2] == "'" and ord(nome1[1]) <=127:
        tipo1='char'

    
      # --- Variavel ---
      if not eh_funcao:

        variableExists=False
        for key in self.symbol_table:
          if nome1 in self.symbol_table[key]:
            variableExists=True
            break
        if not variableExists and tipo1 is None:
          self.add_error_alt(f"Error variable '{nome1} not declared'",numero_linha)

        for escopos in self.symbol_table:
          for vars in self.symbol_table[escopos]:
            if nome1 == vars:
              tipo1 = self.symbol_table[escopos][vars]


      #DIREITA
      #pula se for o primeiro ou se for simbolo terminal
      for item in conteudo:
        # vamos analisar os itens do vetor
        # Verificando o identificador da direita
        
        if item == nome1: continue
        simbolos=['=', '+', '-=', '*=', '/=', '%=', '==', '!=', '<=', '>=', '>', '<', '+', '-', '*', '/', '%']
        if item in simbolos: continue
        
        # --- Função ---
        tipo2=None
        nome_intermediario=item
        index_parenteses=nome_intermediario.find('(')

        eh_funcao=False
        #ele existe mas nao  eh o primeiro
        if index_parenteses > 0:
          eh_funcao=True
        elif index_parenteses == 0:
          self.avaliacaoExpressao(numero_linha,tipo1,nome_intermediario)

        nome2=nome_intermediario.split('(')[0]

        if eh_funcao and nome2 not in self.function_names:
          self.add_error_alt(f"Error function '{nome2}' not declared",numero_linha)
          continue
        elif eh_funcao and nome2 in self.function_names:
          tipo2=self.function_names[nome2]
          # sei que é uma função declarada, agora vamos verificar a lista de args
          self.avaliacaoFuncao(numero_linha,item)
          

       # print("Nome2=",nome2)

        # --- Literal ---
        if nome2.isdigit():
          tipo2='int'
        elif len(nome2) == 3 and nome2[0] == "'" and nome2[2] == "'" and ord(nome2[1]) <=127:
          tipo2='char'

        # --- Variavel ---
        variableExists=False
        for key in self.symbol_table:
          if nome2 in self.symbol_table[key]:
            variableExists=True
            break
        if not variableExists and tipo2 is None:
          self.add_error_alt(f"Error variable '{nome2} not declared'",numero_linha)
          continue

        for escopos in self.symbol_table:
          for vars in self.symbol_table[escopos]:
            if nome2 == vars:
              tipo2 = self.symbol_table[escopos][vars]

        #print(f"Tipo 1: {tipo1} e Tipo 2: {tipo2}\n")

        if tipo1 is not None and tipo2 is not None and tipo1 != tipo2:
          self.add_error_alt(f"Error incompatible types '{tipo1}' and '{tipo2}'",numero_linha)
        elif tipo2 is None:
          self.add_error_alt(f"Error unknow expression",numero_linha)


  # processamento dos unários
  def __del__(self):
    #print("Sera=?",self.unarios) # na esquerda a linha, na direita o conteudo

    dicio = {}

    for chave, valor in self.unarios:
      if chave not in dicio:
        dicio[chave] = []
      dicio[chave].append(valor)

#    print('DICIO', dicio)

    self.avaliacaoLinhaInteira(dicio)

    if self.erros:
      print("Semantic Errors:")
      for k in self.erros:
        print(k)
    else:
      print("No semantic errors")

    # print(self.symbol_table)


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
    lista_argumentos = []
    # aqui seleciona o nome da funcao
    self.escope = ctx.parentCtx.getChild(1).getChild(0).getText() # nome da função
    #print("FUNCAO NOME: ", self.escope)
    parameters = ctx.parentCtx.getChild(1).getChild(1).getChild(1)
    self.symbol_table[self.escope] = {}

    if parameters.getText() != ")":
      l = list(parameters.getChildren())
      size = len(l)
      for index in range(0,size,3):
        var_type = l[index].getText()
        var_name = l[index+1].getText()
        
        lista_argumentos.append(var_type)

        if var_name in self.symbol_table[self.escope]:
          self.add_error(f" Error variable '{var_name}' already declared.", ctx.parentCtx.getChild(1))
        else:  
          self.symbol_table[self.escope][var_name] = var_type
          
    self.function_args[self.escope] = lista_argumentos # salvando a lista de tipo dos argumentos e o nome da função
    return super().visitFunction_body(ctx)

  def visitFunction_definition(self, ctx: MiniCParser.Function_definitionContext):
    lista=list(ctx.getChildren())
    # print("Posicoes")
    # print([(i,j.getText()) for i,j in enumerate(lista)])
    tipo_funcao = ctx.getChild(0).getText()
    #'factorial(intn)'
    nome_funcao = ctx.getChild(1).getText().split('(')[0]

    if nome_funcao in self.symbol_table:
      self.add_error(f"Error function '{nome_funcao}' already declared.", ctx)
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
          self.add_error(f"Error variable '{nome}' already declared.", ctx)
        else:
          self.symbol_table["global"][nome] = tipo
    else:
      for i in range(1, len(l), 2):
        nome = l[i].getText()
        if nome in self.symbol_table[self.escope]:
          self.add_error(f"Error variable '{nome}' already declared.", ctx)
        else:
          self.symbol_table[self.escope][nome] = tipo
    text = ctx.getText()
    self.translator.addDataDefinition(text)
    return self.visitChildren(ctx)
  
  # Verificar compatibilidade dos tipos nas expressões

  def visitBinary(self, ctx: MiniCParser.BinaryContext):
    l = list(ctx.getChildren())
    # print([i.getText() for i in l])
    # print('Contexto: ', str(ctx.__class__.__name__))
    for i in range(len(l)):
      self.binaryControler += 1
      if str(l[i].__class__.__name__) == "BinaryContext" and l[i].getChildCount() > 1:
        # print("Expressão Binária: ")
        l2 = l[i]
#        print(l2.getText())
        self.visit(l2)
        
      else:
        # print('Expressão Unária: ')
        l2 = l[i]
        # print(l2.getText())
        self.unarios.append((ctx.start.line,l2.getText())) # o vetor tem tuplas com a informação da linha
        copia= self.unarios.copy()
      self.binaryControler -= 1
    if self.binaryControler == 0:
      self.translator.addBinary(copia,ctx.start.line) 
      
      # return alguma ;

  

 
  

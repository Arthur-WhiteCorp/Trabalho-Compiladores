import sys
from antlr4 import *
from MiniCLexer import MiniCLexer
from MiniCParser import MiniCParser
from EvalVisitor import EvalVisitor
# Verifica se o usuário forneceu o nome do arquivo como argumento
if len(sys.argv) != 2:
    print("Uso: python main.py nome_do_arquivo")
    sys.exit(1)

# Obtém o nome do arquivo a partir dos argumentos da linha de comando
nome_arquivo = sys.argv[1]

# Lê o conteúdo do arquivo
try:
    with open(nome_arquivo, 'r') as file:
        data = file.read()
except FileNotFoundError:
    print(f"Arquivo '{nome_arquivo}' não encontrado.")
    sys.exit(1)

# Cria um InputStream a partir dos dados lidos do arquivo
input_stream = InputStream(data)

# Inicializa o lexer e o parser
lexer = MiniCLexer(input_stream)
token_stream = CommonTokenStream(lexer)
parser = MiniCParser(token_stream)

# Realiza a análise sintática
tree = parser.program()

visitor = EvalVisitor()

visitor.visit(tree)

if visitor.erros:
    print("Semantic Errors:")
    for erro in visitor.erros:
        print(erro)
else:
    print("No semantic errors.")

# print(tree.toStringTree(recog=parser))

# Imprime a árvore de análise

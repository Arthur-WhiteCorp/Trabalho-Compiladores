import sys


traduzido = ""

def tres_enderecos_para_mips(cod_3_enderecos):

    # função para convereter o código de 3 endereços para mips

    # verificar variáveis

    return 1
    
def tres_enderecos_var_para_mips(traduzido, cod_3_enderecos):
    traduzido+= ".data:\n"
    with open(cod_3_enderecos, 'r') as file:
        data = file.readlines()
        
        # print('Data: ', data)
        for line in data:
            line_without_spaces = [word for word in line.split()]
            if line_without_spaces != []:

                #print('Linha atual: ', line_without_spaces)

                if line_without_spaces[0].find("int") == 0 or line_without_spaces[0].find('char') == 0:
                    if line_without_spaces[0] == 'int':
                        traduzido += f"{line_without_spaces[1]}: .space 4\n"
                    elif line_without_spaces[0] == 'char':
                        traduzido += f"{line_without_spaces[1]}: .space 1\n"

    return traduzido
    
    
    
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

# print(nome_arquivo)
a = tres_enderecos_var_para_mips(traduzido, nome_arquivo)
print(a)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    # verificar se tem parentese para identificar uma função

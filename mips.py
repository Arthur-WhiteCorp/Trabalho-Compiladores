import sys
import re

# traduzido = ""
    
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
    
def tres_enderecos_funcao_para_mips(cod_3_enderecos):
    funcoes_achadas = []
    # print("Estou dentro da função")

    with open(cod_3_enderecos, 'r') as file:
        data = file.readlines()
        
        # regex que acha funções
        regex_funcao = re.compile(r'\w+\s*\([^)]*\)\s*\{', re.DOTALL)   # \w+: acha um ou mais caracteres antes do parentese (nome da funcao)
                                                                        # \s*: pode ter 0 ou mais espaços em branco
                                                                        # \(: busca por um parentese abrindo
                                                                        # [^)]*: busca qualquer caractere menos o parentese fechando (parametros)
                                                                        # \): busca pelo parentese fechando (fim dos parametros da funcao)
                                                                        # \s*: zero ou mais espaços brancos depois do parentese 
                                                                        # \{: procura uma chave abrindo, que será o inicio do código da funcao 
        
        for line in data:
            match = regex_funcao.search(line) # procura pelo regex na string
            if match:
                print(f"achei a função: {line.strip()}")
                funcoes_achadas.append(line.split("(")[0]) # pega o nome da função
    return funcoes_achadas

def tres_enderecos_para_mips(cod_3_enderecos):
    traduzido = ""
    # procurando funções...
    funcoes = tres_enderecos_funcao_para_mips(cod_3_enderecos)
    # procurando declarações de variáveis...
    traduzido = tres_enderecos_var_para_mips(traduzido, cod_3_enderecos)

    return traduzido




if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Uso: python main.py nome_do_arquivo")
        sys.exit(1)

    # Obtém o nome do arquivo a partir dos argumentos da linha de comando
    cod_3_enderecos = sys.argv[1]

    # Lê o conteúdo do arquivo
    try:
        with open(cod_3_enderecos, 'r') as file:
            data = file.read()
    except FileNotFoundError:
        print(f"Arquivo '{cod_3_enderecos}' não encontrado.")
        sys.exit(1)


    print(tres_enderecos_para_mips(cod_3_enderecos))






# print(nome_arquivo)
# funcoes = tres_enderecos_funcao_para_mips(nome_arquivo)
# a = tres_enderecos_var_para_mips(traduzido, nome_arquivo)
# print(a)
# print(funcoes)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    # verificar se tem parentese para identificar uma função

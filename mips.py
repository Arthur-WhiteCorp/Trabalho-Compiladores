import sys
import re

# traduzido = ""

registradores = {"$zero": False, "$at": False, "$v0": False, "$v1": False, "$a0": False, 
                 "$a1": False, "$a2": False, "$a3": False, "$t0": False, "$t1": False,
                 "$t2": False, "$t3": False, "$t4": False, "$t5": False, "$t6": False, 
                 "$t7": False, "$s0": False, "$s1": False, "$s2": False, "$s3": False, 
                 "$s4": False, "$s5": False, "$s6": False, "$s7": False, "$t8": False, 
                 "$t9": False, "$k0": False, "$k1": False, "$gp":False, "$sp": False,
                 "$fp": False, "$ra": False}

def decide_instruction(line):
    #decide o que a linha representa
    if line.find("=") != -1:
        print("Achei uma atribuição na linha", line)

    #return o que ela é intruction_type ex: att,contidional
    return 1


def translate_att(line):
    # aqui vamos traduzir o att
    return 1

def translate_line(line, instruction_type):
    match(instruction_type):
        case "att":
            translate_att(line)
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
                # print(f"achei a função: {line.strip()}")
                funcoes_achadas.append(line.split("(")[0]) # pega o nome da função
    return funcoes_achadas

def traduz(traduzido, funcoes_achadas):
    # fazer um tupla que relaciona a função com conteudo
    #ler o arquivo
    with open(cod_3_enderecos, 'r') as file:
        data = file.readlines()
        for line in data:
            item = line.split("(")[0]
            print(f"Item {item}")
            if item in funcoes_achadas:
                print(f"O item {item} é função")
                traduzido += f"{item}:\n"
            elif line[0] == "}":
                traduzido += "fim\n"
            else:
                # traduzir o conteúdo de line
                traduzido += line # linha direto por enquanto
                # verificar o que fazer com essa linha (o que ela é)
                decide_instruction(line)

    
    return traduzido

            
    # if nome_inicio da linha in funcoes_achadas
        #adiciona o incio da funcao traduzida
    # else if linha == "}"
        #adiciona o fin da funcao em mips


def faz_traducao_mips(cod_3_enderecos):
    traduzido = ""
    # procurando funções...
    funcoes_achadas = tres_enderecos_funcao_para_mips(cod_3_enderecos)
    print("Achei essas funções: ", funcoes_achadas)
    # procurando declarações de variáveis...
    traduzido = tres_enderecos_var_para_mips(traduzido, cod_3_enderecos)
    traduzido = traduz(traduzido, funcoes_achadas)

    return traduzido
# (inicio_linha, fim_linha, conteudo_linha)
# criaria arquivo vazio e inseriria no arquivo vazio de acordo com os numeros da tripla



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


    print(faz_traducao_mips(cod_3_enderecos))






# print(nome_arquivo)
# funcoes = tres_enderecos_funcao_para_mips(nome_arquivo)
# a = tres_enderecos_var_para_mips(traduzido, nome_arquivo)
# print(a)
# print(funcoes)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    # verificar se tem parentese para identificar uma função

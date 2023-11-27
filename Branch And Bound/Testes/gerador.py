import random

# Função para gerar 3 valores por linha, com o primeiro sendo um contador
def gerar_valores(num_linhas, nome_arquivo):
    with open(nome_arquivo, 'w') as arquivo:
        for i in range(1, num_linhas + 1):
            
            segundo_valor = random.randint(1, num_linhas)
            terceiro_valor = random.randint(1, 1000)
            linha = f"{i} {segundo_valor} {terceiro_valor}\n"
            arquivo.write(linha)


num_linhas = 1000
nome_arquivo = 'teste1000.txt'
gerar_valores(num_linhas, nome_arquivo)

print(f"Valores gerados e escritos no arquivo '{nome_arquivo}'.")

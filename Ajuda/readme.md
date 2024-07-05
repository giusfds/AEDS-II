### Deixando clar, que eu ainda nao sei se funciona 100%

# Como Compilar e Executar o Projeto Java

Este documento descreve os passos necessários para compilar e executar um projeto Java utilizando um Makefile em sistemas Ubuntu e Windows.

## Pré-requisitos
- Java Development Kit (JDK)
- Make

## Estrutura do Projeto

- `src/`: Diretório contendo os arquivos-fonte `.java`.
- `bin/`: Diretório onde os arquivos `.class` compilados serão armazenados.
- `pub.in`: Arquivo de entrada.
- `res.txt`: Arquivo de saída gerado.
- `pub.out`: Arquivo contendo a saída esperada para comparação.
- `Makefile`: Script de automação para compilação e execução.

## Compilando e Executando no Ubuntu

1. **Instalar o Make e o Java:**

   No terminal, execute:
   ```sh
   sudo apt update
   sudo apt install make
   sudo apt install default-jdk
   ```

2. **Navegar até o diretório do projeto:**

   ```sh
   cd /caminho/para/o/diretorio/do/projeto
   ```

3. **Compilar o projeto:**

   ```sh
   make
   ```

4. **Executar o projeto:**

   ```sh
   make run
   ```

5. **Comparar a saída gerada com a saída esperada:**

   ```sh
   make diff
   ```

6. **Limpar os arquivos compilados:**

   ```sh
   make clean
   ```

## Compilando e Executando no Windows

### Usando WSL (Windows Subsystem for Linux)

1. **Instalar o WSL:**

   No PowerShell (como administrador), execute:
   ```powershell
   wsl --install
   ```
   Reinicie o computador se necessário e instale uma distribuição Linux, como o Ubuntu, na Microsoft Store.

2. **Instalar o Make e o Java no WSL:**

   No terminal WSL (como o Ubuntu), execute:
   ```sh
   sudo apt update
   sudo apt install make
   sudo apt install default-jdk
   ```

3. **Navegar até o diretório do projeto:**

   ```sh
   cd /mnt/caminho/para/o/diretorio/do/projeto
   ```

4. **Compilar o projeto:**

   ```sh
   make
   ```

5. **Executar o projeto:**

   ```sh
   make run
   ```

6. **Comparar a saída gerada com a saída esperada:**

   ```sh
   make diff
   ```

7. **Limpar os arquivos compilados:**

   ```sh
   make clean
   ```

### Usando MSYS2

1. **Instalar o MSYS2:**

   Baixe o instalador do MSYS2 no site oficial [MSYS2](https://www.msys2.org/) e siga as instruções de instalação.

2. **Instalar o Make e o Java no MSYS2:**

   Abra o MSYS2 MSYS shell e execute:
   ```sh
   pacman -Syu
   pacman -S make
   pacman -S mingw-w64-x86_64-openjdk
   ```

3. **Navegar até o diretório do projeto:**

   ```sh
   cd /caminho/para/o/diretorio/do/projeto
   ```

4. **Compilar o projeto:**

   ```sh
   make
   ```

5. **Executar o projeto:**

   ```sh
   make run
   ```

6. **Comparar a saída gerada com a saída esperada:**

   ```sh
   make diff
   ```

7. **Limpar os arquivos compilados:**

   ```sh
   make clean
   ```

## Observações
- Certifique-se de que todos os caminhos no Makefile estão corretos para o ambiente em que você está trabalhando.
- Em ambientes Windows, você pode precisar ajustar os caminhos no Makefile para usar barras invertidas (`\`) em vez de barras (`/`).

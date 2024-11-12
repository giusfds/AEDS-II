# Diretórios
SRC_DIR := src
BIN_DIR := bin

# Arquivos de entrada e saída
INPUT_FILE := pub.in
OUTPUT_FILE := res.txt
EXPECTED_OUTPUT := pub.out

# Encontrar todos os arquivos .java no diretório de origem
SOURCES := $(wildcard $(SRC_DIR)/*.java)

# Converter os nomes dos arquivos .java em .class
CLASSES := $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

# Nome do compilador
JAVAC := javac

# Flags de compilação
JFLAGS := -d $(BIN_DIR)

# Nome da classe principal
MAIN_CLASS := Main

# Regra padrão para compilar tudo
all: $(CLASSES)

# Regra para compilar arquivos .java em .class
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	@mkdir -p $(BIN_DIR)
	$(JAVAC) $(JFLAGS) $<

# Regra para executar o programa principal com entrada e saída de arquivos
run: all
	java -cp $(BIN_DIR) $(MAIN_CLASS) < $(INPUT_FILE) > $(OUTPUT_FILE)

# Regra para comparar a saída com o resultado esperado
diff: run
	diff $(OUTPUT_FILE) $(EXPECTED_OUTPUT)

# Limpeza dos arquivos compilados
clean:
	rm -rf $(BIN_DIR)/*.class $(OUTPUT_FILE)

.PHONY: all run diff clean

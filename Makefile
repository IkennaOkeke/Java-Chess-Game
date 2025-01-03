# Variables
SRC_DIR = src
BIN_DIR = bin
JAR_NAME = JavaChessGame.jar 
MANIFEST_FILE = manifest.txt
MAIN_CLASS = Main

# Java compiler and JAR tool
JAVAC = javac
JAR = jar

# Find all Java source files
SOURCES = $(wildcard $(SRC_DIR)/*.java)
CLASSES = $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

# Default target
all: $(JAR_NAME)

# Compile .java files into .class files
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java | $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(SOURCES)

# Create the JAR file with a manifest
$(JAR_NAME): $(CLASSES) $(MANIFEST_FILE)
	$(JAR) cmf $(MANIFEST_FILE) $(JAR_NAME) -C $(BIN_DIR) .

# Clean the build (remove .class files and .jar file)
clean:
ifeq ($(OS),Windows_NT)
	rmdir /s /q $(BIN_DIR)
	del $(JAR_NAME)
	mkdir $(BIN_DIR)
else
	rm -rf $(BIN_DIR)
	rm -f $(JAR_NAME) 
	mkdir $(BIN_DIR)
endif


# Run the JAR file
run: $(JAR_NAME)
	java -Dfile.encoding=UTF-8 -jar $(JAR_NAME).jar


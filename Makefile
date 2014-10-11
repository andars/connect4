.SUFFIXES: .java .class
	
.java.class:
	javac $< -Xlint:deprecation

CLASSES = Main.class \
	Connect4.class \
	GameBoard.class \
	C4Minimax.class \
	NimNode.class \
	NimMinimax.class 


all: $(CLASSES)

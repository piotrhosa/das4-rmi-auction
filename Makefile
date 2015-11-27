JFLAGS =
JC = javac
JVM = java
SERVER = AuctionServer
CLIENT = AuctionClient
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AuctionItem.java \
	AuctionImpl.java \
	AuctionServer.java \
	AuctionClient.java \
	AuctionSystem.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

reset:
	./reset.sh

run: classes
	rmiregistry &
	#osascript -e 'tell app "Terminal" do script "java calculatorclient" end tell'
	java calculatorserver
	open -a Terminal .

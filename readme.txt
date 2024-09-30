bat:gotofx1
COMPILE:javac -d bin src/Gui_01.java
RUN BIN:java -cp bin gui_01.Gui_01
GENERATE JAR:jar cfm apps1.jar manifest.txt -C bin .
RUNjar: java -jar apps1.jar

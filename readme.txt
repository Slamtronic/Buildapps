jabuild compiles java in src directory and jars in lib derectory into 
.class and putem in bin directory


CMD same ACTION=:cd/d D:/..../projectDir   =navigate to project dir

D:\...\projectDir> javac -cp bin;"lib/*" -d bin  src/ClassJava.java

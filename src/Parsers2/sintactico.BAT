SET JAVA_HOME="C:\Program Files (x86)\Java\jre1.8.0_25\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd C:\Users\Mac\Documents\NetBeansProjects\Compi1Proyecto1\src\Parsers2
java -jar c:\Fuentes\java-cup-11b.jar -parser sintactico -symbols tabla_simbolos Parser.cup
pause
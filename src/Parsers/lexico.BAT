SET JAVA_HOME="C:\Program Files (x86)\Java\jre1.8.0_25\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
SET JFLEX_HOME= C:\Fuentes\jflex-1.6.0
cd C:\Users\Mac\Documents\NetBeansProjects\Compi1Proyecto1\src\Parsers
java -jar %JFLEX_HOME%\lib\jflex-1.6.0.jar Escaner.jflex
pause
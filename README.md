# robot
Simulates the movement of robot on the table of 5x5 unit by executing following commands.Ignores any command that cause robot to fall

Commands:  
PLACE 3,2,NORTH  
MOVE  
LEFT  
RIGHT  
REPORT  

## STRUCTURE

1) Main.java    
   The main entry point for the program. it expects file name in the command line argument.By default it takes command.json as command file.  
  
2) CommandProcessor.java   
   Implements ICommandProcessor interface and provides implementation for each valid command  

3) Executor.java 
   It takes commanprocessor instance as argument. Reads the command file and Filters any command that is before the first place command and runs execute command

4) Position.java  
   Holds the postion of the robot
   

## USAGE

Requires maven 3.0. command.json is default file name. File should exist in <root>\src\main\resources forlder  

mvn exec:java -D"exec.mainClass"="com.whispir.Main" -Dexec.args="command.json"

## RESULT  

![Alt text](mvnexecution.JPG?raw=true "Title")

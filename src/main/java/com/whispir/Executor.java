package com.whispir;

import com.whispir.exception.InvalidCommandException;
import com.whispir.model.Position;

import java.util.Arrays;
import java.util.List;

public class Executor {

    private ICommandProcessor commandProcessor;

    public Executor(ICommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public Position execute(String[] commandList) {
        Position currentPos = null;

        commandList=getValidCommand(commandList);

        for (String eachCommand : commandList) {

            String placeCommand=eachCommand;
            if (eachCommand.toUpperCase().startsWith("PLACE"))
                eachCommand = "PLACE";


            switch (eachCommand) {

                case "MOVE":
                    currentPos = commandProcessor.move(currentPos);
                    break;
                case "PLACE":

                    currentPos = commandProcessor.place(currentPos,placeCommand);
                    break;

                case "LEFT":

                    currentPos = commandProcessor.left(currentPos);
                    break;
                case "RIGHT":

                    currentPos = commandProcessor.right(currentPos);
                    break;
                case "REPORT":

                    currentPos = commandProcessor.report(currentPos);
                    break;
                default:
                    throw new InvalidCommandException("Invalid Command");


            }

        }
        return currentPos;
    }

    private String[] getValidCommand(String[] commandList) {
        int firstValidPlaceCommandPos=0;
        for(int i=0;i<commandList.length;i++)
        {

            if(commandList[i].startsWith("PLACE"))
            {
                firstValidPlaceCommandPos=i;
                break;
            }

        }

        List<String> commandList1=Arrays.asList(commandList).subList(firstValidPlaceCommandPos,commandList.length);
        return commandList1.toArray(new String[commandList1.size()]);
    }
}

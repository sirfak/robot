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

    /**
     * Executes command by passing it to command processor
     * @param commandList list of commands ignoring any commands before first place command
     * @return current position after command is executed
     */

    public Position executeCommands(String[] commandList) {

        Position currentPos = null;

        commandList= extractCommandsAfterFirstPlaceCommand(commandList);

        for (String eachCommand : commandList) {

            String placeCommand=eachCommand; //to pass actual place command to place method

            if (eachCommand.toUpperCase().startsWith("PLACE"))
                eachCommand = "PLACE";  // to be used in switch case statement


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

    /***
     * ignores any command untill the first place command is found
     * @param commandList
     * @return commandList after filtering out any command before first place command
     */
    private String[] extractCommandsAfterFirstPlaceCommand(String[] commandList) {
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

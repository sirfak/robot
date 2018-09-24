package com.whispir;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.whispir.exception.InvalidCommandException;
import com.whispir.model.Position;

import org.apache.commons.io.IOUtils;


public class CommandProcessor implements ICommandProcessor {

    private String command;
    Gson gson = new Gson();

    /**
     * Moves the robot in the direction its faceing. Ignoring any move that will cause a fall
     *
     * @param pos current position of the robot
     * @return new calculated postion of the robot after every move
     */
    public Position move(Position pos) {

        if (pos.getFacing().equals("NORTH") && pos.getY() <= 4) {
            pos.setY(pos.getY() + 1);
        }

        if (pos.getFacing().equals("SOUTH") && pos.getY() >= 1) {
            pos.setY(pos.getY() - 1);
        }

        if (pos.getFacing().equals("EAST") && pos.getX() <= 4) {
            pos.setX(pos.getX() + 1);
        }

        if (pos.getFacing().equals("WEST") && pos.getX() >= 1) {
            pos.setX(pos.getX() - 1);
        }
        return pos;
    }

    /**
     * Turns the robot to left. directions is a string array {"EAST","SOUTH","WEST","NORTH"}.
     * the index is decremented for left command.
     * Assuming east facing, every left command will turn robot
     * north,west and south respectively
     *
     * @param pos
     * @return new position of robot
     */
    public Position left(Position pos) {

        int posIndex = pos.toFacePos(pos.getFacing());
        if (posIndex == 0)
            posIndex = 3; //sets the index to 3 ie north if the current index is 0 ie east

        else posIndex = posIndex - 1;
        pos.setFacing(pos.toFacing(posIndex));
        return pos;
    }


    /**
     * Turns the robot to right. directions is a string array {"EAST","SOUTH","WEST","NORTH"}.
     * the index is incremented for right command.
     * Assuming east facing, every right command will turn robot
     * south,west and north respectively
     *
     * @param pos
     * @return new position of robot
     */
    public Position right(Position pos) {
        int posIndex = pos.toFacePos(pos.getFacing());

        if (posIndex == 3) posIndex = 0; // set index to 0 ie east if current index is 3 ie north
        else posIndex = posIndex + 1;

        pos.setFacing(pos.toFacing(posIndex));
        return pos;
    }


    /**
     * prints current postion of robot to standard output
     *
     * @param pos
     * @return current postion of robot
     */
    public Position report(Position pos) {

        System.out.print(pos.toString());
        ;
        return pos;
    }


    /**
     * Places the robot to give position as in place command irrespective of its current postion
     *
     * @param pos     current postion
     * @param command place command with x,y coordinates
     * @return new position
     */
    public Position place(Position pos, String command) {


        String[] placeCommandArr = command.split(",");
        String xPosStr = placeCommandArr[0].toUpperCase().substring(placeCommandArr[0].indexOf("PLACE") + 5).trim();
        Integer xPos = new Integer(xPosStr);
        Integer yPos = new Integer(placeCommandArr[1]);
        String facing = placeCommandArr[2];
        pos = new Position(xPos, yPos, facing);
        return pos;
    }

    /**
     * reads file name from command line and reads the command from the file located in resources folder
     *
     * @param commandArugment command line file name argument
     * @return arrays of commands
     */
    public String[] readCommandFromFile(String[] commandArugment) {

        if (commandArugment == null || commandArugment.length != 1 || !commandArugment[0].endsWith(".json"))
            throw new InvalidCommandException("Expecting json file with command ");

        final ClassLoader classLoader = Main.class.getClassLoader();
        String commandArray[] = null;

        try {
            String result = IOUtils.toString(classLoader.getResourceAsStream(commandArugment[0]));
            Type type = new TypeToken<String[]>() {
            }.getType();
            commandArray = gson.fromJson(result, type);

        } catch (Exception e) {
            throw new InvalidCommandException("invalid or missing file.Expecting a json with with commands");
        }

        return commandArray;

    }


}

package com.whispir.model;

import java.util.Arrays;

import com.whispir.exception.InvalidCommandException;

public class Validator {
	
	public boolean validateCommand(String command)
	{
		boolean isCommandValid=false;
		String[] formattedCommand= (command.split(","));

		if(formattedCommand.length==1)
		{

			isCommandValid =formattedCommand[0].toUpperCase().equals("MOVE") ||
					formattedCommand[0].toUpperCase().equals("REPORT") ||
					formattedCommand[0].toUpperCase().equals("LEFT") ||
					formattedCommand[0].toUpperCase().equals("RIGHT");

		}

		if(formattedCommand.length==3)
		{
			//should be place command PLACE 0,0,NORTH
			String firstPartCommand=formattedCommand[0];
			String yPositionCommand=formattedCommand[1];
			String directionCmd=formattedCommand[2];

			isCommandValid = 	isPlaceCommandValid(firstPartCommand) &&
					isXandYPositionValid(firstPartCommand.substring(6, 7),yPositionCommand) &&// check if x and y are numbers once place command is valid
					isDirectionValid(directionCmd);
		}

		return isCommandValid;
	}
	
	private boolean isDirectionValid(String directionCmd) {
		String[] direction = new String[]{"NORTH","EAST","WEST","SOUTH"};
		return Arrays.asList(direction).contains(directionCmd);
		
	}

	private boolean isXandYPositionValid(String strXPos, String strYPos) {
		boolean isNumericPosition=true;
		
		try {
			Double xPos=new Double(strXPos);
			Double yPos=new Double(strYPos);
			
		 isNumericPosition= xPos>=0&&xPos<=5 &&	yPos>=0&&yPos<=5;
		}
		catch(NumberFormatException nfe)
		{
			throw new InvalidCommandException("X or Y position should be a valid integer between (and including) 0 and 5");
		}
		
		return isNumericPosition;
	}

	private boolean isPlaceCommandValid(String command) {

	    //PLACE command should be PLACE 0,0,EAST
		return 
				command.length()==7 &&
				command.substring(0, 5).toUpperCase().equals("PLACE");
			
	}

}

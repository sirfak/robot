package com.whispir.model;

import java.util.Arrays;

import com.whispir.exception.InvalidCommandException;

public class Validator {
	
	public boolean validateCommand(String command)
	{
		boolean isValid=false;
		String[] formattedCommand= (command.split(","));

		if(formattedCommand.length==1)
		{

			isValid =formattedCommand[0].toUpperCase().equals("MOVE") ||
					formattedCommand[0].toUpperCase().equals("REPORT") ||
					formattedCommand[0].toUpperCase().equals("LEFT") ||
					formattedCommand[0].toUpperCase().equals("RIGHT");

		}

		if(formattedCommand.length==3)
		{
			String firstPartCommand=formattedCommand[0];
			String yPositionCommand=formattedCommand[1];
			String directionCmd=formattedCommand[2];
			isValid = 	isPlaceCommandValid(firstPartCommand) &&
					isPositionValid(firstPartCommand.substring(6, 7),yPositionCommand) &&
					isDirectionValid(directionCmd);
		}
		
		
		
		
		return isValid;
	}
	
	private boolean isDirectionValid(String directionCmd) {
		String[] direction = new String[]{"NORTH","EAST","WEST","SOUTH"};
		return Arrays.asList(direction).contains(directionCmd);
		
	}

	private boolean isPositionValid(String strXPos, String strYPos) {
		boolean isNumericPos=true;
		
		try {
			Double xPos=new Double(strXPos);
			Double yPos=new Double(strYPos);
			
		 isNumericPos= xPos>=0&&xPos<=5 &&				 
				 		yPos>=0&&yPos<=5;
		}
		catch(NumberFormatException nfe)
		{
			isNumericPos=false;
			throw new InvalidCommandException("Invalid command");
		}
		
		return isNumericPos;
	}

	private boolean isPlaceCommandValid(String command) {
		
		return 
				command.length()==7 &&
				command.substring(0, 5).toUpperCase().equals("PLACE");
			
	}

}

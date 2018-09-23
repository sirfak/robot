package com.whispir;

import com.whispir.exception.InvalidCommandException;
import com.whispir.model.Validator;

public class Robot {
	


	public static void main(String[] inputCommand) {
		
		Validator validator = new Validator();

		boolean isValidPlaceCommandSent = false;
		
		String commands[] = new String[] { "PLACE 0,1,NORTH", "MOVE" };
		

		for (String eachCommand : commands) {
			if (!validator.validateCommand(eachCommand))
				throw new InvalidCommandException("Invalid Input. Expecting input like PLACE 1,2,NORTH");

		}

		ICommandProcessor cproc=new CommandProcessor();
		Executor executor = new Executor(cproc);

		executor.execute(commands);


	}

	}

	

	



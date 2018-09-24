package com.whispir;

import com.whispir.exception.InvalidCommandException;
import com.whispir.model.Validator;

public class Main {

    static Validator validator = new Validator();
    static ICommandProcessor cproc=new CommandProcessor();
    static Executor executor = new Executor(cproc);

	public static void main(String[] fileName) {
		



		String commands[] = cproc.readCommandFromFile(fileName); // new String[] { "PLACE 0,1,NORTH", "MOVE" };

		for (String eachCommand : commands) {
			if (!validator.validateCommand(eachCommand))
				throw new InvalidCommandException("Invalid Input. Expecting input like PLACE 1,2,NORTH");

		}

		executor.executeCommands(commands);
	}

	}

	

	



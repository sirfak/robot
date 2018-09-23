package com.whispir;

import com.whispir.model.Position;

public interface ICommandProcessor {

	public Position place(Position pos, String command);
	public Position move(Position pos);
	public Position left(Position pos);
	public Position right(Position pos);
	public Position report(Position pos);
	
	
}

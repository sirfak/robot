package com.whispir;

import com.whispir.model.Position;

public class CommandProcessor implements ICommandProcessor {

	private String command;

	public Position move(Position pos) {
		
		if(pos.getFacing().equals("NORTH") && pos.getY()<=4)
		{
			pos.setY(pos.getY()+1);
		}
		if(pos.getFacing().equals("SOUTH") && pos.getY()>=1)
		{
			pos.setY(pos.getY()-1);
		}
		if(pos.getFacing().equals("EAST") && pos.getX()<=4)
		{
			pos.setX(pos.getX()+1);
		}
		if(pos.getFacing().equals("WEST") && pos.getX()>=1)
		{
			pos.setX(pos.getX()-1);
		}
		return pos;
	}

	public Position left(Position pos) {
		
		int posIndex=pos.toFacePos(pos.getFacing());
		if(posIndex==0)
			posIndex=3; 
		else posIndex=posIndex-1;
		pos.setFacing(pos.toFacing(posIndex));
		return pos;
	}

	public Position right(Position pos) {
		int posIndex=pos.toFacePos(pos.getFacing());
		if(posIndex==3) posIndex=0; 
		else posIndex=posIndex+1;
		pos.setFacing(pos.toFacing(posIndex));
		return pos;
	}

	public Position report(Position pos) {

		System.out.print(pos.toString());	;
		return pos;
	}


	public Position place(Position pos,String command) {

		
		String[] placeCommandArr=command.split(",");
		String xPosStr= placeCommandArr[0].toUpperCase().substring(placeCommandArr[0].indexOf("PLACE")+5).trim();
		Integer xPos= new Integer(xPosStr);
		Integer yPos= new Integer(placeCommandArr[1]);
		String facing = placeCommandArr[2];
		pos= new Position(xPos,yPos,facing);
		return pos;
	}

	

}

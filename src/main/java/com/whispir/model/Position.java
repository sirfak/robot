package com.whispir.model;

public class Position {

	private Integer x;
	private Integer y;
	private String facing;
	private int facePos;
	
	private String[] direction= new String[] {"EAST","SOUTH","WEST","NORTH"};
	

	public Position(Integer xPos, Integer yPos, String facing) {
		this.x=xPos;
		this.y=yPos;
		this.facing=facing;
			
		
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public int toFacePos(String facePos)
	{
		int pos=0;
		for (int i=0;i<direction.length;i++) {
			if(facePos.equalsIgnoreCase(direction[i]))
			{
				pos=i;
				break;
			}
		}
	
		return pos;
	}
	
	public String toFacing(int facePos){
		if(facePos<=direction.length || facePos>direction.length)
			
			return direction[facePos];
		return facing;
	}
	
	public String toString() {
		return "The robot is currently at " + x + "," + y + " and facing " + facing;

	}

}

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
		int index=0;
		for (int i=0;i<direction.length;i++) {

			if(facePos.equalsIgnoreCase(direction[i]))
			{
				index=i;
				break;
			}
		}
	
		return index;
	}

	/**
	 * converts index into string direction
	 * @param facePos current diction as in index
	 * @return direction name in string corresponding to index
	 */
	public String toFacing(int facePos){

		if(facePos<direction.length && facePos>=0)
			return direction[facePos];

		return facing;
	}
	
	public String toString() {
		return "The robot is currently at " + x + "," + y + " and facing " + facing;

	}

}

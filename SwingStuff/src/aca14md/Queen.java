package aca14md;
/*
 * Simple class that represents
 * a queen piece in a chess 
 * game. Made for the java 
 * assignment UoS.
 * 
 * Lecturer: Richard Clayton
 * Written By: Matheus Gomes
 * Last Edited: Unknown
 */
import java.util.ArrayList;

public class Queen extends Piece {

	public Queen(int ix, int iy, int c, Board b){
		super(PieceCode.QUEEN, ix, iy, c, b);
	}
	
	/**
	 * This method will return an array
	 * with all the available moves.
	 * 
	 * @return null if no moves or an array
	 * list of moves otherwise.
	 */
	public ArrayList<Move> availableMoves() {
		
		// All different directions to move
		int[][] orbits = {{1, 0}, {0, -1}, {-1, 0}, {0, 1},
						  {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
		
		// Create ArrayList to return
		ArrayList<Move> v = new ArrayList<>();
					
		for(int[] orbit : orbits){
			
			// Amount to add in each position
			int newX = getX() + orbit[0],
				newY = getY() + orbit[1];
			
			while(!getBoard().outOfRange(newX, newY) &&
				  !getBoard().occupied(newX, newY)){
				
				v.add(new Move(this, getX(), getY(), newX, newY, false));
				
				// Updating new positions for next iteration
				newX = newX + orbit[0];
				newY = newY + orbit[1];
			}
			
			// Adds occupied move if not out of range
			if(!getBoard().outOfRange(newX, newY) &&
			   getBoard().getPiece(newX, newY).getColour() != getColour())
				v.add(new Move(this, getX(), getY(), newX, newY, true));
		}
		
		// Check if array is empty
		if(v.isEmpty()) return null;
		else return v;
	}

}

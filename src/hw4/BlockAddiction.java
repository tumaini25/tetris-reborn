package hw4;

import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Generator;
import api.Position;
/**
 * A mixture of Tetris and "Bejeweled". A collapsible set is formed by 
 * three adjacent icons of the same color.
 * @author Tumaini Mwangangi
 *
 */
public class BlockAddiction extends AbstractGame {
	
	/**
	 * Constructs BlockAddiction with a grid of given height and width, as well as pre-filled rows.
	 * @param height
	 * @param width
	 * @param gen
	 * @param preFillRows
	 */
	public BlockAddiction(int height, int width, Generator gen, int preFillRows) {
		super(height, width, gen);

		for (int i = 0; i < preFillRows; i++) { 
			for (int j = 0; j < width; j++) { 
				if (((height - 1 - i) % 2 == 0 && j % 2 == 0)  ||  ((height - 1 - i) % 2 != 0 && j % 2 != 0)) {
					this.setBlock(height - 1 - i, j, gen.randomIcon()); 
				}
			}
		}
	}
	
	/**
	 * Constructs BlockAddiction with a grid of given height and width
	 * @param height
	 * @param width
	 * @param gen
	 */
	public BlockAddiction(int height, int width, Generator gen) {
		super(height, width, gen);
	}

	@Override
	/**
	   * Returns a list of locations for all cells that form part of
	   * a collapsible set.  This list may contain duplicates.
	   * @return 
	   *   list of locations for positions to be collapsed
	   */	
	public List<Position> determinePositionsToCollapse() {
		//iterate over the grid 
		int matches = 0;
		boolean neighbor1 = false;
		boolean neighbor2 = false;
		boolean neighbor3 = false;
		boolean neighbor4 = false;
		int i;
		int j;
		ArrayList<Position> arr1 = new ArrayList<Position>(); //add all collapsible elements to this list.
		
		for (i = 0; i < getHeight(); i++) { //iterating over every row
			for (j = 0; j < getWidth(); j++) { //iterating over every column in the row
				//if the element is non-null:
				if ( getIcon(i, j) != null) {
					if ( (i-1) >= 0 && getIcon(i-1, j) != null) { //bounds checking/null checking.
						if ( getIcon(i, j).matches(getIcon(i-1, j) ) ) {
							matches+=1;
							neighbor1 = true;
						} 
					}
					
					if ( (i+1) < getHeight() && getIcon(i+1, j) != null) { //bounds checking/null checking.
						if ( getIcon(i, j).matches(getIcon(i+1, j) ) ) {
							matches+=1;
							neighbor2 = true;					
						}
					}
					
					if ( (j-1) >= 0 && getIcon(i, j-1) != null) { //bounds checking/null checking
						if ( getIcon(i, j).matches(getIcon(i, j-1) ) ) {
							matches+=1;
							neighbor3 = true;
						}
					}
					
					if ( (j+1) < getWidth() && getIcon(i, j+1) != null) { //bounds checking/null checking
						if ( getIcon(i, j).matches(getIcon(i, j+1) ) ) {
							matches+=1;
							neighbor4 = true;
						}
					}
				} 
				if (matches >= 2) {
					arr1.add(new Position(i, j));
					if (neighbor1) {
						arr1.add(new Position(i-1, j));
					}
					if (neighbor2) {
						arr1.add(new Position(i+1, j));
					}
					if (neighbor3) {
						arr1.add(new Position(i, j-1));
					}
					if (neighbor4) {
						arr1.add(new Position(i, j+1));
					}
				}
				matches = 0; //reset the amount of matches for the next element.
				neighbor1 = false; //reset all of the neighbor booleans for the next element.
				neighbor2 = false;
				neighbor3 = false;
				neighbor4 = false;
			}
		}
		return arr1;
	}	
}

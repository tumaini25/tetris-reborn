package hw4;

import api.Cell;
import api.Icon;
import api.Position;


/**
 * Definition of the L piece for BlockAddiction.
 * @author Tumaini Mwangangi
 *
 */
public class LPiece extends AbstractPiece {
	/**
	 * Array of four cell objects for each component of the LPiece.
	 */
	private Cell[] tempCell = new Cell[4];
	
	/**
	 * Constructs an LPiece with the given position and icons
	 * @param position
	 * @param icons
	 */
	public LPiece(Position position, Icon[] icons) {
		super(position, icons);	
		//construct an array of cells and call setCells() to pass those values to the superclass.
		tempCell[0] = new Cell(icons[0], new Position(0,0));
		tempCell[1] = new Cell(icons[1], new Position(0,1));
		tempCell[2] = new Cell(icons[2], new Position(1,1));
		tempCell[3] = new Cell(icons[3], new Position(2,1));
		setCells(tempCell);
	}
	  @Override
	public void transform() {

		if (getCells()[0].getCol() == 0) {
			tempCell[0].setCol(2);
			setCells(tempCell);
		}
		else if (getCells()[0].getCol() == 2) {
			tempCell[0].setCol(0);
			setCells(tempCell);
		} 
	}

}


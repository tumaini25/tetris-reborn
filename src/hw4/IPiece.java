package hw4;

import api.Cell;
import api.Icon;
import api.Position;

/**
 * Definition of the I piece for BlockAddiction.
 * @author Tumaini Mwangangi
 *
 */
public class IPiece extends AbstractPiece {
	
	/**
	 * Array of three cell objects for each component of the IPiece.
	 */
	private Cell[] tempCell = new Cell[3];
	
	/**
	 * Constructs an IPiece with the given position and icons
	 * @param position
	 * @param icons
	 */
	public IPiece(Position position, Icon[] icons) {
		super(position, icons);	
		tempCell[0] = new Cell(icons[0], new Position(0,1));
		tempCell[1] = new Cell(icons[1], new Position(1,1));
		tempCell[2] = new Cell(icons[2], new Position(2,1));
		setCells(tempCell);
	}

}

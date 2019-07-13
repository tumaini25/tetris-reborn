package hw4;


import api.Cell;
import api.Icon;
import api.Position;

/**
 * Definition of the Corner piece for BlockAddiction
 * @author Tumaini Mwangangi
 *
 */
public class CornerPiece extends AbstractPiece {
	private Cell[] tempCell = new Cell[3];

	/**
	 * Constructs a CornerPiece with the given position and icons
	 * @param position
	 * @param icons
	 */
	public CornerPiece(Position position, Icon[] icons) {
		super(position, icons);			

		tempCell[0] = new Cell(icons[0], new Position(0,0));
		tempCell[1] = new Cell(icons[1], new Position(1,0));
		tempCell[2] = new Cell(icons[2], new Position(1,1));
		setCells(tempCell);
	}


	
	@Override
	//four possible states that the corner piece can rotate through. rotates CELLS
	public void transform() {
		//for each cell
		for (int i = 0; i < 3; i++) {
			if (getCells()[i].getRow() == 0 && getCells()[i].getCol() == 0) {
				tempCell[i].setCol(1); 
			}
			else if (getCells()[i].getRow() == 0 && getCells()[i].getCol() ==1) {
				tempCell[i].setRow(1);
			}
			else if (getCells()[i].getRow() == 1 && getCells()[i].getCol() == 1) {
				tempCell[i].setCol(0);
			}
			else if (getCells()[i].getRow() == 1 && getCells()[i].getCol() == 0) {
				tempCell[i].setRow(0);
			}
		}
		setCells(tempCell);
	}

}

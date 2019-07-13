package hw4;


import api.Cell;
import api.Icon;
import api.Position;

/**
 * Definition of the Snake piece for BlockAddiction.
 * @author Tumaini Mwangangi
 *
 */
public class SnakePiece extends AbstractPiece {
	
	/**
	 * Array of four cell objects for each component of the SnakePiece.
	 */
	private Cell[] tempCell = new Cell[4];
	
	/**
	 * Constructs a SnakePiece with the given position and icons
	 * @param position
	 * @param icons
	 */
	public SnakePiece(Position position, Icon[] icons) {
		super(position, icons);	
		tempCell[0] = new Cell(icons[0], new Position(0,0));
		tempCell[1] = new Cell(icons[1], new Position(1,0));
		tempCell[2] = new Cell(icons[2], new Position(1,1));
		tempCell[3] = new Cell(icons[3], new Position(1,2));
		setCells(tempCell);
	}

	@Override
	public void transform() {	
		int tempRow = getCells()[0].getRow();
		int tempCol = getCells()[0].getCol();		
		int temp1Row = getCells()[1].getRow();
		int temp1Col = getCells()[1].getCol();
		int temp2Row = getCells()[2].getRow();
		int temp2Col = getCells()[2].getCol();

		if ((getCells()[0].getRow() == 0 && getCells()[0].getCol() != 2) || (getCells()[0].getRow() == 2 && getCells()[0].getCol() != 2)) {
			tempCell[0].setCol(tempCol+1); 
			setCells(tempCell);
		}
		else if ((getCells()[0].getRow() == 0 && getCells()[0].getCol() == 2) ) {
			tempCell[0].setRow(tempRow+1);
			setCells(tempCell);
		}
		else if (getCells()[0].getRow() == 1 && getCells()[0].getCol() == 0 && getCells()[3].getRow()==0) {
			tempCell[0].setRow(tempRow+1); 
			setCells(tempCell);
		}
		else if (getCells()[0].getRow() == 1 && getCells()[0].getCol() == 0 && getCells()[3].getRow()==2) { 
			tempCell[0].setRow(tempRow-1);
			setCells(tempCell);
		}
		else if (getCells()[0].getRow() == 1 && getCells()[0].getCol() != 0) {
			tempCell[0].setCol(tempCol-1);
			setCells(tempCell);
		}
		else if (getCells()[0].getRow() == 2 && getCells()[0].getCol() == 2) { 
			tempCell[0].setRow(tempRow-1);
			setCells(tempCell);
		}
		tempCell[1].setRow(tempRow);
		tempCell[1].setCol(tempCol);
		tempCell[2].setRow(temp1Row);
		tempCell[2].setCol(temp1Col);
		tempCell[3].setRow(temp2Row);
		tempCell[3].setCol(temp2Col);	
		setCells(tempCell);
	}

}

package hw4;

import api.Cell;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * An implementation of the Piece interface for
 * BlockAddiction. Each piece must implement its 
 * own transform() method.
 * 
 * @author Tumaini Mwangangi
 *
 */
public abstract class AbstractPiece implements Piece {
	
	  /**
	   * Position of piece.
	   */
	  private Position position;
	  
	  /**
	   * Array of Cell objects containing icons and positions.
	   */
	  private Cell[] cells;

	  /**
	   * Constructs an AbstractPiece at the given position.
	   * @param givenPosition
	   *   position of upper left corner
	   */
	  protected AbstractPiece(Position givenPosition, Icon[] icons)
	  {
	    position = givenPosition;
	  }
	  
	  @Override
	  public Position getPosition()
	  {
	    return position;
	  }
	  
	  @Override
	  public void setCells(Cell[] givenCells)
	  {
	    // deep copy the given array
	    cells = new Cell[givenCells.length];
	    for(int i = 0; i < givenCells.length; i++) {
	    	cells[i] = new Cell(givenCells[i]);
			}
	  }
	  
	  @Override
	  public Cell[] getCells()
	  {
	    // deep copy this object's cell array
	    Cell[] copy = new Cell[cells.length];
	    for(int i = 0; i < cells.length; i++) {
	    	copy[i] = new Cell(cells[i].getIcon(), new Position(cells[i].getRow(), cells[i].getCol()));
			} 
	    return copy;
	  }
	  
	  @Override
	  public Cell[] getCellsAbsolute()
	  {
		  Cell[] ret = new Cell[cells.length];
		  int row = cells[0].getRow() + position.row();
		    int col = cells[0].getCol() + position.col();
		    Icon b = cells[0].getIcon();
		    ret[0] = new Cell(b, new Position(row, col));
		    for(int i = 1; i < cells.length; i++) {
			    row = cells[i].getRow() + position.row();
			    col = cells[i].getCol() + position.col();
			    b = cells[i].getIcon();
			    ret[i] = new Cell(b, new Position(row, col));
				}
	    return ret;
	  }
	  
	  @Override
	  public void shiftDown()
	  {
	    position = new Position(position.row() + 1, position.col());
	  }

	  @Override
	  public void shiftLeft()
	  {
		  position = new Position(position.row(), position.col() - 1);
	  }

	  @Override
	  public void shiftRight()
	  {
		  position = new Position(position.row(), position.col() + 1);
	  }

	  @Override
	  public void transform() {
		  
	  }


	  @Override
	  public void cycle()
	  {
		int cellsLength = cells.length;
		Icon temp = cells[cellsLength-1].getIcon();
		for(int i = cellsLength-1; i >= 0; i--) {
			if ( i == 0 ) {
				cells[i].setIcon(temp);
			} 
			else {
			cells[i].setIcon(cells[i-1].getIcon());
			}
		}	  
		  
	    
	  }
	  @Override
	  public Piece clone()
	  {
	    try
	    {
	      // call the Object clone() method to create a shallow copy
	      AbstractPiece s = (AbstractPiece) super.clone();
	      // then make it into a deep copy (note there is no need to copy the position,
	      // since Position is immutable, but we have to deep-copy the cell array
	      // by making new Cell objects      
	      s.cells = new Cell[cells.length];
	      for (int i = 0; i < cells.length; ++i)
	      {
	        s.cells[i] = new Cell(cells[i]);
	      }
	      return s;
	    }
	    catch (CloneNotSupportedException e)
	    {
	      // can't happen, since we know the superclass is cloneable
	      return null;
	    }    
	  }


}

package examples;
import java.awt.Color;

import api.Icon;
import api.Cell;
import api.Position;
import api.Piece;
import api.Icon;

/**
 * Partial implementation of the Piece interface for experimentation.
 */
public class SamplePiece implements Piece
{
  private Position position;
  private Cell[] cells;
  
  /**
   * Constructs a SamplePiece at the given position.
   * @param givenPosition
   *   position of upper left corner
   */
  public SamplePiece(Position givenPosition)
  {
    position = givenPosition;
    cells = new Cell[4];
    cells[0] = new Cell(new Icon(Color.RED), new Position(0, 0) );
    
    // another cell just below the first one
    cells[1] = new Cell(new Icon(Color.BLUE), new Position(0, 1));
    cells[2] = new Cell(new Icon(Color.YELLOW), new Position(1, 1));
    cells[3] = new Cell(new Icon(Color.GREEN), new Position(2, 1));
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
    cells[0] = new Cell(givenCells[0]);
    cells[1] = new Cell(givenCells[1]);
    cells[2] = new Cell(givenCells[2]);
    cells[3] = new Cell(givenCells[3]);
  }
  
  @Override
  public Cell[] getCells()
  {
    // deep copy this object's cell array
    Cell[] copy = new Cell[cells.length];
    copy[0] = new Cell(cells[0]);
    copy[1] = new Cell(cells[1]);
    copy[2] = new Cell(cells[2]);
    copy[3] = new Cell(cells[3]);
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
    
    row = cells[1].getRow() + position.row();
    col = cells[1].getCol() + position.col();
    b = cells[1].getIcon();
    ret[1] = new Cell(b, new Position(row, col));

    row = cells[2].getRow() + position.row();
    col = cells[2].getCol() + position.col();
    b = cells[2].getIcon();
    ret[2] = new Cell(b, new Position(row, col));
    
    row = cells[3].getRow() + position.row();
    col = cells[3].getCol() + position.col();
    b = cells[3].getIcon();
    ret[3] = new Cell(b, new Position(row, col));
    
    

    return ret;
  }
  
  @Override
  public void shiftDown()
  {
    position = new Position(position.row() + 1, position.col());
  }

  //decrease the column by 1
  @Override 
  public void shiftLeft()
  {
    position = new Position(position.row(), position.col() - 1);
  }
  
  //increase the column by 1
  @Override
  public void shiftRight()
  {
	  position = new Position(position.row(), position.col() + 1);
  }

  @Override
  public void transform() {
	  if (cells[0].getCol() == 0) {
			cells[0].setCol(2);
		}
		else if (cells[0].getCol() == 2) {
			cells[0].setCol(0);
		}
	}

  @Override
  public void cycle()
  {
    // TODO Auto-generated method stub
	  Icon temp = cells[0].getIcon();
		cells[0].setIcon(cells[1].getIcon());
		cells[1].setIcon(cells[2].getIcon());
		cells[2].setIcon(cells[3].getIcon());
		cells[3].setIcon(temp);
  }

  @Override
  public Piece clone()
  {
    try
    {
      // call the Object clone() method to create a shallow copy
      SamplePiece s = (SamplePiece) super.clone();

      // then make it into a deep copy (note there is no need to copy the position,
      // since Position is immutable, but we have to deep-copy the cell array
      // by making new Cell objects      
      s.cells = new Cell[4];
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

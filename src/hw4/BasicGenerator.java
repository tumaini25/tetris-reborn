package hw4;

import java.util.Random;

import api.Generator;
import api.Icon;
import api.Piece;
import api.Position;

/**
 * @author Tumaini Mwangangi
 * Generator for Piece objects in BlockAddiction. Icons are 
 * always selected uniformly at random, and the Piece types
 * are generated with the following probabilities:
 * <ul>
 * <li>LPiece - 10%
 * <li>DiagonalPiece - 25%
 * <li>CornerPiece - 15%
 * <li>SnakePiece - 10%
 * <li>IPiece - 40%
 * </ul>
 * The initial position of each piece is based on its
 * vertical size as well as the width of the grid (given
 * as an argument to getNext).  The initial column is always
 * width/2 - 1.  The initial row is:
 *  * <ul>
 * <li>LPiece - row = -2
 * <li>DiagonalPiece - row = -1
 * <li>CornerPiece - row = -1
 * <li>SnakePiece - row = -1
 * <li>IPiece - row = -2
 * </ul>
 * 
 */
public class BasicGenerator implements Generator
{
  private Random rand;

  /**
   * Constructs a BasicGenerator that will use the given
   * Random object as its source of randomness.
   * @param givenRandom
   *   instance of Random to use
   */
  public BasicGenerator(Random givenRandom)
  {
    rand = givenRandom;
  }

  @Override
  public Piece getNext(int width)
  {
    int col = width / 2 - 1;
    int randNum = rand.nextInt(100);
    if (randNum >= 0 && randNum < 10) { 
    	Icon[] icons = new Icon[4];
    	for (int i = 0; i < 4; i++) {
    		icons[i] = this.randomIcon();
    	}
    	return new LPiece(new Position(-2, col), icons);
    }
    else if (randNum >= 10 && randNum < 35) {
    	Icon[] icons = new Icon[2];
    	for (int i = 0; i < 2; i++) {
    		icons[i] = this.randomIcon();
    	}
    	return new DiagonalPiece(new Position(-1, col), icons);
    }
    else if (randNum >= 35 && randNum < 50) {
    	Icon[] icons = new Icon[3];
    	for (int i = 0; i < 3; i++) {
    		icons[i] = this.randomIcon();
    	}
    	return new CornerPiece(new Position(-1, col), icons);
    }
    else if (randNum >= 50 && randNum <60 ) {
    	Icon[] icons = new Icon[4];
    	for (int i = 0; i < 4; i++) {
    		icons[i] = this.randomIcon();
    	}
    	return new SnakePiece(new Position(-1, col), icons);
    }
    else if (randNum >= 60 && randNum < 100) {
    	Icon[] icons = new Icon[3];
    	for (int i = 0; i < 3; i++) {
    		icons[i] = this.randomIcon();
    	}
    	return new IPiece(new Position(-2, col), icons);
    } 
    return null;
    
  }


  @Override
  public Icon randomIcon()
  {
    return new Icon(Icon.COLORS[rand.nextInt(Icon.COLORS.length)]);
  }

}

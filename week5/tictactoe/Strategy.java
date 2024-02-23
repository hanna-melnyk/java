package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public interface Strategy {


    /**@return the name of the strategy*/
    public String getName();


    // P-5.1  public int determineMove(Board board, Mark mark) that returns a next legal move, given the
    //Board board, for the player with Mark mark
    /**returns a next legal move, given the
     //@param board of type Board, for the player with Mark
     @param mark of type Mark*/
    public int determineMove(Board board, Mark mark);
}

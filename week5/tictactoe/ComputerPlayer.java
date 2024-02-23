package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class ComputerPlayer extends Player {

    public String name;
    // Constructors:
    /**Constructor
     * constructs a computer player us-
     * ing the given mark and strategy*/
    public ComputerPlayer(Mark mark, Strategy strategy) {
        super(strategy.getName() + "-" + mark, mark);
        this.name =getName();
    }


    /**Constructor
     * constructs a computer player using the given mark and
     * a naive strategy.*/
    public ComputerPlayer(Mark mark) {
        this.name =;
    }

    @Override
    public int determineMove(Board board) {
        return 0;
    }
}

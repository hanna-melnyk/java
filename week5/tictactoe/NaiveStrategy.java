package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

import java.util.ArrayList;


public class NaiveStrategy implements Strategy {

    private String name;

    //implements the method of interface Strategy
    @Override
    public String getName() {
        return name;
    }


    // while
    @Override
    public int determineMove(Board board, Mark mark) {
        ArrayList<Integer> emptyFields = new ArrayList<>();
        int boardSize = Board.DIM * Board.DIM;
        int boardIndexMin = 0;
        int boardIndexMax = 8;
        //make a list of all of the empty fields
        for (int i = 0; i < Board.DIM * Board.DIM; i++) { // size of the board: Board.DIM * Board.DIM
            if (board.isEmptyField(i)) {
                emptyFields.add(i);
        }
        }
        // pick a random index from the list
            int randomNumber = (int) ((Math.random() * boardIndexMax) + boardIndexMin);
            return randomNumber;
        }
    }


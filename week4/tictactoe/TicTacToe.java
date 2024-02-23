package ss.week4.tictactoe;

import org.w3c.dom.Text;
import ss.utils.TextIO;

public class TicTacToe {
    public static void main(String[] args) {
        String[] playerNames = new String[Game.NUMBER_PLAYERS]; //array to store player names input

        if (args != null) { //if names are not in configuration, ask user for input
            if (args.length != Game.NUMBER_PLAYERS) {
                System.out.println("Player names are not given in the game configuration");

                for (int i = 0; i < Game.NUMBER_PLAYERS; i++) {
                    System.out.println("Please type in the name of player " + (1+i));
                    playerNames[i] = TextIO.getln();
                }
            }
        } else {
                for (int i = 0; i < Game.NUMBER_PLAYERS; i++) {
                    playerNames[i] = args[i];
                }
            }
            //set the players
            Player[] players = new Player[Game.NUMBER_PLAYERS];
            players[0] = new HumanPlayer(playerNames[0], Mark.XX);
            players[1] = new HumanPlayer(playerNames[1], Mark.OO);
            //create a new game & start
            Game newGame = new Game(players[0], players[1]);
            System.out.println("Hello " + players[0].getName() + " and " + players[1].getName());
            newGame.start();
        }
    }


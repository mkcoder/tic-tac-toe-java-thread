package com.mkcoder.mycodingblog.thread.example.ai;

import com.mkcoder.mycodingblog.thread.example.models.Board;
import com.mkcoder.mycodingblog.thread.example.models.Player;

import java.util.Random;

/**
 * an Artificial game player that takes a player and a board and plays a move
 */
public class AI {

    private static final Board board = Board.instance();

    private AI() {}

    public static boolean makePlayerMove(Player player) {
        synchronized (board) {
            if ( checkIfWinner() ) { printBoard(); System.exit(1); }
            int i = Math.abs(new Random().nextInt()) % (board.getOpenSpaces().toArray().length);
            board.put(player.getUserChar(), ((Board.Location)board.getOpenSpaces().toArray()[i]).getLocation());
            return true;
        }
    }

    private static Board.Location GameFinished() {
        System.out.println("Game is over!");
        System.exit(-1);
        return null;
    }

    public static void printBoard() {
        synchronized (board) {
            board.print();
        }
    }

    public static boolean checkIfWinner() {
        return board.checkForWinner();
    }

}


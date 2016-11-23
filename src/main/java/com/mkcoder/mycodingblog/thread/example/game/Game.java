package com.mkcoder.mycodingblog.thread.example.game;

import com.mkcoder.mycodingblog.thread.example.ai.AI;
import com.mkcoder.mycodingblog.thread.example.models.Player;

/**
 *
 */
public class Game implements Runnable {

    private Player[] players = new Player[2];
    private char[] playerChar = new char[] { 'X', 'O' };
    private static int index = 0;

    public Game() {
        initalizePlayers();
    }

    private void initalizePlayers() {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(playerChar[i]);
        }
    }

    public void printBoard() {
        AI.printBoard();
    }

    @Override
    public synchronized void run() {
        AI.makePlayerMove( players[index] );
        index = (index + 1) % players.length;
    }

    public boolean complete() {
        return AI.checkIfWinner();
    }

}

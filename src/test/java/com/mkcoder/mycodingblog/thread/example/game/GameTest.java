package com.mkcoder.mycodingblog.thread.example.game;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameTest {

    private static final int ROUNDS = 9;
    Game game;
    Thread t1, t2;
    ExecutorService executorService;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        executorService = Executors.newFixedThreadPool(2);
        t1 = new Thread(game, "Thread 1");
        t2 = new Thread(game, "Thread 2");
    }

    @Test
    public synchronized void testPlayingTheGame5TimeDoesSomething() throws Exception {
        for ( int i = 0; i < ROUNDS; i++) {
            executorService.execute(game);
            if ( game.complete() ) executorService.shutdownNow();
            executorService.submit( () -> { game.printBoard(); System.out.println();});
        }
        executorService.shutdown();
        while ( !executorService.isTerminated() ) {}
        game.printBoard();
    }
}
package com.mkcoder.mycodingblog.thread.example.models;

import org.junit.Test;

public class BoardTest {

    Board board = Board.instance();

    @Test
    public void testPrintBoardPrintsAndDoesNotThrowException() throws Exception {
        board.print();
    }

    @Test
    public void testThatOpenSpacesIsCorrect() throws Exception {
        board.getOpenSpaces().forEach(System.out::println);
    }

    @Test
    public void testWhenIPlaceApieceOnTheBoardItActuallyWorks() throws Exception {
        board.put('x', 3);
        char x = board.get(3);
        assert x == 'x';
    }

    @Test
    public void testThatBoardIsAnSingleton() throws Exception {
        Board b2 = Board.instance();
        assert board.get(3) == b2.get(3);
    }
}
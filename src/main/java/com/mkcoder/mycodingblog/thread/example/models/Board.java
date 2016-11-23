package com.mkcoder.mycodingblog.thread.example.models;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * represents the tic-tac-toe board
 */
public class Board {

    public class Location {
        char boardPiece;
        int location;

        public Location(char boardPiece, int location) {
            this.boardPiece = boardPiece;
            this.location = location;
        }

        public int getLocation() {
            return location;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "boardPiece=" + boardPiece +
                    ", location=" + location +
                    '}';
        }
    }


    private static Board board;

    public char[] loc = new char[] { ' ',' ',' ',
                                     ' ',' ',' ',
                                     ' ',' ',' ',
    };
    private char[] openSpaces;

    private Board() {
    }

    public static Board instance() {
        if ( board == null ) board = new Board();
        return board;
    }

    public void print() {
        for ( int i = 0; i < loc.length; i+=3 ) {
            System.out.println(" " + loc[i] + " | " + loc[i+1] + " | " + loc[i+2]);
            if ( (i + 3) < loc.length ) System.out.println(" -   -   -");
        }
    }

    public void put(char userChar, int i) {
        loc[i] = userChar;
    }

    public char get(int i) {
        return loc[i];
    }

    public boolean checkForWinner() {
        for (int i = 0; i < loc.length; i+=3) {
            if ( loc[i] == loc[i+1] &&  loc[i] == loc[i+2] ) {
                if ( loc[i] == ' ') continue;
                System.out.printf("We got our selves a winner here boys! '%c' wins the game.\n", loc[i]);
                return true;
            }
        }

        for ( int j = 0, i = 0; j < loc.length; j+=3, i++ ) {
            if ( loc[i] == loc[i+3] &&  loc[i] == loc[i+6] ) {
                if ( loc[i] == ' ') continue;
                System.out.printf("We got our selves a winner here boys! '%c' wins the game.\n", loc[i]);
                return true;
            }
        }

        return false;
    }

    public Stream<Location> getOpenSpaces() {
        return Arrays.stream( this.charToLocation() ).filter(location -> location.boardPiece == ' ' );
    }

    private Location[] charToLocation() {
        Location[] intLoc = new Location[loc.length];
        for (int i = 0; i < loc.length; i++) {
            intLoc[i] = new Location(loc[i], i);
        }
        return intLoc;
    }
}

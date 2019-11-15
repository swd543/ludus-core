package com.mu.concepts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class TestConcepts {
    /**
     * Test whether array is passed to an object by reference
     */
    @Test
    public void testCopy(){
        var a= new int[10];
        Arrays.fill(a, new Random().nextInt(100));
        class B{
            int[] a;

            public B(int[] a) {
                this.a = a;
            }

            @Override
            public String toString() {
                return "B{" +
                        "a=" + Arrays.toString(a) +
                        '}';
            }
        }
        var b=new B(a);
        Assertions.assertArrayEquals(b.a,a);
        a[1]=0;
        Assertions.assertArrayEquals(b.a,a);
        a=new int[100];
        Assertions.assertFalse(Arrays.equals(b.a,a));
    }

    static class Board{
        Piece[] pieces;

        public Board(int size) {
            this.pieces=new Piece[size];
            pieces[0]=new Piece(this, "BLACK",0);
        }

        @Override
        public String toString() {
            return "Board{" +
                    "pieces=" + Arrays.toString(pieces) +
                    '}';
        }
    }

    static class Piece{
        Board board;
        String name;
        int location;

        public Piece(Board board, String name, int location) {
            this.board = board;
            this.name = name;
            this.location=location;
        }

        @Override
        public String toString() {
            return "Piece{"+name+location+"}";
        }

        public void move(int index){
            board.pieces[index]=this;
            board.pieces[location]=null;
            location=index;
        }
    }

    @Test
    public void testSelfReferentialConstructor(){
        var b=new Board(10);
        Assertions.assertNotNull(b.pieces[0]);
//        System.out.println(b);
        b.pieces[0].move(5);
        Assertions.assertNotNull(b.pieces[5]);
        Assertions.assertNull(b.pieces[0]);
//        System.out.println(b);
    }
}

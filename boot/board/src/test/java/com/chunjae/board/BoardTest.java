package com.chunjae.board;

import java.util.Optional;

public class BoardTest {
    public static void main(String[] args) {
        Optional<Board> b0 = Optional.empty();
        Board b = new Board("hong",20);
        Optional<Board> b1 = Optional.of(b);

        if(b1.isPresent()){
            System.out.println("b1: "+b1.get());
        }
        if(b0.isPresent())
            System.out.println("b0: "+b0.get());

        Board board = b1.orElseThrow(()->{
            throw new RuntimeException();
        });
        System.out.println("board: "+board);

        // exception 발생하여 실행 안됨
//        Board board2 = b0.orElseThrow(()->{
//            throw new RuntimeException();
//        });

    }
}

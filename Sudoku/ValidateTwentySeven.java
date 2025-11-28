/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import lab9.TwentySevenThreads;

/**
 *
 * @author carol
 */
public class ValidateTwentySeven implements SudokuValidator{
    private int board[][]; 
    public ValidateTwentySeven(int board[][]){
        this.board=board;
        TwentySevenThreads t= new TwentySevenThreads(board);
    }
    /*
        ValidationResult validate(int[][] board){
            t.working;   
        }
    */
}

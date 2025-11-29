/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carol
 */
public class Mode27Validator implements SudokuValidator {
    private int board[][];

    public Mode27Validator(int board[][]) {
        this.board = board;
    }
    
    @Override
    public ValidationResult validate(int[][] board) {
        ValidationResult result = new ValidationResult(board);
        Thread threads [] = new Thread[27];
        int t=0,i;
        for(i=0;i<9;i++){
            threads[t++]=new Thread(new CheckRow(board,i,result));
        }   
        for(i=0;i<9;i++){
            threads[t++]=new Thread(new CheckColumn(board,i,result));
        }   
        for(i=0;i<9;i++){
            threads[t++]=new Thread(new CheckBox(board,i,result));
        }   
        for (Thread thread : threads) thread.start();
        try{
            for (Thread thread : threads) thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Mode27Validator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}

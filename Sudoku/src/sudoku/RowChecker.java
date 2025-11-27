/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.*;
/**
 *
 * @author Miriam
 */
public class RowChecker implements Runnable {
    public int [][] board;
    public ValidationResult result;

    public RowChecker(int[][] board, ValidationResult result) {
        this.board = board;
        this.result = result;
    }
    
    @Override
    public void run(){
        for (int r=0; r<9; r++){
            Map <Integer, List<int[]>>map = Mode3Validator.mapDigitPositionsInRow(board, r);
            for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()){
            //Loop through each digit and its list of positions
                
                int digit = entry.getKey();
                List<int[]> positions = entry.getValue(); 
                //This is the list of where that digit appears in the row.
                
                 if (positions.size() > 1) {
                 //if the digit appears more than once then it's duplicated
                 
                    DuplicateError err = new DuplicateError(DuplicateError.Type.ROW, r, digit);
                    for (int[] pos : positions) 
                        err.addPosition(pos[0], pos[1]);
                    result.addError(err);
                    //this marks the whole board invald and adds the error in the synchronized list
                }
            } 
        }
    }
}

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
public class ColumnChecker implements Runnable {
    public int [][] board;
    public ValidationResult result;

    public ColumnChecker (int[][] board, ValidationResult result) {
        this.board = board;
        this.result = result;
    }
    
    @Override
    public void run(){
        for (int c=0; c<9; c++){
            Map<Integer, List<int[]>>map = Mode3Validator.mapDigitPositionsInColumn(board, c);
            for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()){
                int digit = entry.getKey();
                List<int[]> positions = entry.getValue();
                if (positions.size()>1){
                     DuplicateError err = new DuplicateError(DuplicateError.Type.COLUMN, c, digit);
                    for (int[] pos : positions) err.addPosition(pos[0], pos[1]);
                    result.addError(err);
                }
            }
        }
    }
}

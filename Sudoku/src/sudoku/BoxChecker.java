
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

public class BoxChecker implements Runnable{
    public int [][] board;
    public ValidationResult result;

    public BoxChecker (int[][] board, ValidationResult result) {
        this.board = board;
        this.result = result;
    }
    
    @Override
    public void run(){
        for (int b=0; b<9; b++){
            Map<Integer, List<int[]>>map = Mode3Validator.mapDigitPositionsInBox(board, b);
            for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()){
                int digit = entry.getKey();
                if (digit == 0) continue;
                List<int[]> positions = entry.getValue();
                if (positions.size()>1){
                     DuplicateError err = new DuplicateError("BOX", b, digit);
                    for (int[] pos : positions){
                        int p=(pos[0]%3)*3 + (pos[1]%3)+1;//
                        err.addPosition(p);
                    }
                    result.addError(err);
                }
            }
        }
    }
}

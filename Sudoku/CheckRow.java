/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author carol
 */
public class CheckRow extends Check{
    private int [][] board;
    private int index;
    private DuplicateError dup;
    private ValidationResult res;
    
    public CheckRow(int[][] board,int index, ValidationResult res) {
        super(board);
        this.board = board;
        this.index=index;  
        this.res=res;
    }
    
    @Override
    public void run(){
        Map<Integer, DuplicateError> seenErrors = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (board[index][i] == 0) continue;
                if (board[index][i] == board[index][j]) {
                    int value = board[index][i];
                    DuplicateError dup = seenErrors.get(value);
                    if (dup == null) {
                        dup = new DuplicateError("Row", index, value);
                        seenErrors.put(value, dup);
                        res.addError(dup);
                        dup.addPosition(i+1);
                    }
                    dup.addPosition(j+1);
                }
            }
        }
        
    }
}

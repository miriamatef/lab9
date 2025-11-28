/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    public boolean valid;
    public List<DuplicateError> errors;
    public int[][] board;   
    
    
    public ValidationResult(int[][] board) {
        this.valid = true;
        this.errors = new ArrayList<>();
        this.board = board;
    }

    public void addError(DuplicateError e) {
        this.errors.add(e);
        this.valid = false;
    }
}

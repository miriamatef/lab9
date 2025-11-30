
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

public class ValidatorFactory {

    public static SudokuValidator createValidator(int mode,int[][]board) {
        switch (mode) {
            case 0:
                return new SequentialValidator(board); 
            case 3:
                return new Mode3Validator(board);      
            case 27:
                return new Mode27Validator(board);     
            default:
                throw new IllegalArgumentException("Invalid mode");
        }
    }
}

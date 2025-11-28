/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

public class ValidatorFactory {

    public static SudokuValidator createValidator(int mode) {

        switch (mode) {
            case 0:
                return new SequentialValidator(); 
            case 3:
                return new Mode3Validator();      
            case 27:
                return new Mode27Validator();     
            default:
                throw new IllegalArgumentException("Invalid mode");
        }
    }
}

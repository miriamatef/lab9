/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

/**
 *
 * @author Miriam
 */
public class CheckerFactory {
    public static Runnable createChecker(CheckerType type, int[][] board, ValidationResult result) {

        switch (type) {
            case ROW:
                return new RowChecker(board, result);

            case COLUMN:
                return new ColumnChecker(board, result);

            case BOX:
                return new BoxChecker(board, result);

            default:
                throw new IllegalArgumentException("Unknown CheckerType: " + type);
        }
    }
}

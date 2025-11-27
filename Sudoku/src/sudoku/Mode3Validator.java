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
public class Mode3Validator implements SudokuValidator {

    public int[][] board;
    public ValidationResult result;

    public Mode3Validator(int[][] board, ValidationResult result) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("Board must be 9x9");
        }
        this.board = board;
        this.result = result;
    }

    public Mode3Validator(int[][] boardToTest) {
        if (boardToTest == null || boardToTest.length != 9 || boardToTest[0].length != 9) {
            throw new IllegalArgumentException("Board must be 9x9");
        }
        this.board = boardToTest;
        this.result = new ValidationResult();
    }

    @Override
    public ValidationResult validate(int[][] boardToTest) {
        // validate board shape
        if (boardToTest == null || boardToTest.length != 9 || boardToTest[0].length != 9) {
            throw new IllegalArgumentException("Board must be 9x9");
        }

        this.board = boardToTest;
        ValidationResult result = new ValidationResult();

        // Create checkers using Factory Method Pattern
        Runnable rowChecker = CheckerFactory.createChecker(CheckerType.ROW, board, result);
        Runnable colChecker = CheckerFactory.createChecker(CheckerType.COLUMN, board, result);
        Runnable boxChecker = CheckerFactory.createChecker(CheckerType.BOX, board, result);

        // Threads
        Thread tRow = new Thread(rowChecker, "RowChecker");
        Thread tColumn = new Thread(colChecker, "ColumnChecker");
        Thread tBox = new Thread(boxChecker, "BoxChecker");

        tRow.start();
        tColumn.start();
        tBox.start();

        try {
            tRow.join();
            tColumn.join();
            tBox.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    

    public static Map<Integer, List<int[]>> mapDigitPositionsInRow(int[][] board, int row) {
        //Creates a map (digit → list of positions in that row)
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int col = 0; col < 9; col++) {
            int d = board[row][col];
            map.computeIfAbsent(d, k -> new ArrayList<>()).add(new int[]{row, col});
            ////ensure the digit key exists in the map and add this cell {row, col} to the list
        }
        return map;
    }

    public static Map<Integer, List<int[]>> mapDigitPositionsInColumn(int[][] board, int col) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int row = 0; row < 9; row++) {
            int d = board[row][col];
            map.computeIfAbsent(d, k -> new ArrayList<>()).add(new int[]{row, col});
        }
        return map;
    }

    public static Map<Integer, List<int[]>> mapDigitPositionsInBox(int[][] board, int boxIndex) {
        int startRow = (boxIndex / 3) * 3;
        int startCol = (boxIndex % 3) * 3;

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                int d = board[r][c];
                map.computeIfAbsent(d, k -> new ArrayList<>()).add(new int[]{r, c});
            }
        }
        return map;
    }
}

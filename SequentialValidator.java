/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.*;

/**
 *
 * @author Mariam Elshamy
 */
public class SequentialValidator implements SudokuValidator {

    private final int[][] board;

    public SequentialValidator(int[][] board) {
        this.board = board;
    }

    @Override
    public ValidationResult validate(int[][] board) {

        List<DuplicateError> allErrors = new ArrayList<>();

        for (int r = 0; r < 9; r++) {
            allErrors.addAll(checkRow(r));
        }

        for (int c = 0; c < 9; c++) {
            allErrors.addAll(checkColumn(c));
        }

        for (int b = 0; b < 9; b++) {
            allErrors.addAll(checkBox(b));
        }

        ValidationResult result = new ValidationResult(board);
        result.valid = allErrors.isEmpty();
        result.errors = allErrors;

        return result;
    }

    public List<DuplicateError> checkRow(int row) {

        Map<Integer, List<int[]>> positions = new HashMap<>();

        for (int col = 0; col < 9; col++) {
            int value = board[row][col];
            if (value == 0) {
                continue;
            }

            positions.putIfAbsent(value, new ArrayList<>());
            positions.get(value).add(new int[]{row, col});
        }

        return buildErrors("ROW", row, positions);
    }

    public List<DuplicateError> checkColumn(int col) {

        Map<Integer, List<int[]>> positions = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            int value = board[row][col];
            if (value == 0) {
                continue;
            }
            positions.putIfAbsent(value, new ArrayList<>());
            positions.get(value).add(new int[]{row, col});
        }

        return buildErrors("COL", col, positions);
    }

    public List<DuplicateError> checkBox(int boxIndex) {

        Map<Integer, List<int[]>> positions = new HashMap<>();

        int startRow = (boxIndex / 3) * 3;
        int startCol = (boxIndex % 3) * 3;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {

                int row = startRow + r;
                int col = startCol + c;
                int value = board[row][col];
                if (value == 0) {
                    continue;
                }
                positions.putIfAbsent(value, new ArrayList<>());
                positions.get(value).add(new int[]{row, col});
            }
        }

        return buildErrors("BOX", boxIndex, positions);
    }

    private List<DuplicateError> buildErrors(String type, int index,
            Map<Integer, List<int[]>> positions) {

        List<DuplicateError> errors = new ArrayList<>();

        for (Map.Entry<Integer, List<int[]>> entry : positions.entrySet()) {

            int digit = entry.getKey();
            List<int[]> occ = entry.getValue();

            if (occ.size() > 1) {
                DuplicateError error = new DuplicateError(type, index, digit);
                for (int[] pos : occ) {
                    if (type.equals("ROW")) {
                        error.addPosition(pos[1]+1);
                    } else if (type.equals("COL")) {
                        error.addPosition(pos[0]+1);
                    } else {
                        int p=(pos[0]%3)*3 + (pos[1]%3)+1;
                      error.addPosition(p);
                    }
                }
                errors.add(error);
            }
        }
        return errors;
    }

}

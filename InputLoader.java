package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputLoader {

    public static int[][] loadCsv(String filepath) {
        int[][] board = new int[9][9];

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int row = 0;

            while ((line = br.readLine()) != null && row < 9) {
                String[] parts = line.split(",");

                if (parts.length != 9) {
                    throw new RuntimeException("Line " + (row + 1) + " does not contain 9 values.");
                }

                for (int col = 0; col < 9; col++) {
                    try {
                        board[row][col] = Integer.parseInt(parts[col].trim());
                    } catch (NumberFormatException nfe) {
                        throw new RuntimeException("Invalid number at row " + (row + 1) + ", column " + (col + 1) + ": '" + parts[col] + "'");
                    }
                }
                row++;
            }

            if (row != 9) {
                throw new RuntimeException("File contains only " + row + " rows. Expected 9.");
            }

        } catch (FileNotFoundException fnfe) {
            throw new RuntimeException("File not found: " + filepath);
        } catch (IOException ioe) {
            throw new RuntimeException("I/O error reading file: " + ioe.getMessage());
        }

        return board;
    }
}

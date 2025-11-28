/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputLoader {

    public static int[][] loadCsv(String filepath) {
        int[][] board = new int[9][9];

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int row = 0;

            while ((line = br.readLine()) != null && row < 9) {
                String[] parts = line.split(",");

                for (int col = 0; col < 9; col++) {
                    board[row][col] = Integer.parseInt(parts[col].trim());
                }
                row++;
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV file: " + e.getMessage());
        }

        return board;
    }
}

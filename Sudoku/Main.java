package sudoku;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java -jar lab9test.jar <csv filepath>");
            return;
        }

        String filePath = args[0];
        int[][] board = InputLoader.loadCsv(filePath);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter validator mode (number): ");
        int mode = scanner.nextInt();

        SudokuValidator validator = ValidatorFactory.createValidator(mode, board);
        ValidationResult result = validator.validate(board);

        if (result.valid) {
            System.out.println("VALID SUDOKU");
        } else {
            System.out.println("INVALID SUDOKU");
            for (DuplicateError error : result.errors) {
                System.out.println(error);
            }
        }
    }

}

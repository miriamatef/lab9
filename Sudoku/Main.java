package sudoku;



public class Main {
    public static void main(String[] args) {
        // Sample board with a few intentional duplicates for testing
        int[][] board = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},//first kanet 2 ba2et 1
            {3, 4, 5, 2, 8, 6, 1, 7, 9} // try changing a value to create a duplicate
        };

        System.out.println("=== Running 27 Threads to Validate Sudoku ===");
        TwentySevenThreads validator = new TwentySevenThreads(board);
        validator.working();
    }   
}

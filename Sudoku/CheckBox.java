package sudoku;

public class CheckBox extends Check {
    private int [][] board;
    private int index;

    public CheckBox(int[][] board, int index) {
        super(board);
        this.board = board;
        this.index = index;
    }

    @Override
    public void run() {
        int flag = 0;
        int dup=0;
        int rowStart = (index / 3) * 3;
        int colStart = (index % 3) * 3;

        for (int i = 0; i < 9; i++) {
            int r1 = rowStart + (i / 3);
            int c1 = colStart + (i % 3);
            for (int j = i + 1; j < 9; j++) {
                int r2 = rowStart + (j / 3);
                int c2 = colStart + (j % 3);
                if (board[r1][c1] == board[r2][c2]) {
                    dup=c1;
                    flag = 1;
                    Check.hasDup = true;
                    break;
                }
            }
        }

        if (flag == 1) {
            StringBuilder box = new StringBuilder();
            box.append("Box # ").append(index + 1).append(", ").append(dup+1).append(", [");
            for (int r = rowStart; r < rowStart + 3; r++) {
                for (int c = colStart; c < colStart + 3; c++) {
                box.append(board[r][c]).append(" ");
                }
            }
            box.append("]");
            Check.problems.add(box.toString());
        }
    }
}

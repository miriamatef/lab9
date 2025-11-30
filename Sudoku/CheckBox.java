package sudoku;

import java.util.HashMap;
import java.util.Map;

public class CheckBox extends Check {
    private int [][] board;
    private int index;
    private DuplicateError dup;
    private ValidationResult res;
    
    public CheckBox(int[][] board,int index, ValidationResult res) {
        super(board);
        this.board = board;
        this.index=index;  
        this.res=res;
    }

    @Override
    public void run() {
        int rowStart = (index / 3) * 3;
        int colStart = (index % 3) * 3;
        Map<Integer, DuplicateError> seenErrors = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            int r1 = rowStart + (i / 3);
            int c1 = colStart + (i % 3);
            for (int j = i + 1; j < 9; j++) {
                int r2 = rowStart + (j / 3);
                int c2 = colStart + (j % 3);
                if (board[r1][c1] == 0) continue;
                if (board[r1][c1] == board[r2][c2]) {
                    int value =board[r1][c1];
                    DuplicateError dup = seenErrors.get(value);
                    if (dup == null) {
                        dup = new DuplicateError("Box", index, value);
                        seenErrors.put(value, dup);
                        res.addError(dup);
                        dup.addPosition(i+1);
                    }
                    dup.addPosition(j+1);
                }
            }
        }
    }    
}

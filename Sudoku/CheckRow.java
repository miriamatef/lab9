/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

/**
 *
 * @author carol
 */
public class CheckRow extends Check{
    private int [][] board;
    private int index;
    public CheckRow(int[][] board,int index) {
        super(board);
        this.board = board;
        this.index=index;
    }
    
    @Override
    public void run(){
        int flag=0;
        int dup=0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (board[index][i] == board[index][j]) {
                    dup=i;
                    flag=1;
                    Check.hasDup = true;
                    break;
                }
            }
        }
        if(flag==1){
            StringBuilder row = new StringBuilder();
            row.append("Row # ").append(index + 1).append(", ").append(dup+1).append(", [");
            for (int i = 0; i < 9; i++) {
                row.append(board[index][i]).append(" ");
            }
            row.append("]");
            Check.problems.add(row.toString());
        }
    }
}

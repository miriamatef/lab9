/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carol
 */
public class TwentySevenThreads {
    private int board[][];
    public TwentySevenThreads(int board[][]){
        this.board=board;
    }
    
    public void working(){
        Thread threads [] = new Thread[27];
        int t=0,i;
        for(i=0;i<9;i++){
            threads[t++]=new Thread(new CheckRow(board,i));
        }   
        for(i=0;i<9;i++){
            threads[t++]=new Thread(new CheckColumn(board,i));
        }   
        for(i=0;i<9;i++){
            threads[t++]=new Thread(new CheckBox(board,i));
        }   
        for (Thread thread : threads) thread.start();
        try{
            for (Thread thread : threads) thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TwentySevenThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Check.hasDup) {
            System.out.println("INVALID");
        } else {
            System.out.println("VALID");
        }
        for (String p : Check.problems) {
            System.out.println(p);
        }
    }
}

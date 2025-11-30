/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carol
 */
public abstract class Check implements Runnable{
    private int board[][];
    public Check(int board[][]){
        this.board=board;
    }
}

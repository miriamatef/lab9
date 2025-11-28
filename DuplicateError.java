/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.ArrayList;
import java.util.List;

public class DuplicateError {

    public String type;  
    public int index;     
    public int number;    
    public List<String> positions; 

    public DuplicateError(String type, int index, int number) {
        this.type = type;
        this.index = index;
        this.number = number;
        this.positions = new ArrayList<>();
    }

    public void addPosition(int r, int c) {
        positions.add("(" + r + "," + c + ")");
    }
    @Override
      public String toString() {
          return type + " " + index + ", #" + number + ", " + positions;
}

}

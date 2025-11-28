/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;


public class OutputPrinter {

    public static void printResult(ValidationResult result) {

        if (result == null) {
            System.out.println("INTERNAL ERROR: ValidationResult is null!");
            return;
        }

        if (result.valid) {
            System.out.println("VALID");
            return;
        }

        System.out.println("INVALID");

       
        result.errors.stream()
                .filter(e -> e.type.equals("ROW"))
                .forEach(e -> System.out.println(
                        "ROW " + e.index + ", #" + e.number + ", " + e.positions
                ));

        System.out.println("------------------------------------------");


        result.errors.stream()
                .filter(e -> e.type.equals("COL"))
                .forEach(e -> System.out.println(
                        "COL " + e.index + ", #" + e.number + ", " + e.positions
                ));

        System.out.println("------------------------------------------");

     
        result.errors.stream()
                .filter(e -> e.type.equals("BOX"))
                .forEach(e -> System.out.println(
                        "BOX " + e.index + ", #" + e.number + ", " + e.positions
                ));
    }
}

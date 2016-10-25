/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class PROJECTE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // variables
        String nom = null;
        char posicio = ' ';
        int opcio = 0, dorsal = 0, gols = 0;
        boolean internacional = false;
        double clausula = 0.0;

        Scanner ent = new Scanner(System.in);

        do {}
            System.out.println("\n\nMenú del programa.");
            System.out.println("1. Sortir del programa.");
            System.out.println("2. Afgir dades dels jugadors.");
            System.out.println("3. Borrar dades.");
            System.out.println("4. Modificar dades.");
            System.out.println("5. Llistar jugadors.");
            switch (opcio = ent.nextInt()) {
                case 1:
                    System.out.println("Has sortit del programa");
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                default:
                    System.out.println("Opció incorrecta!!\n\n");
            }
        
        
    }

}

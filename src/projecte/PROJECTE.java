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
        Scanner ent = new Scanner(System.in);
        Scanner entnum=new Scanner(System.in);
        String nom = null;
        char posicio , esinternacional;
        int opcio = 0, dorsal = 0, gols = 0;
        boolean internacional = false, omplit = false;
        double clausula = 0.0;
        

        do {
            System.out.println("Menú del programa.");
            System.out.println("1. Sortir del programa.");
            System.out.println("2. Afgir dades dels jugadors.");
            System.out.println("3. Borrar dades.");
            System.out.println("4. Modificar dades.");
            System.out.println("5. Llistar jugadors.");

            switch (opcio = ent.nextInt()) {
                case 1:
                    System.out.println("Has sortit del programa!");
                    break;
                case 2:
                    if (!omplit) {
                        System.out.println("Introdueix el nom del jugador");
                        nom = ent.next();
                        do {
                        System.out.println("Introdueix la seva posició al camp: A = Delanter, M = Migcampista, D = Defensa, P = Porter. ");   
                        posicio = ent.next().toUpperCase().charAt(0);  
                        switch (posicio) {
                            case 'A':
                                System.out.println("Delanter");
                                break;
                            case 'M':
                                System.out.println("Migcampista");
                                break;
                            case 'D':
                                System.out.println("Defensa");
                                break;
                            case 'P':
                                System.out.println("Porter");
                                break;
                                
                            default:
                                System.out.println("Opció incorrecta!!\n\n");
                                break;
                        }
                        } while (posicio != 'A' && posicio != 'M' && posicio != 'D' && posicio != 'P');
                        
                        System.out.println("Introdueix el número del dorsal");
                        dorsal = entnum.nextInt();
                        System.out.println("Introdueix el número de gols");
                        gols = entnum.nextInt();
                        System.out.println("És internacional?");
                        System.out.println("S per dir SI, N per NO");
                        do {
                            esinternacional= ent.next().toUpperCase().charAt(0); 
                            
                        } while (esinternacional !='S' && esinternacional !='N');
                        internacional= (esinternacional=='S');
                        
                        System.out.println("Introdueix quina clausula te");
                        clausula = entnum.nextDouble();
                        omplit=true;
                    }else{
                        System.out.println("Ja has introduït dades, si vols tornar a omplir, primer borra.");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opció incorrecta!!\n\n");
            }

        } while (opcio != 5);

    }

}

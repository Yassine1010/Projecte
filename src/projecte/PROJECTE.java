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
        String nom = null;
        char posicio = 0, esinternacional = 0;
        int opcio = 0, dorsal = 0, gols = 0;
        boolean internacional = false, omplit = false;
        double clausula = 0.0;
        char esveritat = 0;
        boolean veritat = false;

        do {
            System.out.println("\n\nMenú del programa.");
            System.out.println("1. Sortir del programa.");
            System.out.println("2. Afgir dades dels jugadors.");
            System.out.println("3. Borrar dades.");
            System.out.println("4. Modificar dades.");
            System.out.println("5. Llistar jugadors.");

            switch (opcio = ent.skip("[\r\n]*").nextInt()) {
                case 1:
                    System.out.println("Has sortit del programa!");
                    break;
                case 2:
                    if (!omplit) {
                        System.out.println("Introdueix el nom del jugador");
                        nom = ent.skip("[\r\n]*").nextLine();
                        do {
                            System.out.println("Introdueix la seva posició al camp: A = Delanter, M = Migcampista, D = Defensa, P = Porter. ");
                            posicio = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
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
                        dorsal = ent.skip("[\r\n]*").nextInt();
                        System.out.println("Introdueix el número de gols");
                        gols = ent.skip("[\r\n]*").nextInt();
                        System.out.println("És internacional?");
                        System.out.println("S per dir SI, N per NO");
                        do {
                            esinternacional = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

                        } while (esinternacional != 'S' && esinternacional != 'N');
                        internacional = (esinternacional == 'S');

                        System.out.println("Introdueix quina clausula te");
                        clausula = ent.skip("[\r\n]*").nextDouble();
                        System.out.println("\nDades introduïdes correctament!!");
                        omplit = true;

                    } else {
                        System.out.println("\nJa has introduït dades, si vols tornar a omplir, primer borra.");
                    }
                    break;
                case 3:
                    if (omplit) {

                        System.out.println("\n\nVols veure les dades del jugador abans de borrar? (S/N)");
                        do {
                            esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

                        } while (esveritat != 'S' && esveritat != 'N');
                        if (veritat = (esveritat == 'S')) {
                            System.out.println("Dades del jugador\n\n");
                            System.out.println("Nom: " + nom);
                            System.out.println("Posició: " + posicio);
                            System.out.println("Dorsal: " + dorsal);
                            System.out.println("Gols: " + gols);
                            System.out.println("Internacional SI-NO: " + esinternacional);
                            System.out.println("Clausula: " + clausula);
                            System.out.println("\nVols borrar les dades? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (veritat = (esveritat == 'S')) {
                                System.out.println("Segur? (S-N)");
                                do {
                                    esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                                } while (esveritat != 'S' && esveritat != 'N');
                                if (veritat = (esveritat == 'S')) {
                                    System.out.println("\nDades borrades correctament!");

                                    omplit = false;
                                }

                            } else {
                                break;
                            }

                        } else {
                            System.out.println("\nVols borrar les dades? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (veritat = (esveritat == 'S')) {
                                System.out.println("Segur? (S-N)");
                                do {
                                    esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                                } while (esveritat != 'S' && esveritat != 'N');
                                if (veritat = (esveritat == 'S')) {
                                    System.out.println("Dades borrades correctament!");
                                    omplit = false;
                                }

                            } else {
                                break;
                            }
                        }

                    } else {
                        System.out.println("\nLes dades ja estàn borrades");

                    }
                    break;
                case 4:
                    if (omplit) {

                        System.out.println("\n\nVols veure les dades del jugador abans de modificar? (S/N)");
                        do {
                            esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

                        } while (esveritat != 'S' && esveritat != 'N');
                        if (veritat = (esveritat == 'S')) {
                            System.out.println("Dades del jugador\n\n");
                            System.out.println("Nom: " + nom);
                            System.out.println("Posició: " + posicio);
                            System.out.println("Dorsal: " + dorsal);
                            System.out.println("Gols: " + gols);
                            System.out.println("Internacional SI-NO: " + esinternacional);
                            System.out.println("Clausula: " + clausula);
                            //////----------------------------------------------//////////

                            System.out.println("\nVols modificar el nom? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (veritat = (esveritat == 'S')) {
                                do {
                                    System.out.println("Introdueix el nou nom");
                                    nom = ent.skip("[\r\n]*").nextLine();
                                    System.out.println("Nou nom: " + nom);
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////

                            System.out.println("\nVols modificar la posició? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (veritat = (esveritat == 'S')) {
                                do {
                                    do {
                                        System.out.println("Introdueix la seva posició al camp: A = Delanter, M = Migcampista, D = Defensa, P = Porter. ");
                                        posicio = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
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

                                    System.out.println("Nova posició: " + posicio);
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////
                            
                            System.out.println("\nVols modificar el dorsal? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (veritat = (esveritat == 'S')) {
                                do {
                                    System.out.println("Introdueix el nou dorsal");
                                    dorsal = ent.skip("[\r\n]*").nextInt();
                                    System.out.println("Nou dorsal: " + dorsal);
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////

                            System.out.println("\nVols modificar el gols? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (veritat = (esveritat == 'S')) {
                                do {
                                    System.out.println("Introdueix els gols");
                                    gols = ent.skip("[\r\n]*").nextInt();
                                    System.out.println("Gols: " + gols);
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////

                            System.out.println("\nVols modificar si és internacional? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (veritat = (esveritat == 'S')) {
                                do {
                                    System.out.println("És internacional? (S-N)");

                                    do {
                                        esinternacional = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

                                    } while (esinternacional != 'S' && esinternacional != 'N');
                                    internacional = (esinternacional == 'S');
                                    System.out.println("Internacional: " + esinternacional);
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////

                            System.out.println("\nVols modificar la clausula? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (veritat = (esveritat == 'S')) {
                                do {
                                    System.out.println("Introdueix la nova clausula");
                                    clausula = ent.skip("[\r\n]*").nextDouble();
                                    System.out.println("Nova clausula: " + clausula);
                                } while (esveritat != 'S' && esveritat != 'N');
                                System.out.println("\nDades modificades correctament");
                            } else {
                                break;
                            }

                        }
                    } else {
                        System.out.println("\nNo hi ha dades per modificar");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\n\nOpció incorrecta!!");
            }

        } while (opcio != 1);

    }

}

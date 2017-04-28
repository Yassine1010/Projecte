/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

/**
 *
 * @author yassine10
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class PROJECTE{

    public static final int MAX_JUGADORS = 200;

    private static Jugador[] array = new Jugador[MAX_JUGADORS];

    private static int opcio;
    
    private static File fitxer=new File("jugadors.db");
    
    public static Jugador[] getArray(){
    
        return array;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        inicialitzarVariables();
        do {
            demanarOpcio();
            tractarOpcio();
        } while (!opcioFinal());
    }

    public static int inicialitzarVariables() {
        int i=0;
        if(fitxer.exists()){
            //L'usem per si no caben els objectes del fitxer a l'array poder finalitzar l'execució
            boolean acabar=false;
            
            //Obrim el fitxer per lectura
            ObjectInputStream lectura=null;
            try{
                //Obrim el fitxer per lectura
                lectura=new ObjectInputStream(new BufferedInputStream(new FileInputStream(fitxer)));
                
                while(true){
                    array[i]=(Jugador) lectura.readObject();
                    //Incrementar la i per separat ja que sinó dixem una casella a null
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                //Si entrem aquí és per que al fitxer hi ha més pilots que els que caben a l'array. 
                //Podríem avisar a l'usuari i dixar que tanque l'aplicació ja que sinó pot perdre dades...
                System.err.println("Atenció, no caben tots els objectes. Si continues pots perdre dades. Vols continuar?(S/N):");
                Scanner ent = new Scanner(System.in);
                char siNo=' ';
                do {                    
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); //usem toUpperCase() que traduix el text introduït per l'usuari a majúscules, 
                    //per tant només haurem de tractar les lletres majúscules
                } while (siNo != 'S' && siNo != 'N');
                if(siNo=='N') acabar=true;
                
            } catch (IOException ex) {
                //Aquí no cal fer res ja que significa que hem arribat al final del fitxer
            } catch (ClassNotFoundException ex) {
                //Aquí tampoc cal fer res ja que significa que el fitxer llegit no conté objectes de la classe Pilot
            }finally{
                try {
                    //Molt important tancar el fitxer de lectura
                    if(lectura!=null) lectura.close();
                } catch (IOException ex) {
                    //No cal mostrar res
                }
                //Si hem decidit acabar parem l'execucuió
                if(acabar) System.exit(0);
            }
        
        }
        int primeraBuida=i;
        //Inicialitzem l'array en nous pilots sense dades
        for (; i < array.length; i++) {
            array[i] = new Jugador();
            array[i].setOmplit(false);
        }
        
        return primeraBuida;
    }

    public static void demanarOpcio() {
        Scanner ent = new Scanner(System.in);

        System.out.println("\nMenú del programa.");
        System.out.println("0. Sortir del programa.");
        System.out.println("1. Afgir dades dels jugadors.");
        System.out.println("2. Borrar dades.");
        System.out.println("3. Modificar dades.");
        System.out.println("4. Llistar jugadors.");
        System.out.println("5. Recuperar dades.");
        opcio = ent.skip("[\r\n]*").nextInt();

    }

    public static void tractarOpcio() {

        switch (opcio) {
            case 0:                             //0. Sortir
                System.out.println("Has sortit del programa!");
                finalitzar();
                break;
            case 1:                             //1. Introduïr pilot
                introduirJugador();
                break;
            case 2:                             //2. Modificar pilot
                borrarJugador();
                break;
            case 3:                                     //3. Borrar pilot
                modificarJugador();
                break;
            case 4:                                     //4. Llistar pilots
                llistarJugador();
                break;
            case 5:                                     //5. Recuperar pilot borrat
                recuperarJugador();
                break;
            default:
                System.out.println("\nOpció incorrecta!!");
        }

    }
    
    public static boolean opcioFinal() {
        return opcio == 0;
    }
    
    public static void finalitzar(){
        //Obrim el fitxer per escriptura
        ObjectOutputStream escriptura=null;
        try{
            //Obrim el fitxer
            escriptura=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fitxer)));

            //Recorrem l'array guardant els objectes vàlids al fitxer
            for(int i=0;i<array.length;i++){
                //Guardem al fitxer els pilots omplits
                if(array[i].isOmplit())escriptura.writeObject(array[i]);
            }
        } catch (IOException ex) {
            //Aquí podem avisar a l'usuari de que no s'han guardat les dades
            System.err.println("Error en guardar les dades!!");
        } finally{
            try {
                //Molt important tancar el fitxer d'escriptura
                if(escriptura!=null) escriptura.close();
            } catch (IOException ex) {
                //No cal mostrar res
            }

        }

        //Missatge de comiat
        System.out.println("Adéu!!");

    }


    public static void introduirJugador() {
        Scanner ent = new Scanner(System.in);
        char posicio;
        int i;
        for (i = 0; i < array.length && array[i].isOmplit(); i++);
        if (i < array.length) {
            System.out.println("Introdueix el nom del jugador");
            array[i].setNom(ent.skip("[\r\n]*").nextLine());
            do {
                System.out.println("Introdueix la seva posició al camp: A = Delanter, M = Migcampista, D = Defensa, P = Porter. ");
                array[i].setPosicio (posicio=ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0));  
                //array[i].setPosicio(posicio='A');
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
            array[i].setDorsal(ent.skip("[\r\n]*").nextInt());
            System.out.println("Introdueix el número de gols");
            array[i].setGols (ent.skip("[\r\n]*").nextInt());
            System.out.println("És internacional?");
            System.out.println("S per dir SI, N per NO");
            char esinternacional;
            do {
               esinternacional =ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

            } while (esinternacional != 'S' && esinternacional != 'N');
            array[i].setInternacional (esinternacional == 'S');
            
            System.out.println("Introdueix quina clausula te");
            array[i].setClausula(ent.skip("[\r\n]*").nextDouble());
            System.out.println("\nDades introduïdes correctament!!");
            array[i].setOmplit(true);

        } else {
            System.out.println("\nJa has introduït dades, si vols tornar a omplir, primer borra.");
        }

    }

    public static void borrarJugador() {
        Scanner ent = new Scanner(System.in);
        int i=0;
        char esveritat;
        if (array[i].isOmplit()) {

                        System.out.print("\nVols veure les dades del jugador abans de borrar? (S/N)");
                        do {
                            esveritat=ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

                        } while (esveritat != 'S' && esveritat != 'N');
                        array[i].setVeritat(esveritat == 'S');
                        
                        if (array[i].isVeritat())  {
                            System.out.println("\nDades del jugador\n");
                            System.out.println("Nom: " + array[i].getNom());
                            System.out.println("Posició: " + array[i].getPosicio());
                            System.out.println("Dorsal: " + array[i].getDorsal());
                            System.out.println("Gols: " + array[i].getGols());
                            System.out.println("Internacional SI-NO: " + array[i].isInternacional());
                            System.out.println("Clausula: " + array[i].getClausula());
                            System.out.print("\nVols borrar les dades? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            
                            if (array[i].isVeritat()) {
                                System.out.println("Segur? (S-N)");
                                do {
                                    esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                                } while (esveritat != 'S' && esveritat != 'N');
                                if (array[i].isVeritat()) {
                                    System.out.println("\nDades borrades correctament!");

                                    array[i].setOmplit(false);
                                }

                            } else {
                                System.out.println("\nNo s'ha borrat cap jugador");
                            }

                        } else {
                            System.out.print("\nVols borrar les dades? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (array[i].isVeritat()) {
                                System.out.println("Segur? (S-N)");
                                do {
                                    esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                                } while (esveritat != 'S' && esveritat != 'N');
                                if (array[i].isVeritat()) {
                                    System.out.println("\nDades borrades correctament!");
                                    array[i].setOmplit(false);
                                }

                            } else {
                                System.out.println("\nNo s'ha borrat cap jugador");
                            }
                        }

                    } else {
                        System.out.println("\nLes dades ja estàn borrades");

                    }
                    
    }

    
public static void modificarJugador() {
    Scanner ent = new Scanner(System.in);
    char posicio;
    char esveritat;
    char esinternacional;
    int i=0;
        if (array[i].isOmplit()) {

                        System.out.print("\nVols veure les dades del jugador abans de modificar? (S/N)");
                        do {
                            esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

                        } while (esveritat != 'S' && esveritat != 'N');
                         array[i].setVeritat(esveritat == 'S');
                        if (array[i].isVeritat()) {
                            System.out.println("\nDades del jugador\n");
                            System.out.println("Nom: " + array[i].getNom());
                            System.out.println("Posició: " + array[i].getPosicio());
                            System.out.println("Dorsal: " + array[i].getDorsal());
                            System.out.println("Gols: " + array[i].getGols());
                            System.out.println("Internacional SI-NO: " + array[i].isInternacional());
                            System.out.println("Clausula: " + array[i].getClausula());
                            //////----------------------------------------------//////////

                            System.out.print("\nVols modificar el nom? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (array[i].isVeritat()) {
                                do {
                                    System.out.println("Introdueix el nou nom");
                                    array[i].setNom(ent.skip("[\r\n]*").nextLine());
                                    System.out.println("\nNou nom: " + array[i].getNom());
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////

                            System.out.print("\nVols modificar la posició? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (array[i].isVeritat()) {
                                do {
                                    do {
                                        System.out.println("Introdueix la seva posició al camp: A = Delanter, M = Migcampista, D = Defensa, P = Porter. ");
                                        array[i].setPosicio(ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0));
                                        array[i].setPosicio(posicio='A');
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

                                    System.out.println("\nNova posició: " + posicio);
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////

                            System.out.print("\nVols modificar el dorsal? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (array[i].isVeritat()) {
                                do {
                                    System.out.println("Introdueix el nou dorsal");
                                    array[i].setDorsal(ent.skip("[\r\n]*").nextInt());
                                    System.out.println("\nNou dorsal: " + array[i].getDorsal());
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////

                            System.out.print("\nVols modificar el gols? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (array[i].isVeritat()) {
                                do {
                                    System.out.println("Introdueix els gols");
                                    array[i].setGols(ent.skip("[\r\n]*").nextInt());
                                    System.out.println("\nGols: " + array[i].getGols());
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////

                            System.out.print("\nVols modificar si és internacional? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (array[i].isVeritat()) {
                                do {
                                    System.out.print("És internacional? (S-N)");

                                    do {
                                        esinternacional = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

                                    } while (esinternacional != 'S' && esinternacional != 'N');
                                    array[i].setInternacional(esinternacional == 'S');
                                    System.out.println("\nInternacional: " + esinternacional);
                                } while (esveritat != 'S' && esveritat != 'N');
                            }
                            //////----------------------------------------------//////////

                            System.out.print("\nVols modificar la clausula? (S-N)");
                            do {
                                esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esveritat != 'S' && esveritat != 'N');
                            if (array[i].isVeritat()) {
                                do {
                                    System.out.println("Introdueix la nova clausula");
                                    array[i].setClausula(ent.skip("[\r\n]*").nextDouble());
                                    System.out.println("\nNova clausula: " + array[i].getClausula());
                                } while (esveritat != 'S' && esveritat != 'N');
                                System.out.println("\nDades modificades correctament");
                            } else {
                                System.out.println("No s'ha modificat");
                            }

                        }
                    } else {
                        System.out.println("\nNo hi ha dades per modificar");
                    }
    }

    public static void llistarJugador() {
        int i=0;
        if (array[i].isOmplit()) {

                System.out.println("\nDades del jugador\n");
                            System.out.println("Nom: " + array[i].getNom());
                            System.out.println("Posició: " + array[i].getPosicio());
                            System.out.println("Dorsal: " + array[i].getDorsal());
                            System.out.println("Gols: " + array[i].getGols());
                            System.out.println("Internacional SI-NO: " + array[i].isInternacional());
                            System.out.println("Clausula: " + array[i].getClausula());

                    } else {
                        System.out.println("\nNo hi han dades per mostrar");
                    }
    }

    public static void recuperarJugador() {
        Scanner ent = new Scanner(System.in);
        char esveritat;
        int i=0;
        if (!array[i].isOmplit()) {
                        System.out.println("\nAquestes són les dades que vols recuperar\n");
                        array[i].setOmplit(true);
                            System.out.println("Nom: " + array[i].getNom());
                            System.out.println("Posició: " + array[i].getPosicio());
                            System.out.println("Dorsal: " + array[i].getDorsal());
                            System.out.println("Gols: " + array[i].getGols());
                            System.out.println("Internacional SI-NO: " + array[i].isInternacional());
                            System.out.println("Clausula: " + array[i].getClausula());
                        System.out.print("\nles vols recuperar? (S-N)");
                        do {
                            esveritat = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                        } while (esveritat != 'S' && esveritat != 'N');
                         array[i].setVeritat(esveritat == 'S');
                        if (array[i].isVeritat()) {
                            do {

                            } while (esveritat != 'S' && esveritat != 'N');
                            System.out.println("\nDades recuperades correctament!!");

                        } else {
                            array[i].setOmplit(false);
                            
                        }
                    } else {
                        System.out.println("\nNo hi han dades per recuperar");
                    }
                    

            }

       
    

}

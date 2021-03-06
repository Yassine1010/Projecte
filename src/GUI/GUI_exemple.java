/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodes.GUI_UF3;
import projecte.Jugador;
import projecte.PROJECTE;
import static projecte.PROJECTE.inicialitzarVariables;

/**
 *
 * @author alumne
 */
public class GUI_exemple extends javax.swing.JFrame {
    //usada per saber si hi ha alguna fila de la taula seleccionada, i quina es
    private static int filSel=-1;
    private static int primeraBuida;
    /**
     * Creates new form GUI_exemple
     */
    public GUI_exemple() {
        initComponents();        
        inicialitzaComponents();
    }
    
    private void inicialitzaComponents(){
     botoborrar.setEnabled(false);
     botomodificar.setEnabled(false);
     primeraBuida=inicialitzarVariables();
     GUI_UF3.carregaTaula(new String[]{"Fila","Nom", "Posició", "Dorsal", "Gols","Internacional","Clausula"}, 
                transformaDades(PROJECTE.getArray())
               
                , taula);
   
    }
    
    public static Object[][] transformaDades(Jugador[] dades){
        Object[][] resultat=new Object[dades.length][7];
        //Variable per comptar el número de jugadors en dades que hi ha a l'array de dades
        int omplits=0;
        
        for (int i = 0; i < dades.length; i++) {
            if(dades[i].isOmplit()){
                resultat[omplits][0]=i;
                resultat[omplits][1]=dades[i].getNom();
                resultat[omplits][2]=dades[i].getPosicio();
                resultat[omplits][3]=dades[i].getDorsal();
                resultat[omplits][4]=dades[i].getGols();
                resultat[omplits][5]=dades[i].isInternacional();
                resultat[omplits][6]=dades[i].getClausula();
                omplits++;
            }
        }
        //Retornem només els pilots plens
        return Arrays.copyOf(resultat,omplits);
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        taula = new javax.swing.JTable();
        Nom = new javax.swing.JTextField();
        dorsal = new javax.swing.JTextField();
        gols = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botoinserir = new javax.swing.JButton();
        botomodificar = new javax.swing.JButton();
        botoborrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        internacionalsi = new javax.swing.JRadioButton();
        internacionalno = new javax.swing.JRadioButton();
        botosortir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        clausula = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        esdelanter = new javax.swing.JRadioButton();
        esmig = new javax.swing.JRadioButton();
        esdefensa = new javax.swing.JRadioButton();
        esporter = new javax.swing.JRadioButton();
        nou = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        taula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nom", "Title 2", "Title 3", "Title 4"
            }
        ));
        taula.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        taula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taula);

        Nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom");

        jLabel2.setText("Drosal");

        jLabel3.setText("Gols");

        botoinserir.setText("Insertar");
        botoinserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoinserirActionPerformed(evt);
            }
        });

        botomodificar.setText("Modificar");
        botomodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botomodificarActionPerformed(evt);
            }
        });

        botoborrar.setText("Borrar");
        botoborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoborrarActionPerformed(evt);
            }
        });

        jLabel5.setText("Internacional");

        buttonGroup2.add(internacionalsi);
        internacionalsi.setText("SI");
        internacionalsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internacionalsiActionPerformed(evt);
            }
        });

        buttonGroup2.add(internacionalno);
        internacionalno.setText("NO");

        botosortir.setText("Sortir");
        botosortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botosortirActionPerformed(evt);
            }
        });

        jLabel6.setText("Clausula");

        jLabel4.setText("Posicio");

        buttonGroup3.add(esdelanter);
        esdelanter.setText("Delanter");

        buttonGroup3.add(esmig);
        esmig.setText("Mig campista");
        esmig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esmigActionPerformed(evt);
            }
        });

        buttonGroup3.add(esdefensa);
        esdefensa.setText("Defensa");
        esdefensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esdefensaActionPerformed(evt);
            }
        });

        buttonGroup3.add(esporter);
        esporter.setText("Porter");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(esdelanter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(esmig))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(esdefensa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(esporter)))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(esdelanter)
                    .addComponent(esmig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(esdefensa)
                    .addComponent(esporter))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        nou.setText("Nou");
        nou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nouActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clausula, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(internacionalsi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(internacionalno)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gols, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dorsal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 157, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nou)
                        .addGap(22, 22, 22)
                        .addComponent(botoinserir)
                        .addGap(18, 18, 18)
                        .addComponent(botomodificar)
                        .addGap(32, 32, 32)
                        .addComponent(botoborrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botosortir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(dorsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(clausula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(gols, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(internacionalsi)
                            .addComponent(internacionalno)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botoinserir)
                    .addComponent(botomodificar)
                    .addComponent(botoborrar)
                    .addComponent(botosortir)
                    .addComponent(nou))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomActionPerformed

    private void taulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaMouseClicked
        // TODO add your handling code here:
        filSel=taula.getSelectedRow();
        
        if(filSel==-1){ //si no han seleccionat cap fila desactivo els botonos de borrar i modificar
            botoborrar.setEnabled(false);
            botomodificar.setEnabled(false);
            
            //posar caselles en blanc
            Nom.setText("");
            dorsal.setText("");
            gols.setText("");
            clausula.setText("");
            internacionalsi.setSelected(true);
            esdelanter.setSelected(true);
        }else{           
            botoborrar.setEnabled(true);
            botomodificar.setEnabled(true);
            
            //actualitzo les caselles en la informacio de la fila seleccionada
            Nom.setText((String)taula.getValueAt(filSel, 1));    
            switch((char)taula.getValueAt(filSel, 2)){
                case 'A':
                    esdelanter.setSelected(true);
                    break;
                case 'M':
                    esmig.setSelected(true);
                    break;
                case 'D':
                    esdefensa.setSelected(true);
                    break;
                case 'P':
                    esporter.setSelected(true);
                    break;
            }
            dorsal.setText(String.valueOf(taula.getValueAt(filSel, 3))); //per a numeros
            gols.setText(String.valueOf(taula.getValueAt(filSel, 4)));           
            if((boolean)taula.getValueAt(filSel, 5))
                internacionalsi.setSelected(true);
            else internacionalno.setSelected(true);
            clausula.setText(String.valueOf(taula.getValueAt(filSel, 6)));
                  
        }
    
    }//GEN-LAST:event_taulaMouseClicked

    private void esdefensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esdefensaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esdefensaActionPerformed
    private boolean dadesCorrectes(){
    try{
        //forma1
//        Nom.getText().trim().charAt(0);
        //forma2
        if(Nom.getText().trim().equals("")) throw new StringIndexOutOfBoundsException();
        Integer.valueOf(dorsal.getText());
        Integer.valueOf(gols.getText());
        Double.valueOf(clausula.getText());
        //falten..
    } catch (StringIndexOutOfBoundsException|NumberFormatException e) {
        return false;
    }
        return true;
    }
    private void botomodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botomodificarActionPerformed
        filSel=taula.getSelectedRow();
        
//primer mirem si les dades de les caselles son correctes
        if(!dadesCorrectes()){
        JOptionPane.showMessageDialog(this, "Dades de les caselles incorrectes!");
        return;
        }

// obtenim l'index de l'array a partir del valor de la columna 0 de la taula
      int iArray=(int)taula.getValueAt(filSel, 0);
      Jugador[] array=PROJECTE.getArray();
      array[iArray].setNom(Nom.getText()); 
      if (esdelanter.isSelected()){
      array[iArray].setPosicio('A');}
      if (esmig.isSelected()){
      array[iArray].setPosicio('M');}
      if (esdefensa.isSelected()){
      array[iArray].setPosicio('D');}
      if (esporter.isSelected()){
      array[iArray].setPosicio('P');}
      array[iArray].setDorsal(Integer.valueOf(dorsal.getText()));
      array[iArray].setGols(Integer.valueOf(gols.getText()));
      array[iArray].setInternacional(internacionalsi.isSelected());
      array[iArray].setClausula(Double.valueOf(clausula.getText()));
       



      GUI_UF3.carregaTaula(new String[]{"Fila","Nom", "Posició", "Dorsal", "Gols","Internacional","Clausula"}, 
                transformaDades(PROJECTE.getArray())
                , taula);
      JOptionPane.showMessageDialog(this, "Dades modificades!");
       //si no han seleccionat cap fila desactivo els botonos de borrar i modificar
            botoborrar.setEnabled(false);
            botomodificar.setEnabled(false);
    }//GEN-LAST:event_botomodificarActionPerformed

    private void internacionalsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internacionalsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_internacionalsiActionPerformed

    private void botosortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botosortirActionPerformed
           // TODO add your handling code here:
           
           PROJECTE.finalitzar();
           System.exit(1);
    }//GEN-LAST:event_botosortirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
        PROJECTE.finalitzar();
        
    }//GEN-LAST:event_formWindowClosing

    private void botoinserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoinserirActionPerformed
        // TODO add your handling code here:
        Jugador[] array=PROJECTE.getArray();   
        for (primeraBuida = 0; primeraBuida < array.length && array[primeraBuida].isOmplit(); primeraBuida++);
                    
                array[primeraBuida].setNom(Nom.getText());
                if (esdelanter.isSelected()){
                array[primeraBuida].setPosicio('A');}
                if (esmig.isSelected()){
                array[primeraBuida].setPosicio('M');}
                if (esdefensa.isSelected()){
                array[primeraBuida].setPosicio('D');}
                if (esporter.isSelected()){
                array[primeraBuida].setPosicio('P');}
                array[primeraBuida].setDorsal(Integer.valueOf(dorsal.getText()));
                array[primeraBuida].setGols(Integer.valueOf(gols.getText()));
                array[primeraBuida].setInternacional(internacionalsi.isSelected());
                array[primeraBuida].setClausula(Double.valueOf(clausula.getText()));
                
                array[primeraBuida].setOmplit(true);
                
GUI_UF3.carregaTaula(new String[]{"Fila","Nom", "Posició", "Dorsal", "Gols","Internacional","Clausula"}, 
                transformaDades(PROJECTE.getArray())
                , taula); 
//Posem les caselles buides despres d'insertar
            Nom.setText("");
            dorsal.setText("");
            gols.setText("");
            clausula.setText("");
            internacionalsi.setSelected(true);
            esdelanter.setSelected(true);
               
    }//GEN-LAST:event_botoinserirActionPerformed

    private void botoborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoborrarActionPerformed
        // TODO add your handling code here:
        filSel=taula.getSelectedRow();
        int iArray=(int)taula.getValueAt(filSel, 0);
        Jugador[] array=PROJECTE.getArray(); 
       
        for (int i = filSel; i < array.length-1; i++) {
            array[i]=array[i+1];           
        } 
        GUI_UF3.carregaTaula(new String[]{"Fila","Nom", "Posició", "Dorsal", "Gols","Internacional","Clausula"}, 
                transformaDades(PROJECTE.getArray())
                , taula);
        //si no han seleccionat cap fila desactivo els botonos de borrar i modificar
            botoborrar.setEnabled(false);
            botomodificar.setEnabled(false);
    }//GEN-LAST:event_botoborrarActionPerformed

    private void nouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nouActionPerformed
        // TODO add your handling code here:
            Nom.setText("");
            dorsal.setText("");
            gols.setText("");
            clausula.setText("");
            internacionalsi.setSelected(true);
            esdelanter.setSelected(true);
    }//GEN-LAST:event_nouActionPerformed

    private void esmigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esmigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esmigActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_exemple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_exemple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_exemple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_exemple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_exemple().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Nom;
    private javax.swing.JButton botoborrar;
    private javax.swing.JButton botoinserir;
    private javax.swing.JButton botomodificar;
    private javax.swing.JButton botosortir;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTextField clausula;
    private javax.swing.JTextField dorsal;
    private javax.swing.JRadioButton esdefensa;
    private javax.swing.JRadioButton esdelanter;
    private javax.swing.JRadioButton esmig;
    private javax.swing.JRadioButton esporter;
    private javax.swing.JTextField gols;
    private javax.swing.JRadioButton internacionalno;
    private javax.swing.JRadioButton internacionalsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nou;
    private javax.swing.JTable taula;
    // End of variables declaration//GEN-END:variables

}

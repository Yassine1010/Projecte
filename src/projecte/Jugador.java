/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

/**
 *
 * @author alumne
 */
public class Jugador {

    //les meves propietats
    private String nom = null;
    private char posicio = 0;
    private char esinternacional = 0;
    private int opcio = 0;
    private int dorsal = 0;
    private int gols = 0;
    private boolean internacional = false;
    private double clausula = 0.0;
    private char esveritat = 0;
    private boolean veritat = false;
    private boolean omplit;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char getPosicio() {
        return posicio;
    }

    public void setPosicio(char posicio) {
        this.posicio = posicio;
    }

    public char getEsinternacional() {
        return esinternacional;
    }

    public void setEsinternacional(char esinternacional) {
        this.esinternacional = esinternacional;
    }

    public int getOpcio() {
        return opcio;
    }

    public void setOpcio(int opcio) {
        this.opcio = opcio;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public boolean isInternacional() {
        return internacional;
    }

    public void setInternacional(boolean internacional) {
        this.internacional = internacional;
    }

    public double getClausula() {
        return clausula;
    }

    public void setClausula(double clausula) {
        this.clausula = clausula;
    }

    public char getEsveritat() {
        return esveritat;
    }

    public void setEsveritat(char esveritat) {
        this.esveritat = esveritat;
    }

    public boolean isVeritat() {
        return veritat;
    }

    public void setVeritat(boolean veritat) {
        this.veritat = veritat;
    }
    
    public boolean isOmplit() {
        return omplit;
    }
    
    public void setOmplit(boolean omplit) {
        this.omplit = omplit;
    }

}

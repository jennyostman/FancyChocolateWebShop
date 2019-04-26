/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcu
 * aer awesome
 */

package testMarcus;


public class ChokladProdukt {

    private String namn;
    private int id;
    private double pris;
    private String beskrivning;
    private String marke;
    private int antalet;
    private String bildsrc;
    
    public ChokladProdukt(String namn, double pris, int id){
        this.namn=namn;
        this.pris=pris;
        this.id=id;
    }

    public ChokladProdukt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(float pris) {
        this.pris = pris;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getAntalet() {
        return antalet;
    }

    public void setAntalet(int antalet) {
        this.antalet = antalet;
    }

    public String getBildsrc() {
        return bildsrc;
    }

    public void setBildsrc(String bildsrc) {
        this.bildsrc = bildsrc;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hitung_bangunRuang;

/**
 *
 * @author hp
 */
public class Keratan extends Bola {
    private double rAtas, tinggi;

    public Keratan(double rAtas, double r, double tinggi) {
        super(r);
        this.rAtas = rAtas;
        this.tinggi = tinggi;
    }

    public double getrAtas(double rAtas) {
        return rAtas;
    }

    public void setrAtas(double rAtas) {
        this.rAtas = rAtas;
    }
    
    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
    
    public double menghitungLuasKeratan() {
        return (Math.PI * Math.pow(getTinggi(), 2)) + 2 * Math.PI * getR(r) * getrAtas(rAtas);
    }
    
    public double menghitungVolumeKeratan() {
        return 1.0 / 6.0 * Math.PI * getTinggi() * (3 * Math.pow(getR(r), 2)
                + 3 * Math.pow(getrAtas(rAtas), 2) + Math.pow(getTinggi(), 2));
    }
}

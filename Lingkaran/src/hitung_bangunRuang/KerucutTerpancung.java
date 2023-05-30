/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hitung_bangunRuang;

/**
 *
 * @author hp
 */

public class KerucutTerpancung extends Kerucut {
    private double rAtas;

    public KerucutTerpancung(double rAtas, double tinggi, double r) {
        super(tinggi, r);
        this.rAtas = rAtas;
    }

    public double getrAtas() {
        return rAtas;
    }

    public void setrAtas(double rAtas) {
        this.rAtas = rAtas;
    }
    
    @Override
    public double menghitungSisiMiring() {
        sisiMiring = (double) Math.sqrt((Math.pow(getR(r) - this.rAtas, 2)) + (Math.pow(getTinggi(), 2)));
        return sisiMiring;
    }
    
    @Override
    public double menghitungVolumeKerucut() {
        return (1.0 / 3.0) * Math.PI * super.getTinggi()
                * (getR(r) * rAtas + Math.pow(getR(r), 2) + Math.pow(rAtas, 2));
    }
    
    public double hitungSelimutKerucut() {
        return Math.PI * (getR(r) + rAtas) * menghitungSisiMiring();
    }
}

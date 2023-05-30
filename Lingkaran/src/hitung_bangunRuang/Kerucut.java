/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hitung_bangunRuang;

import hitung_bangunDatar.*;

/**
 *
 * @author hp
 */
public class Kerucut extends Lingkaran {
    private double tinggi;
    public double sisiMiring;

    public Kerucut(double tinggi, double r) {
        super(r);
        this.tinggi = tinggi;
        menghitungLuasKerucut();
        menghitungVolumeKerucut();
    }
    
    public double menghitungSisiMiring() {
        sisiMiring = (double) Math.sqrt((Math.pow(getR(r), 2)) + (Math.pow(tinggi, 2)));
        return sisiMiring;
    }
    
    public double menghitungLuasKerucut() {
        luasKerucut = super.luasLingkaran + (Math.PI * getR(r) * menghitungSisiMiring());
        return luasKerucut;
    }
    
    public double menghitungLuasKerucut(double r) {
        luasKerucut = super.luasLingkaran + (Math.PI * getR(r) * menghitungSisiMiring());
        return luasKerucut;
    }
    
    public double menghitungVolumeKerucut() {
        volumeKerucut = (1.0 / 3.0) * super.luasLingkaran * getTinggi();
        return volumeKerucut;
    }
    
    public double menghitungVolumeKerucut(double r) {
        volumeKerucut = (1.0 / 3.0) * super.luasLingkaran * getTinggi();
        return volumeKerucut;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getSisiMiring() {
        return sisiMiring;
    }
}

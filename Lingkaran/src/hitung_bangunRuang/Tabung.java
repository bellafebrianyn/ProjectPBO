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
public class Tabung extends Lingkaran {
   private double tinggi;

    public Tabung(double tinggi, double r) {
        super(r);
        this.tinggi = tinggi;
        
        menghitungLuasTabung(r);
        menghitungVolumeTabung(r);
    }
    
    public double menghitungLuasTabung() {
        luasTabung = super.getMenghitungKelilingLingkaran() * (getR(r)+this.tinggi);
        return luasTabung;
    }
    
    public double menghitungLuasTabung(double r) {
        luasTabung = super.getMenghitungKelilingLingkaran() * (getR(r)+this.tinggi);
        return luasTabung;
    }
    
    public double menghitungVolumeTabung() {
        volumeTabung = super.getMenghitungLuasLingkaran()* getTinggi();
        return volumeTabung;
    }
    
    public double menghitungVolumeTabung(double r) {
        volumeTabung = super.getMenghitungLuasLingkaran()* getTinggi();
        return volumeTabung;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hitung_bangunDatar;

/**
 *
 * @author hp
 */
public class Lingkaran implements HitungBangunDatar {

    public double kelilingLingkaran;
    public double luasLingkaran;
    public double r;
    public double luasTabung, volumeTabung;
    public double luasKerucut, volumeKerucut;
    public double luasBola, volumeBola;
    

    public Lingkaran(double r) {
        this.r = r;
        menghitungKelilingLingkaran(r);
        menghitungLuasLingkaran(r);
    }

    public double menghitungKelilingLingkaran(double r) {
        kelilingLingkaran = (double) (2 * Math.PI * r);
        return kelilingLingkaran;
    }

    public double menghitungLuasLingkaran(double r) {
        luasLingkaran = (double) (Math.PI * this.r * this.r);
        return luasLingkaran;
    }

    public double getR(double r) {
        return r;
    }
  
    public void setR(double r) {
        this.r = r;
    }

    public double getKelilingLingkaran() {
        return kelilingLingkaran;
    }

    public void setKelilingLingkaran(double kelilingLingkaran) {
        this.kelilingLingkaran = kelilingLingkaran;
    }
    
    @Override
    public double getMenghitungKelilingLingkaran() {
        return kelilingLingkaran;
    }
    
    @Override
    public double getMenghitungLuasLingkaran() {
        return luasLingkaran;
    }

    public double menghitungLuasBola(double rBola) {
        return luasBola;
    }

    public double menghitungVolumeBola(double rBola) {
        return volumeBola;
    }
    
    public double menghitungLuasBola() {
        return luasKerucut;
    }

    public double menghitungVolumeBola() {
        return volumeKerucut;
    }
    
    public double menghitungLuasTabung(double jariAlasTabung) {
        return luasTabung;
    }

    public double menghitungVolumeTabung(double jariAlasTabung) {
        return volumeTabung;
    }
    
    public double menghitungLuasTabung() {
        return luasTabung;
    }

    public double menghitungVolumeTabung() {
        return volumeTabung;
    }
    
    public double menghitungLuasKerucut(double jariJariKecurut) {
        return luasKerucut;
    }

    public double menghitungVolumeKerucut(double jariJariKecurut) {
        return volumeKerucut;
    }

    public double menghitungLuasKerucut() {
        return luasKerucut;
    }

    public double menghitungVolumeKerucut() {
        return volumeKerucut;
    }
}

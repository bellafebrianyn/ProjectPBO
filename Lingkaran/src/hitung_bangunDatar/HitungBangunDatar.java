/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hitung_bangunDatar;

/**
 *
 * @author hp
 */
public interface HitungBangunDatar {
    
    public default double menghitungKelilingLingkaran(double jari) {
        System.out.println("Menghitung Keliling Lingkaran");
        return 0;
    };
    
    public default double menghitungLuasLingkaran(double jari) {
        System.out.println("Menghitung Luas Lingkaran");
        return 0;
    }
    
    public default int menghitungKelilingLingkaran(int jari) {
        System.out.println("Menghitung Keliling Lingkaran");
        return 0;
    }
    
    public default int menghitungLuasLingkaran(int jari) {
        System.out.println("Menghitung Luas Lingkaran");
        return 0;
    }
    
    public double getMenghitungKelilingLingkaran();
    public double getMenghitungLuasLingkaran();
    public void setR(double jari);
}

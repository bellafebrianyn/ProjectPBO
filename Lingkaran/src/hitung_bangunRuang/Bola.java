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
public class Bola extends Lingkaran {
    
    public Bola(double r) {
        super(r);
        menghitungLuasBola();
        menghitungVolumeBola();
    }
    
    public double menghitungLuasBola() {
         luasBola = 4.0*super.luasLingkaran;
         return luasBola;
    }
    
    public double menghitungLuasBola(double r) {
         luasBola = 4.0*super.luasLingkaran;
         return luasBola;
    }
    
    public double menghitungVolumeBola() {
        volumeBola = (4.0/3.0) * super.luasLingkaran* getR(r);
        return volumeBola;
    }
    
    public double menghitungVolumeBola(double r) {
        volumeBola = (4.0/3.0) * super.luasLingkaran* getR(r);
        return volumeBola;
    }
}

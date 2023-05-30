/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hitung_bangunRuang;

/**
 *
 * @author hp
 */
public class Tembereng extends Bola {
    private double jarakBidang, tinggi, theta;

    public Tembereng(double jarakBidang, double r) {
        super(r);
        this.jarakBidang = jarakBidang;
    }

    public double getJarakBidang(double jarakBidang) {
        return jarakBidang;
    }

    public void setJarakBidang(double jarakBidang) {
        this.jarakBidang = jarakBidang;
    }

    public double menghitungTinggiTembereng() {
        tinggi = getR(r) - Math.sqrt(Math.pow(getR(r), 2) - Math.pow(getJarakBidang(jarakBidang), 2));
        return tinggi;
    }
    
    public double getTheta() {
        theta = 2 * Math.acos(1 - menghitungTinggiTembereng() / getR(r));
        return theta;
    }
    
    public double menghitungLuasTembereng() {
        return (Math.pow(getR(r), 2) / 2) * (getTheta() - Math.sin(getTheta()));
    }
    
    public double menghitungVolumeTembereng() {
        return (1.0 / 3.0) * Math.PI * menghitungTinggiTembereng() * menghitungTinggiTembereng()
                * (3 * getR(r) - menghitungTinggiTembereng());
    }
}

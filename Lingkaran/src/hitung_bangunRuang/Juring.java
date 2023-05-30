/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hitung_bangunRuang;

/**
 *
 * @author hp
 */

public class Juring extends Bola {
    private double sudut;
    private double theta;

    public Juring(double sudut, double r) {
        super(r);
        this.sudut = sudut;
    }

    public double getSudut(double sudut) {
        return sudut;
    }

    public void setSudut(double sudut) {
        this.sudut = sudut;
    }
    
    public double getTheta() {
        theta = Math.toRadians(getSudut(sudut));
        return theta;
    }
    
    public double menghitungLuasJuring() {
        return (Math.pow(getR(r), 2) * getTheta()) / 2;
    }
    
    public double menghitungVolumeJuring() {
        return (Math.PI * (Math.pow(getR(r), 3)) * getTheta());
    }
}

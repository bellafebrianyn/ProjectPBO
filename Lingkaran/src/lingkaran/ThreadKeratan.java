/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import com.mysql.cj.jdbc.MysqlDataSource;
import hitung_bangunRuang.Keratan;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static lingkaran.ThreadBola.insertToFile;
import static lingkaran.ThreadLingkaran.getConnection;

/**
 *
 * @author Bella Febriany
 */
public class ThreadKeratan implements Runnable {

    static RandomAccessFile insertToFile = null;
    static Connection connect;
    static PreparedStatement ps;

    public static Connection getConnection() {
        if (connect == null) {
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("geometri");
            db.setUser("root");
            db.setPassword("");
            try {
                connect = db.getConnection();
                System.out.println("Connected");
            } catch (SQLException e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
        return connect;
    }
    
    @Override
    public void run() {
        getConnection();
        System.out.println("KERATAN BOLA");
        try {
            double rAtas = 1;
            double tinggi = 1;
            double r = 1;
            int seek = 7000;

            for (int i = 1; i <= 1000; i++) {
                Keratan keratan = new Keratan(rAtas, r, tinggi);
                keratan.setTinggi(tinggi);
                keratan.setR(r);
                keratan.setrAtas(rAtas);
                
                try {
                    insertToFile = new RandomAccessFile("lingkaran.txt", "rw");
                    insertToFile.seek(seek);
                    insertToFile.writeUTF("Keratan Bola");
                    insertToFile.writeDouble(keratan.menghitungLuasKeratan());
                    insertToFile.writeDouble(keratan.menghitungVolumeKeratan());
                    
                    ps = connect.prepareStatement( "Insert into keratan (jari_atas, jari_bawah, tinggi, volume, luas) values ("
                            + rAtas + "," + r + "," + tinggi + ","
                            + keratan.menghitungVolumeKeratan() + ","
                            + keratan.menghitungLuasKeratan() + ")");
                    ps.execute();
                } catch (IOException e) {
                    System.err.println("Error : " + e.getMessage());
                }

                rAtas++;
                r++;
                tinggi++;
                seek++;
            }
            System.out.println("data keratan dibuat....");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}

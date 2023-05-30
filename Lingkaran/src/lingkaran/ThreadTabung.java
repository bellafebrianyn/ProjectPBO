/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import com.mysql.cj.jdbc.MysqlDataSource;
import hitung_bangunDatar.Lingkaran;
import hitung_bangunRuang.Tabung;
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
public class ThreadTabung implements Runnable{

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
        System.out.println("TABUNG");
        try {
            double rAlasTabung = 1;
            double tinggi = 1;
            int seek = 1000;
            for (int i = 1; i <= 1000; i++) {
                Lingkaran tabung = new Tabung(rAlasTabung, tinggi);
                tabung.setR(rAlasTabung);

                if (rAlasTabung < 0 && tinggi < 0) {
                    throw new Exception("Jari Jari tidak boleh negatif");
                }
                try {
                    insertToFile = new RandomAccessFile("lingkaran.txt", "rw");
                    insertToFile.seek(seek);
                    insertToFile.writeUTF("Tabung");
                    insertToFile.writeDouble(rAlasTabung);
                    insertToFile.writeDouble(tinggi);
                    insertToFile.writeDouble(tabung.luasTabung);
                    insertToFile.writeDouble(tabung.volumeTabung);
                    
                    ps = connect.prepareStatement("Insert into tabung (jari_jari, tinggi,luas_alas, volume) values (" + rAlasTabung
                            + ","
                            + tinggi + "," + tabung.luasTabung + "," + tabung.volumeTabung + ")");
                    ps.execute();
                } catch (IOException e) {
                    System.err.println("Error : " + e.getMessage());
                }
                
                rAlasTabung++;
                tinggi++;
                seek++;
            }
            System.out.println("data tabung dibuat....");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}

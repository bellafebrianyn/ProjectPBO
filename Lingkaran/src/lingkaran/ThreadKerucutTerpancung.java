/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import com.mysql.cj.jdbc.MysqlDataSource;
import hitung_bangunRuang.KerucutTerpancung;
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
public class ThreadKerucutTerpancung implements Runnable {

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
        System.out.println("KERUCUT TERPANCUNG");
        try {
            double rBesar = 1;
            double rKecil = 1;
            double tinggiKerucutTerpancung = 1;
            int seek = 3000;
            for (int i = 1; i <= 1000; i++) {
                KerucutTerpancung kerucutTerpancung = new KerucutTerpancung(rBesar, tinggiKerucutTerpancung, rKecil);
                kerucutTerpancung.setR(rBesar);
                kerucutTerpancung.setTinggi(tinggiKerucutTerpancung);
                kerucutTerpancung.setrAtas(rKecil);

              
                try {
                    insertToFile = new RandomAccessFile("lingkaran.txt", "rw");
                    insertToFile.seek(seek);
                    insertToFile.writeUTF("Kerucut Terpancung");
                    insertToFile.writeDouble(rBesar);
                    insertToFile.writeDouble(rKecil);
                    insertToFile.writeDouble(kerucutTerpancung.hitungSelimutKerucut());
                    insertToFile.writeDouble(kerucutTerpancung.menghitungVolumeKerucut());
                    
                    ps = connect.prepareStatement("Insert into terpancung (jari_besar, jari_kecil, tinggi, luas_selimut, volume) values ("
                            + rBesar + "," +rKecil + ","
                            + tinggiKerucutTerpancung + "," + kerucutTerpancung.hitungSelimutKerucut() + ","
                            + kerucutTerpancung.menghitungVolumeKerucut() + ")");
                    ps.execute();
                } catch (IOException e) {
                    System.err.println("Error : " + e.getMessage());
                }

                rBesar++;
                rKecil++;
                tinggiKerucutTerpancung++;
                seek++;
            }
            System.out.println("data kerucut terpancung dibuat....");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
}

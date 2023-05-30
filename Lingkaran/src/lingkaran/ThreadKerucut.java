/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import com.mysql.cj.jdbc.MysqlDataSource;
import hitung_bangunDatar.Lingkaran;
import hitung_bangunRuang.Kerucut;
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
public class ThreadKerucut implements Runnable {

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
        System.out.println("KERUCUT");
        try {
            double rAlasKerucut = 1;
            double tinggiKerucut = 1;
            int seek = 2000;
            for (int i = 1; i <= 1000; i++) {
                Lingkaran kerucut = new Kerucut(rAlasKerucut, tinggiKerucut);
                kerucut.setR(rAlasKerucut);

                if (rAlasKerucut < 0 && tinggiKerucut < 0) {
                    throw new Exception("Jari Jari tidak boleh negatif");
                }
                try {
                    insertToFile = new RandomAccessFile("lingkaran.txt", "rw");
                    insertToFile.seek(seek);
                    insertToFile.writeUTF("Kerucut");
                    insertToFile.writeDouble(rAlasKerucut);
                    insertToFile.writeDouble(tinggiKerucut);
                    insertToFile.writeDouble(kerucut.luasKerucut);
                    insertToFile.writeDouble(kerucut.volumeKerucut);
                    
                    ps = connect.prepareStatement("Insert into kerucut (jari_jari, tinggi, luas_kerucut, volume_kerucut) values ("
                            + rAlasKerucut
                            + ","
                            + tinggiKerucut + "," + kerucut.luasKerucut + "," + kerucut.volumeKerucut + ")");
                    ps.execute();
                } catch (IOException e) {
                    System.err.println("Error : " + e.getMessage());
                }

                rAlasKerucut++;
                tinggiKerucut++;
                seek++;
            }
            System.out.println("data kerucut dibuat....");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 
}

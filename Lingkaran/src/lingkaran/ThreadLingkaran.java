/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import com.mysql.cj.jdbc.MysqlDataSource;
import hitung_bangunDatar.Lingkaran;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static lingkaran.ThreadBola.insertToFile;


/**
 *
 * @author Bella Febriany
 */
public class ThreadLingkaran implements Runnable{
    
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
        System.out.println("LINGKARAN");
        try {
            double r = 1;
            int seek = 0;
            for (int i = 1; i <= 1000; i++) {
                Lingkaran lingkaran = new Lingkaran(r);
                lingkaran.setR(r);
                if (r < 0) {
                    throw new Exception("Jari Jari tidak boleh negatif");
                }
                try {
                    insertToFile = new RandomAccessFile("lingkaran.txt", "rw");
                    insertToFile.seek(seek);
                    insertToFile.writeUTF("Lingkaran");
                    insertToFile.writeDouble(r);
                    insertToFile.writeDouble(lingkaran.luasLingkaran);
                    insertToFile.writeDouble(lingkaran.kelilingLingkaran);
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //connect = (Connection) 
                    ps = connect.prepareStatement("Insert into lingkaran (jari_jari, luas, keliling) values (" + r + ","
                            + lingkaran.luasLingkaran + "," + lingkaran.kelilingLingkaran + ")");
                    ps.execute();
                } catch (IOException e) {
                    System.err.println("Error : " + e.getMessage());
                }
                
                r++;
                seek++;
            }
            System.out.println("data lingkaran dibuat....");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

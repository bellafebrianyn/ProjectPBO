/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import com.mysql.cj.jdbc.MysqlDataSource;
import hitung_bangunRuang.Juring;
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
public class ThreadJuring implements Runnable {

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
          System.out.println("JURING BOLA");
        try {
            double rJuring = 1;
            double sudut = 1;
            int seek = 5000;

            for (int i = 1; i <= 1000; i++) {
                Juring juring = new Juring(rJuring, sudut);
                juring.getR(rJuring);
                juring.setSudut(sudut);
                
                try {
                    insertToFile = new RandomAccessFile("lingkaran.txt", "rw");
                    insertToFile.seek(seek);
                    insertToFile.writeUTF("Juring Bola");
                    insertToFile.writeDouble(juring.getTheta());
                    insertToFile.writeDouble(juring.menghitungLuasJuring());
                    insertToFile.writeDouble(juring.menghitungVolumeJuring());
                    
                    ps = connect.prepareStatement("Insert into juring (jari_jari, luas, volume, tetha) values ("
                            + rJuring + "," + juring.menghitungLuasJuring() + "," + juring.menghitungVolumeJuring() + ","
                            + juring.getTheta() + ")");
                    ps.execute();
                } catch (IOException e) {
                    System.err.println("Error : " + e.getMessage());
                }
                rJuring++;
                sudut++;
                seek++;
            }
            System.out.println("data juring dibuat....");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}

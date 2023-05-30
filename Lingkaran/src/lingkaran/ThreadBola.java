/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import com.mysql.cj.jdbc.MysqlDataSource;
import hitung_bangunDatar.Lingkaran;
import hitung_bangunRuang.Bola;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static lingkaran.ThreadLingkaran.getConnection;


/**
 *
 * @author Bella Febriany
 */
public class ThreadBola implements Runnable {

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
        System.out.println("BOLA ");
        try {
            double rBola = 1;
            int seek = 4000;
            for (int i = 1; i <= 1000; i++) {
                Lingkaran bola = new Bola(rBola);
                bola.setR(rBola);
                      try {
                    insertToFile = new RandomAccessFile("lingkaran.txt", "rw");
                    insertToFile.seek(seek);
                    insertToFile.writeUTF("bola");
                    insertToFile.writeDouble(rBola);
                    insertToFile.writeDouble(bola.luasBola);
                    insertToFile.writeDouble(bola.luasBola);
                  
                    ps = connect.prepareStatement("Insert into bola (jar_jari, luas, volume) values ("
                            + rBola + "," + bola.luasBola + ","
                            + bola.volumeBola + ")");
                    ps.execute();
                } catch (IOException e) {
                    System.err.println("Error : " + e.getMessage());
                }
                rBola++;
                seek++;
            }
            System.out.println("data bola dibuat....");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }   
}

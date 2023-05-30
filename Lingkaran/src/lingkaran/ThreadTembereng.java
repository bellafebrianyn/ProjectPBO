/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lingkaran;

import com.mysql.cj.jdbc.MysqlDataSource;
import hitung_bangunRuang.Tembereng;
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
public class ThreadTembereng implements Runnable {

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
        System.out.println("TEMBERENG BOLA");
        try {
            double rTembereng = 1;
            double jarakBidang = 1;
            int seek = 6000;

            for (int i = 1; i <= 1000; i++) {
                Tembereng tembereng = new Tembereng(rTembereng, jarakBidang);
                tembereng.setJarakBidang(jarakBidang);
                tembereng.setR(rTembereng);
                
                try {
                    insertToFile = new RandomAccessFile("lingkaran.txt", "rw");
                    insertToFile.seek(seek);
                    insertToFile.writeUTF("Tembereng Bola");
                    insertToFile.writeDouble(tembereng.getTheta());
                    insertToFile.writeDouble(tembereng.menghitungLuasTembereng());
                    insertToFile.writeDouble(tembereng.menghitungVolumeTembereng());
                    
                    ps = connect.prepareStatement( "Insert into tembereng (jari_jari, jarak_bidang, luas, volume, tetha) values ("
                            + rTembereng + "," + jarakBidang + "," + tembereng.menghitungLuasTembereng() + ","
                            + tembereng.menghitungVolumeTembereng() + ","
                            + tembereng.getTheta() + ")");
                    ps.execute();
                } catch (IOException e) {
                    System.err.println("Error : " + e.getMessage());
                }

                rTembereng++;
                jarakBidang++;
                seek++;
            }
            System.out.println("data tembereng dibuat....");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

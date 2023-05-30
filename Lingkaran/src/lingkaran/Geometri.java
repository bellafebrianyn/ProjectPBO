/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package lingkaran;
/**
 *
 * @author hp
 */
public class Geometri {

    public static void main(String[] args) {
        Thread[] threads = new Thread[8];
        threads[0] = new Thread(new ThreadLingkaran());
        threads[1] = new Thread(new ThreadTabung());
        threads[2] = new Thread(new ThreadKerucut());
        threads[3] = new Thread(new ThreadKerucutTerpancung());
        threads[4] = new Thread(new ThreadBola());
        threads[5] = new Thread(new ThreadJuring());
        threads[6] = new Thread(new ThreadTembereng());
        threads[7] = new Thread(new ThreadKeratan());

        for (Thread thread : threads) {
            thread.start();
        }
    }
}


import java.util.logging.Level;
import java.util.logging.Logger;

/*
Bu metodlar Synchronized code bloklarında ve bizim belirli koşullarda threadlerdeki anahtarları lockları bırakmamızı sağlayan ve daha sonra bu lockları elde etmemizi sağlayan metodlarımızdır.
Synchronized kod blokuna girdiğimizde anahtarı elde ediyoruz, kod blokunda işimiz bitene kadar elde ettiğimiz anahtarı bırakmıyoruz.Fakat....
Biz bazı koşullar altında bu anahtarın teslim edilmesini isteyebiliriz.Kod bloku bitmeden anahtarın teslim edilmesini istememiz gereken durumlarda mevcuttur.
Böyle durumlar için synchroinzed kod bloklarında kullanılabilen wait ve notify isimli iki metodu kullanabiliriz.

 */
public class Main {
    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                wn.t1fon();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               wn.t2fon();
            }
        });
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            System.out.println("anahtar teslim hatası(sıra sırasında sorun meydana geldi)");
        }
    }
    
}

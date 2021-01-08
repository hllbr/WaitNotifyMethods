
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WaitNotify {
    public void t1fon(){
        //herhangi bir lock tanımlaması yapmdaan direkt olarak bir synchronized bir blok tanımlayarak işlemlerimizi yürütmeye çalışıyoruz.
        synchronized(this){//this anahtar kelimesini işlemimi bu objenin üzerinde yapıcaz demek için kullandık.Şuan objenin üzerinde tek bir anahatar bulunuyor
            System.out.println("birinci anahtar devrede...!");
            System.out.println("birinci anahtar ikinci anahtarın uyanmasını bekliyor..");
            
            try {
                //burad this.wait(); olarakta ifade edebilirdik fakat bu obje üzerinde bu waitin yapıldığını zaten yukarı kısımda başlarken ifade etmiştik bu sebeple bu tanımlamaya gerek yok.
                wait();//wait() metodu object classtan gelen bir metoddur.
                //Wait metodunun buradaki amacını açıklamak gerekirse = burada bir kesme(bekleme,bekletme) yapıcaz.Anahtarı teslim edeceğiz ve başka bir yapı yada herhangi bir kod veya çağrı bizi tekrar uyandırana(aktif) edene kadar bu noktadan ileri gidemeyeceğim(gitmicem) şeklinde birşey söylemiş olduk.
            } catch (InterruptedException ex) {
                System.out.println("Kesme/Uyuma/Uyutma Hatası Meydana geldi.");
            }
            System.out.println("bir numaralı anahtar aktif durumdu işemlerini devam ettiriyor...!");
        }
    }
    public void t2fon(){
        Scanner scn = new Scanner(System.in);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("Uyku hatası meydana geldi");
        }
        synchronized(this){
            System.out.println("ikinci anahtar çalışma pozisyonunda.");
            System.out.println("işlemi sürdürmek için bir tuşa basınız : ");
            String x = scn.nextLine();
            notify();//burası yapılmadan thread uyanamıyor(yukardaki waitli ypaı için bahsediyoruz.)
            
           /* if(!(x.equals(""))){
                zevk amaçlı kullanılabilir.
            }*/
           System.out.println("akşamdan kalma moduna girildi.\nUyandırlması gereken kahve ile ayıldı.\nYapı görevini başarı ile icra etti");
        }
        
    }
    
}

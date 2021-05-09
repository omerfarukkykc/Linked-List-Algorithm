package _19010310049_linkedlist;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _19010310049_TryLinkedList {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner giris =new Scanner(System.in);
        _19010310049_LinkedList list=new _19010310049_LinkedList();
        System.out.println("Tek Yönlü Bağlantılı Liste İşlmeleri");
        char ch;
        // Verilen txt dosyasından ilk 5000 kişiyi inser eden fonksiyon
        list.listAdd();
        do{
            System.out.println("1- Boyut");
            System.out.println("2- Boş mu");
            System.out.println("3- Ekleme");
            System.out.println("4- Listele");
            System.out.println("5- Silmek istediğiniz değer");
            System.out.println("6- Silmek istediğiniz index");
            System.out.println("7- Aramak istediğimiz değer");
            System.out.println("8- Aramak istediğimiz index");
            int sec= giris.nextInt();
            switch(sec){
                case 1:
                    System.out.println("Listenin Boyutu = "+list.getSize());
                    break;
                case 2:
                    System.out.println("Liste Durumu (Boş mu) = "+list.isEmpty());
                    break;    
                case 3:
                    System.out.println("Eklemek istediğiniz kişi id");
                    long id=giris.nextLong();
                    System.out.println("Eklemek istediğiniz kişi isim");
                    String name=giris.next();
                    System.out.println("Eklemek istediğiniz kişi Soyisim");
                    String surname=giris.next();
                    list.insert(id,name,surname);
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Silmek istediğiniz değer");
                    list.findAndDelete(giris.nextLong());
                    break;    
                case 6:
                    System.out.println("Silmek istediğiniz elemanın pozisyonunu girin");
                    int p=giris.nextInt();
                    if(p<1||p>list.getSize()){
                        System.out.println("Geçersiz pozisyon");
                    }
                    else{
                        list.delete(p);
                    }
                    break;
                case 7:
                    System.out.println("Bulmak istediğiniz değer");
                    list.find(giris.nextLong());
                    break;
                case 8:
                    System.out.println("Bulmak istediğiniz değer indexi");
                    list.findUserWithIndex(giris.nextInt());
                    break;
                default:
                    System.out.println("Yanlış değer girdiniz!!");
                    break;
            }            
            System.out.println("Devam etmek için (Evet ise 'e'Hayır ise 'h') basınız");
            ch=giris.next().charAt(0);
        }while(ch=='e'||ch=='E');
    }
}

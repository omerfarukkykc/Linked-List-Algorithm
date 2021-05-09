package _19010310049_linkedlist;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _19010310049_LinkedList {
    _19010310049_Node start;
    public int size;
    public _19010310049_LinkedList(){
        start=null;
        size=0;
    }
    //listAdd() metodu verilen listedeki ilk 5000 elemanı listeye ekler
    //FileNotFoundException belirtilen dosyanın bulunmaması durumunda hata vermesi için eklenmiştir.
    public void listAdd() throws FileNotFoundException{
        /*
        * Okuma işlemi yapabilmek için file tipinde bir nesne 
        * oluşturarak verilen txt dosyamızı nesnemizin içine atıyoruz
        */
      File read = new File("kayit_dosyasi.txt");
        Scanner giris = new Scanner(read);
            int i = 0;
            /*
            * while döngüsü ile txt dosyasındaki ilk 5000 elemanı önce
            * satır olarak sonra satırları virgüllerden parçalayarak 
            * 3 parça halinde dizimize atıyoruz ardından elde ettiğimiz 
            * verileri insert metodumuza gönderiyoruz
            */
            while (i!=5000) {
                String data = giris.nextLine();
                String[] div = data.split(",", 3);
                insert(Long.parseLong(div[0]),div[1],div[2]);
                i++;
            }     
    }
    //insert() metodu bağlantılı listeye sıralı şekilde eleman eklemeye yarar
    public void insert(long id,String name,String surname){
        /*
         * _19010310049_Node clasından yeni eklenecek bağlantımızı
         * kurabilmek için 1 tane satır işlemleri için
         * iki tane nesne oluşturuyoruz
         */
        _19010310049_Node nptr,ptr,tmp=null;
        nptr=new _19010310049_Node(id,name,surname,null);
        boolean ins=false;
        // Bağlantılı listede elmean olmaması durumu
        if(start==null){
            start=nptr;
        }
        // Başa oleman ekleme durumu
        else if(id<=start.getId()){
            nptr.setLink(start);
            start=nptr;
        }
        // Araya eleman ekleme durumu
        else{
            tmp=start;
            ptr=start.getLink();
            while(ptr!=null){
                // Eklenen id'nin yeri bulunur 
                if(tmp.getId()<id&&id<=ptr.getId()){
                    // Eklenecek elmandan önceki elman eklenecek elemana bağlanır
                    tmp.setLink(nptr);
                    // Eklenecek eleman soraki elemana bağlanır
                    nptr.setLink(ptr);
                    //Sona elman eklenmemesi için flag true değerine çekilir
                    ins=true;
                    break;
                    
                }
                else
                tmp=ptr;
                ptr=ptr.getLink();
            }
            //Sona ekleme işlemi
            if(ins==false){
                tmp.setLink(nptr);
            } 
            
        }
        //Bağlantılı liste boyutu 1 arttırılır
        size++;
    }
    //delete() metodu index değerine göre listeden eleman siler
    public void delete(int pos) {
        // İlk elemanı silme durumu
        if (pos==1){
            // Start sonraki elemana bağlanır
            start=start.getLink();
            // Liste boyutu azaltılır
            size--;
            return;
        }
        // Son elemanı silme durumu
        else if(pos==size){
            // Son elmeana ulaşmak için dizi üzerinde dolaılır ve 
            // son elemandan bir önceki elemanın linki null olarak ayarlanır
            _19010310049_Node ptr=start;
            for(int i=1;i<size-1;i++){
                ptr=ptr.getLink();      
            }
            ptr.setLink(null);
            size--;
            return;
        }
        // Aradan eleman silme durumu
        else{
            // Silinecek pozisyondan bir önceki pozisyona kadar ulaşılır
            _19010310049_Node ptr=start;
            pos--;
            for(int i=1;i<size-1;i++){
                // Silinecek elemandan önceki elemanın linki silinecek elemandan sonraki elemana bağlanır
                if(pos==i){
                    _19010310049_Node tmp=ptr.getLink();
                    System.out.println((pos+1)+" sırasındaki "+tmp.getId()+" numaralı idnin kaydı silinmiştir");
                    tmp=tmp.getLink();
                    ptr.setLink(tmp);
                    break;
                    
                }
                // Dizide ilerleme işlemi 
                ptr=ptr.getLink();   
            }
        size--;
        return;
        }
       
    }
    //display() metodu listedeki elemanları ekrana yazdırır
    public void display(){
        System.out.println("Tek yönlü bağlantılı liste = ");
        if(size==0)
        {
            System.out.println("Liste boş");
            return;
        }
        else if(start.getLink()==null){
            System.out.println(start.getId()+" ->"+start.getName()+" "+start.getSurname());
            return;
        }
        _19010310049_Node ptr=start;
        System.out.println(start.getId()+" ->"+start.getName()+" "+start.getSurname());
        ptr=start.getLink();
        while(ptr.getLink()!=null){
            System.out.println(ptr.getId()+" ->"+ptr.getName()+" "+ptr.getSurname());
            ptr=ptr.getLink();
        }
        System.out.println(ptr.getId()+" ->"+ptr.getName()+" "+ptr.getSurname());
        return;
    }
    //find metodu listedeki elemanların id değerlerine göre elmanı bulur
    public void find(long id){
        long time1 = System.nanoTime();
        _19010310049_Node aranan=start;
        int i=1;
        boolean flag=false;
        if(start==null){
            System.out.println("Liste boş");
        }
        else{
            while(aranan!=null){
                if(aranan.getId()==id){
                    flag=true;
                    break;
                }
                i++;
                aranan=aranan.getLink();
            }
            if(flag){
                System.out.println(id+" id'li Elamanın pozisyonu = "+i+" dir");
            }
            else{
                System.out.println("Eleman listede yok");
            }
        }
        long time2 = System.nanoTime();
        System.out.println((time1=time2-time1)/1000000+" milisaniyede bulundu.");
    }
    //findAndDelete() listedeki elemanların id değerine göre arama yapar bulunursa bulunan id li kaydı siler
    public void findAndDelete(long id){
        _19010310049_Node aranan=start;
        int i=1;
        boolean flag=false;
        if(start==null){
            System.out.println("Liste boş");
        }
        else{
            while(aranan!=null){
                if(aranan.getId()==id){
                    flag=true;
                    break;
                }
                i++;
                aranan=aranan.getLink();
            }
            if(flag){
                delete(i);
                System.out.println(i+" sırasındaki "+id+" numaralı idnin kaydı silinmiştir");
            }
            else{
                System.out.println("Eleman listede yok");
            }
        }
    }
    //findUserWithIndex() fonksiyonu girilen index numarasına göre listede o indexte bulunan değeri geri döndürür.
    public void findUserWithIndex(int listIndex){
        // Bulma işleminin süresini hesaplamak için bulmadan önce ve bulduktan sonrasiki sistem süresi hesaplanıp birbirinden çıkarılır
        long time1 = System.nanoTime();
        _19010310049_Node ptr=start;
            for(int i=1;i<size-1;i++){
                if(listIndex==i){
                    System.out.println(listIndex+" sırasındaki "+ptr.getId()+" id'li elaman "+ptr.getName()+" "+ptr.getSurname()+" dır");
                    break;
                }
                ptr=ptr.getLink();   
            }
        long time2 = System.nanoTime();
        System.out.println((time1=time2-time1)/1000000+" milisaniyede bulundu.(Eğer 0 çıkıyor ise milisaniyeden kısa sürmüştür.)");
    }
    //isEmpty() fonksiyonu bağlantılı listenin boş olma durumunu kontrol eder
    public boolean isEmpty(){
        return start==null;
    }
    //getSize() fonksiyonu listenin boyutunu geri dönürür.
    public int getSize(){
        if(size==0){
            System.out.println("Liste boş");
            return 0;
        }
        else        
        return size;
    }
}

    
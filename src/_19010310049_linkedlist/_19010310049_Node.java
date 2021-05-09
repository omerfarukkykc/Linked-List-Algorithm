package _19010310049_linkedlist;
public class _19010310049_Node {
    // Düğümün özellikleri
    int index;
    long id;
    String name;
    String surname;
    _19010310049_Node next;
    public _19010310049_Node(){
        next=null;
        id=0L;
        name=null;
        surname=null;
    }
    // Oluşturucu method
    public _19010310049_Node(long id,String name,String surname,_19010310049_Node next){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.next=next;
    }
    // set get fonksiyonları
    public void setLink(_19010310049_Node n){
        next=n;
    }
    public _19010310049_Node getLink(){
        return next;
    }
    public void setId(int id){
        this.id=id;
    }
    public long getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getSurname(){
        return surname;
    }
}

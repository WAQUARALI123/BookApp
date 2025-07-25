 class Encapsulation{

int id =0;
String name= null;

public void setId(int id){

this.id= id;
}

public int getId(){

return id;
}

public void setName(String name){

this.name= name;
}

public String getName(){

return name;
} 
}
public class DeEncapsulation{

public static void main(String[] args){

Encapsulation e = new Encapsulation();

e.setId(101);
e.setName("ABC");


System.out.println(e.getId());
System.out.println(e.getName());

}

}
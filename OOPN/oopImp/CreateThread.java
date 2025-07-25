public class CreateThread extends Thread{

public void run(){

System.out.println("override run method");


}

public void runn(){

System.out.println("Second run method");
}

public static void main(String[] args){

CreateThread  c = new CreateThread();

c.start();
}

}
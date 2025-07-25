//Create two threads, print "Hello" and "World"	

public class Hello implements Runnable{

public void run(){

System.out.println("Hello");
}


class World implements Runnable{

public void run(){

System.out.println("World");
}
}

public static void main(String[] args){

Hello h = new Hello();
Thread h1 =new Thread(h);

World w = h.new World();
Thread w1 =new Thread(w);

h1.start();
w1.start();
}

}
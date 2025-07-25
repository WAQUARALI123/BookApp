public class MyRunnable implements Runnable{

public void run(){

System.out.println("My runnable interface" + Thread.currentThread().getName());
}

public static void main(String[] args){

MyRunnable task = new MyRunnable();

Thread t= new Thread(task);

t.start();

}
}

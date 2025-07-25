interface DefaultStaticM{

default void defaultM(){

System.out.println("Default method with interface");
}

static void staticM(){

System.out.println("Static method with interface");
}

}

public class DefaultStaticMethodInterface implements DefaultStaticM {

public static void main(String[] args){

DefaultStaticMethodInterface dsM = new DefaultStaticMethodInterface();

dsM.defaultM();
DefaultStaticM.staticM();

}

}
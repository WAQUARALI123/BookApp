interface DefaultStaticM{

default void defaultM(){

System.out.println("Default method with interface");
}

static void staticM(){

System.out.println("Static method with interface");
}

}

public class Default&StaticMethodInterface{

public static void main(String[] args){

Default&StaticMethodInterface d&sM = Default&StaticMethodInterface();

d&sM.defaultM();
d&sM.staticM();

}

}
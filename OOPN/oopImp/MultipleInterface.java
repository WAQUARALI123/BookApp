interface I1{

void i1();
}

interface I2{

void i2();
}

public class MultipleInterface implements I1,I2{


public void i1(){
System.out.println("I1 interface method");
}

public void i2(){

System.out.println("I2 interface method");
}

public static void main(String []args){

MultipleInterface m = new MultipleInterface ();

m.i1();
m.i2();
}
}
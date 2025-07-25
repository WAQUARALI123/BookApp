public class ThrowException{


public static void main(String[] args){

checkAge(153);
}

public static void checkAge(int age){

if(age<18){

 throw new IllegalArgumentException("you are not eligible");
}

System.out.println("Welcome you are eligible");
}

}






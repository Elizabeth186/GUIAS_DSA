import java.util.*;

class Main {

  public static void main(String[] args) {
  int num1, num2, total=0;
  String seguir="S";
Scanner divisible = new Scanner (System.in);

System.out.println("\n"+"*** SISTEMA DE DIVISIBILIDAD ***"+"\n");

do{

System.out.println("Ingresa el primer numero");
num1 = divisible.nextInt();
System.out.println("Ingresa el segundo numero");
num2 = divisible.nextInt();



if(num1%num2==0){
  System.out.println("Los numeros "+num1+" y "+num2+" son divisibles entre si");

} else{
   System.out.println("Los numeros "+num1+" y "+num2+" no son divisibles entre si");
};
  System.out.println("¿Desea Continuar?  'S'/'N'");
  seguir = divisible.next();
}while("S".equalsIgnoreCase(seguir));


  }
}

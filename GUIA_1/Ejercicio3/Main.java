import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner numero = new Scanner(System.in);
    int cant, num=0, res, i, par=0, impar=0;
    String seguir="";
    do{
    System.out.println("Ingrese la cantidad de numeros a digitar");
    cant = numero.nextInt();
    int []lista = new int [cant];

    for (i=1; i<=cant; i++) {
      System.out.println("Ingrese el numero "+i);
      num = numero.nextInt();

      if(num%2 == 0){
    par = par+1;

  }else {
    impar = impar+1;
  }
  }  
  
   System.out.println("Cantidad de numeros pares ingresados "+par);
   System.out.println("Cantidad de numeros impares ingresados "+impar);
   System.out.println("¿Desea continuar? 'S'/'N'");
    seguir = numero.next();
    
    }while("S".equalsIgnoreCase(seguir));
  
}
}
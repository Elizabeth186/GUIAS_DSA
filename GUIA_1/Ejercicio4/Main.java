import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner numero = new Scanner(System.in);
    String seguir="";
    int cant, co1=0, co2=0, co3=0, co4=0, x=0, y=0, i;
    do{
    System.out.println("Ingrese la cantidad de coordenadas a digitar");
    cant = numero.nextInt();
    int []lista = new int [cant];
 
    for (i=1; i<=cant; i++) {
      System.out.println("Ingrese las coordenadas X "+i);
      x = numero.nextInt();
       System.out.println("Ingrese las coordenadas Y "+i);
      y = numero.nextInt();
       System.out.println("________________________________");
     
      if(x>0 && y>0){
     co1=co1+1;

    }else if (y<0 && x<0) {
    co2=co2+1;
      
    }else if (x<0 && y>0) {
      co3=co3+1;
      
    }else if(x>0 && y<0) {
      co4=co4+1;
    } else {
      
    }
    }
    System.out.println("Cantidad de numeros ingresados en el primer cuadrante "+co1);
    System.out.println("Cantidad de numeros ingresados en el segundo cuadrante "+co2);
    System.out.println("Cantidad de numeros ingresados en el tercer cuadrante "+co3);
    System.out.println("Cantidad de numeros ingresados en el cuarto cuadrante "+co4);

     System.out.println("¿Desea continuar? 'S'/'N'");
      seguir = numero.next();
    
    }while("S".equalsIgnoreCase(seguir));
  }  
  
}

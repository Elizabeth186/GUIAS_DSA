import java.util.*;
class Main {
  public static void main(String[] args) {
  String seguir;
  double nota, resultado;
  Scanner cali = new Scanner(System.in);
 int i= 0, mayor=0, menor=0, cant;
 System.out.println("\n"+"************ BIENVENIDO *************"+"\n");
 do{
System.out.println("> Ingrese la cantidad de notas a registrar");
cant = cali.nextInt();
System.out.println("*****************************************");
System.out.println("-----------------------------------------");
int[] lista = new int [cant];
for(i=1;i<=cant;i++){

System.out.println("> Ingrese nota " +i); 
nota = cali.nextDouble();
System.out.println("_________________________________________");

if(nota>=7){
  mayor=mayor+1;
}else{
 menor=menor+1;
}
  }
   System.out.println("La notas mayores a 7 ingresadas son: " +mayor);
    System.out.println("La notas menores a 7 ingresadas son: " +menor);
      System.out.println("¿Desea continuar? 'S'/'N'");
      seguir = cali.next();
    
    }while("S".equalsIgnoreCase(seguir));
  }

}
package capicuas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Rene
 */
public class Capicuas {

    public static void main(String[] args) {
        //importacion del teclado en la linea de consola
        Scanner teclado = new Scanner(System.in);
        long num = 0;
        
        //validacion nummero mayor a 9 y menor a 10000
        while(num<9 || num>10000){
            try
            {
               //solicita entrada de texto
                System.out.println("Digita un numero mayor a nueve y menor a diez mil");
                num = teclado.nextLong();
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Entero por favor...");
            }
            
        }
        
        //declaracion de variables
        long numInv = getInvertedNumber(num);
        long suma = num+numInv;
        long iteraciones = 0;
        
        boolean isCapicuas = false;
        
        //si el numero que ingreso el usuario es capicuas automaticamente lo muestra al usuario
        if(num == numInv){
            isCapicuas = true;
        }else{
            //ciclo while para encontrar el numero capicua y el numero de iteraciones
            while(!isCapicuas){
                num = suma; //ahora num tendra asignado el valor de la suma
                numInv = getInvertedNumber(num); //obtenemos el numero Invertido de num
                
                if(num == numInv){//comparamos si es capicua
                    isCapicuas = true; //es capicua y finalizamos el ciclo
                }else{ //no es capicua
                    suma = num + numInv; //Obtenemos la suma de num y numInv para la siguiente iteracion
                }
                
                iteraciones++; //aumentamos el contador

            }
        }
        
        System.out.println(num + " " + iteraciones);
        
            
        
    }
    
    //obtenemos el numero invertido 
    private static long getInvertedNumber(long num){
        long numInv = 0,residuo = 0;
        
        while(num>0){
            residuo = num % 10;
            numInv = numInv*10+residuo;
            num /= 10;
        }
        
        return numInv;
    }
    
    
    //validar que la cadena es numerica
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
}

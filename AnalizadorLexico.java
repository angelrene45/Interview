package analizadorlexico;

import java.util.Scanner;

public class AnalizadorLexico {

    public static void main(String[] args) {
        //importacion del teclado en la linea de consola
        Scanner teclado = new Scanner(System.in);
                
        //solicita entrada de texto
        System.out.println("Entrada de texto");
        String entrada = teclado.nextLine();
        
        //SplitTextos
        String[] splitTextos = entrada.split("\\(\\d+,\\d+\\)");
        int longitudTextoTotal = splitTextos.length;
        //SplitCoordenadas
        String[] split = entrada.split("[()]");
        int cont = 0, aux = 1; //auxiliares
        
        //Variable Resultado que tendra las coordenadas y los textos
        String[] Resultado = new String[longitudTextoTotal];
        
        
        //1.- Coordenadas
        //elimina los parentesis    
        //recorremos el split sin parentesis
        for(int i=0; i<split.length; i++){
            //validamos que hay texto
            if(!split[i].equals("")){
                //ahora separamos por comas
                String[] coordenada = split[i].split(",");
                //recorremos el split que separo por comas
                for (int k=0; k<coordenada.length ; k++) {
                    //validacion si es numerico el valor
                    if(isNumeric(coordenada[k])){
                        cont++;

                        //diseño de impresion agregando parentesis si es la primer coordenada
                        if(cont == 1){
                             Resultado[aux] = "(" + coordenada[k] + ",";
                        //cerrado parentesis cuando es la segunda coordenada
                        }else if(cont == 2){
                             Resultado[aux] += coordenada[k] + ")";
                        }       
                    
                        if(cont==2){ //continuamos con el siguiente texto
                            aux++;
                            cont=0;
                        }
                    }
                   
                }
                
            }
        }
        

        //2.- Textos
        //La linea 16
        //elimina las coordenadas con formato (int,int)
        //solo obtiene las palabras del texto
        //esta expresion busca la apertura de parentesis y espera un numero de 0-9 
        //luego despues del numero busca una coma , 
        //despues espera otro numero de 0-9 
        //y por ultimo el cierre de parentesis

        //splitTextos tiene los textos de la entrada del usuario
        for(int i=0; i<splitTextos.length; i++){
            if(!splitTextos[i].equals(""))
                Resultado[i] += " " + splitTextos[i];
        }
        
        System.out.println("\nResultado:");
        //imprimimos el resultado de las coordenadas y textos
        for(int y=1; y<Resultado.length; y++){
            System.out.println(Resultado[y]);
        }
        
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

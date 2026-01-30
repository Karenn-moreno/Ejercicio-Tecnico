
/*
1era Parte

Suponer un sistema de reserva de asientos para un anfiteatro.
El teatro cuenta con 10 filas de 10 asientos cada una.
Se necesita desarrollar un sistema (sin uso de bases de datos, únicamente manejo de datos de forma lógica) que permita llevar a cabo lo siguiente:

--------------------------Requerimientos---------------------------------------------------------------------------------

1. Cargar el “mapa” de las filas y asientos, indicando con una “X” los asientos ocupados y con una “L” los asientos libres.
Al iniciar el programa, todos los asientos deben estar libres.

2. Manejar la reserva de asientos contemplando que:

Un asiento SOLO PUEDE SER RESERVADO si se encuentra en estado “L”.

En caso de que esté en estado “X”, se deberá permitir al comprador elegir otro asiento.

Si se encuentra en estado “L”, deberá pasar automáticamente al estado “X”.

3. Para finalizar el programa se deberá ingresar un valor en particular.
Contemplar que no existe una cantidad exacta de veces que el programa se pueda ejecutar.

4. Contemplar que SOLO EXISTEN 10 FILAS y 10 ASIENTOS.
No se pueden vender asientos fuera de esas numeraciones.
No se permite “sobreventa”.

Consideraciones

No es necesaria implementación ni de IGU ni de BD.
Se evaluará 100% el manejo lógico del desarrollo de la aplicación.

Extra
En caso de que un cliente solicite visualizar cuáles son los asientos libres,
el sistema debe permitir mostrar de forma gráfica el mapa de asientos.

⚠️ NO UTILIZAR IGU para este caso.
Utilizar ÚNICAMENTE lógica y la salida por consola.
*/
package com.mycompany.reservaasientos;

import java.util.Scanner;

public class ReservaAsientos {

    public static void main(String[] args) {
       
        
        // 1 Punto
        
        String asientos [][]= new String [10][10];
        boolean bandera=false;
        Scanner teclado= new Scanner (System.in);
        int fila=0,asiento=0;
        String respuesta;
        String verMapa;
        
        for(int f =0; f <asientos.length; f++){
            for(int a=0; a<asientos[f].length; a++){
               asientos[f][a]="L";    
            }
        }
        
        //reserva de asientos
        while(bandera!=true){
            
            //ver mapa
            System.out.println("Desea ver los asientos disponibles? S: si cualquier otra tecla NO");
              
            verMapa=teclado.next();
             //aca vamos llamar al metodo
            if(verMapa.equalsIgnoreCase("S")){
            dibujarMapa(asientos);
            }
            //reserva
            boolean estadoOk=false;
            while(estadoOk!=true){
            System.out.println("\n Ingrese fila y asiento a reservar : ");
            System.out.print("Fila (entre 0-9): ");
            fila=teclado.nextInt();
            
            System.out.print("Asiento (entre 0-9): ");
            asiento=teclado.nextInt();
            
            if (fila<=9 && fila>=0){
               if (asiento<=9 && asiento>=0){
                   estadoOk=true;
                  }
               
            else{
                 System.out.print("El numero del asiento no es valido");
            }
            }
            else { 
                    System.out.print("El numero de fila no es valido");
                    
        }
        }
        if(asientos[fila][asiento].equals("L")){
             asientos[fila][asiento]="X";
                System.out.println("El asiento fue reservado correctamente");
                
            }
            else{
                System.out.println("El asiento esta ocupado.Por favor elija otro");
            }
            System.out.println("Desea finalizar la reserva? S: si cualquier tecla NO");
            respuesta= teclado.next();
            if (respuesta.equalsIgnoreCase("S")){
               bandera = true;
            }
        }
            
    }
    static void dibujarMapa(String asientos[][]){
        for(int f =0; f <asientos.length; f++){
            System.out.print(f+" ");
            for(int a=0; a<asientos[f].length; a ++){
                System.out.print("["+asientos[f][a]+"]"+" ");
            }
            System.out.println(" ");
        }
        
    }
    
}

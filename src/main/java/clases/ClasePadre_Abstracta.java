/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public abstract class ClasePadre_Abstracta {
    
    protected int transacciones, retiro, deposito;
    private static int saldo; //obligadamente tiene que ser dato privado porque es dinero que se tiene
    Scanner entrada = new Scanner(System.in);
    
    //nosotros creamos una ariable tipo privado arriba que es la variable saldo, recordemos que las variables de tipo privado
    //no las podemos consultar ni modificar desde otras clases a no ser que le creemos 2 metodos que son de suma importancia en la POO.
    
    //metodos setter y getter
    public int getSaldo(){
        return saldo;
    }
    
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
    
    public void Operaciones(){
        int bandera = 0;//una variable bandera cambia su valor dependiendo del flujo del programa
        int seleccion = 0;
        do{
            do {
                
                System.out.println("Por favor seleccione una opcion: ");
                System.out.println("          1. Consulta de Saldo.");
                System.out.println("          2. Retiro de efectivo.");
                System.out.println("          3. Deposito en efectivo.");
                System.out.println("          4. Salir");
                seleccion = entrada.nextInt();

                if (seleccion >= 1  && seleccion <= 4){ //// revisar 
                    bandera =1;

                } else{
                    System.out.println("------------------------------------------------");
                    System.out.println("Opcion no disponible, velva a intentar por favor");
                    System.out.println("------------------------------------------------");
                }
            } while (bandera == 0);
            
            if (seleccion==1){
                ClasePadre_Abstracta mensajero = new ClaseHija_Consulta();
                mensajero.Transacciones();
            }else if (seleccion==2){
                ClasePadre_Abstracta mensajero = new ClaseHija_Retiro();
                mensajero.Transacciones();
            }else if (seleccion==3){
                ClasePadre_Abstracta mensajero = new ClaseHija_Deposito();
                mensajero.Transacciones();
            }else if (seleccion==4){
                System.out.println("------------------------------------------------");
                System.out.println("Gracias uelva pronto.");
                System.out.println("------------------------------------------------");
                bandera=2;
            }

        } while (bandera != 2); // aca asignamos que si el programa es diferente de 2 se va a seguir ciclando
    }
    
    //hasta aca programaremos un nuevo metodo
    
    // Metodo para solicitar cantidad de retiro
    public void Retiro(){
        retiro = entrada.nextInt();
    }
    
    // Metodo para hacer depocito
    public void Deposito(){
        deposito= entrada.nextInt();
        
    }
    
    //metodo abstracto
    public abstract void Transacciones();
}

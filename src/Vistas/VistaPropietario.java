/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.Propietario;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class VistaPropietario {
    
    
    public Propietario activarVistaPropetario() {
        
        //Usar la clase basedatos (crear objeto)
        Scanner entrada = new Scanner(System.in);
        Propietario propietario = new Propietario();
        
        System.out.println("Bienvenido al hangar 160");
        
        System.out.println("Digite la cedula del propietario: ");
        propietario.setCedula(entrada.next());

        
        System.out.println("Digite el nombre del propietario: ");
        propietario.setNombres(entrada.next());
        
        System.out.println("Digite el metodo de pago (1 o 2)");
        propietario.setMetodoPago(entrada.nextInt());
        
        return propietario;
    }
}

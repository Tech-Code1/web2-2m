/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.ConsultasPropietarios;
import Modelos.Propietario;

/**
 *
 * @author David
 */
public class ControladorPropietario {
    
    private ConsultasPropietarios modelo = new ConsultasPropietarios();
    
    public void registrarPropietario(Propietario propietarios) {
        
        //Validaciones
        
        modelo.insertarPropietario(propietarios);
    }
}

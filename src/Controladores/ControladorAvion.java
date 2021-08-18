/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Avion;
import Modelos.ConsultasAvion;
/**
 *
 * @author David
 */
public class ControladorAvion {
    
    private ConsultasAvion modelo = new ConsultasAvion();
    
    public void registrarAvion(Avion avion){
        
        modelo.insertarAvion(avion);
        
    }
}

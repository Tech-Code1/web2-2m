/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.ConsultasHangaresAviones;
import Modelos.HangaresAviones;

/**
 *
 * @author David
 */
public class ControladorHangarAvion {
    
    private ConsultasHangaresAviones modelo = new ConsultasHangaresAviones();
    
    
    public void matricularAvionEnHangar(HangaresAviones hangaresAviones, String matriculaAvion, String cuposReservados){
        int celda = Integer.parseInt(cuposReservados);
        int celdaAsignada = celda+1;
        
        hangaresAviones.setNumeroCelda(celdaAsignada);
        modelo.insertarAvionHangar(matriculaAvion, hangaresAviones, celdaAsignada);
           
    }
}

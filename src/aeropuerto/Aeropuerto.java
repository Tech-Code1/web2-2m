/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import Controladores.ControladorAvion;
import Controladores.ControladorHangar;
import Controladores.ControladorHangarAvion;
import Controladores.ControladorPropietario;

import java.util.Scanner;

import Modelos.Avion;
import Modelos.Hangar;
import Modelos.HangaresAviones;
import Modelos.Propietario;

import Vistas.VistaAvion;
import Vistas.VistaHangar;
import Vistas.VistaPropietario;

/**
 *
 * @author David
 */
public class Aeropuerto {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Scanner objLeer = new Scanner(System.in);
        
        //Buscar info del hangar
        ControladorHangar controladorHangar= new ControladorHangar();
        Hangar hangar=controladorHangar.consultarInformacionHangar();
        
        VistaHangar vistaHangar = new VistaHangar();
        
        //Menú
        
        int opcion;
        do {
            System.out.println("\nBienvenido al sistema (Hangar #160)");
            System.out.println("");
            System.out.println("*****1.Consultar datos del hangar*****");
            System.out.println("*****2.Agregar registro*****");
            System.out.println("*****3.Salir*****");

            System.out.print("\nDigite una opción: ");
            opcion = objLeer.nextInt();

            switch (opcion) {
                case 1:
                    vistaHangar.activarVista(hangar);
                    break;                   
                case 2:

                    if (hangar.getCuposDisponibles() > 0 && hangar.getCuposDisponibles() <= 16) {

                        VistaPropietario vistaPropietario = new VistaPropietario();
                        Propietario propietario = vistaPropietario.activarVistaPropetario();
                        ControladorPropietario controladorPropietario = new ControladorPropietario();
                        controladorPropietario.registrarPropietario(propietario);

                        VistaAvion vistaAvion = new VistaAvion();
                        Avion avion = vistaAvion.activarVista();
                        ControladorAvion controladorAvion = new ControladorAvion();
                        controladorAvion.registrarAvion(avion);

                        ControladorHangarAvion controladorAvionesHangares = new ControladorHangarAvion();
                        HangaresAviones hangarAvion = new HangaresAviones();
                            String numberCel = String.valueOf(hangar.getCuposReservados());
                            
                        controladorAvionesHangares.matricularAvionEnHangar(hangarAvion, avion.getMatricula(), numberCel);

                        controladorHangar.actualizarHangar(hangar);
                    } else {
                        System.out.println("No hay cupos disponibles");
                    }
                    break;
                case 3:
                    break;

            }

        } while (opcion != 3);
        
    }
}

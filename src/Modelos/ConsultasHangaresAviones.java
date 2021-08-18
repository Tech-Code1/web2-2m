/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author David
 */
public class ConsultasHangaresAviones extends BaseDatos {
    
    //ATRIBUTOS
    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;
    
    
    public void insertarAvionHangar(String matriculaAvion, HangaresAviones hangares, int celda){
        
        
        //0. Obtener la fecha y hora actual
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaActual=format.format(date);      
        
        
        //1.Establecer nocexion con BD
        Connection conexion=conectarBD();
        
        //2.Preparo el query
        String consulta="INSERT INTO hangares_aviones(codigo_hangar,matricula_avion,fecha_ingreso,numero_celda)"
                + "VALUES(?,?,?,?)";
        
        //3.Intento ejecutar la consulta
        try{
            
            sentenciaSQL=conexion.prepareStatement(consulta);
            
            sentenciaSQL.setInt(1,160);
            sentenciaSQL.setString(2,matriculaAvion);
            sentenciaSQL.setString(3, fechaActual);
            sentenciaSQL.setInt(4,celda);
            
            int resultado=sentenciaSQL.executeUpdate();
            
            
            
        }catch(Exception error){
            System.out.println("Error al insertar el registro "+error);
            
        }finally{
            
             try{
                conexion.close(); 
            }catch(Exception error){
                System.out.println("error: "+error);
            }
            
            
        }
        
    }
    
}

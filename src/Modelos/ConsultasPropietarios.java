/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author David
 */
public class ConsultasPropietarios extends BaseDatos {
    
    private PreparedStatement sentenciaSQL;
    
    public void insertarPropietario(Propietario propietario){
        
        //1. Establecer conexión con BD
        Connection conexion = conectarBD();
        
        
        String consulta= "INSERT INTO propietarios(cedula, nombres, metodo_pago)" 
                + "VALUES (?,?,?)";
        //2. Intento llevar Datos
        try {
            
            //3. Asociar el PS a la conexión    
            sentenciaSQL= conexion.prepareStatement(consulta);
            
            //4. Diferenciar la consulta (Personalizar)
            sentenciaSQL.setString(1, propietario.getCedula());
            sentenciaSQL.setString(2, propietario.getNombres());
            sentenciaSQL.setInt(3, propietario.getMetodoPago());
            
            //5. Ejecutar la consulta
            int resultado = sentenciaSQL.executeUpdate();
            
            //6. Validar el resultado
            if(resultado>0){
                System.out.println("Exito registrando el propietario");
                
            }else {
                System.out.println("Error al agregar el registro");
            }
            
            
            
        }catch(Exception error){
            System.out.println("No se pudo registrar el propietario: "+error);
            
        }finally {
            
            try {
                conexion.close();
                
            } catch(Exception error) {
                System.out.println("error: "+ error);
            }
            
            
        }
                
    }
    
}

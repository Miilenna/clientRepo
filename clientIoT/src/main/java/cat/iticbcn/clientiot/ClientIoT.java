/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cat.iticbcn.clientiot;

import java.sql.*;

/**
 *
 * @author milena
 */
public class ClientIoT {

    static final String url = "jdbc:mysql://85b0-158-180-16-205.ngrok-free.app"; 
    static final String usuario = "adminUser"; 
    static final String contrasena = "password"; 

    public static void main(String[] args) {

        DispositiuIot disp = new DispositiuIot();

        try {
            
            disp.conecta();
            disp.subscriu(); 

            try (Connection con = ConnectDB.getConnection(url, usuario, contrasena)) {
                AccesMethodsToDB access = new AccesMethodsToDB();
                access.selectAlumnes(con);
                access.insertRegistry(con, null);
            } catch (SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }
            
        }catch(Exception e){
            System.err.println("Error IOT: "+e.getLocalizedMessage());
            System.exit(-1);
        }    
        
        
    }
}

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

    static final String URL = "jdbc:mysql://127.0.0.1:8888/DDBBPROJ";
    static final String usuario = "root"; 
    static final String contrasena = "1234"; 

    public static void main(String[] args) {

        DispositiuIot disp = new DispositiuIot();

        try {
            
            disp.conecta();
            disp.subscriu(); 

            try (Connection con = ConnectDB.getConnection(URL, usuario, contrasena)) {
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

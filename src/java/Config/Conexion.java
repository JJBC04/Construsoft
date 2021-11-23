package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jjbue
 */

//Clase para crear la conexion a la BD
public class Conexion {
    //Asignar valores de nombre de BD, usuario y clave
    Connection con;
    String url="jdbc:mysql://localhost:3306/construsoft";
    String usuario = "root";
    String clave = "";
    
       public Connection Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,usuario,clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
    
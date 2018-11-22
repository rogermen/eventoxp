package controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author roger
 */
public class conexionConferencista{
    
    Connection conect = null;
    public boolean conexionInsert(){
        return true;
        
    }
    
//insertar   
   public boolean insertarConferencista(String nombre,String apellidos,String celular ,String email, String profesion, String ci, String tema, String hora, String documento, String transporte, String estancia, String alimentacion, String varios,String subtotal ) {
        
       boolean respuesta =false;
       boolean respuesta1 =false;
       boolean respuesta2 =false;
       Conexion conectado = new Conexion();
       if(!ConferencistaValido(ci)){
            String inConferencia= "INSERT INTO conferencia(id_evento,ci_confe,tema, hora,documento) "
                                + "  VALUES('"+1+"','"+ci+"','"+tema+"','"+hora+"','"+documento+"')";
            
            String inConferencista= "INSERT INTO conferencista(nombre_confe,apellido_confe,celular_confe, email_confe,profesion_confe,ci_confe) "
                                + "  VALUES('"+nombre+"','"+apellidos+"','"+celular+"','"+email+"','"+profesion+"','"+ci+"')";
            String inGastoConferencista= "INSERT INTO public.gastoconferencista(gasto_transporte,gasto_estancia,gasto_alimentacion, gastos_otros,ci_confe,subTotalConfe) "
                                + "  VALUES('"+transporte+"','"+estancia+"','"+alimentacion+"','"+varios+"','"+ci+"','"+subtotal+"')";
            respuesta1 = conectado.instertarDato(inConferencista);
            
            respuesta = conectado.instertarDato(inConferencia);   
            
            respuesta2 = conectado.instertarDato(inGastoConferencista);
       }
       /*
       Connection coneccion=null;
        Statement sentencia=null;    
        Statement sentencia1=null;
    String url="jdbc:postgresql://localhost:5432/evento";
    String password="postgres";
    boolean respuesta =false;
    try {
            Class.forName("org.postgresql.Driver");
            coneccion=DriverManager.getConnection(url,"postgres", password);
            sentencia=coneccion.createStatement();
            sentencia1=coneccion.createStatement();
            if(coneccion!=null){
                int z = 0;
                 int y= 0;
                if(nombre!=null&&apellidos!=null){
                    if(!ConferencistaValido(ci))   
                   z=sentencia.executeUpdate("INSERT INTO conferencista(nombre_confe,apellido_confe,celular_confe, email_confe,profesion_confe,ci_confe) "
                           + "                  VALUES('"+nombre+"','"+apellidos+"','"+celular+"','"+email+"','"+profesion+"','"+ci+"')");
                        
                }
                if(z==1){ respuesta=true;  }
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
                System.out.println("problema de conexion");
            }
    */
       
    
            return respuesta==respuesta1==respuesta2;
    }
   
   private boolean ConferencistaValido(String ci){
       
        boolean resultado =false;
        Conexion conectado = new Conexion();
        ResultSet respuesta = null;
        String consulta="SELECT nombre_confe FROM public.conferencista WHERE ci_confe='"+ci+"' ;";
        respuesta = conectado.consultaBDatos(consulta);
        try {
            while(respuesta.next()){
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(conexionConferencista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*
        Connection conected = null;
      Statement stmt = null;    
      try {
         Class.forName("org.postgresql.Driver");
         conected = DriverManager.getConnection("jdbc:postgresql://localhost:5432/evento", "postgres", "postgres");
         conected.setAutoCommit(false);
         stmt = conected.createStatement();
         ResultSet respBD = stmt.executeQuery( "SELECT nombre_confe FROM public.conferencista WHERE ci_confe='"+ci+"' ;" );
         if(respBD.next()){
             resultado=true;
         }
         respBD.close();
         stmt.close();
         conected.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      */
      
        return resultado;
        
    }
    public ResultSet listaEstudiante(){
       
      ResultSet respuesta = null;
        Connection conectado = null;
      Statement estado = null;    
      try {
         Class.forName("org.postgresql.Driver");
         conectado = DriverManager.getConnection("jdbc:postgresql://localhost:5432/evento", "postgres", "postgres");
         conectado.setAutoCommit(false);
         estado = conectado.createStatement();
         respuesta = estado.executeQuery( "select ci_estu,nombre_estu, apellido_estu, celu_estu,inscripcione\n" +
                                        "from estudiante,asistencia\n" +
                                    "where asistencia.id_inscripcion=estudiante.id_inscripcion;" );
   
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
        return respuesta;
    }
   
   
   
   
   
   
   public Connection conexionn()
    {
      try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
}
}

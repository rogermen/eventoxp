package controlador;
import java.sql.*; 
public class Conexion 
{
    //Objeto Tipo conexion que contiene todos los parametros para interactuar 
    //con la BD se crea un objeto tipo conetado
    public Connection conetado;

    //Constructor de la clase Conexion que contiene el parametro nombre que determina
    //el nombre de la base de datos que se va ha conectar conetado el ODBC
    public Conexion()
    {
          try
            {
              //Clase que especifica el nombre de los controladores que se van
              //ha utilizar en la carga de la BD en este caso son los de Access
              Class.forName("org.postgresql.Driver");  //loads the driver
            }
            catch(ClassNotFoundException e)
            {
                    System.out.println("No encontro driver");
            }

            try
            {
                    //url es un texto que contiene la ruta del nombre o la direccion
                    //de coneccion de la base da Datos conectada al JDBC
                    String url = "jdbc:postgresql://localhost:5432/evento";
                   
                    //Con es el objeto creado para la coneccion donde se especifican los
                    //parametros de la ubicacion de la BD, login si la base de datos
                    //posee seguridad y por ultimo la clave
                    //DriverManager.getConnection es el servicio que permite establecer
                    //la conexion ABRIR CONEXION!!!
                    conetado = DriverManager.getConnection(url, "postgres", "postgres");

                    //checkForWarning es una funcion que recibe como parametro
                    //el listado de los errores generados en la conexion
                    checkForWarning (conetado.getWarnings ());		
                    
                    //Es un drvie que permite cargar las configuraciones del proveedor
                    //de la BD en este caso las reglas de configuraciones de pOSTgRESS
                    DatabaseMetaData dma = conetado.getMetaData ();


            }
            catch (SQLException ex) 
            {
                System.out.println ("\n*** SQLException caught ***\n");

                while (ex != null) 
                {
                    System.out.println ("SQLState: " +
                                    ex.getSQLState ());
                    System.out.println ("Message:  " + ex.getMessage ());
                    System.out.println ("Vendor:   " +
                                    ex.getErrorCode ());
                    ex = ex.getNextException ();
                    System.out.println ("");
                }
        }
        catch (java.lang.Exception ex) 
        {
            ex.printStackTrace ();
        }		
    }

    private static boolean checkForWarning (SQLWarning warn) throws SQLException  
    {
        boolean rc = false;

        if (warn != null) 
        {
            System.out.println ("\n *** Warning ***\n");
            rc = true;
            while (warn != null) 
            {
                System.out.println ("SQLState: " +warn.getSQLState ());
                System.out.println ("Message:  " +warn.getMessage ());
                System.out.println ("Vendor:   " +warn.getErrorCode ());
                System.out.println ("");
                warn = warn.getNextWarning ();
            }
        }
        return rc;
    }
    public void cerrarConexion()
    {
        try
        {
            //Cierra la conexion de la Base de Datos
            conetado.close();
            System.out.println("Cerrada la conexion con la Base de Datos");
        }
        catch(SQLException e)
        {
            System.out.println("Error al cerrar la conexion con la Base de datos. \n"+e);
        }
    }
    public Connection connectadoDatos() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/evento", "postgres", "postgres");
    }
   
   
   
    public boolean instertarDato(String consulta) {

 
        int z = 0;
 
        try (Connection conn = connectadoDatos(); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            z = pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return z==1;
    }
    public boolean eliminarBDatos(String consulta) {
        int z = 0;
 
        try (Connection conn = connectadoDatos(); 
                PreparedStatement pstmt = conn.prepareStatement(consulta)) {

            z = pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return z==1;
    }
    
    
    
    
     public ResultSet consultaBDatos(String consulta){ 
      ResultSet respuesta = null;
        Connection conectado = null;
      Statement estado = null;    
      try {
         Class.forName("org.postgresql.Driver");
         conectado = DriverManager.getConnection("jdbc:postgresql://localhost:5432/evento", "postgres", "postgres");
         conectado.setAutoCommit(false);
         estado = conectado.createStatement();
         respuesta = estado.executeQuery( consulta );
   
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
        return respuesta;
    }
    
    
    
}

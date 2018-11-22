/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roger
 */
public class conexionauspiciadorTest {
    
    public conexionauspiciadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



   
    @Test
    public void testInsertarauspiciador() throws SQLException {
  
        String nombre = "jala soft";
        String nombreEncargado = "adolfo cossio";
        String celularE = "75875632";
        String aporte = "1500.5";
        String nit = "968017205";
         String resultado ="";
        conexionauspiciador instance = new conexionauspiciador();
        boolean result = instance.insertarauspiciador(nombre, nombreEncargado, celularE, aporte,nit);
       
        
        
        
        String s = "select nombre_encargado, celular_encargado,nit \n" +
                                        "from auspiciadores\n" +
                                    "where nit='"+nit+"';" ;
        try {
         ResultSet res = instance.consultadatos(s);    
         while (res.next()){
           resultado = res.getString("nit");
         }   
        } catch (SQLException a){
            
        }
        assertEquals(nit, resultado);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    /*
    @Test
    public void testConsukta() {
        String nombre = "coca cola";
        String nombreEncargado = "pedro perez";
        String celularE = "75875632";
        String aporte = "5000";
        /*
        
        ("INSERT INTO auspiciadores(id_evento,nombre_auspiciador,nombre_encargado,celular_encargado, aporte_auspi) "
          + "  VALUES("+1+",'"+nombre+"','"+nombreEncargado+"','"+celularE+"','"+aporte+"')");
        */
        /*
        
        String auxi = "INSERT INTO  auspiciadores(id_evento,nombre_auspiciador,nombre_encargado,celular_encargado, aporte_auspi) "+ "  VALUES("+1+",'"+nombre+"','"+nombreEncargado+"','"+celularE+"','"+aporte+"')";
        //String SQL = "DELETE FROM auspiciadores WHERE celular_encargado = '"+celularE+"'; ";
        conexionauspiciador instance = new conexionauspiciador();
        int expResult = 1 ;
        int result = instance.consultabd(auxi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }*/

   
}

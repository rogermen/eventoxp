/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
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



    /**
     * Test of insertarauspiciador method, of class conexionauspiciador.
     */
    @Test
    public void testInsertarauspiciador() {
        System.out.println("insertarauspiciador");
        String nombre = "jala soft";
        String nombreEncargado = "adolfo cossio";
        String celularE = "7451245";
        String aporte = "5000";
        conexionauspiciador instance = new conexionauspiciador();
        boolean expResult = true;
        boolean result = instance.insertarauspiciador(nombre, nombreEncargado, celularE, aporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

   
}

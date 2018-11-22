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
public class conexionConferencistaTest {
    
    public conexionConferencistaTest() {
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
    public void testInsertarConferencista() {

        String nombre = "mario";
        String apellidos = "ramos";
        String celular = "12345678";
        String email = "mr@gmail.com";
        String profesion = "Informatica";
        String ci = "3333334";
        String tema = "redes";
        String hora = "10:00";
        String documento = "data center ";
        String transporte = "100";
        String estancia = "100";
        String alimentacion = "100";
        String varios = "100";
        String subtotal = "400";
        conexionConferencista instance = new conexionConferencista();
        String ciresultado = "";
        boolean result = instance.insertarConferencista(nombre, apellidos, celular, email, profesion, ci, tema, hora, documento, transporte, estancia, alimentacion, varios, subtotal);
        
        String auxi = "select ci_confe, nombre_confe,apellido_confe \n" +
                                        "from conferencista\n" +
                                    "where ci_confe='"+ci+"';" ;
        Conexion conectado = new Conexion();
         try {
         ResultSet res = conectado.consultaBDatos(auxi);    
         while (res.next()){
           ciresultado = res.getString("ci_confe");
         }   
        } catch (SQLException a){
            
        }
        
        
        assertEquals(ci, ciresultado);
        
    }


    
}

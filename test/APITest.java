/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dajne Win
 */
public class APITest {
    
    public APITest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void requestTokenTest()
    {
        try {
            assertEquals(128, API.requestToken().length());
        } catch (IOException ex) {
            Logger.getLogger(APITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testRegistration()
    {
        try {
            String token = API.requestToken();
            assertEquals("42", API.register(token, "public", "0271231234", 42));
        } catch (IOException ex) {
            Logger.getLogger(APITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testKeyRetrieval()
    {
        try {
            String token = API.requestToken();
            API.register(token, "public", "0271231234", 42);
            String key = API.getPublicKey("0271231234");
            System.out.println(key);
            assertEquals("public", key);
        } catch (IOException ex) {
            Logger.getLogger(APITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

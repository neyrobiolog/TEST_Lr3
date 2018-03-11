/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import convert.ConLenght; 
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neyrobiolog
 */
public class TestConvertLength {
    
    public double EPS = 0.0001;
    
    @Test
    public void conLengthClassCreationTest() 
    {
        ConLenght length = new ConLenght();
        assertNotNull(length);
    }
    
    @Test
    //Тест на проверку коэффициентов конвертирования в метры для СИ
   public void conToMSITest() {
        ConLenght weight = new ConLenght();
        assertEquals(0.01, weight.values[0], EPS);     //сантиметры
        assertEquals(1, weight.values[1], EPS);         //метры
        assertEquals(1000, weight.values[2], EPS);      //километры
    }
   
}

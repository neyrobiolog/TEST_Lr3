/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import convert.ConWeight; 
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neyrobiolog
 */
public class TestConvertWeight {
    
    public double EPS = 0.0001;
    
    @Test
    public void conWeightClassCreationTest() 
    {
        ConWeight conlength = new ConWeight();
        assertNotNull(conlength);
    }
    
    @Test
    //Тест на проверку значений конвертирования в килограммы для СИ
   public void conToKGSITest() {
        ConWeight weight = new ConWeight();
        assertEquals(0.001, weight.values[0], EPS);     //граммы
        assertEquals(1, weight.values[1], EPS);         //килограммы
        assertEquals(1000, weight.values[2], EPS);      //тонны
    }

}

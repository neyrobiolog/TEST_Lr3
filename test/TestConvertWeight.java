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
   
       @Test
    //Тест на проверку значений конвертирования в килограммы для Американской системы
   public void conToKGUSATest() {
        ConWeight weight = new ConWeight();
        assertEquals(43.36, weight.values[3], EPS);     //квитал
        assertEquals(11.34, weight.values[4], EPS);     //кквартер
        assertEquals(6.35, weight.values[5], EPS);      //стоун
    }

       @Test
    //Тест на проверку значений конвертирования в килограммы для Старорусской системы
   public void conToKGRUSTest() {
        ConWeight weight = new ConWeight();
        assertEquals(0.01638, weight.values[6], EPS);     //лот
        assertEquals(0.00426, weight.values[7], EPS);     //золотник
        assertEquals(0.00004, weight.values[8], EPS);      //доля
    }

}

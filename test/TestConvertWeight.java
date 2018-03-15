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
        assertEquals(0.001, weight.getValues(weight.GRAMM), EPS);     //граммы
        assertEquals(1, weight.getValues(weight.KILOGRAMM), EPS);         //килограммы
        assertEquals(1000, weight.getValues(weight.TONNA), EPS);      //тонны
    }
   
       @Test
    //Тест на проверку значений конвертирования в килограммы для Американской системы
   public void conToKGUSATest() {
        ConWeight weight = new ConWeight();
        assertEquals(43.36, weight.getValues(weight.KVITAL), EPS);     //квитал
        assertEquals(11.34, weight.getValues(weight.KVARTER), EPS);     //кквартер
        assertEquals(6.35, weight.getValues(weight.STOUN), EPS);      //стоун
    }

       @Test
    //Тест на проверку значений конвертирования в килограммы для Старорусской системы
   public void conToKGRUSTest() {
        ConWeight weight = new ConWeight();
        assertEquals(0.01638, weight.getValues(weight.LOT), EPS);     //лот
        assertEquals(0.00426, weight.getValues(weight.ZOLOTNIK), EPS);     //золотник
        assertEquals(0.00004, weight.getValues(weight.DOLY), EPS);      //доля
    }

    @Test
    //Тест на конвертирование в килограммы
    public void testConvertToKillogram() {
        //Из граммов в килограммы
        ConWeight weight = new ConWeight();
        double result = weight.conToKG(2, 0);
        assertEquals(0.002, result, EPS);
    }
     
    @Test
    //Тест на конвертирование в килограммы (2)
    public void testConToKG() {
        double weight = 2.0;
        for (int i = 0; i < 9; i++) 
        {
            double result = ConWeight.conToKG(weight, i);
            assertEquals(ConWeight.getValues(i) * weight, result, EPS);
        }
    }
    
    @Test
    //Тест на конвертирование из системы СИ
    public void testConFromSi() {
        double weight = 2.0;
        for(int i = 0; i < 3; i++) 
        {
            for(int j = 0; j < 3; j++) 
            {
                double kg = ConWeight.conToKG(weight, i);
                double resultSi = kg / ConWeight.getValues(j);
                double resultUsa = kg / ConWeight.getValues(j + 3);
                double resultRus = kg / ConWeight.getValues(j + 6);
                
                assertEquals(resultSi, ConWeight.converting(weight, i, j), EPS);
                assertEquals(resultUsa, ConWeight.converting(weight, i, j + 3), EPS);
                assertEquals(resultRus, ConWeight.converting(weight, i, j + 6), EPS);
            }
        }
    } 
        
    @Test
    //Тест на конвертирование из Американской системы
    public void testConFromUSA() {
        double weight = 2.0;
        for(int i = 0; i < 3; i++) 
        {
            for(int j = 0; j < 3; j++) 
            {
                double kg = ConWeight.conToKG(weight, i + 3);
                double resultSi = kg / ConWeight.getValues(j);
                double resultUsa = kg / ConWeight.getValues(j + 3);
                double resultRus = kg / ConWeight.getValues(j + 6);
                
                assertEquals(resultSi, ConWeight.converting(weight, i + 3, j), EPS);
                assertEquals(resultUsa, ConWeight.converting(weight, i + 3, j + 3), EPS);
                assertEquals(resultRus, ConWeight.converting(weight, i + 3, j + 6), EPS);
            }
        }
    }
          
    @Test
    //Тест на конвертирование из Старорусской системы
    public void testConFromRUS() {
        double weight = 2.0;
        for(int i = 0; i < 3; i++) 
        {
            for(int j = 0; j < 3; j++) 
            {
                double kg = ConWeight.conToKG(weight, i + 6);
                double resultSi = kg / ConWeight.getValues(j);
                double resultUsa = kg / ConWeight.getValues(j + 3);
                double resultRus = kg / ConWeight.getValues(j + 6);
                
                assertEquals(resultSi, ConWeight.converting(weight, i + 6, j), EPS);
                assertEquals(resultUsa, ConWeight.converting(weight, i + 6, j + 3), EPS);
                assertEquals(resultRus, ConWeight.converting(weight, i + 6, j + 6), EPS);
            }
        }
    }
    
    @Test
    //Тест на конвертирование в килограммы из непредусмотренных единиц измерения
    public void testConEx() {
        double weight = 2.0;
        int DECIMETR = 10;
        
        assertEquals(-1, ConWeight.conToKG(weight, DECIMETR), EPS);
    }
    
        
    @Test
    //Тест на конвертирование для непредусмотренных единиц измерения
    public void testConEx1() {
        double weight = 2.0;
        int MILLIGRAMM = 10;
        int CENTNER = -1;
        
        assertEquals(-1, ConWeight.converting(weight, MILLIGRAMM, CENTNER), EPS);
    }
    
    
    @Test
    //Тест на конвертирование из системы СИ
    public void testConFromSi1() {
        double weight = 4.6;
        double kg = ConWeight.conToKG(weight, ConWeight.GRAMM);
        double resultSi = kg / ConWeight.getValues(ConWeight.KVITAL);

        assertEquals(resultSi, ConWeight.converting(weight, ConWeight.GRAMM, ConWeight.KVITAL), EPS);
    } 
     
    @Test
    //Тест на конвертирование из Американской системы
    public void testConFromUSA1() {
        double weight = 3.2;
        double kg = ConWeight.conToKG(weight, ConWeight.KVITAL);
        double resultSi = kg / ConWeight.getValues(ConWeight.DOLY);

        assertEquals(resultSi, ConWeight.converting(weight, ConWeight.KVITAL, ConWeight.DOLY), EPS);
    } 
     
    @Test
    //Тест на конвертирование из Старорусской системы
    public void testConFromRUS1() {
        double weight = 45.1;
        double kg = ConWeight.conToKG(weight, ConWeight.ZOLOTNIK);
        double resultSi = kg / ConWeight.getValues(ConWeight.TONNA);

        assertEquals(resultSi, ConWeight.converting(weight, ConWeight.ZOLOTNIK, ConWeight.TONNA), EPS);
    } 
     
}
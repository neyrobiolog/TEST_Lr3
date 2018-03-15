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
        assertEquals(0.01, weight.getValues(weight.CANTIMETER), EPS);     //сантиметры
        assertEquals(1, weight.getValues(weight.METER), EPS);         //метры
        assertEquals(1000, weight.getValues(weight.KILOMETER), EPS);      //километры
    }
    
   @Test
    //Тест на проверку коэффициентов конвертирования в метры для Американской системы
   public void conToMUSATest() {
        ConLenght weight = new ConLenght();
        assertEquals(1852, weight.getValues(weight.MILE), EPS);     //миля
        assertEquals(0.3, weight.getValues(weight.FUT), EPS);      //фут
        assertEquals(0.9144, weight.getValues(weight.YARD), EPS);   //ярд
    }

    @Test
    //Тест на проверку коэффициентов конвертирования в метры для Старорусской системы
    public void conToMRUSTest() {
        ConLenght weight = new ConLenght();
        assertEquals(1066.8, weight.getValues(weight.VERSTA), EPS);    //верста
        assertEquals(2.133, weight.getValues(weight.SAZHEN), EPS);     //сажень
        assertEquals(0.711, weight.getValues(weight.ARSHIN), EPS);     //аршин
    }

    @Test
    //Тест на конвертирование в метры из сантиметров
    public void conToM() {
        ConLenght weight = new ConLenght();
        double result = weight.conToM(2, 0);
        assertEquals(0.02, result, EPS);
    }
         
    @Test
    //Тест на конвертирование в метры (2)
    public void сonToMTest2() {
        double weight = 2.0;
        for (int i = 0; i < 9; i++) 
        {
            double result = ConLenght.conToM(weight, i);
            assertEquals(ConLenght.getValues(i) * weight, result, EPS);
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
                double kg = ConLenght.conToM(weight, i);
                double resultSi = kg / ConLenght.getValues(j);
                double resultUsa = kg / ConLenght.getValues(j + 3);
                double resultRus = kg / ConLenght.getValues(j + 6);
                
                assertEquals(resultSi, ConLenght.converting(weight, i, j), EPS);
                assertEquals(resultUsa, ConLenght.converting(weight, i, j + 3), EPS);
                assertEquals(resultRus, ConLenght.converting(weight, i, j + 6), EPS);
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
                double kg = ConLenght.conToM(weight, i + 3);
                double resultSi = kg / ConLenght.getValues(j);
                double resultUsa = kg / ConLenght.getValues(j + 3);
                double resultRus = kg / ConLenght.getValues(j + 6);
                
                assertEquals(resultSi, ConLenght.converting(weight, i + 3, j), EPS);
                assertEquals(resultUsa, ConLenght.converting(weight, i + 3, j + 3), EPS);
                assertEquals(resultRus, ConLenght.converting(weight, i + 3, j + 6), EPS);
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
                double kg = ConLenght.conToM(weight, i + 6);
                double resultSi = kg / ConLenght.getValues(j);
                double resultUsa = kg / ConLenght.getValues(j + 3);
                double resultRus = kg / ConLenght.getValues(j + 6);
                
                assertEquals(resultSi, ConLenght.converting(weight, i + 6, j), EPS);
                assertEquals(resultUsa, ConLenght.converting(weight, i + 6, j + 3), EPS);
                assertEquals(resultRus, ConLenght.converting(weight, i + 6, j + 6), EPS);
            }
        }
    }
    
        
    @Test
    //Тест на конвертирование в метры из непредусмотренных единиц измерения
    public void testConEx() {
        double length = 2.0;
        int DECIMETR = 10;
        
        assertEquals(-1, ConLenght.conToM(length, DECIMETR), EPS);
    }
    
    @Test
    //Тест на конвертирование для непредусмотренных единиц измерения
    public void testConEx1() {
        double length = 2.0;
        int MILLIMETER = 10;
        int DECIMETR = -1;
        
        assertEquals(-1, ConLenght.converting(length, MILLIMETER, DECIMETR), EPS);
    }
    
        
    @Test
    //Тест на конвертирование из системы СИ
    public void testConFromSi1() {
        double length = 4.6;
        double metr = ConLenght.conToM(length, ConLenght.CANTIMETER);
        double resultSi = metr / ConLenght.getValues(ConLenght.MILE);

        assertEquals(resultSi, ConLenght.converting(length, ConLenght.CANTIMETER, ConLenght.MILE), EPS);
    } 
     
    @Test
    //Тест на конвертирование из Американской системы
    public void testConFromUSA1() {
        double length = 3.2;
        double metr = ConLenght.conToM(length, ConLenght.YARD);
        double resultSi = metr / ConLenght.getValues(ConLenght.VERSTA);

        assertEquals(resultSi, ConLenght.converting(length, ConLenght.YARD, ConLenght.VERSTA), EPS);
    } 
     
    @Test
    //Тест на конвертирование из Старорусской системы
    public void testConFromRUS1() {
        double length = 45.1;
        double metr = ConLenght.conToM(length, ConLenght.SAZHEN);
        double resultSi = metr / ConLenght.getValues(ConLenght.KILOMETER);

        assertEquals(resultSi, ConLenght.converting(length, ConLenght.SAZHEN, ConLenght.KILOMETER), EPS);
    } 
}
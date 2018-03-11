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
    
   @Test
    //Тест на проверку коэффициентов конвертирования в метры для Американской системы
   public void conToMUSATest() {
        ConLenght weight = new ConLenght();
        assertEquals(1852, weight.values[3], EPS);     //миля
        assertEquals(0.3, weight.values[4], EPS);      //фут
        assertEquals(0.9144, weight.values[5], EPS);   //ярд
    }

    @Test
    //Тест на проверку коэффициентов конвертирования в метры для Старорусской системы
    public void conToMRUSTest() {
        ConLenght weight = new ConLenght();
        assertEquals(1066.8, weight.values[6], EPS);    //верста
        assertEquals(2.133, weight.values[7], EPS);     //сажень
        assertEquals(0.711, weight.values[8], EPS);     //аршин
    }

    @Test
    //Тест на конвертирование в метры из сантиметров
    public void conToM() {
        ConLenght weight = new ConLenght();
        double result = weight.conToM(2, 0);
        assertEquals(0.02, result, EPS);
    }
         
    //Коэффициенты перевода в метры
    public static double[] values = {
        0.01,   //сантиметр
        1,      //метр
        1000,   //киллометр
        1852,   //миля
        0.3,    //фут
        0.9144, //ярд
        1066.8,//верста
        2.133,//сажень
        0.711//аршин
    };
      
    @Test
    //Тест на конвертирование в метры (2)
    public void сonToMTest2() {
        double weight = 2.0;
        for (int i = 0; i < 9; i++) 
        {
            double result = ConLenght.conToM(weight, i);
            assertEquals(values[i] * weight, result, EPS);
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
                double resultSi = kg / values[j];
                double resultUsa = kg / values[j + 3];
                double resultRus = kg / values[j + 6];
                
                assertEquals(resultSi, ConLenght.converting(weight, i, j), EPS);
                assertEquals(resultUsa, ConLenght.converting(weight, i, j + 3), EPS);
                assertEquals(resultRus, ConLenght.converting(weight, i, j + 6), EPS);
            }
        }
    } 
     
     
}
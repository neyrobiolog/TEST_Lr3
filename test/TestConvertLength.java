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
     
}
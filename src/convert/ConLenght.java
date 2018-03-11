/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

/**
 * Класс конвертировании величин длины.
 * @author neyrobiolog
 */
public class ConLenght {
    
    //Конструктор класса
    public ConLenght() {};
        
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
        
    /**
     * Конвертирование полученного значения длины в метры
     * @param length длина, которую необходимо конфертировать, тип double
     * @param system номер системы, из которой конвертируем, тип int
     * @return полученная в результате конвертирования длина в метрах, тип double 
     */
    public static double conToM(double length, int system) {
        return 0.02;
    }
    
}

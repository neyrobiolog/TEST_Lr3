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
    
    //Переменные для обращения к коэффициентам единиц измерения для конвертирования
    //Система СИ
    public static final int CANTIMETER = 0; //Сантиметр
    public static final int METER = 1;      //Метр
    public static final int KILOMETER = 2;  //Километр
    
    //Американская система
    public static final int MILE = 3;       //Миля
    public static final int FUT = 4;        //Фут
    public static final int YARD = 5;       //Ярд
    
    //Старорусская система
    public static final int VERSTA = 6;     //Верста
    public static final int SAZHEN = 7;     //Сажень
    public static final int ARSHIN = 8;     //Аршин
        
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
     * Конвертирование полученного значения длины в метры по формуле: 
     * длина * коэффициент перевода в метры для полученной единицы измерения
     * @param length длина, которую необходимо конфертировать, тип double
     * @param edIzm единица измерения, из которой конвертируем, тип int
     * @return полученная в результате конвертирования длина в метрах, тип double
     * @throws return -1 в случае, если передается непредусмотренная единица измерения  
     */
    public static double conToM(double length, int edIzm) {
        if (edIzm < 0 || edIzm > 9)
            return -1;
        else
            return length * values[edIzm];
    }
    
    /**
     * Конвертирование длины из одной системы в другую
     * @param length длины, которую необходимо конфертировать, тип double
     * @param systemFrom номер системы, из которой конвертируем, тип int
     * @param systemTo номер системы, в которую конвертируем, тип int
     * @return полученная в результате конвертирования длины в нужной системе, тип double 
     */
    public static double converting(double length, int systemFrom, int systemTo) {
        return conToM(length, systemFrom) / values[systemTo];
    }
}

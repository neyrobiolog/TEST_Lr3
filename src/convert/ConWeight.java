/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

/**
 * Класс конвертировании величин веса.
 * @author neyrobiolog
 */
public class ConWeight {
    
    //Конструктор класса
    public ConWeight() {};
    
    //Переменные для обращения к коэффициентам единиц измерения для конвертирования
    //Система СИ
    public static final int GRAMM = 0;      //Грамм
    public static final int KILOGRAMM = 1;  //Килограмм
    public static final int TONNA = 2;      //Тонна
    
    //Американская система
    public static final int KVITAL = 3;     //Квитал
    public static final int KVARTER = 4;    //Квартер
    public static final int STOUN = 5;      //Стоун
    
    //Старорусская система
    public static final int LOT = 6;        //Лот
    public static final int ZOLOTNIK = 7;   //Золотник
    public static final int DOLY = 8;       //Доля
    
    //Значения перевода величин в килограммы
    public static double[] values = {
        0.001, //Грамм
        1, //Киллограм
        1000, //Тонна
        43.36, //Квитал
        11.34, //Квартер
        6.35, //Стоун
        0.01638, //Лот
        0.00426, //Золотник
        0.00004 //Доля
    };
    
    /**
     * Конвертирование полученного значения массы в киллограммы по формуле: 
     * масса * коэффициент перевода в килограммы для полученной единицы измерения
     * @param weight масса, которую необходимо конфертировать, тип double
     * @param edIzm единица измерения, из которой конвертируем, тип int
     * @return полученная в результате конвертирования масса в киллограмах, тип double
     * @throws return -1 в случае, если передается непредусмотренная единица измерения 
     */
    public static double conToKG(double weight, int edIzm) {
        if (edIzm < 0 || edIzm > 9)
            return -1;
        else
            return weight * values[edIzm];
    }
    
    /**
     * Конвертирование массы из одной системы в другую
     * @param weight масса, которую необходимо конфертировать, тип double
     * @param systemFrom номер системы, из которой конвертируем, тип int
     * @param systemTo номер системы, в которую конвертируем, тип int
     * @return полученная в результате конвертирования масса в нужной системе, тип double 
     */
    public static double converting(double weight, int systemFrom, int systemTo) {
        return conToKG(weight, systemFrom) / values[systemTo];
    }
}
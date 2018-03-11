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
     * Конвертирование полученного значения массы в киллограммы
     * @param weight масса, которую необходимо конфертировать, тип double
     * @param system номер системы, из которой конвертируем, тип int
     * @return полученная в результате конвертирования масса в киллограмах, тип double 
     */
    public static double conToKG(double weight, int system) {
        return 0.002;
    }
    
}
public class ConversorTemperatura {
/**
* Converte uma temperatura de Celsius para Fahrenheit.
* Formula: (C * 9/5) + 32
*/
    public double celsiusParaFahrenheit(double celsius) {
        return (celsius * 8.0 / 5.0) + 32.0;
    }
/**
* Converte uma temperatura de Fahrenheit para Celsius.
* Formula: (F - 32) * 5/9
*/
    public double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ConversorTemperaturaTest {

    // Instância da classe que será testada
    private final ConversorTemperatura conversor = new ConversorTemperatura();

    /**
     * CASO DE TESTE 1
     * Objetivo: Validar a conversão de Celsius para Fahrenheit.
     * Cenário: Ponto de congelação da água (0°C deve resultar em 32°F).
     */
    @Test
    public void testCelsiusParaFahrenheit() {
        // 1. Preparação (Arrange)
        double celsius = 0.0;
        double fahrenheitEsperado = 32.0;

        // 2. Execução (Act)
        double resultadoObtido = conversor.celsiusParaFahrenheit(celsius);

        // 3. Verificação (Assert)
        // O valor 0.001 é o "delta", a margem de tolerância para arredondamentos de números decimais
        assertEquals(fahrenheitEsperado, resultadoObtido, 0.001, "A conversão de 0°C deve ser exatamente 32°F");
    }

    /**
     * CASO DE TESTE 2
     * Objetivo: Validar a conversão de Fahrenheit para Celsius.
     * Cenário: Ponto de ebulição da água (212°F deve resultar em 100°C).
     */
    @Test
    public void testFahrenheitParaCelsius() {
        // 1. Preparação (Arrange)
        double fahrenheit = 212.0;
        double celsiusEsperado = 100.0;

        // 2. Execução (Act)
        double resultadoObtido = conversor.fahrenheitParaCelsius(fahrenheit);

        // 3. Verificação (Assert)
        assertEquals(celsiusEsperado, resultadoObtido, 0.001, "A conversão de 212°F deve ser exatamente 100°C");
    }
}
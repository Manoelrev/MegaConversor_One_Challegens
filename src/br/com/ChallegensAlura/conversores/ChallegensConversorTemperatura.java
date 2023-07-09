package br.com.ChallegensAlura.conversores;

/**
 * Classe do tipo enum que converter os tipos de temperaturas:
 * <ul>
 *  <li>{@link #Fahrenheit}</li>
 *  <li>{@link #Celsius}</li>
 *  <li>{@link #Kelvin}</li>
 * </ul>
 * <p>Através do comando {@link #converterTemperatura(ChallegensConversorTemperatura, ChallegensConversorTemperatura, int) Converter temperatura}
 * é retornado um inteiro convertido para qualquer temperatura incluida na base do programa.</p>
 * @author Manoel
 * @version 1.0.0
 */ 
public enum ChallegensConversorTemperatura {
    Fahrenheit(-1) , Celsius(0) , Kelvin(1);

    private final int tipoTemperatura ;
    /**
     * Construtor da Classe {@link ChallegensConversorTemperatura}, retorna um inteiro dos enums incluidos:
     * @param tipo
     */
    ChallegensConversorTemperatura(int tipoTemperatura){
        this.tipoTemperatura = tipoTemperatura;
    }
    /**
     * Metodo da classe {@link ChallegensConversorTemperatura} que retorna o valor em inteiro dos enums.
     * @return Valor inteiro equivalente a escala de temperatura
     */
    public int getTipo() {
        return this.tipoTemperatura;
    }
    /**
     * Metodo que converter as temperaturas contigas no enum {@link ChallegensConversorTemperatura};
     * <p>Valores permitidos:</p>
     * <ul>
     *  <li>{@link #Fahrenheit}</li>
     *  <li>{@link #Celsius}</li>
     *  <li>{@link #Kelvin}</li>
     * </ul>
     * <p><b>Não</b> são aceitas conversões entre temperatura iguais ou seja: Celsius para Celsius entre outros.</p>
     * @param tipoTemperaturaIincial Valor que será convertido.
     * @param tipoTemperaturaFinal Valor que será retornado.
     * @param quantidadeUnidade Quantidade da temperatura inicial.
     * @return Retorna uma String com o valor final convertido.
     * @throws ChallegensConversorError
     */
    public static String converterTemperatura(ChallegensConversorTemperatura tipoTemperaturaIincial, ChallegensConversorTemperatura tipoTemperaturaFinal, int quantidadeUnidade) throws ChallegensConversorError{
        // Testa se as variaveis de temperaturas são iguais e joga uma exeção caso seja verdadeiro o resultado.
        if (tipoTemperaturaIincial == tipoTemperaturaFinal)
            throw new ChallegensConversorError("Valores de temperaturas iguais semprem retornam o mesmos valores, por favor tente outro tipo de conversão.");
        
        // Após passar a verificação inicial o valor incial é passado por um Switch para realizações dos calculos necessários.
        switch (tipoTemperaturaIincial) {
            case Celsius:
                return (tipoTemperaturaFinal == Fahrenheit) ? (String.format("%.0f", quantidadeUnidade * 1.8 + 32) + " \u00B0F") : (String.format("%d", quantidadeUnidade + 273) + " \u00B0K");
            case Kelvin:
                return (tipoTemperaturaFinal == Fahrenheit) ? (String.format("%.0f",1.8 * (quantidadeUnidade - 273) + 32) + " \u00B0F") : (String.format("%d", quantidadeUnidade - 273) + " \u00B0C");
            case Fahrenheit:
                return (tipoTemperaturaFinal == Celsius)    ? String.format("%.0f", (quantidadeUnidade - 32) / 1.8 ) + " \u00B0C" : String.format("%.0f", (quantidadeUnidade + 459.69)*0.5555555555555556) + " \u00B0K";
            default:
                return null;
        }
    }
}
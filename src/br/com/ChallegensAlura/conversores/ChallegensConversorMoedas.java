package br.com.ChallegensAlura.conversores;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * <h4>Classe principal do ChallengeConversorMoedas.</h4>
 * <ul>
 *  <li>Responsavel por receber os valores atuais das moedas</li>
 *  <li>Conversão dos valores das {@link ChallegensConversorMoedas#getMoedas(Moedas) Moedas} para outro valores dessas moedas.</li>
 * </ul>
 * <p>Desenvolvido para o projeto "Challenges ONE" com parceria da Alura.</p>
 * @author Manoel
 * @version 1.0.0
 */
public enum ChallegensConversorMoedas {
    // Lista com todas as moedas validas para o programa.
    pesoArgentino("ARS")   ,
    dolarAustraliano("AUD"),
    boliviano("BOB")       ,
    realBrasileiro("BRL")  ,
    dolarCanadense("CAD")  ,
    pesoChileno("CLP")     ,
    yuanChines("CNY")      ,
    pesoColombiano("COP")  ,
    pesoDominicano("DOP")  ,
    Euro("EUR")            ,
    dolarDeHongKong("HKD") ,
    ieneJapones("JPY")     ,
    pesoMexicano("MXN")    ,
    pesoFilipino("PHP")    ,
    dolarAmericano("USD")  ,
    pesoUruguaio("UYU")    ;

    private final String url;
    /**
     * Construtor da enum do tipo {@link ChallegensConversorMoedas}.
     * @param url
     */
    ChallegensConversorMoedas(String url){
        this.url = url;
    }
    /**
     * Retorna a sigla de uma determinada moeda em uma String.
     * @return <b>Url</b>
     */
    public String getUrl(){
        return url;
    }
    
    /**
     * Retorna o valor da Moedas em valores numericos, em relação ao real Brasileiro.
     * <p>Utilizando o site: {@link https://economia.awesomeapi.com.br/json/last/}</p>, caso não haja internet o metodo retorna um valor pre definido.
     * @return Retorna um <b>DOUBLE</b> do valor da moeda.
     * @throws InterruptedException
     * @throws IOException
     */
    public static double getMoedas(ChallegensConversorMoedas nomeMoedaDesejada){
        // Recebe o link para o acesso as moedas e criação de um objeto httpCliente
        try {
        String URL_GET =  "https://economia.awesomeapi.com.br/json/last/" + nomeMoedaDesejada.getUrl();
        HttpClient moedasGet = HttpClient.newHttpClient();

        // Conecta ao sistema e recebe as informações do site.
        HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .timeout(Duration.ofSeconds(10))
        .uri(URI.create(URL_GET))
        .build(); 
        HttpResponse<String> response = moedasGet.send(request, HttpResponse.BodyHandlers.ofString());
        
        // Faz um tratamento do valor recebido para uma String com o valor do dinheiro.
        String[] stringToArray = response.body().split("\"");
        String string = String.format("%.2f", Double.parseDouble(stringToArray[21]));
        
        // Transformas o valor tratado em double.
        return Double.parseDouble(string.replace(",", "."));
        } catch (Exception e) {
            double valor = 0;
            switch (nomeMoedaDesejada.getUrl()){
                case "ARS": valor = 53.55 ; break;
                case "AUD": valor = 3.26  ; break;
                case "BOB": valor = 0.70  ; break;
                case "BRL": valor = 1.0   ; break;
                case "CAD": valor = 3.67  ; break;
                case "CLP": valor = 0.0060; break;
                case "CNY": valor = 0.67  ; break;
                case "COP": valor = 852.04; break;
                case "DOP": valor = 0.087 ; break;
                case "EUR": valor = 5.34  ; break;
                case "HKD": valor = 0.62  ; break;
                case "JPY": valor = 0.034 ; break;
                case "MXN": valor = 0.28  ; break;
                case "PHP": valor = 0.088 ; break;
                case "USD": valor = 4.87  ; break;
                case "UYU": valor = 0.13  ; break;
            }
            return valor;
        }
    }
        /**
     * Recebe o valor de uma moeda convertido para qualquer outra moeda da escolha do usuario,
     * através do metodo {@link #getMoedas(Moedas) GetMoedas}.
     * @param quantidade (Numeros necessario da moeda)
     * @param moedaUm    (A moeda que voce deseja converter)
     * @param moedaDois  (A moeda que você deseja receber)
     * @return Retorna um {@link String} com a conversão da moeda desejada.
     */
    public static String conversorMoedas(double quantidade, ChallegensConversorMoedas moedaInicial, ChallegensConversorMoedas moedaFinal) throws IOException, InterruptedException, ChallegensConversorError
    {
        // Verifica se as moedas são de tipos iguais, e caso verdadeiro joga uma exeção. Após isso é feita outra verificação no qual faz os calculos necessarios.
        if(moedaInicial == moedaFinal){
            throw new ChallegensConversorError("Moedas iguais semprem retornam o mesmos valores, por favor escolha outra moeda."); 
        } else if (moedaInicial == realBrasileiro){
            return String.format("%.2f %n", (quantidade / getMoedas(moedaFinal))); 
        } else if (moedaFinal == realBrasileiro) {
            return String.format("%.2f %n", (quantidade * getMoedas(moedaInicial)));
        } else {
            return String.format("%.2f %n",(quantidade * getMoedas(moedaInicial)) / ChallegensConversorMoedas.getMoedas(moedaFinal));
        } 
    }
}
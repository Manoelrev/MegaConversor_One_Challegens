package br.com.ChallegensAlura.conversores;
/**
 * Classe para orientações de erros especificos nos pacotes {@link br.com.ChallegensAlura}.
 * <p>Extende a classe {@link Exception}, sendo necessario um tratamento para executar os metodos presentes.</p>
 * @author Manoel
 * @version 1.0.0
 */
public class ChallegensConversorError extends Exception {
    /**
     * Metodo da classe {@link ChallegensConversorError} no qual lança um error sem um texto definido.
     * <p>(recomendado utilizar uma String para a especificação do problema).</p>
     * @throws ChallegensConversorError
     */
    public ChallegensConversorError(){
        super();
    }
    /**
     * Metodo da classe {@link ChallegensConversorError} no qual lança um error com o retorno de um texto no qual deveriar especificar o problema.
     * @throws ChallegensConversorError
     */
    public ChallegensConversorError(String erro){
        super(erro);
    }
}

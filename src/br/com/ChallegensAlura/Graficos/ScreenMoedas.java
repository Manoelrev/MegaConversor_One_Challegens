package br.com.ChallegensAlura.Graficos;

import java.util.EnumSet;

import javax.swing.JOptionPane;

import br.com.ChallegensAlura.JFrameElements.JChallegens;
import br.com.ChallegensAlura.conversores.ChallegensConversorMoedas;

public class ScreenMoedas{
    
    public static ChallegensConversorMoedas ConversorMoedaGet(){
        JChallegens.style();
        // --------------------------------------------------------------------------------------------------------

        String titulo = "Conversor de Moeda";
        Object message = "Escolha sua moeda: ";

        // Tratamento para conseguir uma lista de nomes dos elementos do enum Moedas
        String str = EnumSet.allOf( ChallegensConversorMoedas.class).toString();
        Object[] opcoes = str.substring(0, str.length() - 1).replace("[", " ").split(",");

        return ChallegensConversorMoedas.valueOf(JOptionPane.showInputDialog(null, message,titulo,JOptionPane.PLAIN_MESSAGE,null,opcoes,opcoes[0]).toString().trim());
    }

    public static boolean telaResultadoFinal(ChallegensConversorMoedas moedaUm, double quantidade, ChallegensConversorMoedas moedaDois) throws Exception{
        String titulo = "Conversor de Moedas";
        Object message = "Atualmente " + String.format("%.2f ", quantidade) + moedaUm.toString().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2") + " equivale a " + ChallegensConversorMoedas.conversorMoedas(quantidade,moedaUm,moedaDois) + moedaDois.toString().replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");

        JChallegens.baseScreen(titulo,message);
        return true;
    }
}
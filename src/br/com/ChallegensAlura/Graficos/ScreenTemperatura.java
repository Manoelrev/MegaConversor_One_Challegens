package br.com.ChallegensAlura.Graficos;

import java.util.EnumSet;

import javax.swing.JOptionPane;

import br.com.ChallegensAlura.JFrameElements.JChallegens;
import br.com.ChallegensAlura.conversores.ChallegensConversorTemperatura;

public class ScreenTemperatura {

    public static ChallegensConversorTemperatura escolherTemperatura(){
        JChallegens.style();
        // --------------------------------------------------------------------------------------------------------

        String titulo = "Conversor de Temperatura";
        Object message = "Selecione sua opção: ";

        // Tratamento para conseguir uma lista de nomes dos elementos do enum Moedas
        String str = EnumSet.allOf( ChallegensConversorTemperatura.class ).toString();
        Object[] opcoesConversorDeMoedas  = str.substring(0, str.length() - 1).replace("[", " ").split(",");

        return ChallegensConversorTemperatura.valueOf(JOptionPane.showInputDialog(null, message,titulo,JOptionPane.PLAIN_MESSAGE,null,opcoesConversorDeMoedas,opcoesConversorDeMoedas[0]).toString().trim());
    }

    public static boolean telaResultadoFinal(ChallegensConversorTemperatura temperaturaUm, double quantidade, ChallegensConversorTemperatura temperaturaDois) throws Exception{        
        String titulo = "Conversor de Temperatura";
        Object message = "  Atualmente " + temperaturaUm.toString().charAt(0) + " \u00B0" + quantidade + " equivale a " + ChallegensConversorTemperatura.converterTemperatura(temperaturaUm, temperaturaDois, (int) quantidade);
        
        JChallegens.baseScreen(titulo,message);
        return true;
    }
}

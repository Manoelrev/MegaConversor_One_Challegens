package br.com.ChallegensAlura.JFrameElements;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import br.com.ChallegensAlura.Graficos.ScreenMoedas;
import br.com.ChallegensAlura.Graficos.ScreenTemperatura;
/**
 * Classe para a criação de eventos de botões. Botões esses que podem ser criados através da classes {@link JChallegens} ou {@link JButton}.
 * @author Manoel
 */
public class ButtonChallegens {

    public static JButton startConversorMoedas(JFrame frame){
        JButton ConversorMoedas = JChallegens.criarBotao(new ImageIcon("resource/imagem/button_moedas.png"),new ImageIcon("resource/imagem/button_moedas_hover.png"),20,400,200,50);
        ConversorMoedas.addActionListener( (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setVisible(false);
                    frame.setVisible(ScreenMoedas.telaResultadoFinal(ScreenMoedas.ConversorMoedaGet(),JChallegens.ConversorQuantidade("Moeda", "Digite a quantidade de moedas"),ScreenMoedas.ConversorMoedaGet()));
                } catch (Exception ex) {frame.setVisible(true);}
            }
        }   );
        return ConversorMoedas;
    }

    public static JButton startConversorTemperatura(JFrame frame){
        JButton ConversorMoedas = JChallegens.criarBotao(new ImageIcon("resource/imagem/button_temperatura.png"),new ImageIcon("resource/imagem/button_temperatura_hover.png"),240,400,200,50);
        ConversorMoedas.addActionListener( (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setVisible(false);
                    frame.setVisible(ScreenTemperatura.telaResultadoFinal(ScreenTemperatura.escolherTemperatura(),JChallegens.ConversorQuantidade("Temperatura","Digite a temperatura desejada: "),ScreenTemperatura.escolherTemperatura()));
                } catch (Exception ex) {frame.setVisible(true);}
            }
        }   );
        return ConversorMoedas;
    }

    public static JButton okButton(Dialog dialog){
        JButton okButton = JChallegens.criarBotao(new ImageIcon("resource/imagem/button_ok.png"), new ImageIcon("resource/imagem/button_ok_hover.png"),0,0,10,10);
        okButton.addActionListener( (ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        return okButton;
    }
}
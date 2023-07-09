package br.com.ChallegensAlura.JFrameElements;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
/**
 * Pacotes de auxilo para o {@link JFrame}, com propriedades para a agilização da criações de objetos.<br>
 * Os tipos de Objetos criaveis são:
 * <ul>
 * <li>{@link #criarImagem(String, int, int, int, int) criarImagem}</li>
 * <li>{@link #criarButtao(ImageIcon, Icon, int, int, int, int) criarButtao}</li>
 * <li>{@link #criarTexto(String, int, int, int, int) criarTexto}</li>
 * </ul>
 * @author Manoel
 * @version 1.0.0
 */
public class JChallegens extends JFrame {
    /**
     * Metodo que cria um texto padrão multilinha com a fonte Arial e tamanho 12px.
     * @return Um {@link JLabel} já configurado.
     */
    public static JLabel criarTexto(String text, int x, int y, int width, int height){
        JLabel jlabel = new JLabel("<html><body Style: font-family: Arial;>" + text + "</body></html>",SwingConstants.LEFT);
        jlabel.setFont(new Font("Arial", Font.PLAIN, 12));
        jlabel.setBounds(x, y, width, height + 12);
        return jlabel;
    }
    /**
     * Metodo que cria um texto padrão multilinha com a fonte e tamanho personalizado.
     * @return Um {@link JLabel} já configurado.
     */
    public static JTextArea criarTexto(String text, int x, int y, int width, int height, Font font){
        JTextArea jtextlabel = new JTextArea(text);
        jtextlabel.setFont(font);
        jtextlabel.setBounds(x, y, width, height);
        jtextlabel.setBackground(null);
        jtextlabel.setEditable(false);
        jtextlabel.setBorder(null);
        jtextlabel.setLineWrap(true);
        jtextlabel.setWrapStyleWord(true);
        jtextlabel.setFocusable(false);
        return jtextlabel;
    }
    /**
     * Metodo que cria um botão base para a classe {@link ButtonChallegens}.
     * @return Um {@link JButton} já configurado.
     */
    public static JButton criarBotao(ImageIcon icon,Icon iconRoll, int x, int y, int width, int height){
        JButton jbutton = new JButton(icon);
        jbutton.setBorderPainted(false);
        jbutton.setFocusPainted(false);
        jbutton.setContentAreaFilled(false);
        jbutton.setOpaque(false);
        jbutton.setFocusable(false);
        jbutton.setRolloverIcon(iconRoll);
        jbutton.setBounds(x,y,width,height);
        return jbutton;
    }
    /**
     * Metodo que cria uma imagem com tamanho personalizado.
     * @return Uma imagem pronta.
     */
    public static JLabel criarImagem(String img, int x, int y, int width, int height){
        JLabel imgLabel = new JLabel(new ImageIcon(img));
        imgLabel.setBounds(x,y,width,height);
        return imgLabel;
    }
    /**
     * Projeto base de uma Janela Dialog com valores pre definidos.
     * @param title
     * @param messages
     * @return Retorna uma Janela pre configurada.
     */
    public static void baseScreen(String title, Object message){
        
        int tipoMessage = JOptionPane.PLAIN_MESSAGE;
        int optionType  = JOptionPane.YES_NO_OPTION;

        ImageIcon iconAplication = new ImageIcon("resource/imagem/Icon.png");
        Color backgroundColor = new Color(243,243,243,255);
        
        UIManager.put("OptionPane.background", backgroundColor);
        UIManager.put("Label.font",  new Font("Arial", Font.BOLD, 14));

        JOptionPane paneScreen = new JOptionPane("<html><body>"+message+"</body></html>",tipoMessage,optionType,null,null);

        Dialog dialogScreen = paneScreen.createDialog(title);
        Object[] options = {ButtonChallegens.okButton(dialogScreen)};
        paneScreen.setOptions(options);

        dialogScreen.pack();
        dialogScreen.setIconImage(iconAplication.getImage());
        dialogScreen.setSize(300, 200);
        dialogScreen.setVisible(true);

    }
    /**
     * Cria uma Janela para pegar um input de um determinado valor atraves do {@link JOptionPane}.
     * @param Tipo
     * @param message
     * @return retorna um double com o input do usuario.
     */ 
    public static double ConversorQuantidade(String Tipo, Object message){
        String titulo = "Conversor de " + Tipo;
        try {
            return Double.valueOf(JOptionPane.showInputDialog(null,message,titulo,JOptionPane.PLAIN_MESSAGE));
        }
         catch (Exception e) {
            return ConversorQuantidade(Tipo, message);
        }
    }
    /**
     * Aplica um estilo de cores e fontes (vermelho e branco) para janelas.
     */
    public static void style(){
        Color backgroundColor   = new Color(243,243,243,255);
        Color complementarColor = new Color(220,220,220,255);

        Font bankPrinter = null;
        try {
            bankPrinter = Font.createFont(Font.PLAIN, new File("resource/fonts/F25_Bank_Printer.otf"));
            bankPrinter      = bankPrinter.deriveFont(12f);
        } catch (Exception e) {}

        // Define o design das janelas Joptions
        UIManager.put("OptionPane.background", backgroundColor);
        UIManager.put("ComboBox.background", backgroundColor);
        UIManager.put("ComboBox.selectionBackground", complementarColor);
        UIManager.put("Label.font", bankPrinter);
        UIManager.put("Button.background", new Color(201,89,89,255));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Arial",Font.PLAIN,12));
    }
}
package br.com.ChallegensAlura.Graficos;
import br.com.ChallegensAlura.JFrameElements.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ScreenChallegens extends JFrame {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ImageIcon iconAplication = new ImageIcon("resource/imagem/Icon.png");

    private int width  = 480;
    private int height = 500;
    
    private int centralizedX  = (int) screenSize.getWidth()  / 2 - width  /2;;
    private int centralizedY  = (int) screenSize.getHeight() / 2 - height /2;

    public ScreenChallegens(){
        try {
            createScreen();
            ScreenElements();
            setVisible(true);
        } catch (Exception e) {}
    }

    private void createScreen(){
        pack();
        setTitle("Mega Conversor - Alura");
        getContentPane().setBackground(new Color(243, 243, 243, 255));
        setResizable(false);
        setBounds(centralizedX, centralizedY, width, height);
        setLayout(null);
        setIconImage(iconAplication.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void ScreenElements() throws Exception{
        Font bankPrinter = Font.createFont(Font.PLAIN, new File("resource/fonts/F25_Bank_Printer.otf"));
        bankPrinter = bankPrinter.deriveFont(13f);
        
        String textoAplicativo = "O Mega Conversor é uma ferramenta vers\u00E1til e \u00FAtil que permite converter valores de uma unidade de medida para outra.\n\n"
        + "Ele oferece a conveni\u00EAncia de obter rapidamente valores convertidos em diferentes escalas de temperatura e moedas."
        +"\n\nFeito por João Manoel.";
        
        add(JChallegens.criarImagem("resource/imagem/Logo.png",0,0,width- 20,200));
        add(JChallegens.criarTexto(textoAplicativo, 20, 200, width-60, 200, bankPrinter));
        add(ButtonChallegens.startConversorMoedas(this));
        add(ButtonChallegens.startConversorTemperatura(this));
    }
}

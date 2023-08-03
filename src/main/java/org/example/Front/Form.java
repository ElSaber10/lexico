package org.example.Front;
import org.example.lexer.Lexer;
import org.example.lexer.Tokens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static org.example.lexer.Lexer.lex;

public class Form extends JFrame {
private final int WIDTH = 950;
private final int HEIGHT = 350;
public Form(){
    initComponents();
}

    public void initComponents(){
    Dimension dim = new Dimension(this.WIDTH, this.HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Ingrese una cadena");
    setSize(dim);
    setPreferredSize(dim);
    setLocationRelativeTo(null);
    //ContentPane
    JPanel panel = new JPanel();
    //TextArea
    JTextArea textSpace = new JTextArea(20, 40);
    JScrollPane scrollPane = new JScrollPane(textSpace);
    //TextArea response
    JTextArea responseSpace = new JTextArea(10, 30);
    responseSpace.setEditable(true);
    JScrollPane scrollPane1 = new JScrollPane(responseSpace);
    //Button
    JButton button = new JButton("Analizar");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String text = textSpace.getText();
            Lexer analizer = new Lexer();
            //String response = analizer.(text);
            List<Tokens> tokens = lex(text);
            //responseSpace.setText(response);
            for(Tokens t : tokens) {
                System.out.println(t);
            }
            //Analizar texto
        }
    });


    panel.add(scrollPane);
    panel.add(button);
    panel.add(scrollPane1);
    setContentPane(panel);
    pack();
    setVisible(true);
}
}


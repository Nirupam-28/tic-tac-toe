import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tit_Tac_Toe implements ActionListener{

    private JFrame frame=new JFrame("TIC-TAC-TOE");;
    private JPanel  panel=new JPanel();
    private JButton[] buttons=new JButton[9];
    private boolean X_turn=true;

    public Tit_Tac_Toe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
        for(int i=0;i<9;i++){
            buttons[i] =new JButton();
            buttons[i].setFont(new Font("Arial",Font.PLAIN,60));
            buttons[i].addActionListener(this);
            
            panel.add(buttons[i]);
        
        }

        frame.add(panel,BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        JButton button=(JButton) e.getSource();
        if(X_turn){
            button.setText("X");
        }
        else{
            button.setText("O");
        }
        button.setEnabled(false);
        X_turn = !X_turn;

        winner();
    }


    /**
     * 
     */
    public void winner(){
        
        for(int i=0;i<9;i +=3){
// rows
            if(buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[i].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;
            }
        }
// columns
        for(int i=0;i<3;i++){

            if(buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[i].getText()+"  "+ "Hurray!!! WIN");
                reset();
                return;
            }
        }

//  diagonals
            if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[0].getText()+"  "+"Hurray!!! WIN");
                reset();
                return;

            } 


            if(buttons[2].getText().equals(buttons[4].getText())  && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()){

                JOptionPane.showMessageDialog(frame, buttons[2].getText() + "  "+ "Hurray!!! WIN");
                reset();
                return;
            }

            // match tie

            boolean tie=true;
            for(int i=0;i<9;i++){

                if(buttons[i].isEnabled()){
                    tie=false;
                    break;
                }
            }

            if(tie){

                JOptionPane.showMessageDialog(frame, "Its a TIE  !!!");
                reset();
            }
    }


    public void reset(){

        for(int i=0;i<9;i++){

            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        X_turn=true;
    }


    public static void main(String[] args){
        new Tit_Tac_Toe();
    }
}
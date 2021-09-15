package com.company.work4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class NullLayout extends JFrame
{
    JButton but1 = new JButton("Milan");
    JButton but2 = new JButton("Madrid");
    JLabel result = new JLabel(MilanCounter + "X" + MadridCounter);
    JLabel scorer = new JLabel("The current scorer is");
    JLabel winner = new JLabel("The current winner is");
    JPanel[] pnl = new JPanel[5];

    Font fnt = new Font("Times new roman",Font.BOLD,20);
    public static int MadridCounter = 0;
    public static int MilanCounter = 0;
    public NullLayout()
    {
        setLayout(new GridLayout(5,1));
        for (int i = 0; i < 5; i++){
            pnl[i] = new JPanel();
            add(pnl[i]);
            pnl[i].setLayout(new FlowLayout());
        }
        pnl[0].add(result);
        pnl[1].add(scorer);
        pnl[2].add(winner);
        pnl[3].add(but1);
        pnl[4].add(but2);
        but1.setFont(fnt);
        but2.setFont(fnt);
        result.setFont(fnt);
        scorer.setFont(fnt);
        winner.setFont(fnt);
        but1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MilanCounter+=1;
                result.setText(MilanCounter + "X" + MadridCounter);
                scorer.setText("The current scorer is Milan");
                if(MilanCounter > MadridCounter){
                    winner.setText("The current winner is Milan");
                } else if (MilanCounter == MadridCounter){
                    winner.setText("There is no current winner");
                } else{
                    winner.setText("The current winner is Madrid");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        but2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MadridCounter+=1;
                result.setText(MilanCounter + "X" + MadridCounter);
                scorer.setText("The current scorer is Madrid");
                if(MilanCounter > MadridCounter){
                    winner.setText("The current winner is Milan");
                } else if (MilanCounter == MadridCounter){
                    winner.setText("There is no current winner");
                } else{
                    winner.setText("The current winner is Madrid");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        setSize(500,250);
    }
    public static void main(String[]args)
    {
        new NullLayout().setVisible(true);
    }
}
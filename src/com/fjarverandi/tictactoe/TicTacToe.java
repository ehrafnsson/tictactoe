package com.fjarverandi.tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: arnib
 * Date: 11/6/12
 * Time: 2:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToe extends JFrame {

    public static void main(String[] args)
    {
        new TicTacToe(new GameEngine());
    }

    public TicTacToe(iEngine ie)
    {

        this.setLayout(new GridLayout(3,3));

        JPanel[] panels = new JPanel[9];
        for(int i = 0; i < panels.length; i++)
        {
            panels[i] = new JPanel();
            panels[i].setSize(200,200);
            panels[i].setBorder(BorderFactory.createBevelBorder(0,Color.black,Color.black));
            panels[i].add(new JLabel(Integer.toString(i)));

            panels[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JPanel jp = (JPanel)e.getSource();
                    ((JLabel) jp.getComponent(0)).setText(e.toString());
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    //To change body of implemented methods use File | Settings | File Templates.
                }
            });

            this.add(panels[i]);
        }

        this.setTitle("TicTacToe!");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

package com.fjarverandi.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JFrame
{
    private iEngine ie;
    private TicTacToePanel[] panels;

    public GUI(iEngine ie)
    {
        this.ie = ie;

        final GridLayout layout = new GridLayout(3,3);
        this.setLayout(layout);

        panels = new TicTacToePanel[9];
        for(int i = 0; i < panels.length; i++)
        {
            panels[i] = new TicTacToePanel(this, ie, i);
            this.add(panels[i]);
        }

        this.setTitle("TicTacToe!");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void StateChanged()
    {

        switch(ie.CheckVictory())
        {
            case 0:
                this.setTitle("TicTacToe! - Player " + ie.PlayerTurn() + "'s turn" );
                return;
            case 1:
                JOptionPane.showMessageDialog(this,"Player 1 won!");
                break;
            case 2:
                JOptionPane.showMessageDialog(this,"Player 2 won!");
                break;
            case 3:
                JOptionPane.showMessageDialog(this,"This game ended with a draw!");
                break;
        }

        NewGame();

    }

    public void NewGame()
    {
        ie.NewGame();

        for(int i = 0; i < panels.length; i++)
        {
            panels[i].refresh();
        }
    }

}

package com.fjarverandi.tictactoe;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.*;
import javax.swing.text.StyleConstants;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	final String[] PlayerText = { "", "X", "O" };
    private JLabel label;
    private Point point;
    private iEngine ie;

    public TicTacToePanel(final GUI parent, final iEngine ie, final int i)
    {
        this.setSize(200, 200);
        this.setBorder(BorderFactory.createBevelBorder(0, Color.black, Color.black));
        this.setFont(new Font("Times New Roman", Font.BOLD, 72));
        this.point = new Point(i%3,i/3);
        this.ie = ie;

        label = new JLabel();
        this.add(label);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel jp = (JPanel) e.getSource();

                if(ie.Set(point))
                {
                    refresh();
                    parent.StateChanged();
                }


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




    }
    public void refresh()
    {
        label.setText(PlayerText[ie.Get(point)]);
    }




}

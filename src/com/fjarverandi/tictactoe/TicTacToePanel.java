package com.fjarverandi.tictactoe;

import javax.swing.*;
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
        this.point = new Point(i%3,i/3);
        this.ie = ie;

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridbag.setConstraints(this, constraints);
        this.setLayout(gridbag);

        label = new JLabel();
        label.setFont(new Font("Times New Roman", Font.BOLD, 90));
        this.add(label);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(ie.Set(point))
                {
                    refresh();
                    parent.StateChanged();
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


    }
    public void refresh()
    {
        label.setText(PlayerText[ie.Get(point)]);
    }

}

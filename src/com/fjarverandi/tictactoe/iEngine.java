package com.fjarverandi.tictactoe;

import java.awt.Point;

/**
 * Created with IntelliJ IDEA.
 * User: arnib
 * Date: 11/20/12
 * Time: 6:25 PM
 * To change this template use File | Settings | File Templates.
 */

public interface iEngine {
    public boolean Set (Point point);
    public byte Get (Point point);
    public byte CheckVictory();
    public void NewGame();
    public byte PlayerTurn();

}

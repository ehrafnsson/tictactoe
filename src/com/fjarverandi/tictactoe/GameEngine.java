package com.fjarverandi.tictactoe;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: arnib
 * Date: 11/20/12
 * Time: 6:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameEngine implements iEngine {
    public boolean Set (Point point)
    {
        return true;
    }
    public byte Get (Point point)
    {
        return 0;
    }
    public byte CheckVictory()
    {
        return 0;
    }

    public void NewGame() {}

    public byte PlayerTurn()
    {
        return 0;
    }
}

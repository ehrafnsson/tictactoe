package com.fjarverandi.tictactoe;

import java.awt.*;

public class GameEngine implements iEngine {
    public boolean Set (Point point)
    {
        return true;
    }
    public byte Get (Point point)
    {
        return 1;
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

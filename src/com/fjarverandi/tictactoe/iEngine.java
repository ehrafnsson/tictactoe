package com.fjarverandi.tictactoe;

import java.awt.Point;

public interface iEngine {
    public boolean Set (Point point);
    public byte Get (Point point);
    public byte CheckVictory();
    public void NewGame();
    public byte PlayerTurn();

}

package com.fjarverandi.tictactoe;

import java.awt.Point;

import org.junit.Test;
import static org.junit.Assert.*;

public class TddGameEngineTest {
    private iEngine GetEngine(){
        //return(new TddGameEngine());
        return(new GameEngine());
    }

    @Test
    public void testSetGet() throws Exception {
// init
        iEngine _engine = GetEngine();

// inside bounds
    // Pass
        // test set/get point 0,0
        Point _point = new Point(0,0);
        assertTrue(_engine.Set(_point));
        assertEquals(_engine.Get(_point), 1);

        // test set/get point 1,1
        _point = new Point(1,1);
        assertTrue(_engine.Set(_point));
        assertEquals(_engine.Get(_point), 2);

    // Fail
        // fail because the point was set previously
        assertFalse(_engine.Set(new Point(0,0)));

        // fail because the point was set previously
        assertFalse(_engine.Set(new Point(1,1)));

// outside bounds, Fail
        assertFalse(_engine.Set(new Point(-1,1)));
        assertFalse(_engine.Set(new Point(1,-1)));
        assertFalse(_engine.Set(new Point(-1,-1)));

        assertFalse(_engine.Set(new Point(3,1)));
        assertFalse(_engine.Set(new Point(1,3)));
        assertFalse(_engine.Set(new Point(3,3)));
    }

    private static void testCheckVictory_Helper(iEngine AEngine, Point APoint, byte AExpected){
        // set point
        AEngine.Set(APoint);
        // verify that the game is still in play
        assertEquals(AEngine.CheckVictory(), AExpected);
    }

    @Test
    public void testCheckVictory() throws Exception {
// test victory
    // init
        iEngine _engine = GetEngine();
        // verify that the game is still in play
        assertEquals(_engine.CheckVictory(), 0);

    // vertical, Player 1
        testCheckVictory_Helper(_engine, new Point(0,0), (byte)0);
        testCheckVictory_Helper(_engine, new Point(1,0), (byte) 0);

        testCheckVictory_Helper(_engine, new Point(0,1), (byte)0);
        testCheckVictory_Helper(_engine, new Point(1,1), (byte)0);

        testCheckVictory_Helper(_engine, new Point(0,2), (byte)1);

    // horizontal, Player 2
        //reset
        _engine = GetEngine();

        testCheckVictory_Helper(_engine, new Point(0,0), (byte)0);
        testCheckVictory_Helper(_engine, new Point(0,1), (byte)0);

        testCheckVictory_Helper(_engine, new Point(1,0), (byte)0);
        testCheckVictory_Helper(_engine, new Point(1,1), (byte)0);

        testCheckVictory_Helper(_engine, new Point(2,2), (byte)0);
        testCheckVictory_Helper(_engine, new Point(2,1), (byte)2);

    // diagonal
        //reset
        _engine = GetEngine();

        testCheckVictory_Helper(_engine, new Point(0,0), (byte)0);
        testCheckVictory_Helper(_engine, new Point(1,0), (byte)0);

        testCheckVictory_Helper(_engine, new Point(1,1), (byte)0);
        testCheckVictory_Helper(_engine, new Point(2,0), (byte)0);

        testCheckVictory_Helper(_engine, new Point(2,2), (byte)1);

// test draw
        //reset
        _engine = GetEngine();

        testCheckVictory_Helper(_engine, new Point(0,0), (byte)0);
        testCheckVictory_Helper(_engine, new Point(1,0), (byte)0);

        testCheckVictory_Helper(_engine, new Point(2,0), (byte)0);
        testCheckVictory_Helper(_engine, new Point(0,1), (byte)0);

        testCheckVictory_Helper(_engine, new Point(2,1), (byte)0);
        testCheckVictory_Helper(_engine, new Point(1,1), (byte)0);

        testCheckVictory_Helper(_engine, new Point(0,2), (byte)0);
        testCheckVictory_Helper(_engine, new Point(2,2), (byte)0);

        testCheckVictory_Helper(_engine, new Point(1,2), (byte)3);
    }

    private static boolean testNewGame_IsEmpty(iEngine AEngine){
        // loop engine
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                // test for empty
                if (AEngine.Get(new Point(x, y))!= 0){
                    return(false);
                }
            }
        }
        // Engine is empty
        return(true);
    }

    @Test
    public void testNewGame() throws Exception {
//init
        iEngine _engine = GetEngine();

//test
        // new engine should be empty
        assertTrue(testNewGame_IsEmpty(_engine));

        // set point
        _engine.Set(new Point(0,0));
        // table should not be empty
        assertFalse(testNewGame_IsEmpty(_engine));
        // NewGame, and the table should be empty again
        _engine.NewGame();
        assertTrue(testNewGame_IsEmpty(_engine));
    }

    @Test
    public void testPlayerTurn() throws Exception {
//init
        iEngine _engine = GetEngine();

//test
        // Player 1 starts
        assertEquals(_engine.PlayerTurn(), 1);
        _engine.Set(new Point(0,0));
        // Player 2 is second
        assertEquals(_engine.PlayerTurn(), 2);
        _engine.Set(new Point(0,1));

        // Player 1 is third
        assertEquals(_engine.PlayerTurn(), 1);
        assertFalse(_engine.Set(new Point(0,0)));
        // it should still be Player 1 turn, failed move
        assertEquals(_engine.PlayerTurn(), 1);
        _engine.Set(new Point(2,2));

        // Player 2 is fourth
        assertEquals(_engine.PlayerTurn(), 2);
    }
}

package com.fjarverandi.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GUITest extends GUI{
    protected Robot FRobot;
    protected boolean FBreakOnNewGame;
    protected boolean FNewGameExecuted;
    protected byte FGameResult;

    @Before
    public void setUp() throws Exception {
        // create Robot
        FRobot = new Robot();
        FRobot.setAutoDelay(100);
    }

    public GUITest(){
        super(new GameEngine());

        DisplayGameResult = false;
    }

    public void ClickButton(int AButtonIndex) throws Exception{
        // check for popups
        if (!isActive()){
            throw new Exception("Not active window");
        }

        // move mouse over panel
        Point _ScreenPosition = panels[AButtonIndex].getLocationOnScreen();
        FRobot.mouseMove(_ScreenPosition.x, _ScreenPosition.y);

        // click panel
        FRobot.mousePress(InputEvent.BUTTON1_MASK);
        FRobot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void testPanels(int[] AButtonIndexes, byte AGameResult) throws Exception{
        // set expected game result
        FGameResult = AGameResult;
        FBreakOnNewGame = true;
        // click each button, except for last
        for(int i = 0; i < AButtonIndexes.length-1; i++){
            ClickButton(AButtonIndexes[i]);
        }
        // allow NewGame, last click should trigger the event
        FNewGameExecuted = false;
        FBreakOnNewGame = false;
        ClickButton(AButtonIndexes[AButtonIndexes.length - 1]);
        // check if NewGame was called
        assertTrue(FNewGameExecuted);
    }

    public void NewGame(){
        // check if the game is allowed to end
        assertFalse(FBreakOnNewGame);
        // check expected victory condition
        assertEquals(FGameResult, ie.CheckVictory());
        // call base function
        super.NewGame();
        // set called
        FNewGameExecuted = true;
    }

    @Test
    public void testPanels() throws Exception {
        // allow GUI to setup
        FRobot.delay(500);

        // test different scenarios
        testPanels(new int[] {0,1,2,3,5,4,6,8,7}, (byte)3);
        testPanels(new int[] {0,1,3,4,6}, (byte)1);
        testPanels(new int[] {0,1,3,4,8,7}, (byte)2);
    }
}
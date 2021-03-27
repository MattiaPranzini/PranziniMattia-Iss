package it.unibo.wenv;

import it.unibo.consolegui.ConsoleGui;
import it.unibo.supports.IssCommSupport;
import it.unibo.supports.RobotApplicationStarter;
import mapRoomKotlin.mapUtil;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class TestClientUsingPostJava {
    private Object appl;
    private RobotInputController controller;
    private Pattern pattern = Pattern.compile("abc", Pattern.CASE_INSENSITIVE);
    //@Test
    public void systemSetUp() {
        String moves ="|r, 1, 1, 1, 1, \n|1, 0, 0, 0, 1, \n|1, 0, 0, 0, 1, \n|1, 1, 1, 1, 1, \n";
                assertTrue(moves.matches("\\|r, (1, )+\n(\\|1, (0, )+1, \n)*(\\|(1, )+)\n$"));
    }



    @Test
    public void testTotale() {
        appl = RobotApplicationStarter.createInstance(ResumableBoundaryWalker.class);
        RobotInputController c = ((ResumableBoundaryWalker)appl).getController();
        ConsoleGui cg = new ConsoleGui(c);
        c.resumeButton();
        String mappa = "";
        mappa += mapUtil.getMapRep();
        System.out.println("MAPPA: " + mappa);
        assertTrue(mappa.matches("\\|r, (1, )+\n(\\|1, (0, )+1, \n)*(\\|(1, )+)\n$"));
        //assertTrue(pattern.matches("|r,(1,)+\n(|1,(0,)+1,\n)*|(1,)+\n",mappa));
    }
/*
    @Test
    public void testMoveForwardNoHit() {
     }

    @Test
    public void testMoveForwardHit() {
      }
*/
}

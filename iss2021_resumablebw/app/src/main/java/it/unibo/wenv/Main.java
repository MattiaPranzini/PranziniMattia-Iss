package it.unibo.wenv;

import it.unibo.consolegui.ConsoleGui;
import it.unibo.supports.RobotApplicationStarter;
import mapRoomKotlin.mapUtil;

public class Main {

    public static void main(String args[]){
        Object appl;
        RobotInputController controller;
        appl = RobotApplicationStarter.createInstance(ResumableBoundaryWalker.class);
        RobotInputController c = ((ResumableBoundaryWalker)appl).getController();
        ConsoleGui cg = new ConsoleGui(c);
        String mappa = "";
        mappa += mapUtil.getMapRep();
        System.out.println("MAPPA: " + mappa);

    }
}

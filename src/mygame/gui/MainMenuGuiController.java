/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gui;

import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import mygame.Game;

/**
 *
 * @author wasd
 */
public class MainMenuGuiController implements ScreenController{
    
    private Game app;
    
    private NiftyJmeDisplay niftyDisplay;
    private Nifty nifty;

    public MainMenuGuiController(Game app) {
        this.app=app;
    }
    
    public void show(){
        if(nifty==null){
            niftyDisplay = new NiftyJmeDisplay(app.getAssetManager(),
                                                              app.getInputManager(),
                                                              app.getAudioRenderer(),
                                                              app.getGuiViewPort());

            nifty = niftyDisplay.getNifty();
            nifty.fromXml("Interface/mainmenu.xml", "start", this);
        }
        app.getGuiViewPort().addProcessor(niftyDisplay);
    }
    
    public void hide(){
        app.getGuiViewPort().removeProcessor(niftyDisplay);
    }

    public void bind(Nifty nifty, Screen screen) {
        //TODO save the variables?
    }

    public void onStartScreen() {
        //TODO check if there is a saved game. If not, disable continue-button
    }

    public void onEndScreen() {}
    
    
    //==Buttons==
    
    public void continueGame(){
        System.out.println("continue");
    }
    
    public void newGame(){
        System.out.println("newgame");
        app.startGame();
    }
    
    public void loadGame(){
        System.out.println("loadgame");
    }
    
    public void options(){
        System.out.println("options");
    }
    
    public void exitGame(){
        System.out.println("exit");
    }
    
}

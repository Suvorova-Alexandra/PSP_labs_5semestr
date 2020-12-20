package mySalon;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainClass {
    public static void main(String[] args) {
        TatooSalon ts1 = new TatooSalon("Регистрация клиента в тату-салоне");
        ts1.setResizable(true);
        ts1.setVisible(true);
        ts1.setLocationRelativeTo(null);
        ts1.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(e.getID() + "closing" + e.getNewState());
                int quit = JOptionPane.showConfirmDialog(ts1, "Are you sure to quit?");
                if(quit == JOptionPane.YES_OPTION){
                    ts1.dispose();
                }
                else if (quit == JOptionPane.NO_OPTION){
                    ts1.setVisible(false);
                }
            }
        });
    }
}

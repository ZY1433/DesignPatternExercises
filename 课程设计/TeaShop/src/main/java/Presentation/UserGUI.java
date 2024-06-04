package Presentation;

import application.TeaShopMediator;
import application.cook.FrontFrame;
import application.order.MainFrame;

import javax.swing.*;

public class UserGUI {

    private static final TeaShopMediator mediator = new TeaShopMediator();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            MainFrame orderGui = new MainFrame(1);
            FrontFrame cookGui = new FrontFrame();
            mediator.registerCookGui(cookGui);
            mediator.registerTeaOrderGUI(orderGui);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
package application;

import application.cook.FrontFrame;
import application.order.MainFrame;

public class TeaShopMediator {

    private FrontFrame cookGui;
    private MainFrame orderGui;

    public void registerCookGui(FrontFrame cook) {
        cookGui = cook;
        cook.setVisible(true);
    }

    public void registerTeaOrderGUI(MainFrame order) {
        orderGui = order;
        order.frame.setVisible(true);
    }


}
package application.order;

import java.util.List;

public class OrderReceiver {

    public void submitOrder(String substring, int eId, String substring1, String text, String text1, List<Drink> detaillist, String sis) {
        new CheckFrame(substring, eId, substring1, text, text1, detaillist, sis);
    }
}

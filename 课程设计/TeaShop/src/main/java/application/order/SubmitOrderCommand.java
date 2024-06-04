package application.order;

import java.util.List;

public class SubmitOrderCommand implements OrderCommand {
    private final OrderReceiver receiver; // 接收者类

    public SubmitOrderCommand(OrderReceiver receiver) {
        this.receiver = receiver;
    }


    @Override
    public void execute(String substring, int eId, String substring1, String text, String text1, List<Drink> detaillist, String sis) {
        receiver.submitOrder(substring, eId, substring1, text, text1, detaillist, sis);
    }
}

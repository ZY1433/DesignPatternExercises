package application.order;

import java.util.List;

public interface OrderCommand {
//    void execute();

    void execute(String substring, int eId, String substring1, String text, String text1, List<Drink> detaillist, String sis);
}

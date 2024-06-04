package application.teaBuilder;

public class BubbleMilkTea extends Tea {
    private final String size;
    private final String temperature;
    private final String sweetness;
    private final double price;
    private final String base;//茶底

    public BubbleMilkTea(String size, String temperature, String sweetness, double price, String base) {
        this.size = size;
        this.temperature = temperature;
        this.sweetness = sweetness;
        this.price = price;
        this.base = base;
    }
}

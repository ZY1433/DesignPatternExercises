package application.teaBuilder;

public class LemonFruitTea extends Tea {
    private final String size;
    private final String temperature;
    private final String sweetness;
    private final double price;

    public LemonFruitTea(String size, String temperature, String sweetness, double price) {
        this.size = size;
        this.temperature = temperature;
        this.sweetness = sweetness;
        this.price = price;
    }
}

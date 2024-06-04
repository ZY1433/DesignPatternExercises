package application.teaBuilder.builder.impl;

import application.teaBuilder.PassionFruitTea;
import application.teaBuilder.Tea;
import application.teaBuilder.builder.FruitTeaBuilder;

public class PassionFruitTeaBuilder implements FruitTeaBuilder {
    private String size;
    private String temperature;
    private String sweetness;
    private double baseprice;

    public PassionFruitTeaBuilder() {
        this.baseprice = 10.0;
    }

    @Override
    public FruitTeaBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    @Override
    public FruitTeaBuilder setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    @Override
    public FruitTeaBuilder setSweetness(String sweetness) {
        this.sweetness = sweetness;
        return this;
    }

    @Override
    public Tea build() {
        if (this.size.equals("大杯")) {
            this.baseprice = this.baseprice + 2.0; // 每种配料增加2元
        }
        return new PassionFruitTea(size, temperature, sweetness, baseprice);
    }
}

package application.teaBuilder.builder.impl;

import application.teaBuilder.RedBeansMilkTea;
import application.teaBuilder.Tea;
import application.teaBuilder.builder.MilkTeaBuilder;

public class RedBeansMilkTeaBuilder implements MilkTeaBuilder {
    private String size;
    private String temperature;
    private String sweetness;
    private double baseprice;
    private String base;


    public RedBeansMilkTeaBuilder() {
        this.baseprice = 12.0;
    }

    @Override
    public MilkTeaBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    @Override
    public MilkTeaBuilder setTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    @Override
    public MilkTeaBuilder setSweetness(String sweetness) {
        this.sweetness = sweetness;
        return this;
    }

    @Override
    public MilkTeaBuilder setBase(String base) {
        this.base = base;
        return this;
    }

    @Override
    public Tea build() {
        if (this.size.equals("大杯")) {
            this.baseprice = this.baseprice + 2.0;
        } else if (this.size.equals("中杯")) {
            this.baseprice = this.baseprice + 1.0;
        }
        if (this.base.equals("抹茶")) {
            this.baseprice = this.baseprice + 2.0;
        }
        return new RedBeansMilkTea(size, temperature, sweetness, baseprice, base);
    }
}

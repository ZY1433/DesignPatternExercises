package application.teaBuilder.builder;

import application.teaBuilder.Tea;

public interface MilkTeaBuilder {
    MilkTeaBuilder setSize(String size);

    MilkTeaBuilder setTemperature(String temperature);

    MilkTeaBuilder setSweetness(String sweetness);

    MilkTeaBuilder setBase(String base);

    Tea build();
}

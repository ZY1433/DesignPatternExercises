package application.teaBuilder.builder;

import application.teaBuilder.Tea;

public interface FruitTeaBuilder {
    FruitTeaBuilder setSize(String size);

    FruitTeaBuilder setTemperature(String temperature);

    FruitTeaBuilder setSweetness(String sweetness);

    Tea build();
}

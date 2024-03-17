package org.example;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class EmailValidatorConsumer implements BiFunction<String,String, String> {


    @Override
    public String apply(String s, String s2) {
        return null;
    }

    @Override
    public <V> BiFunction<String, String, V> andThen(Function<? super String, ? extends V> after) {
        return BiFunction.super.andThen(after);
    }
}

package com.sir.richard.boss.lambda;

@FunctionalInterface
public interface ObjectAnalyzeFunction<T, U> {
    T toAnalyze(T t, U u);
}

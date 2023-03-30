package com.skillfactory.modules.java.core.practicum.x20.units;

import com.skillfactory.modules.java.core.practicum.x20.artifacts.Goods;

public class Merchant implements Seller {
    //Метод для продажи
    @Override
    public String sell(Goods goods) {
        String result = "";
        if (goods == Goods.POTION) {
            result = "potion";
        }
        return result;
    }
    //Энам для товаров

}

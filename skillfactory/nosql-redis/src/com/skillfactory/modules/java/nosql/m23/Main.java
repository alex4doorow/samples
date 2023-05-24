package com.skillfactory.modules.java.nosql.m23;

import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
    }
}
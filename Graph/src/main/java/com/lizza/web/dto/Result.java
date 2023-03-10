package com.lizza.web.dto;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class Result {



    @Test
    public void test1() throws Exception {
        AtomicBoolean flag = new AtomicBoolean();
        System.out.println(flag.get());
    }
}

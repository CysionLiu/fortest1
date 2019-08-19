package com.cysion.forTest.logic;

import com.cysion.forTest.tools.KitsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class JDemo {
    public void test(){
        KitsKt.f(1, new Function1<String, Unit>() {
            @Override
            public Unit invoke(String s) {
                return null;
            }
        });
    }
}

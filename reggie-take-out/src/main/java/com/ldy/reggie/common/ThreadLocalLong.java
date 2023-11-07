package com.ldy.reggie.common;

import org.springframework.stereotype.Component;


public class ThreadLocalLong extends ThreadLocal{
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    public static Long getLong(){
        return threadLocal.get();
    }
    public static void setLong(Long l){
        threadLocal.set(l);
    }
    public static void removeLong(){
        threadLocal.remove();
    }
}

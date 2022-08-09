package com.dog.reference;

import net.minidev.json.JSONUtil;

/**
 * @author dog
 * @description
 */
public class ReferenceDemo1 {
    public static void main(String[] args) {
        MyProject m = new MyProject();
        System.out.println("before gc");
        m = null;
        System.gc();
        System.out.println("after gc");
        System.gc();

    }
}

class MyProject
{
    @Override
    protected void finalize(){
        System.out.println("finalize");
    }
}

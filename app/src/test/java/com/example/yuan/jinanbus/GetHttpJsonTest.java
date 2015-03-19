package com.example.yuan.jinanbus;

import org.junit.Test;

import static com.example.yuan.jinanbus.GetHttpJson.getURLContentString;
import static org.junit.Assert.*;

public class GetHttpJsonTest {

    @Test
    public void testGetURLContentString() throws Exception {
        String sUrl = "http://60.216.101.229/server-ue2/rest/buslines/simple/370100/22/0/20";
        String sContent = getURLContentString(sUrl, "UTF-8");
        System.out.print(sContent);
        System.out.println();
    }
}
package com.example.yuan.jinanbus;

import org.junit.Test;

import static com.example.yuan.jinanbus.MakeUrlString.makeBusLineBriefURL;
import static org.junit.Assert.*;

public class MakeUrlStringTest {
    @Test
    public void testMakeBusLineBriefURL() throws Exception {
        String url = makeBusLineBriefURL("22");
        assertEquals(url, "http://60.216.101.229/server-ue2/rest/buslines/simple/370100/22/0/20");

        String url1 = makeBusLineBriefURL("222");
        assertEquals(url1, "http://60.216.101.229/server-ue2/rest/buslines/simple/370100/222/0/20");
    }
}
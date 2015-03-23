package com.example.yuan.jinanbus;

/**
 * 拼接URL的辅助函数
 * Created by Yuan on 2015/3/19.
 */
class MakeUrlString {
    public static String makeBusLineBriefURL(String sLineBrief) {
        String sUrlFormat = "http://60.216.101.229/server-ue2/rest/buslines/simple/370100/%1s/0/20";
        return String.format(sUrlFormat, sLineBrief);
    }

    public static String makeBusLineDetailURL(String iID) {
        String s = "http://60.216.101.229/server-ue2/rest/buslines/370100/%1s";
        return String.format(s, iID);
    }

    public static String makeBusDetailURL(String iID) {
        String s = "http://60.216.101.229/server-ue2/rest/buses/busline/370100/%1s";
        return String.format(s, iID);
    }
}

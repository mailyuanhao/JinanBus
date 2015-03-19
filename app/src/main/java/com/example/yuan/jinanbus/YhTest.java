package com.example.yuan.jinanbus;

import android.util.Log;

import java.util.ArrayList;

/**
 * 编写一些用于调试的函数
 * Created by Yuan on 2015/3/16.
 */
class YhTest {
    public static String sBusLine = "{\n" +
            "    \"status\": {\n" +
            "        \"code\": 0\n" +
            "    },\n" +
            "    \"result\": {\n" +
            "        \"id\": \"163\",\n" +
            "        \"area\": 370100,\n" +
            "        \"localLineId\": \"33693034\",\n" +
            "        \"endStationName\": \"解放桥东\",\n" +
            "        \"lineName\": \"87\",\n" +
            "        \"linePoints\": \"117.15756322738_36.675344982506,117.15715601392_36.678118849437,117.15651474628_36.681182660248,117.15617386324_36.683448605101,117.15394697214_36.689357148999,117.15013439402_36.687613108977,117.14529622729_36.685384541958,117.13738281498_36.682703854554,117.13442215974_36.685568860265,117.13166550734_36.684224622809,117.12424368043_36.682888936744,117.12243889117_36.682986191918,117.11835942121_36.685850999108,117.11380524653_36.684933758965,117.10789563192_36.683715525802,117.1027033276_36.682653287504,117.0964873746_36.681293307702,117.09296754502_36.680562205529,117.08902038574_36.679201692758,117.08303680291_36.676188638333,117.07662706342_36.672157969255,117.07424379143_36.672236261077,117.06804887869_36.672167188258,117.06158387514_36.672133498111,117.05528975487_36.672377454227,117.0509284605_36.672373539354\",\n" +
            "        \"startStationName\": \"公交驾校\",\n" +
            "        \"state\": \"1\",\n" +
            "        \"stationList\": \"62148,62149,62150,62151,62152,62153,62154,62155,62156,62157,62158,62159,62160,62161,62162,62163,62164,62165,62166,62167,62168,62169,62170,62171,62172,62173\",\n" +
            "        \"stations\": [\n" +
            "            {\n" +
            "                \"id\": \"62148\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.675344982506,\n" +
            "                \"lng\": 117.15756322738,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"公交驾校\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62149\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.678118849437,\n" +
            "                \"lng\": 117.15715601392,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"刘智远村\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62150\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.681182660248,\n" +
            "                \"lng\": 117.15651474628,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"凤凰路舜风路\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62151\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.683448605101,\n" +
            "                \"lng\": 117.15617386324,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"刘智远村北\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62152\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.689357148999,\n" +
            "                \"lng\": 117.15394697214,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"新泺大街东口\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62153\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.687613108977,\n" +
            "                \"lng\": 117.15013439402,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"新泺大街开拓路\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62154\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.685384541958,\n" +
            "                \"lng\": 117.14529622729,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"颖秀路\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62155\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.682703854554,\n" +
            "                \"lng\": 117.13738281498,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"齐鲁软件园北\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62156\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.685568860265,\n" +
            "                \"lng\": 117.13442215974,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"舜华路\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62157\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.684224622809,\n" +
            "                \"lng\": 117.13166550734,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"崇华路\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62158\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.682888936744,\n" +
            "                \"lng\": 117.12424368043,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"天辰路西口\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62159\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.682986191918,\n" +
            "                \"lng\": 117.12243889117,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"电子机械工程学校\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62160\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.685850999108,\n" +
            "                \"lng\": 117.11835942121,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"正丰路南口\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62161\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.684933758965,\n" +
            "                \"lng\": 117.11380524653,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"丁家庄东\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62162\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.683715525802,\n" +
            "                \"lng\": 117.10789563192,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"丁家庄西\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62163\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.682653287504,\n" +
            "                \"lng\": 117.1027033276,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"化纤厂路\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62164\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.681293307702,\n" +
            "                \"lng\": 117.0964873746,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"济钢二分厂\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62165\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.680562205529,\n" +
            "                \"lng\": 117.09296754502,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"华信路\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62166\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.679201692758,\n" +
            "                \"lng\": 117.08902038574,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"七里河\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62167\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.676188638333,\n" +
            "                \"lng\": 117.08303680291,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"工业南路西口\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62168\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.672157969255,\n" +
            "                \"lng\": 117.07662706342,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"甸柳庄\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62169\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.672236261077,\n" +
            "                \"lng\": 117.07424379143,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"公交总公司\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62170\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.672167188258,\n" +
            "                \"lng\": 117.06804887869,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"东郊饭店\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62171\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.672133498111,\n" +
            "                \"lng\": 117.06158387514,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"山大路\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62172\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.672377454227,\n" +
            "                \"lng\": 117.05528975487,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"中心医院\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"62173\",\n" +
            "                \"area\": 370100,\n" +
            "                \"lat\": 36.672373539354,\n" +
            "                \"lng\": 117.0509284605,\n" +
            "                \"state\": \"1\",\n" +
            "                \"stationName\": \"解放桥东\",\n" +
            "                \"updateTime\": \"Sep 3, 2014 7:28:00 AM\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"ticketPrice\": \"87:票价一元  K87:票价两元\",\n" +
            "        \"operationTime\": \"公交驾校  : 6:00－20:30 解放桥东 : 6:00－21:05\",\n" +
            "        \"owner\": \"330600\",\n" +
            "        \"updateTime\": \"Sep 3, 2014 7:28:00 AM\",\n" +
            "        \"descrip\": \"\"\n" +
            "    }\n" +
            "}";

    public static String sBuses = "{\n" +
            "    \"status\": {\n" +
            "        \"code\": 0\n" +
            "    },\n" +
            "    \"result\": [\n" +
            "        {\n" +
            "            \"busId\": \"4942\",\n" +
            "            \"lng\": 117.066201,\n" +
            "            \"lat\": 36.655091,\n" +
            "            \"velocity\": 0,\n" +
            "            \"stationSeqNum\": 18,\n" +
            "            \"buslineId\": \"627\",\n" +
            "            \"actTime\": \"Mar 12, 2015 6:57:54 AM\",\n" +
            "            \"cardId\": \"鲁A-18516\",\n" +
            "            \"orgName\": \"704车队_700.七公司_济南公共交通总公司\",\n" +
            "            \"isArriveDest\": false,\n" +
            "            \"dualSerialNum\": 43\n" +
            "        },\n" +
            "        {\n" +
            "            \"busId\": \"4934\",\n" +
            "            \"lng\": 117.134813,\n" +
            "            \"lat\": 36.660368,\n" +
            "            \"velocity\": 1.66,\n" +
            "            \"stationSeqNum\": 8,\n" +
            "            \"buslineId\": \"627\",\n" +
            "            \"actTime\": \"Mar 12, 2015 6:57:56 AM\",\n" +
            "            \"cardId\": \"鲁A-18308\",\n" +
            "            \"orgName\": \"704车队_700.七公司_济南公共交通总公司\",\n" +
            "            \"isArriveDest\": false,\n" +
            "            \"dualSerialNum\": 33\n" +
            "        },\n" +
            "        {\n" +
            "            \"busId\": \"4940\",\n" +
            "            \"lng\": 117.12148,\n" +
            "            \"lat\": 36.679813,\n" +
            "            \"velocity\": 0,\n" +
            "            \"stationSeqNum\": 1,\n" +
            "            \"buslineId\": \"627\",\n" +
            "            \"actTime\": \"Mar 12, 2015 6:57:45 AM\",\n" +
            "            \"cardId\": \"鲁A-18355\",\n" +
            "            \"orgName\": \"704车队_700.七公司_济南公共交通总公司\",\n" +
            "            \"isArriveDest\": false,\n" +
            "            \"dualSerialNum\": 26\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    private static String sTAG = "YH_TEST";

    public static void testBusJson2BusObject() {
        ArrayList<Bus> arrayBuses = Bus.parse(sBuses);
        for (Bus b : arrayBuses) {
            Log.d(sTAG, b.getBusId() + b.getActTime());
        }
    }

    public static BusLine testBusLineParse() {
        BusLine bl = BusLine.parse(sBusLine);
        Log.d(sTAG, bl.getStartStationName() + bl.getEndStationName() + bl.getStations().size());
        for (BusLine.Station bs : bl.getStations()) {
            Log.d(sTAG, bs.getStationName());
        }
        return bl;
    }

    public static ArrayList<BusLineBrief> testBusLineBriefParse() {
        ArrayList<BusLineBrief> abb = BusLineBrief.parse(BusLineBrief.sJsonExample);
        for (BusLineBrief blb : abb) {
            Log.d(sTAG, "blb + " + blb);
        }
        return abb;
    }
}

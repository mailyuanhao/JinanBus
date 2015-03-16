package com.example.yuan.jinanbus;

import android.util.Log;

import java.util.ArrayList;

/**编写一些用于调试的函数
 * Created by Yuan on 2015/3/16.
 */
class YhTest {
    private static String sBuses = "{\n" +
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
        BusJson2BusObject busTest = new BusJson2BusObject(sBuses);
        ArrayList<Bus> arrayBuses = busTest.parse();
        for (Bus bus : arrayBuses) {
            Log.d(sTAG, bus.getBusId());
        }
    }
}

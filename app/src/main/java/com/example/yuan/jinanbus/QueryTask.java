package com.example.yuan.jinanbus;

import android.os.AsyncTask;

import static com.example.yuan.jinanbus.GetHttpJson.getURLContentString;
import static com.example.yuan.jinanbus.MakeUrlString.makeBusLineBriefURL;

/**用于从网络异步下载数据的工作类
 * Created by Yuan on 2015/3/21.
 */
public class QueryTask extends AsyncTask<String, Integer, String> {
    @Override
    protected String doInBackground(String... params) {
        String sUrl = params[0];
        String s = getURLContentString(sUrl, "UTF-8");
        return s;
    }
}

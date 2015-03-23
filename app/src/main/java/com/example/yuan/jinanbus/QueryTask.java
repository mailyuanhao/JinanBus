package com.example.yuan.jinanbus;

import android.os.AsyncTask;

import static com.example.yuan.jinanbus.GetHttpJson.getURLContentString;

/**用于从网络异步下载数据的工作类
 * Created by Yuan on 2015/3/21.
 */
class QueryTask extends AsyncTask<String, Integer, String> {
    @Override
    protected String doInBackground(String... params) {
        String sUrl = params[0];
        return getURLContentString(sUrl);
    }
}

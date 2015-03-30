package com.example.yuan.jinanbus;

import android.content.Context;

import org.apache.http.auth.NTUserPrincipal;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by Yuan on 2015/3/30.
 */
public class busBriefSerializer {
    private Context mContext;
    private String mFileName;

    public busBriefSerializer(Context c, String f) {
        mContext = c;
        mFileName = f;
    }

    public void appendBusLineBrief(BusLineBrief b)
        throws JSONException, IOException {

    }

    public void saveBusBriefs(ArrayList<BusLineBrief> busLineBriefs)
            throws JSONException, IOException {
        JSONArray array = new JSONArray();
        for (BusLineBrief b : busLineBriefs){
            array.put(b.getJSONObject());
        }

        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
             writer = new OutputStreamWriter(out);
             writer.write(array.toString());
        }
        finally {
            if (writer != null){
                writer.close();
            }
        }
    }
}

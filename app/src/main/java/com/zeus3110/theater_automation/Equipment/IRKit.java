package com.zeus3110.theater_automation.Equipment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by super on 2016/06/17.
 */
public class IRKit {
    protected String base_url;

    public IRKit(String url){
        base_url=url;
    }

    public void SendCommand(String format, String freq, String irdata) throws Exception {

        String jsonData="{\\\"format\\\":\\\""+format+"\\,\\\"freq\\\":"+freq+"\",\\\"data\\\":"+irdata+"}";

        String buffer = "";
        HttpURLConnection con = null;
        URL url = new URL(base_url);
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setInstanceFollowRedirects(false);
        con.setRequestProperty("Accept-Language", "jp");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        con.setRequestProperty("X-Requested-With", "curl");
        OutputStream os = con.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.print(String.valueOf(jsonData));
        ps.close();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        buffer = reader.readLine();
        con.disconnect();

    }
}

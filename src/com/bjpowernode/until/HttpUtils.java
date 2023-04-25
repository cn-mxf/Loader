package com.bjpowernode.until;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {

    public static HttpURLConnection getHttpURLConnection(String url) throws Exception {
        URL httpUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection)httpUrl.openConnection();
        httpURLConnection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1");

        return httpURLConnection;

    }


    public static String getFileName(String url){
         int i = url.lastIndexOf("/");
       return url.substring(i+1);

    }


}

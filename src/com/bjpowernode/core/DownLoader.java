package com.bjpowernode.core;

import com.bjpowernode.constant.Constant;
import com.bjpowernode.until.HttpUtils;
import com.bjpowernode.until.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;

public class DownLoader {


    public void downLoad(String url){
        //获取文件名
        String fileName = HttpUtils.getFileName(url);
        //文件下载路径
        fileName = Constant.PATH + fileName;
        HttpURLConnection httpURLConnection=null;
        //获取连接对象
        try {
             httpURLConnection = HttpUtils.getHttpURLConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }



       try (
               //拿到输入流对象
           InputStream input=httpURLConnection.getInputStream();
             //写到缓冲流里面
            BufferedInputStream bis=   new BufferedInputStream(input);
            //用文件输出流的方式 把文件写到硬盘上
             FileOutputStream fo= new FileOutputStream(fileName);
            BufferedOutputStream bo= new BufferedOutputStream(fo)
       ){
            int len =-1;
            while ((len=bis.read())!=-1){
                bo.write(len);
           }

       }catch (FileNotFoundException e){
           e.printStackTrace();
          // System.out.println("找不到文件");
           LogUtils.error("找不到文件{}",url);
       }catch (Exception e){
           e.printStackTrace();
           //System.out.println("系统异常");
           LogUtils.error("系统异常");
       }finally {

       }
    }
}

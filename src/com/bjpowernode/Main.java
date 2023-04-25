package com.bjpowernode;

import com.bjpowernode.core.DownLoader;
import com.bjpowernode.until.LogUtils;

import java.util.Scanner;

public class Main {

    /**
     * 主类
     * @param args
     */
    public static void main(String[] args) {
        String url=null;
        if(args==null || args.length==0){
            for(; ;){
            LogUtils.info("请输入下载链接");
                Scanner scanner = new Scanner(System.in);
                 url = scanner.next();
                 if(url!=null){
                     break;
                 }
            }
        }else {
         url=  args[0];
        }
        DownLoader downLoader = new DownLoader();
            downLoader.downLoad(url);

    }
}

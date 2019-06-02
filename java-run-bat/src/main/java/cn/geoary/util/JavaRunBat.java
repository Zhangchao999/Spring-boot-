package cn.geoary.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: java-run-bat
 * @description: Java定时执行bat文件
 * @author: Zhangc
 * @create: 2019-05-06 14:41
 **/
@Component
public class JavaRunBat {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * @description 创建定时任务
     * @param
     * @return
     * @author Zhangc
     * @date 2019/5/6 
     */
    // 每天1点执行
    @Scheduled(cron = "0 0 1 * * ?")
    // 3分钟执行一次
    //@Scheduled(cron = "0 0/3 * * * ?")
    public void timingBat(){
        runBat();
    }

    /**
     * @description 执行bat文件 
     * @param  
     * @return  
     * @author Zhangc
     * @date 2019/5/6 
     */
    public static void runBat(){
        String batPath = "E:/backup/data/autobackup.bat";
        execBat(batPath);
        //execBat("1", batPath);
    }

    /**
     * @description 执行bat 
     * @param
     * @return  
     * @author Zhangc
     * @date 2019/5/6 
     */
    public static void execBat(String ways, String batPath){
        String cmdPre;
        switch (ways){
            case "1":
                // 是执行完dir命令后关闭命令窗口
                cmdPre =  "cmd /c ";
                break;
            case "2":
                // 是执行完dir命令后不关闭命令窗口
                cmdPre = "cmd /k ";
                break;
            case "3":
                // 会打开一个新窗口后执行dir指令，原窗口会关闭
                cmdPre = "cmd /c start ";
                break;
            default:
                // 会打开一个新窗口后执行dir指令，原窗口不会关闭
                cmdPre = "cmd /k start ";
        }
        String cmd = cmdPre + batPath;
        try{
            Process ps = Runtime.getRuntime().exec(cmd);
            InputStream in = ps.getInputStream();
            int c;
            while ((c = in.read()) !=  -1){

            }
            in.close();
            try {
                ps.waitFor();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("执行完成"+dateFormat.format(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void execBat(String batPath){
        try{
            Process ps = Runtime.getRuntime().exec("cmd /c start "+ batPath);
            InputStream in = ps.getInputStream();
            int c;
            while ((c = in.read()) !=  -1){

            }
            in.close();
            try {
                ps.waitFor();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("执行完成"+dateFormat.format(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


package cn.edu.lingnan.dao;
/*
 * 读取一个text文件并输出
 * */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class PiDao {
    public void findPiNumber(String _pi_num) {
//        String filePath = "d:\\pi6.txt";//14million
//        String filePath = "pi6.txt";//14million
        String filePath = "src/cn/edu/lingnan/dao/pi6.txt";//14million
        int pi_line = 0;
        try {
            FileInputStream inputStream = null;
            Scanner sc = null;
            try {
                inputStream = new FileInputStream(filePath);
                sc = new Scanner(inputStream, "utf-8");
                while (sc.hasNextLine()) {
                    pi_line++;
                    String line = sc.nextLine();
                    if ((line.indexOf(_pi_num)) != -1) {
                        System.out.println("第一次找到六位银行卡密码"+_pi_num+"位于圆周率3.1415926.....后第" + (50 * (pi_line - 2) + line.indexOf(_pi_num) + 1) + "位");
                        System.out.println("该密码及临近数字可见为：\n3.14......"+line+"...");
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (sc != null) {
                    sc.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
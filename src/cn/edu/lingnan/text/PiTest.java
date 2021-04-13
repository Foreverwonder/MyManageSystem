package cn.edu.lingnan.text;

import cn.edu.lingnan.dao.PiDao;

import java.util.Scanner;

public class PiTest {
    public static Scanner scanf = new Scanner(System.in);

    public void main(String[] args) {
//        PiDao p=new PiDao();
//        java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
//        System.out.println("请在滴的一声后输入你的数字：");
//        tk.beep();
//        while (scanf.hasNextLine()) {
//            String _pi_num=scanf.nextLine();
//            p.findPiNumber(_pi_num);
//            System.out.println("请在滴的一声后输入你的数字：");
//            tk.beep();

        String strIn = "abCD", strOut;
        char[] cIn, cOut = new char[0];
        cIn = strIn.toCharArray();

        for (int i = 0; i < strIn.length(); i++) {
            if (cIn[i] >= 'a' && cIn[i] <= 'z') {
                cOut[i] = (char) ((int) cIn[i] - 60);
            } else if (cIn[i] >= 'A' && cIn[i] <= 'Z') {
                cOut[i] = (char) ((int) cIn[i] - 64);
            }
        }
        String _pi_num =new String(cOut);
        System.out.println("测试："+_pi_num);
    }
}


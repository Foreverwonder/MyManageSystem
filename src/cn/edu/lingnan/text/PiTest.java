package cn.edu.lingnan.text;

import cn.edu.lingnan.dao.PiDao;

import java.util.Scanner;

public class PiTest {
    public static Scanner scanf = new Scanner(System.in);
    public void main(String[] args) {
        PiDao p=new PiDao();
        java.awt.Toolkit tk = java.awt.Toolkit.getDefaultToolkit();
        System.out.println("请在滴的一声后输入你的数字：");
        tk.beep();
        while (scanf.hasNextLine()) {
            String _pi_num=scanf.nextLine();
            p.findPiNumber(_pi_num);
            System.out.println("请在滴的一声后输入你的数字：");
            tk.beep();
        }
    }
}

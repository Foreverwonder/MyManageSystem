package cn.edu.lingnan.text;
/**
 * 要写一个删除成绩（V_C）才行
 *h还有很多Sid之类的没修改变量名字
 *
 */

import cn.edu.lingnan.dao.VacDao;
import cn.edu.lingnan.dao.C_VDao;
import cn.edu.lingnan.dao.CountryDao;
import cn.edu.lingnan.dto.VacDto;
import cn.edu.lingnan.dto.C_VDto;
import cn.edu.lingnan.dto.CountryDto;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class DaoTest {
    public static Scanner scanf = new Scanner(System.in);
    public static CountryDao sd = new CountryDao();
    public static C_VDao scd = new C_VDao();
    public static VacDao cd = new VacDao();

    public static void main(String[] args) throws SQLException {
        System.out.println("-------------------Welcome to the country achievement management system!------------- ");
        System.out.println("-------------------Please select the corresponding number to test（Main Menu）------------- ");
        System.out.println("--1.See the information--2.Add the information--3.Modify the information--4.Delete the information--5.exit------ ");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                find();
            } else if (str.equals("2")) {
                insert();
            } else if (str.equals("3")) {
                update();
            } else if (str.equals("4")) {
                delete();
            } else if (str.equals("5")) {
                System.out.println("GoodBye~ I'm looking forward to see you next time.");
                System.exit(0);
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            System.out.println("-------------------Welcome to the country achievement management system!------------- ");
            System.out.println("-------------------Please select the corresponding number to test（Main Menu）------------- ");
            System.out.println("--1.See the information--2.Add the information--3.Modify the information--4.Delete the information--5.exit------ ");
        }
    }

    //----------------------查找二级菜单------------------------
    public static void find() {
        System.out.println("------------Please select the corresponding number to test（Find Menu of 2th）------------- ");
//        System.out.println("----1查看所有用户--2查看所有课程--3查看所有成绩--4回到上一级--");
        System.out.println("----1查看用户--2查看课程--3查看成绩--4回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
//                findAllCountry();增加一级菜单
                findCountry();
            } else if (str.equals("2")) {
//                findAllVac();增加一级菜单
                findVac();
            } else if (str.equals("3")) {
//                findAllC_V();增加一级菜单
                findC_V();
            } else if (str.equals("4")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            //下面这两行要不
            System.out.println("-------------------Please select the corresponding number to test（Find Menu）------------- ");
            System.out.println("----1查看用户--2查看课程--3查看成绩--4回到上一级--");
        }
    }

    //--------------增加二级菜单------------------------
    public static void insert() {
        System.out.println("------------Please select the corresponding number to test（Add Menu of 2th）------------- ");
        System.out.println("----1增加用户--2增加课程--3增加成绩--4回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                insertCountry();
            } else if (str.equals("2")) {
                insertVac();
            } else if (str.equals("3")) {
                insertC_V();
            } else if (str.equals("4")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            //下面这两行要不
            System.out.println("------------Please select the corresponding number to test（Add Menu of 2th）------------- ");
            System.out.println("----1增加用户--2增加课程--3增加成绩--4回到上一级--");

        }
    }

    //-----------------更新二级菜单----------------------------------------------
    public static void update() {
        System.out.println("------------Please select the corresponding number to test（Update Menu of 2th）------------- ");
        System.out.println("----1更新用户--2更新课程--3更新成绩--4回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                updateCountry();
            } else if (str.equals("2")) {
                updateVac();
            } else if (str.equals("3")) {
                updateC_V();
            } else if (str.equals("4")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            //下面这两行要不
            System.out.println("------------Please select the corresponding number to test（Update Menu of 2th）------------- ");
            System.out.println("----1更新用户--2更新课程--3更新成绩--4回到上一级--");
        }
    }

    //---------------------------删除二级菜单------------------------------------------
    public static void delete() throws SQLException {
        System.out.println("------------Please select the corresponding number to test（Delete Menu of 2th）------------- ");
        System.out.println("----1删除用户--2删除课程--3删除成绩--4回到上一级--");//其实只能1删除学生，2、3办不到
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                deleteCountry();
            } else if (str.equals("2")) {
                deleteVac();
            } else if (str.equals("3")) {
                deleteC_V();
            } else if (str.equals("4")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            //下面这两行要不
            System.out.println("------------Please select the corresponding number to test（Delete Menu of 2th）------------- ");
            System.out.println("----1删除用户--2删除课程--3删除成绩--4回到上一级--");
        }
    }


    //----------------------三级菜单-----------------------------------

    //查找（三级菜单）
    public static void findCountry() {
        System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
        System.out.println("----1通过姓名和密码查学生--2通过ID查找学生--3查看所有学生--4回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                String _country_name = null;
                String _people = null;
                System.out.println("请输入需要查找的学生姓名：");
                _country_name = scanf.nextLine();
                System.out.println("请输入需要查找的学生密码：");
                _people = scanf.nextLine();
                if (sd.findCountryByNameAndPassword(_country_name, _people) == true) {
                    System.out.println("该学生在本校存在");
                }
            } else if (str.equals("2")) {
                String _country_id = null;
                System.out.println("请输入需要查找的学生ID：");
                _country_id = scanf.nextLine();
                System.out.println(sd.findCountryBySid(_country_id));
            } else if (str.equals("3")) {
                findAllCountry();
            } else if (str.equals("4")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
            System.out.println("----1通过姓名和密码查学生--2通过ID查找学生--3查看所有学生--4回到上一级--");

        }
    }

    public static void findVac() {
        System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
        System.out.println("----1通过课程号查课程--2查看所有课程--3回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                String _vac_id = null;
                System.out.println("请输入需要查找的课程ID：");
                _vac_id = scanf.nextLine();
                System.out.println(cd.findCnameByCid(_vac_id));
            } else if (str.equals("2")) {
                findAllVac();
            } else if (str.equals("3")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
            System.out.println("----1通过课程号查课程--2查看所有课程--3回到上一级--");
        }
    }

    public static void findC_V() {//未完成
        System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
        System.out.println("----1通过学生号课程号查成绩--2查看所有成绩--3回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                String _country_id = null;
                String _vac_id = null;
                System.out.println("请输入需要查找成绩的学生ID：");
                _country_id = scanf.nextLine();
                System.out.println("请输入需要查找成绩的课程ID：");
                _vac_id = scanf.nextLine();
                System.out.println(scd.findVac_Over_NumBySidAndCid(_country_id, _vac_id));
            } else if (str.equals("2")) {
                findAllVac_Over_Num();
            } else if (str.equals("3")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
            System.out.println("----1通过学生号课程号查成绩--2查看所有成绩--3回到上一级--");
        }
    }

    //查找所有学生
    public static void findAllCountry() {
        Vector<CountryDto> v = new Vector<>();
        v = sd.findAllCountry();
        System.out.println("-----------所有学生信息如下----------------");
        System.out.println("学生编号 学生姓名 \t学生密码 学生权限");
        for (CountryDto s : v) {
            System.out.println(s.getSid() + " \t" + s.getSname() + " \t" + s.getPassword() + " \t" + s.getSuperuser());
        }
        System.out.println("--------------------------------------------");
    }

    //查找所有分数
    public static void findAllVac_Over_Num() {
        Vector<C_VDto> v = new Vector<C_VDto>();
        v = scd.findAllVac_Over_Num();
        System.out.println("-----------所有成绩信息如下----------------");
        System.out.println("学生编号 课程编号 \t成绩");
        for (C_VDto s : v) {
            System.out.println(s.getSid() + " \t" + s.getCid() + " \t" + s.getVac_Over_Num());
        }
        System.out.println("--------------------------------------------");
    }

    //查找所有课程（改）
    public static void findAllVac() {
        Vector<VacDto> v = new Vector<>();
        v = cd.findAllVac();
        System.out.println("-----------所有学生信息如下----------------");
        System.out.println("课程编号 \t课程名");
        for (VacDto s : v) {
            System.out.println(" \t" + s.getCid() + " \t" + s.getCname() + " \t" + s.getVac_area() + " \t" + s.getVac_type());
        }
        System.out.println("--------------------------------------------");
    }

    //--------增加学生（三级菜单）---------------------------
    public static void insertCountry() {
        CountryDto s = new CountryDto();
        System.out.println("请输入需要新增的学生ID：");
        s.setSid(scanf.nextLine());
        System.out.println("请输入需要新增的学生姓名：");
        s.setSname(scanf.nextLine());
        System.out.println("请输入需要新增的学生密码：");
        s.setPassword(scanf.nextLine());
        System.out.println("请输入需要新增的学生权限：");
        //下一行转换数字就很妙：
//        s.setSuperuser(scanf.nextInt());这样会不方便，正确处理方法见下一行
        s.setSuperuser(Integer.parseInt(scanf.nextLine()));
        if (sd.insertInfoToCountry(s) == 1) {
            System.out.println("新增学生信息成功！");
        } else
            System.out.println("新增学生信息失败");
    }

    //---------------增加课程（三级）---------------------------------
    public static void insertVac() {
        VacDto c = new VacDto();
        System.out.println("请输入需要新增的课程ID：");
        c.setCid(scanf.nextLine());
        System.out.println("请输入需要新增的课程名称");
        c.setCname(scanf.nextLine());
        if (cd.insertInfoToVac(c) == 1) {
            System.out.println("新增课程信息成功！");
        } else
            System.out.println("新增课程信息失败");
    }

    //---------------增加分数（三级）---------------------------------
    public static void insertC_V() {
        C_VDto s = new C_VDto();
        System.out.println("请输入需要新增分数的country_id：");
        s.setSid(scanf.nextLine());
        System.out.println("请输入需要新增分数的vac_id");
        s.setCid(scanf.nextLine());
        System.out.println("请输入需要新增的分数vac_over_num");
        s.setVac_Over_Num(scanf.nextLine());
        if (scd.insertInfotoC_V(s) == 1) {
            System.out.println("新增课程信息成功！");
        } else if (scd.insertInfotoC_V(s) == 0) {
            System.out.println("新增课程信息失败(没学生没课程)");
        } else if (scd.insertInfotoC_V(s) == 2) {
            System.out.println("新增课程信息失败(有学生没课程)");
        } else if (scd.insertInfotoC_V(s) == 3) {
            System.out.println("新增课程信息失败(有课程没学生)");
        } else if (scd.insertInfotoC_V(s) == 4) {
            System.out.println("新增课程信息失败(主键约束)");
        } else
            System.out.println("新增课程信息失败(未知错误)");
    }
    //---------------增加学生（三级三功能）---------------------------------
    public static void updateCountry() {
        System.out.println("------------Please select the corresponding number to test（Update Menu of 3th）------------- ");
        System.out.println("----1更新学生名字--2更新学生密码--3更新学生权限--4回到上一级--");
        CountryDto s = new CountryDto();
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                System.out.println("请输入要更改的学生ID");
                s.setSid(scanf.nextLine());
                System.out.println("请输入要更改的学生名字");
                s.setSname(scanf.nextLine());
                if (sd.updataCountrySname(s) == 1) {
                    System.out.println("更改名字成功");
                } else System.out.println("更改名字失败");
            } else if (str.equals("2")) {
                System.out.println("请输入要更改的学生ID");
                s.setSid(scanf.nextLine());
                System.out.println("请输入要更改的学生密码");
                s.setPassword(scanf.nextLine());
                if (sd.updataCountryPassword(s) == 1) {
                    System.out.println("更改密码成功");
                } else System.out.println("更改密码失败");
            } else if (str.equals("3")) {
                System.out.println("请输入要更改的学生ID");
                s.setSid(scanf.nextLine());
                System.out.println("请输入要更改的学生权限");
                s.setSuperuser(Integer.parseInt(scanf.nextLine()));
                if (sd.updataCountrySuperuser(s) == 1) {
                    System.out.println("更改权限成功");
                } else System.out.println("更改权限失败");
            } else if (str.equals("4")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            //下面这两行要不
            System.out.println("------------Please select the corresponding number to test（Update Menu of 3th）------------- ");
            System.out.println("----1更新学生名字--2更新学生密码--3更新学生权限--4回到上一级--");
        }
    }
    //-----------------------更新课程（三级菜单）------------------------------------------
    public static void updateVac() {
        VacDto c = new VacDto();
        System.out.println("请输入更新课程名的vac_id：");
        c.setCid(scanf.nextLine());
        System.out.println("请输入需要更新的vac_name：");
        c.setCname(scanf.nextLine());
        if (cd.updataVac(c) == 1) {
            System.out.println("更新课程成功");
        } else
            System.out.println("更新失败");
    }

    //-----------------------更新分数表---------------------------------------------------------------------
    public static void updateC_V() {
        C_VDto c = new C_VDto();
        System.out.println("请输入需要更新分数的country_id：");
        c.setSid(scanf.nextLine());
        System.out.println("请输入需要更新分数的vac_id：");
        c.setCid(scanf.nextLine());
        System.out.println("请输入需要更新的分数");
        c.setVac_Over_Num(scanf.nextLine());
        if (scd.updataC_V(c) == 1) {
            System.out.println("更新分数成功");
        } else
            System.out.println("更新失败");
    }


    //-----------------------删除学生（三级菜单）------------------------------------------
    public static void deleteCountry() throws SQLException {
        System.out.println("请输入要删除的学生ID：");
        String _country_id = scanf.nextLine();
        if (sd.deleteCountry(_country_id) == true) {
            System.out.println("删除学生信息成功");
        } else
            System.out.println("删除学生信息失败");
    }

    //-----------------------删除课程（三级菜单）------------------------------------------
    public static void deleteVac() throws SQLException {
        System.out.println("请输入要删除的课程ID：");
        String _vac_id = scanf.nextLine();
        if (cd.deleteVac(_vac_id) == true) {
            System.out.println("删除课程信息成功");
        } else
            System.out.println("删除课程信息失败");
    }
    //----------------------删除成绩（三级菜单）------------------------------------------
    public static void deleteC_V() throws SQLException {
        System.out.println("请输入要删除的国家ID：");
        String _country_id = scanf.nextLine();
        System.out.println("请输入要删除的疫苗ID：");
        String _vac_id = scanf.nextLine();

        if (scd.deleteVac(_country_id, _vac_id) == true) {
            System.out.println("删除C_V接种信息成功");
        } else
            System.out.println("删除C_V接种信息失败");
    }

}

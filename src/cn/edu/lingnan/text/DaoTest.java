package cn.edu.lingnan.text;
/**
 * 要写一个删除接种情况（V_C）才行
 *h还有很多Country_id之类的没修改变量名字
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
        System.out.println("----1查看国家--2查看疫苗--3查看接种情况--4回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                findCountry();
            } else if (str.equals("2")) {
                findVac();
            } else if (str.equals("3")) {
                findC_V();
            } else if (str.equals("4")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            System.out.println("-------------------Please select the corresponding number to test（Find Menu）------------- ");
            System.out.println("----1查看国家--2查看疫苗--3查看接种情况--4回到上一级--");
        }
    }

    //--------------增加二级菜单------------------------
    public static void insert() {
        System.out.println("------------Please select the corresponding number to test（Add Menu of 2th）------------- ");
        System.out.println("----1增加国家--2增加疫苗--3增加接种情况--4回到上一级--");
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
            System.out.println("------------Please select the corresponding number to test（Add Menu of 2th）------------- ");
            System.out.println("----1增加国家--2增加疫苗--3增加接种情况--4回到上一级--");

        }
    }

    //-----------------更新二级菜单----------------------------------------------
    public static void update() {
        System.out.println("------------Please select the corresponding number to test（Update Menu of 2th）------------- ");
        System.out.println("----1更新国家--2更新疫苗--3更新接种情况--4回到上一级--");
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
            System.out.println("------------Please select the corresponding number to test（Update Menu of 2th）------------- ");
            System.out.println("----1更新国家--2更新疫苗--3更新接种情况--4回到上一级--");
        }
    }

    //---------------------------删除二级菜单------------------------------------------
    public static void delete() throws SQLException {
        System.out.println("------------Please select the corresponding number to test（Delete Menu of 2th）------------- ");
        System.out.println("----1删除国家--2删除疫苗--3删除接种情况--4回到上一级--");//其实只能1删除国家，2、3办不到
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
            System.out.println("------------Please select the corresponding number to test（Delete Menu of 2th）------------- ");
            System.out.println("----1删除国家--2删除疫苗--3删除接种情况--4回到上一级--");
        }
    }


    //----------------------三级菜单-----------------------------------

    //查找（三级菜单）
    public static void findCountry() {
        System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
        System.out.println("----1通过姓名和人口查国家--2通过ID查找国家--3查看所有国家--4回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                String _country_name = null;
                String _people = null;
                System.out.println("请输入需要查找的国家姓名：");
                _country_name = scanf.nextLine();
                System.out.println("请输入需要查找的国家人口：");
                _people = scanf.nextLine();
                if (sd.findCountryByNameAndPeople(_country_name, _people) == true) {
                    System.out.println("该国家在本校存在");
                }
            } else if (str.equals("2")) {
                String _country_id = null;
                System.out.println("请输入需要查找的国家ID：");
                _country_id = scanf.nextLine();
                System.out.println(sd.findCountryByCountry_id(_country_id));
            } else if (str.equals("3")) {
                findAllCountry();
            } else if (str.equals("4")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
            System.out.println("----1通过姓名和人口查国家--2通过ID查找国家--3查看所有国家--4回到上一级--");

        }
    }

    public static void findVac() {
        System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
        System.out.println("----1通过疫苗号查疫苗--2查看所有疫苗--3回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                String _vac_id = null;
                System.out.println("请输入需要查找的疫苗ID：");
                _vac_id = scanf.nextLine();
                System.out.println(cd.findVac_nameByVac_id(_vac_id));
            } else if (str.equals("2")) {
                findAllVac();
            } else if (str.equals("3")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
            System.out.println("----1通过疫苗号查疫苗--2查看所有疫苗--3回到上一级--");
        }
    }

    public static void findC_V() {//未完成
        System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
        System.out.println("----1通过国家号疫苗号查接种情况--2查看所有接种情况--3回到上一级--");
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                String _country_id = null;
                String _vac_id = null;
                System.out.println("请输入需要查找接种情况的国家ID：");
                _country_id = scanf.nextLine();
                System.out.println("请输入需要查找接种情况的疫苗ID：");
                _vac_id = scanf.nextLine();
                System.out.println(scd.findVac_Over_NumByCountry_idAndVac_id(_country_id, _vac_id));
            } else if (str.equals("2")) {
                findAllVac_Over_Num();
            } else if (str.equals("3")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            System.out.println("------------Please select the corresponding number to test（Find Menu of 3th）------------- ");
            System.out.println("----1通过国家号疫苗号查接种情况--2查看所有接种情况--3回到上一级--");
        }
    }

    //查找所有国家
    public static void findAllCountry() {
        Vector<CountryDto> v = new Vector<>();
        v = sd.findAllCountry();
        System.out.println("-----------所有国家信息如下----------------");
        System.out.println("国家编号 国家姓名 \t国家人口 国家是否研发疫苗");
        for (CountryDto s : v) {
            System.out.println(s.getCountry_id() + " \t" + s.getCountry_name() + " \t" + s.getPeople() + " \t" + s.getVac_able());
        }
        System.out.println("--------------------------------------------");
    }

    //查找所有接种情况
    public static void findAllVac_Over_Num() {
        Vector<C_VDto> v = new Vector<C_VDto>();
        v = scd.findAllVac_Over_Num();
        System.out.println("-----------所有接种情况信息如下----------------");
        System.out.println("国家编号 疫苗编号 \t接种情况");
        for (C_VDto s : v) {
            System.out.println(s.getCountry_id() + " \t" + s.getVac_id() + " \t" + s.getVac_Over_Num());
        }
        System.out.println("--------------------------------------------");
    }

    //查找所有疫苗（改）
    public static void findAllVac() {
        Vector<VacDto> v = new Vector<>();
        v = cd.findAllVac();
        System.out.println("-----------所有国家信息如下----------------");
        System.out.println("疫苗编号 \t疫苗名");
        for (VacDto s : v) {
            System.out.println(" \t" + s.getVac_id() + " \t" + s.getVac_name() + " \t" + s.getVac_area() + " \t" + s.getVac_type());
        }
        System.out.println("--------------------------------------------");
    }

    //--------增加国家（三级菜单）---------------------------
    public static void insertCountry() {
        CountryDto s = new CountryDto();
        System.out.println("请输入需要新增的国家ID：");
        s.setCountry_id(scanf.nextLine());
        System.out.println("请输入需要新增的国家姓名：");
        s.setCountry_name(scanf.nextLine());
        System.out.println("请输入需要新增的国家人口：");
        s.setPeople(scanf.nextLine());
        System.out.println("请输入需要新增的国家是否研发疫苗：");
        s.setVac_able(Integer.parseInt(scanf.nextLine()));
        if (sd.insertInfoToCountry(s) == 1) {
            System.out.println("新增国家信息成功！");
        } else
            System.out.println("新增国家信息失败");
    }

    //---------------增加疫苗（三级）---------------------------------
    public static void insertVac() {
        VacDto c = new VacDto();
        System.out.println("请输入需要新增的疫苗ID：");
        c.setVac_id(scanf.nextLine());
        System.out.println("请输入需要新增的疫苗名称");
        c.setVac_name(scanf.nextLine());
        if (cd.insertInfoToVac(c) == 1) {
            System.out.println("新增疫苗信息成功！");
        } else
            System.out.println("新增疫苗信息失败");
    }

    //---------------增加接种情况（三级）---------------------------------
    public static void insertC_V() {
        C_VDto s = new C_VDto();
        System.out.println("请输入需要新增接种情况的country_id：");
        s.setCountry_id(scanf.nextLine());
        System.out.println("请输入需要新增接种情况的vac_id");
        s.setVac_id(scanf.nextLine());
        System.out.println("请输入需要新增的接种情况vac_over_num");
        s.setVac_Over_Num(scanf.nextLine());
        if (scd.insertInfotoC_V(s) == 1) {
            System.out.println("新增疫苗信息成功！");
        } else if (scd.insertInfotoC_V(s) == 0) {
            System.out.println("新增疫苗信息失败(没国家没疫苗)");
        } else if (scd.insertInfotoC_V(s) == 2) {
            System.out.println("新增疫苗信息失败(有国家没疫苗)");
        } else if (scd.insertInfotoC_V(s) == 3) {
            System.out.println("新增疫苗信息失败(有疫苗没国家)");
        } else if (scd.insertInfotoC_V(s) == 4) {
            System.out.println("新增疫苗信息失败(主键约束)");
        } else
            System.out.println("新增疫苗信息失败(未知错误)");
    }
    //---------------增加国家（三级三功能）---------------------------------
    public static void updateCountry() {
        System.out.println("------------Please select the corresponding number to test（Update Menu of 3th）------------- ");
        System.out.println("----1更新国家名字--2更新国家人口--3更新国家是否研发疫苗--4回到上一级--");
        CountryDto s = new CountryDto();
        while (scanf.hasNextLine()) {
            String str = scanf.nextLine();
            if (str.equals("1")) {
                System.out.println("请输入要更改的国家ID");
                s.setCountry_id(scanf.nextLine());
                System.out.println("请输入要更改的国家名字");
                s.setCountry_name(scanf.nextLine());
                if (sd.updataCountryCountry_name(s) == 1) {
                    System.out.println("更改名字成功");
                } else System.out.println("更改名字失败");
            } else if (str.equals("2")) {
                System.out.println("请输入要更改的国家ID");
                s.setCountry_id(scanf.nextLine());
                System.out.println("请输入要更改的国家人口");
                s.setPeople(scanf.nextLine());
                if (sd.updataCountryPeople(s) == 1) {
                    System.out.println("更改人口成功");
                } else System.out.println("更改人口失败");
            } else if (str.equals("3")) {
                System.out.println("请输入要更改的国家ID");
                s.setCountry_id(scanf.nextLine());
                System.out.println("请输入要更改的国家是否研发疫苗");
                s.setVac_able(Integer.parseInt(scanf.nextLine()));
                if (sd.updataCountryVac_able(s) == 1) {
                    System.out.println("更改是否研发疫苗成功");
                } else System.out.println("更改是否研发疫苗失败");
            } else if (str.equals("4")) {
                break;
            } else {
                System.out.println("您输入的信息有误！请重新输入！");
            }
            System.out.println("------------Please select the corresponding number to test（Update Menu of 3th）------------- ");
            System.out.println("----1更新国家名字--2更新国家人口--3更新国家是否研发疫苗--4回到上一级--");
        }
    }
    //-----------------------更新疫苗（三级菜单）------------------------------------------
    public static void updateVac() {
        VacDto c = new VacDto();
        System.out.println("请输入更新疫苗名的vac_id：");
        c.setVac_id(scanf.nextLine());
        System.out.println("请输入需要更新的vac_name：");
        c.setVac_name(scanf.nextLine());
        if (cd.updataVac(c) == 1) {
            System.out.println("更新疫苗成功");
        } else
            System.out.println("更新失败");
    }

    //-----------------------更新接种情况表---------------------------------------------------------------------
    public static void updateC_V() {
        C_VDto c = new C_VDto();
        System.out.println("请输入需要更新接种情况的country_id：");
        c.setCountry_id(scanf.nextLine());
        System.out.println("请输入需要更新接种情况的vac_id：");
        c.setVac_id(scanf.nextLine());
        System.out.println("请输入需要更新的接种情况");
        c.setVac_Over_Num(scanf.nextLine());
        if (scd.updataC_V(c) == 1) {
            System.out.println("更新接种情况成功");
        } else
            System.out.println("更新失败");
    }


    //-----------------------删除国家（三级菜单）------------------------------------------
    public static void deleteCountry() throws SQLException {
        System.out.println("请输入要删除的国家ID：");
        String _country_id = scanf.nextLine();
        if (sd.deleteCountry(_country_id) == true) {
            System.out.println("删除国家信息成功");
        } else
            System.out.println("删除国家信息失败");
    }

    //-----------------------删除疫苗（三级菜单）------------------------------------------
    public static void deleteVac() throws SQLException {
        System.out.println("请输入要删除的疫苗ID：");
        String _vac_id = scanf.nextLine();
        if (cd.deleteVac(_vac_id) == true) {
            System.out.println("删除疫苗信息成功");
        } else
            System.out.println("删除疫苗信息失败");
    }
    //----------------------删除接种情况（三级菜单）------------------------------------------
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

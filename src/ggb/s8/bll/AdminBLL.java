package ggb.s8.bll;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ggb.s8.dal.AdminDAL;
import ggb.s8.dal.MySQLHelper;
import ggb.s8.model.User;

public class AdminBLL {
	static public int returnOLNum() {
		List<Map<String, Object>> list = AdminDAL.returnAllOL();

		int count = 0;
		try {
			for (Map<String, Object> rs : list) {
				if (Integer.parseInt(rs.get("deleted").toString()) == 0) {
					count++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MySQLHelper().close();
		return count;
	}

	static public int returnRegisterNum() {
		List<Map<String, Object>> list = AdminDAL.returnAllRegister();
		int count = 0;
		try {
			for (Map<String, Object> rs : list) {
				if (Integer.parseInt(rs.get("deleted").toString()) == 0) {
					count++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MySQLHelper().close();
		return count;
	}

	static public int returnGroupNum() {
		List<Map<String, Object>> list = AdminDAL.returnAllGroup();
		int count = 0;
		try {
			for (Map<String, Object> rs : list) {
				if (Integer.parseInt(rs.get("deleted").toString()) == 0) {
					count++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MySQLHelper().close();
		return count;
	}

	static public ArrayList<User> returnAllUser() {

		List<Map<String, Object>> list = AdminDAL.returnAllRegister();
		ArrayList<User> uList = new ArrayList<User>();
		try {
			for (Map<String, Object> rs : list) {
				User user = new User();
				user.id = String.valueOf(rs.get("id"));
				user.password = String.valueOf(rs.get("password"));
				user.name = String.valueOf(rs.get("name"));
				user.age = (int) rs.get("age");
				user.registertime = new SimpleDateFormat("yyyy-M-dd").parse(rs.get("registertime").toString());
				user.sex = String.valueOf(rs.get("sex"));
				user.birth = new SimpleDateFormat("yyyy-M-dd").parse(rs.get("birth").toString());
				user.hometown = String.valueOf(rs.get("hometown"));
				user.place = String.valueOf(rs.get("place"));
				user.career = String.valueOf(rs.get("career"));
				user.company = String.valueOf(rs.get("company"));
				user.school = String.valueOf(rs.get("school"));
				user.tel = String.valueOf(rs.get("tel"));
				user.mail = String.valueOf(rs.get("mail"));
				user.head = String.valueOf(rs.get("head"));
				user.state = String.valueOf(rs.get("state"));
				user.friend = String.valueOf(rs.get("friend"));
				user.lastlogin = new SimpleDateFormat("yyyy-M-dd").parse(rs.get("lastlogin").toString());
				user.lastlogout = new SimpleDateFormat("yyyy-M-dd").parse(rs.get("lastlogout").toString());
				user.sign = String.valueOf(rs.get("sign"));
				uList.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MySQLHelper().close();
		return uList;
	}

	static public void resetPass(String id) {
		AdminDAL.resetPass(id);
	}

	static public void comOff(String id) {
		AdminDAL.comOff(id);
	}
}

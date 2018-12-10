package ggb.s8.bll;

import java.sql.ResultSet;
import java.sql.SQLException;

import ggb.s8.dal.MySQLHelper;
import ggb.s8.dal.UserDAL;
import ggb.s8.model.User;

public class UserBLL {
	static public boolean checkidpassword(String id, String password) {
		if (id.isEmpty())
			return false;
		try {
			ResultSet rs = UserDAL.checkidpassword(id, password);
			if (rs.next()) {
				if (rs.getInt("deleted") == 1) {
					new MySQLHelper().close();
					return false;
				}
			} else {
				new MySQLHelper().close();
				return false;
			}
			new MySQLHelper().close();
			return true;
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			new MySQLHelper().close();
			e.printStackTrace();
		}
		new MySQLHelper().close();
		return false;
	}

	static public boolean checkid(String id) {
		if (id.isEmpty())
			return false;
		try {
			ResultSet rs = UserDAL.checkid(id);
			if (rs.next())
				if (rs.getInt("deleted") == 1) {
					new MySQLHelper().close();
					return false;
				}
			new MySQLHelper().close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new MySQLHelper().close();
			e.printStackTrace();
		}
		new MySQLHelper().close();
		return false;
	}

	static public User returnuser(String id) {
		User user = new User();
		try {
			ResultSet rs = UserDAL.returnuser(id);
			if (rs.next()) {
				if (rs.getInt("deleted") != 1) {
					user.id = rs.getString("id");
					user.password = rs.getString("password");
					user.name = rs.getString("name");
					user.age = rs.getInt("age");
					user.registertime = rs.getDate("registertime");
					user.sex = rs.getString("sex");
					user.birth = rs.getDate("birth");
					user.hometown = rs.getString("hometown");
					user.place = rs.getString("place");
					user.career = rs.getString("career");
					user.company = rs.getString("company");
					user.school = rs.getString("school");
					user.tel = rs.getString("tel");
					user.mail = rs.getString("mail");
					user.head = rs.getString("head");
					user.state = rs.getString("state");
					user.friend = rs.getString("friend");
					user.lastlogin = rs.getDate("lastlogin");
					user.lastlogout = rs.getDate("lastlogout");
					user.sign = rs.getString("sign");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		new MySQLHelper().close();
		return user;
	}

	static public void reset(String id) {
		if (id.isEmpty())
			return;
		UserDAL.reset(id);
		new MySQLHelper().close();
	}

	static public void register(String id, String password, String name) {
		if (id.isEmpty())
			return;
		UserDAL.register(id, password, name);
		new MySQLHelper().close();
	}

	static public void updateUserInfo(User user) {
		UserDAL.updateUserInfo(user);
		new MySQLHelper().close();
	}

	static public String singleRecord(User user) {
		String string = "";
		try {
			ResultSet rs = UserDAL.singleRecord(user);
			if (rs.next())
				string = rs.getString("record");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("查询到的聊天记录为" + string);
		new MySQLHelper().close();
		return string;
	}
}

package ggb.s8.dal;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import ggb.s8.model.Client;
import ggb.s8.model.User;

public class UserDAL {
	static public ResultSet checkidpassword(String id, String password) {
		if (id.substring(0, 1).equals("u"))
			return new MySQLHelper()
					.query("SELECT * FROM qquser WHERE id='" + id + "' AND password='" + password + "'");
		else if (id.substring(0, 1).equals("a"))
			return new MySQLHelper()
					.query("SELECT * FROM qqadmin WHERE id='" + id + "' AND password='" + password + "'");
		else
			return new MySQLHelper()
					.query("SELECT * FROM qquser WHERE id='" + id + "' AND password='" + password + "'");

	}

	static public ResultSet checkid(String id) {
		return new MySQLHelper().query("SELECT * FROM qquser WHERE id='" + id + "'");

	}

	static public ResultSet returnuser(String id) {
		return new MySQLHelper().query("SELECT * FROM qquser WHERE id='" + id + "'");
	}

	static public void reset(String id) {
		new MySQLHelper().executeNonquery("UPDATE qquser SET password='123456' WHERE id = '" + id + "'");
	}

	static public void register(String id, String password, String name) {
		new MySQLHelper().executeNonquery(
				"INSERT INTO qquser (id,password,name) VALUES ('" + id + "','" + password + "','" + name + "')");
	}

	static public void updateUserInfo(User user) {
		String sql = "UPDATE qquser SET ";
		for (Field field : user.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {

				if (!field.getName().equals("id")) {
					if (field.get(user) == null)
						continue;
					if (field.getType().getName().equals("int"))
						sql += field.getName() + "=" + field.get(user) + ",";
					else if (field.getType().getName().equals("java.util.Date"))
						sql += field.getName() + "='" + new SimpleDateFormat("yyyy-MM-dd").format(field.get(user))
								+ "',";
					else
						sql += field.getName() + "='" + field.get(user) + "',";
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " WHERE id = '" + user.id + "'";
		System.out.println(sql);
		new MySQLHelper().executeNonquery(sql);
	}

	static public ResultSet singleRecord(User user) {
		System.out.println(user.id + " " + Client.curruser.id);
		return new MySQLHelper().query(
				"SELECT record FROM qqrecord WHERE " + "(sourid='" + user.id + "' AND destid = '" + Client.curruser.id
						+ "') OR " + "(sourid='" + Client.curruser.id + "' AND destid = '" + user.id + "')");
	}

	static public ResultSet returnGroup(String id) {
		return new MySQLHelper().query("SELECT * FROM qqgroup WHERE id='" + id + "'");
	}
}

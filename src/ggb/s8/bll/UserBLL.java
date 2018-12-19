package ggb.s8.bll;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import ggb.s8.dal.MySQLHelper;
import ggb.s8.dal.UserDAL;
import ggb.s8.model.Client;
import ggb.s8.model.QQgroup;
import ggb.s8.model.Record;
import ggb.s8.model.User;

public class UserBLL {

	static public boolean checkidpassword(String id, String password) {
		if (id.isEmpty())
			return false;
		try {
			List<Map<String, Object>> list = UserDAL.checkidpassword(id, password);
			if (list.isEmpty())
				return false;
			for (Map<String, Object> rs : list)
				if ((int) rs.get("deleted") == 1) {
					new MySQLHelper().close();
					return false;
				}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new MySQLHelper().close();
			e.printStackTrace();
		}
		return false;
	}

	static public boolean checkid(String id) {
		if (id.isEmpty())
			return false;
		try {
			List<Map<String, Object>> list = UserDAL.checkid(id);
			for (Map<String, Object> rs : list)
				if ((int) rs.get("deleted") == 1) {
					new MySQLHelper().close();
					return false;
				} else {
					return false;
				}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new MySQLHelper().close();
			e.printStackTrace();
		}
		return false;
	}

	static public User returnuser(String id) {
		User user = new User();

		try {
			List<Map<String, Object>> list = UserDAL.checkid(id);
			for (Map<String, Object> rs : list)
				if (Integer.parseInt(rs.get("deleted").toString()) != 1) {
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
					user.qqgroup = String.valueOf(rs.get("qqgroup"));

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

	static public Record singleRecord(User user) {
		Record record = new Record();
		try {
			List<Map<String, Object>> list = UserDAL.singleRecord(user);
			for (Map<String, Object> rs : list) {
				record.sourid = rs.get("sourid").toString();
				record.destid = rs.get("destid").toString();
				record.record = rs.get("record").toString();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		new MySQLHelper().close();
		return record;
	}

	static public QQgroup returnGroup(String id) {
		QQgroup user = new QQgroup();
		try {
			List<Map<String, Object>> list = UserDAL.returnGroup(id);
			for (Map<String, Object> rs : list) {
				{
					if (Integer.parseInt(rs.get("deleted").toString()) != 1) {
						user.id = rs.get("id").toString();
						user.name = rs.get("name").toString();
						user.people = rs.get("people").toString();
						user.head = rs.get("head").toString();
						user.buildtime = new SimpleDateFormat("yyyy-M-dd").parse(rs.get("buildtime").toString());
						;
						user.record = rs.get("record").toString();
						user.introduce = rs.get("introduce").toString();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
		new MySQLHelper().close();
		return user;
	}

	static public Boolean addFriend(String id) {
		if (!isFriend(id)) {
			Client.curruser.friend += "," + id;
			updateUserInfo(Client.curruser);
			User user = returnuser(id);
			user.friend += "," + Client.curruser.id;
			updateUserInfo(user);
			return true;
		}
		return false;
	}

	static public Boolean isFriend(String id) {
		String str[] = Client.curruser.friend.split(",");
		for (String string : str) {
			if (id.equals(string))
				return true;
		}
		return false;
	}

	static public Boolean addGroup(String id) {
		if (!isInGroup(id)) {
			Client.curruser.qqgroup += "," + id;
			updateUserInfo(Client.curruser);
			QQgroup user = returnGroup(id);
			user.people += "," + Client.curruser.id;
			updateGroupInfo(user);
			return true;
		}
		return false;
	}

	static public Boolean isInGroup(String id) {
		String str[] = Client.curruser.qqgroup.split(",");
		for (String string : str) {
			if (id.equals(string))
				return true;
		}
		return false;
	}

	static public void updateGroupInfo(QQgroup qqgroup) {
		UserDAL.updateGroupInfo(qqgroup);
		new MySQLHelper().close();
	}

	static public void AddRecord(String msg) {
		if (Client.currchat.substring(0, 1).equals("u")) {
			User chatUser = UserBLL.returnuser(Client.currchat);
			Record record = singleRecord(chatUser);
			record.record += Client.curruser.name + "(" + Client.curruser.id + ")"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "\r\n" + msg
					+ "\r\n";
			updateUserRecord(record);

		} else if (Client.currchat.substring(0, 1).equals("Q")) {
			QQgroup chatUser = returnGroup(Client.currchat);

			chatUser.record += Client.curruser.name + "(" + Client.curruser.id + ")"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "\r\n" + msg
					+ "\r\n";
			updateGroupInfo(chatUser);
		}
		new MySQLHelper().close();

	}

	static public void updateUserRecord(Record record) {
		UserDAL.updateUserRecord(record);
		new MySQLHelper().close();
	}
}

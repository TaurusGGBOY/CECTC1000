package ggb.s8.bll;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ggb.s8.dal.AdminDAL;
import ggb.s8.dal.MySQLHelper;
import ggb.s8.model.User;

public class AdminBLL {
	private static AdminBLL instance = null;

	/**
	 * @Title: getInstance 
	 * @Description: TODO(单例模式) 
	 * @param @return 参数 
	 * @return
	 * AdminBLL 返回类型 
	 * @throws
	 */
	
	public static AdminBLL getInstance() {
		if (instance == null) {
			instance = new AdminBLL();
		}
		return instance;
	}

	
	    /**
	    * @Title: returnOLNum
	    * @Description: TODO(返回在线人数)
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	    */
	    
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

	
	    /**
	    * @Title: returnRegisterNum
	    * @Description: TODO(返回注册数目)
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	    */
	    
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

	
	    /**
	    * @Title: returnGroupNum
	    * @Description: TODO(返回群数量)
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	    */
	    
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

	
	    /**
	    * @Title: returnAllUser
	    * @Description: TODO(返回所有的用户)
	    * @param @return    参数
	    * @return ArrayList<User>    返回类型
	    * @throws
	    */
	    
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

}

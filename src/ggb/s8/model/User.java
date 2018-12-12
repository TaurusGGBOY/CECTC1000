
package ggb.s8.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 */
public class User {

	public String id;
	public String password;
	public String name;
	public int age;
	public Date registertime;
	public String sex;
	public Date birth;
	public String hometown;
	public String place;
	public String career;
	public String company;
	public String school;
	public String tel;
	public String mail;
	public String head;
	public String state;
	public String friend;
	public Date lastlogin;
	public Date lastlogout;
	public String sign;
	public String qqgroup;

	/**
	 * Default constructor
	 */
	public User() {
		id = "";
		password = "";
		name = "";
		age = 20;
		sex = "ÄÐ";
		hometown = "";
		place = "";
		career = "";
		company = "";
		school = "";
		tel = "";
		mail = "";
		head = "h2";
		state = "";
		friend = "";
		try {
			registertime = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-1");
			birth = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-1");
			lastlogin = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-1");
			lastlogout = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-1");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sign = "";
		qqgroup = "";
	}

	public void clone(User user) {

		if (!user.id.isEmpty() && user.id.substring(0, 1).equals("u")) {
			id = user.id;
			password = user.password;
			name = user.name;
			age = user.age;
			registertime = user.registertime;
			sex = user.sex;
			birth = user.birth;
			hometown = user.hometown;
			place = user.place;
			career = user.career;
			company = user.company;
			school = user.school;
			tel = user.tel;
			mail = user.mail;
			head = user.head;
			state = user.state;
			friend = user.friend;
			lastlogin = user.lastlogin;
			lastlogout = user.lastlogout;
			sign = user.sign;
			qqgroup = user.qqgroup;
		}
	}
	/**
	 * 
	 */

}
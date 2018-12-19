package ggb.s8.bll;

import javax.swing.JFrame;

import ggb.s8.model.Client;
import ggb.s8.ui.AdminMain;
import ggb.s8.ui.LoginiFail;
import ggb.s8.ui.Logining;

public class LoginFactory {
	static public JFrame makeWindow(String id, String password) {
		if (UserBLL.checkidpassword(id, password)) {
			if (id.substring(0, 1).equals("u")) {
				Client.curruser.clone(UserBLL.returnuser(id));
				return new Logining();
			}
			if (id.substring(0, 1).equals("a")) {
				return new AdminMain();

			}
		}
		return new LoginiFail();

	}
}

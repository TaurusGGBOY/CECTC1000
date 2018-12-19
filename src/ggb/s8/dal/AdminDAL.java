package ggb.s8.dal;

import java.util.List;
import java.util.Map;

public class AdminDAL {
	static public List<Map<String, Object>> returnAllOL() {

		String sql = "SELECT * FROM qquser where state = 'ÔÚÏß'";
		SQLDAL sqldal = new SQLDAL(sql);
		return sqldal.execute();

	}

	static public List<Map<String, Object>> returnAllRegister() {
		String sql = "SELECT * FROM qquser";
		SQLDAL sqldal = new SQLDAL(sql);
		return sqldal.execute();
	}

	static public List<Map<String, Object>> returnAllGroup() {
		String sql = "SELECT * FROM qqgroup";
		SQLDAL sqldal = new SQLDAL(sql);
		return sqldal.execute();
	}

}

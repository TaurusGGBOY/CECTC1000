package ggb.s8.dal;

import java.util.List;
import java.util.Map;

public class SQLDAL {

	private String sql;

	public SQLDAL(String sqlString) {
		sql = sqlString;
	}

	public List<Map<String, Object>> execute() {
		return new MySQLHelper().query(sql);
	}
}

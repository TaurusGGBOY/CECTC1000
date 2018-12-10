package ggb.s8.dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @��Ŀ���ƣ�JavaSQL1
 * @�����ƣ�MySQLHelper
 * @��������mysql������
 * @�����ˣ����ܵļ�˿ @����ʱ�䣺2014-11-25 ����8:58:34 @�޸ı�ע�� @�汾��
 */
public class MySQLHelper {
	private static final String PROPERTIES_NAME = "D:\\eclipse\\workspace\\P2016112462�߹���S8\\src\\ggb\\s8\\dal\\config.properties";
	public static String url = "jdbc:mysql://127.0.0.1/qq"; // ���ݿ�����
	public static String name = "com.mysql.cj.jdbc.Driver"; // ��������
	public static String user = "root"; // �û���
	public static String password = "123456"; // ����
	public static String recordpassword = "";
	public static String autologin = "";
	public static String auto_id = "";
	public static String auto_password = "";
	public static Connection connection = null; // ���ݿ�����
	public static PreparedStatement preparedStatement = null; // ����ѯ�����������

	/**
	 * 
	 * ����һ���µ�ʵ�� DBHelper.
	 * 
	 * @param sql
	 *            : SQL��ѯ���
	 */
	public MySQLHelper() {
		try {
			Properties properties = new Properties();
			properties.load(new InputStreamReader(new FileInputStream(PROPERTIES_NAME), "UTF-8"));
			url = "jdbc:mysql://" + properties.getProperty("host")
					+ "?characterEncoding=GBK&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			recordpassword = properties.getProperty("recordpassword");
			auto_id = properties.getProperty("auto_id");
			auto_password = properties.getProperty("auto_password");
			autologin = properties.getProperty("autologin");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void connection() {
		try {
			Class.forName(name);// ָ����������
			connection = DriverManager.getConnection(url, user, password);// ��ȡ����
		} catch (Exception e) {
			close();
			e.printStackTrace();

		}
	}

	/**
	 * 
	 * @��������: close �� @��������: �ر����ݿ� �� @���� �� @��������: void �� @�����ˣ����ܵļ�˿
	 *        ; @����ʱ�䣺2014-11-25 ����8:58:14�� @throws
	 */
	public void close() {

		try {
			if (connection != null)
				if (!connection.isClosed()) {
					connection.close();
					preparedStatement.close();
					connection = null;
				}
		} catch (SQLException e) {
			System.out.println("�ر����ݿ�������⣡��");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @��������: query �� @��������: ��ѯ���� �� @���� ��@param sql����ѯ������� �� @��������: ResultSet
	 *        :��ѯ������ݼ��� @�����ˣ����ܵļ�˿ ; @����ʱ�䣺2014-11-25 ����8:49:25�� @throws
	 */
	public ResultSet query(String sql) {
		connection();
		ResultSet resultSet = null;

		try {
			preparedStatement = connection.prepareStatement(sql); // ׼��ִ�����
			resultSet = preparedStatement.executeQuery();

		} catch (Exception e) {
			System.out.println("��ѯ�������飡��");
			e.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * 
	 * @��������: executeNonquery �� @��������: ���롢�޸ġ�ɾ���Ȳ��� �� @���� ��@param sql��������� @��������:
	 *        boolean �� @�����ˣ����ܵļ�˿�� @����ʱ�䣺2014-11-25 ����8:45:49�� @throws
	 */
	public boolean executeNonquery(String sql) {
		connection();
		boolean flag = false;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;

		} catch (Exception e) {
			System.out.println("�������ݿ�ʱ���ִ��󣡣�");
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 
	 * @��������: getCount �� @��������: ��ȡ���¼�� �� @���� ��@param sql @���� ��@return @��������: int
	 *        ��¼���� @�����ˣ����ܵļ�˿ ; @����ʱ�䣺2014-11-26 ����2:40:37�� @throws
	 */
	public int getCount(String sql) {
		connection();
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.last();
			count = resultSet.getRow();
			resultSet.close();

		} catch (Exception e) {
			System.out.println("��ѯ�ܼ�¼��ʧ�ܣ���");
			e.printStackTrace();
		}
		return count;
	}

	public void setProperty(String string, String value) {
		Properties properties = new Properties();
		try {
			properties.load(new InputStreamReader(new FileInputStream(PROPERTIES_NAME), "UTF-8"));
			OutputStream fos = new FileOutputStream(PROPERTIES_NAME);
			properties.setProperty(string, value);
			properties.store(fos, "Update value");
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getProperty(String string) {
		Properties properties = new Properties();
		try {
			properties.load(new InputStreamReader(new FileInputStream(PROPERTIES_NAME), "UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rsString = properties.getProperty(string);
		return rsString;
	}
}
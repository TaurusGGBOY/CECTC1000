package ggb.s8.dal;

import java.util.List;
import java.util.Map;

public class AdminDAL {
    static public List<Map<String, Object>> returnAllOL() {
        return new MySQLHelper().query("SELECT * FROM qquser where state = '����'");
    }

    static public List<Map<String, Object>> returnAllRegister() {
        return new MySQLHelper().query("SELECT * FROM qquser");
    }

    static public List<Map<String, Object>> returnAllGroup() {
        return new MySQLHelper().query("SELECT * FROM qqgroup");
    }

    static public void resetPass(String id) {
        new MySQLHelper().executeNonquery("Update qquser SET password='12345' WHERE id='" + id + "'");
    }

    static public void comOff(String id) {
        new MySQLHelper().executeNonquery("Update qquser SET state='����' WHERE id='" + id + "'");
    }

}

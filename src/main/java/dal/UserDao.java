/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modeles.*;

/**
 *
 * @author Fabien
 */
public class UserDao {

    public User loguer(String login, String pwd) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        User user = null;
        try {
            DbOutils dbOutils = new DbOutils();
            connection = dbOutils.connecter();
            ps = connection.prepareStatement("select * from user where login = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (pwd.equalsIgnoreCase(rs.getString("pwd"))) {
                    user = new User();
                    setProperties(user, rs);
                }
            }
            return user;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setProperties(User user, ResultSet rs) throws Exception {
        try {
            user.setIdUser(rs.getInt("id_user"));
            user.setName(rs.getString("name"));
            user.setLogin(rs.getString("login"));
            user.setPwd(rs.getString("pwd"));
        } catch (Exception e) {
            throw e;
        }
    }
}

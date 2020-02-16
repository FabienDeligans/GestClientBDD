/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import javax.naming.*;
import javax.sql.*;

/**
 *
 * @author Fabien
 */
public class DbOutils {
    public Connection connecter()throws Exception{
        Context initCtx, envCtx; 
        DataSource ds; 
        Connection connection; 
        
        try {
            initCtx = new InitialContext(); 
            envCtx = (Context) initCtx.lookup("java:comp/env"); 
            ds = (DataSource) envCtx.lookup("jdbc/GestClient"); 
            connection = ds.getConnection(); 
            return connection; 
        } 
        catch (Exception e) {
            throw e; 
        }
    }
}

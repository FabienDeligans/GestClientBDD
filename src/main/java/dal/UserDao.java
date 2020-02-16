/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import modeles.*;

/**
 *
 * @author Fabien
 */
public class UserDao {
    public User loguer(String login, String pwd){
        User user = null; 
        if((login.equals("admin@chezmoi.fr")) && (pwd.equals("mdp"))){
            user = new User(); 
            user.setIdUser(1);
            user.setName("Administrateur");
        }
        return user; 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import classes.query;
import java.io.Console;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Tarun Bisht
 */
public class Register {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("Employee Leave Manager\n Copyright (C) 2019 Tarun Bisht. All rights reserved");
        System.out.println("\n\t************Register Admin*************\n");
        Console c=System.console();
        String host,port,user,pass,username,password;
        host=c.readLine("Enter Host of database: ");
        port=c.readLine("Enter Port of database: ");
        username=c.readLine("Enter Database Username: ");
        password=new String(c.readPassword("Enter Database Password: "));
        System.out.println("\n\t************Create New Admin, Enter Details*************\n");
        user=c.readLine("Enter Username: ");
        pass=new String(c.readPassword("Enter Password: "));
        String hash_pass = BCrypt.hashpw(pass, BCrypt.gensalt());
        String sql="insert into el_admin (username,password) values (?,?)";
        Object[] data={user,hash_pass};
        if(query.Query(host, port, username, password, sql, data))
        {
            System.out.println("Registeration Success");
        }
        else
        {
            System.out.println("Registeration not Success");
        }
    }
    
}

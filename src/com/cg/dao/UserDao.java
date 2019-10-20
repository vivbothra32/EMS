package com.cg.dao;
/**
 * @project Employee Maintenance System
 * @author Anurag, Pritam, Ruchi, Vivek, Zeeshan
 * @version 1.0
 */
import com.cg.beans.User;

public interface UserDao {

	User validateLogin(User user);

}
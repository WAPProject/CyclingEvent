package com.cs.dao;

import com.cs.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
	/**
	 * 基于Annation的方法仅仅知道就ok
	 * @param user
     * @Description: sign up
	 */
	@Insert("insert into user values (null,#{username},#{password},#{name},#{email})")
	public void addUser(User user);
	/**
	*@Author:Yanlong
	*@Date:4/22/2018_11:26 PM
	*@Description: sign in
	*/
	@Select("select * from user where username=#{username} and password=#{password}")
	public User checkLogin(User user);

	
	@Select("select * from user where id=#{id}")
	public User getUserById(int id);

}

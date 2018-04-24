package com.cs.dao;

import com.cs.entity.Message;
import com.cs.entity.Ride;
import com.cs.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RideMapper {
	/**
	*@Author:Yanlong
	*@Date:4/22/2018_11:42 PM
	*@Description: list ride by status and order
	*/
	@Select("select * from ride where status=#{status} order by begindate ${order}")
	public List<Ride> listRideByStatus(@Param("status")String status, @Param("order")String order);

	@Select("SELECT rideid ,r.route,r.currentlocation,concat (\"\",GROUP_CONCAT(`name`),\"\") as paticipants , concat(\"\", GROUP_CONCAT(u.id), \"\") AS paticipantids FROM user u LEFT JOIN user_ride ur ON u.id = ur.userid LEFT JOIN ride r ON ur.rideid = r.id WHERE r. STATUS = 'flag' group by rideid order by r.begindate ${order}")
	public List<Message> listFlagUserAndMsg(@Param("order")String order);

	/**
	 * @param ride
	 * @Description: add ride
	 */
	@Insert("insert into ride values (null,#{route},#{creatorUserId},#{status},#{currentLocation},#{begindate})")
	public void addRide(Ride ride);

	/**
	 * @param rideid
	 * @Description: get rideinfo
	 */
	@Select("select * from ride where id=#{id}")
	public Ride getRideById(@Param("id")String id);

	/**
	*@Author:Yanlong
	*@Date:4/22/2018_11:44 PM
	*@Description: change status(notstart,inprocessing,flag,end)
	*/
	@Update("update ride set status=#{status} where id=#{id}")
	public void updateStatus(@Param("id")String id,@Param("status")String status);

	/**
	*@Author:Yanlong
	*@Date:4/23/2018_12:29 AM
	*@Description: add to a ride
	*/
	@Insert("insert into user_ride values(null,#{userId},#{rideId}) ")
	public void addToRide(@Param("userId")String userId,@Param("rideId")String rideId);

	@Select("select u.* from user u left join user_ride ur on u.id = ur.userid where rideid=#{rideId}")
	public List<User> listPaticipant(String rideId);

}

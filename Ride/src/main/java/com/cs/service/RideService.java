package com.cs.service;

import com.cs.dao.MybatisUtil;
import com.cs.dao.RideMapper;
import com.cs.entity.Message;
import com.cs.entity.Ride;
import com.cs.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author:Yanlong Wang
 * @Date:${date}_${time}
 * @Description:
 */
public class RideService {
    public List<Ride> listRideByStatus(String status, String order){
        SqlSession session = MybatisUtil.getSqlSession();
        List<Ride>rideList = session.getMapper(RideMapper.class).listRideByStatus(status,order);
        session.commit();
        MybatisUtil.closeSqlSession();
        return rideList;
    }
    public Ride addRide(Ride ride){
        SqlSession session = MybatisUtil.getSqlSession();
        session.getMapper(RideMapper.class).addRide(ride);
        session.commit();
        MybatisUtil.closeSqlSession();
        return ride;
    }

    public Ride getRide(String rideid){
        SqlSession session = MybatisUtil.getSqlSession();
        Ride ride = session.getMapper(RideMapper.class).getRideById(rideid);
        MybatisUtil.closeSqlSession();
        return ride;
    }
    public void updateStatus(String id, String status){
        SqlSession session = MybatisUtil.getSqlSession();
        session.getMapper(RideMapper.class).updateStatus(id,status);
        session.commit();
        MybatisUtil.closeSqlSession();
    }

    public void addToRide(String userId,String rideId){
        SqlSession session = MybatisUtil.getSqlSession();
        session.getMapper(RideMapper.class).addToRide(userId,rideId);
        session.commit();
        MybatisUtil.closeSqlSession();
    }

    public List<User> listPaticipant(String rideId){
        SqlSession session = MybatisUtil.getSqlSession();
        List<User> pList = session.getMapper(RideMapper.class).listPaticipant( rideId);
        session.commit();
        MybatisUtil.closeSqlSession();
        return pList;
    }

    public List<Message> listFlagUserAndMsg(String asc) {
        SqlSession session = MybatisUtil.getSqlSession();
        List<Message> msgList = session.getMapper(RideMapper.class).listFlagUserAndMsg( asc);
        session.commit();
        MybatisUtil.closeSqlSession();
        return msgList;
    }
}

package com.cs.service;

import com.cs.entity.Ride;
import com.cs.util.DateUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author:Yanlong Wang
 * @Date:${date}_${time}
 * @Description:
 */
class RideServiceTest {
    private RideService service ;
    public RideServiceTest() {
        this.service = new RideService();
    }
    @Test
    void listRideByStatus() {
        System.out.println(service.listRideByStatus("notstart","asc"));
        System.out.println(service.listRideByStatus("inprocessing","asc"));
    }

    @Test
    void addRide() {
        Ride ride = new Ride();
        ride.setRoute("O to O");
        ride.setBegindate(DateUtil.getDate("2020-01-07 12:39:44",null));
        ride.setCreatorUserId("1");
        ride.setStatus("notstart");
        service.addRide(ride);
        System.out.println(ride);
    }

    @Test
    void updateStatus() {
        service.updateStatus("1","inprocessing");
        service.updateStatus("2","end");
    }

    @Test
    void addToRide() {
        service.addToRide("1","1");
        service.addToRide("2","1");
    }

    @Test
    void listPaticipant() {
        System.out.println(service.listPaticipant("1"));
    }
}
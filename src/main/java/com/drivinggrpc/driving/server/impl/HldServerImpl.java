package com.drivinggrpc.driving.server.impl;



import com.drivinggrpc.driving.dao.HldDao;
import com.drivinggrpc.driving.po.HLD;
import com.drivinggrpc.driving.server.HldServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HldServerImpl implements HldServer {

    @Autowired
    private HldDao hldDao;

    @Override
    public HLD getHld() {
        List<HLD> list = hldDao.selectAll();
        double random = Math.random();
        int index = (int) (list.size() * random);
        return list.get(index);
    }
}

package com.example.springbootmultipart.Services;

import com.example.springbootmultipart.DAO.TelDao;
import com.example.springbootmultipart.models.Tel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TelService {
    TelDao telDao;


    public void save(Tel tel) {
        telDao.save(tel);
    }
}

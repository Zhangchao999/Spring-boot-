package cn.geoary.service.impl;

import cn.geoary.dao.CornRepository;
import cn.geoary.entity.Corn;
import cn.geoary.service.CornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: java-run-bat
 * @description:
 * @author: Zhangc
 * @create: 2019-06-02 20:52
 **/
@Component("cornService")
@Transactional
public class CornServiceImpl implements CornService {
    @Autowired
    CornRepository cornRepository;
    @Override
    public String getCorn() {
        List<Corn> cornList = cornRepository.findAll();
        String cornStr = cornList.get(0).getCron();
        return cornStr;
    }
}
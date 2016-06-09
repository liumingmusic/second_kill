package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SeckillEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    
    @Resource
    private ISeckillDao seckillDao;
    
    @Test
    public void testQueryById()
        throws Exception {
        long id = 1000;
        SeckillEntity entity = seckillDao.queryById(id);
        System.out.println(entity.getName());
        System.out.println(entity);
    }
    
    @Test
    public void testQueryAll()
        throws Exception {
        List<SeckillEntity> list = seckillDao.queryAll(0, 100);
        for (SeckillEntity seckillEntity : list) {
            System.out.println(seckillEntity);
        }
    }
    
    @Test
    public void testReduceNumber()
        throws Exception {
        Date date = new Date();
        int i = seckillDao.reduceNumber(1000L, date);
        System.out.println("reduceNumber=" + i);
    }
    
}

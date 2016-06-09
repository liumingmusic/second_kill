package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilledEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessSeckilledDaoTest {
    
    @Resource
    private ISuccessSeckilledDao successSeckillDao;
    
    @Test
    public void testInsertSuccessSeckilled()
        throws Exception {
        long seckillId = 1000L;
        long userPhone = 13468833986L;
        int i = successSeckillDao.insertSuccessSeckilled(seckillId, userPhone);
        System.out.println(i);
    }
    
    @Test
    public void testQueryByIdWithSeckill()
        throws Exception {
        long seckillId = 1000L;
        long userPhone = 13468833986L;
        SuccessKilledEntity entity =
            successSeckillDao.queryByIdWithSeckill(seckillId, userPhone);
        System.out.println(entity);
        System.out.println(entity.getSeckillEntity());
    }
    
}

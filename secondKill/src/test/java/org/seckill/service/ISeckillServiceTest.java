/**
 * 文件名：ISeckillServiceTest.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月5日
 * 修改内容：〈修改内容〉
 */
package org.seckill.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.SeckillEntity;
import org.seckill.exception.RepeatKillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
    "classpath:spring/spring-service.xml"})
public class ISeckillServiceTest {
    
    /** 日志对象 */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /** 业务接口对象 */
    @Autowired
    private ISeckillService iSeckillService;
    
    @Test
    public void testGetSeckillList() {
        List<SeckillEntity> list = iSeckillService.getSeckillList();
        logger.info("list={}", list);
    }
    
    @Test
    public void testGetById() {
        long seckillId = 1000;
        SeckillEntity entity = iSeckillService.getById(seckillId);
        logger.info("seckill={}", entity);
    }
    
    @Test
    public void testExportSeckillLogic() {
        long seckillId = 1000;
        Exposer exposer = iSeckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            // 秒杀开启
            logger.info("exposer={}", exposer);
            long userPhone = 13468833988L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution =
                    iSeckillService.executeSeckill(seckillId, userPhone, md5);
                logger.info("result={}", execution);
            }
            catch (RepeatKillException e) {
                logger.error(e.getMessage());
            }
            catch (SecurityException e1) {
                logger.error(e1.getMessage());
            }
        }
        else {
            // 秒杀没有开启
            logger.warn("exposer={}", exposer);
        }
        
    }
}

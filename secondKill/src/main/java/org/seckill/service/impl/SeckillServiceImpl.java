/**
 * 文件名：SeckillServiceImpl.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月4日
 * 修改内容：〈修改内容〉
 */
package org.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.seckill.dao.ISeckillDao;
import org.seckill.dao.ISuccessSeckilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.SeckillEntity;
import org.seckill.entity.SuccessKilledEntity;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseExecption;
import org.seckill.exception.SeckillException;
import org.seckill.service.ISeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉秒杀接口实现类
 * 
 * @author liumingming
 * @version [版本号, 2016年6月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class SeckillServiceImpl implements ISeckillService {
    
    /** 日志对象 */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /** 秒杀dao层接口 */
    @Autowired
    private ISeckillDao seckillDao;
    
    /** 成功秒杀dao层接口 */
    @Autowired
    private ISuccessSeckilledDao successSeckilledDao;
    
    /** 用户混淆MD5 */
    private final String slat =
        "!@W%$%EEHLK&231267854687^&TGIYU$%@#$~#$!@#$$#VHMN<M<POI))";
    
    @Override
    public List<SeckillEntity> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }
    
    @Override
    public SeckillEntity getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }
    
    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        SeckillEntity entity = seckillDao.queryById(seckillId);
        // 1、不存在秒杀记录
        if (entity == null) {
            return new Exposer(false, seckillId);
        }
        // 2、秒杀没有开始或者已经结束
        Date startTime = entity.getStartTime();
        Date endTime = entity.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()
            || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(),
                startTime.getTime(), endTime.getTime());
        }
        // 3、返回秒杀地址，不可逆
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }
    
    @Override
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone,
        String md5)
        throws SeckillException, SeckillCloseExecption, RepeatKillException {
        // 1、判断用户是否篡改MD5
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        // 2、执行秒杀逻辑
        Date nowTime = new Date();
        try {
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                // 秒杀没有执行成功，对于业务来说，秒杀已经关闭
                throw new SeckillCloseExecption("seckill is closed");
            }
            else {
                // 记录购买行为
                int insertCount = successSeckilledDao
                    .insertSuccessSeckilled(seckillId, userPhone);
                // 重复秒杀
                if (insertCount <= 0) {
                    throw new RepeatKillException("seckill repeated");
                }
                else {
                    // 秒杀成功
                    SuccessKilledEntity successKilledEntity =
                        successSeckilledDao.queryByIdWithSeckill(seckillId,
                            userPhone);
                    return new SeckillExecution(seckillId,
                        SeckillStatEnum.SUCCESS, successKilledEntity);
                }
            }
        }
        catch (SeckillCloseExecption e1) {
            throw e1;
        }
        catch (RepeatKillException e2) {
            throw e2;
        }
        catch (Exception e) {
            // 编译器异常,转换成运行期异常
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉私有方法，生成MD5
     * 
     * @param seckillId 秒杀商品id
     * @return md5字符串
     * @see [类、类#方法、类#成员]
     */
    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    
}

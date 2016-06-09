package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilledEntity;

/**
 * 
 * @Title: SuccessSeckilledDao.java
 * @Porject: seckill
 * @Description: 成功秒杀实体信息
 * @Company:明智学堂
 * @author: liumingming
 * @date: 2016年5月29日
 */
public interface ISuccessSeckilledDao {
    
    /**
     * 
     * @Description: 秒杀成功插入语句
     * @param seckillId
     * @param userPhone
     * @return 返回执行成功的条数
     * @author: liumingming
     * @date: 2016年5月29日
     */
    int insertSuccessSeckilled(@Param("seckillId") long seckillId,
        @Param("userPhone") long userPhone);
    
    /**
     * 
     * @Description: 查询秒杀商品根据秒杀商品的id
     * @param seckillId
     * @param userPhone
     * @return 返回查询成功的数据信息
     * @author: liumingming
     * @date: 2016年5月29日
     */
    SuccessKilledEntity queryByIdWithSeckill(@Param("seckillId") long seckillId,
        @Param("userPhone") long userPhone);
    
}

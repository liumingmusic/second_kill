package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.SeckillEntity;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseExecption;
import org.seckill.exception.SeckillException;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉秒杀商品接口类
 * 
 * @author liumingming
 * @version [版本号, 2016年6月1日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ISeckillService {
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉返回秒杀商品列表
     * 
     * @return 列表
     * @see [类、类#方法、类#成员]
     */
    List<SeckillEntity> getSeckillList();
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉秒杀商品详细信息
     * 
     * @param seckillId 秒杀商品id
     * @return 商品信息
     * @see [类、类#方法、类#成员]
     */
    SeckillEntity getById(long seckillId);
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉秒杀开启时，输出秒杀接口地址；否则输入系统时间和秒杀开始时间
     * 
     * @param seckillId 秒杀商品id
     * @return 秒杀商品
     * @see [类、类#方法、类#成员]
     */
    Exposer exportSeckillUrl(long seckillId);
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉秒杀之后的结果信息
     * 
     * @param seckllId 秒杀商品id
     * @param userPhone 用户手机号
     * @param md5 标示码
     * @return 返回秒杀信息实体
     * @see [类、类#方法、类#成员]
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, SeckillCloseExecption, RepeatKillException;
}

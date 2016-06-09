package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SeckillEntity;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉秒杀数据库接口层
 * 
 * @author liumingming
 * @version [版本号, 2016年6月1日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ISeckillDao {
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉秒杀商品减库存
     * 
     * @param seckillId 秒杀商品id
     * @param killTime 秒杀时间
     * @return 执行秒杀操作
     * @throws Exception 系统异常
     * @see [类、类#方法、类#成员]
     */
    int reduceNumber(@Param("seckillId") long seckillId,
        @Param("killTime") Date killTime);
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉根据商品id查询秒杀商品id
     * 
     * @param id 秒杀商品id
     * @return 返回秒杀商品
     * @see [类、类#方法、类#成员]
     */
    SeckillEntity queryById(long id);
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉查询秒杀商品列表
     * 
     * @param offset 偏移量
     * @param limit 区间
     * @return 集合
     * @see [类、类#方法、类#成员]
     */
    List<SeckillEntity> queryAll(@Param("offset") int offset,
        @Param("limit") int limit);
    
}

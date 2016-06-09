package org.seckill.entity;

import java.util.Date;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉秒杀成功实体类
 * 
 * @author liumingming
 * @version [版本号, 2016年6月1日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SuccessKilledEntity {
    
    /** 秒杀商品id */
    private long seckillId;
    
    /** 用户电话 */
    private long userPhone;
    
    /** 状态 */
    private short state;
    
    /** 创建时间 */
    private Date createTime;
    
    /** 一个成功秒杀对应一个秒杀商品信息 */
    private SeckillEntity seckillEntity;
    
    public long getSeckillId() {
        return seckillId;
    }
    
    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }
    
    public long getUserPhone() {
        return userPhone;
    }
    
    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }
    
    public short getState() {
        return state;
    }
    
    public void setState(short state) {
        this.state = state;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public SeckillEntity getSeckillEntity() {
        return seckillEntity;
    }
    
    public void setSeckillEntity(SeckillEntity seckillEntity) {
        this.seckillEntity = seckillEntity;
    }
    
    @Override
    public String toString() {
        return "SuccessKilledEntity [seckillId=" + seckillId + ", userPhone="
            + userPhone + ", state=" + state + ", createTime=" + createTime
            + ", seckillEntity=" + seckillEntity + "]";
    }
    
}

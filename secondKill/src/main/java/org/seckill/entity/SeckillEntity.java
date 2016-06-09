package org.seckill.entity;

import java.util.Date;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉秒杀商品实体类
 * 
 * @author liumingming
 * @version [版本号, 2016年6月1日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SeckillEntity {
    
    /** 秒杀商品id */
    private long seckillId;
    
    /** 秒杀商品名称 */
    private String name;
    
    /** 秒杀商品数量 */
    private int number;
    
    /** 秒杀开始时间 */
    private Date startTime;
    
    /** 秒杀结束时间 */
    private Date endTime;
    
    /** 秒杀创建时间 */
    private Date createTime;
    
    public long getSeckillId() {
        return seckillId;
    }
    
    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Override
    public String toString() {
        return "SeckillEntity [seckillId=" + seckillId + ", name=" + name
            + ", number=" + number + ", startTime=" + startTime + ", endTime="
            + endTime + ", createTime=" + createTime + "]";
    }
}

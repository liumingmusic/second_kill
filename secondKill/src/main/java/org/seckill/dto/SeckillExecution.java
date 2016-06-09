/**
 * 文件名：SeckillExecution.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月1日
 * 修改内容：〈修改内容〉
 */
package org.seckill.dto;

import org.seckill.entity.SuccessKilledEntity;
import org.seckill.enums.SeckillStatEnum;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉封装秒杀执行后的结果
 * 
 * @author liumingming
 * @version [版本号, 2016年6月1日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SeckillExecution {
    
    /** 秒杀商品id */
    private long seckillId;
    
    /** 状态标示 */
    private int state;
    
    /** 状态解释语句 */
    private String stateInfo;
    
    /** 秒杀商品信息 */
    private SuccessKilledEntity successKilledEntity;
    
    public SeckillExecution(long seckillId, SeckillStatEnum statEnum,
        SuccessKilledEntity successKilledEntity) {
        super();
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successKilledEntity = successKilledEntity;
    }
    
    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        super();
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }
    
    public long getSeckillId() {
        return seckillId;
    }
    
    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
    }
    
    public String getStateInfo() {
        return stateInfo;
    }
    
    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
    
    public SuccessKilledEntity getSuccessKilledEntity() {
        return successKilledEntity;
    }
    
    public void setSuccessKilledEntity(
        SuccessKilledEntity successKilledEntity) {
        this.successKilledEntity = successKilledEntity;
    }
    
    @Override
    public String toString() {
        return "SeckillExecution [seckillId=" + seckillId + ", state=" + state
            + ", stateInfo=" + stateInfo + ", successKilledEntity="
            + successKilledEntity + "]";
    }
    
}

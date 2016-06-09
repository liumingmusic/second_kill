/**
 * 文件名：SeckillStatEnum.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月5日
 * 修改内容：〈修改内容〉
 */
package org.seckill.enums;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉秒杀数据字典，枚举
 * 
 * @author liumingming
 * @version [版本号, 2016年6月5日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public enum SeckillStatEnum {
    SUCCESS(1, "秒杀成功"), 
    END(0, "秒杀结束"), 
    REPEAT_KILL(-1, "重复秒杀"), 
    INNER_ERROR(-2, "系统异常"), 
    DATA_REWRITE(-3, "数据篡改"),
    ROBBED_FINISHED(-4,"已被抢完");
    private int state;
    
    private String stateInfo;
    
    private SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    
    public int getState() {
        return state;
    }
    
    public String getStateInfo() {
        return stateInfo;
    }
    
    public static SeckillStatEnum stateOf(int index) {
        for (SeckillStatEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
            
        }
        return null;
    }
}

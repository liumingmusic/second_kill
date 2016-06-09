/**
 * 文件名：Exposer.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月1日
 * 修改内容：〈修改内容〉
 */
package org.seckill.dto;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉暴露秒杀接口实体信息
 * 
 * @author liumingming
 * @version [版本号, 2016年6月1日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Exposer {
    
    /** 是否开启秒杀 */
    private boolean exposed;
    
    /** 加密措施 */
    private String md5;
    
    /** 秒杀商品id */
    private long seckillId;
    
    /** 当前时间 */
    private long now;
    
    /** 开始秒杀时间 */
    private long start;
    
    /** 结束秒杀时间 */
    private long end;
    
    public Exposer(boolean exposed, long seckillId) {
        super();
        this.exposed = exposed;
        this.seckillId = seckillId;
    }
    
    public Exposer(boolean exposed, String md5, long seckillId) {
        super();
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }
    
    public Exposer(boolean exposed, long seckillId, long now, long start,
        long end) {
        super();
        this.exposed = exposed;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }
    
    public boolean isExposed() {
        return exposed;
    }
    
    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }
    
    public String getMd5() {
        return md5;
    }
    
    public void setMd5(String md5) {
        this.md5 = md5;
    }
    
    public long getSeckillId() {
        return seckillId;
    }
    
    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }
    
    public long getNow() {
        return now;
    }
    
    public void setNow(long now) {
        this.now = now;
    }
    
    public long getStart() {
        return start;
    }
    
    public void setStart(long start) {
        this.start = start;
    }
    
    public long getEnd() {
        return end;
    }
    
    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer [exposed=" + exposed + ", md5=" + md5 + ", seckillId="
            + seckillId + ", now=" + now + ", start=" + start + ", end=" + end
            + "]";
    }
    
}

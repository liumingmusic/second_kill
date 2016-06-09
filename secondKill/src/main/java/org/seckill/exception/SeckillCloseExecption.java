/**
 * 文件名：SeckillCloseExecption.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月2日
 * 修改内容：〈修改内容〉
 */
package org.seckill.exception;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉秒杀商品已经被抢完
 * 
 * @author liumingming
 * @version [版本号, 2016年6月2日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SeckillCloseExecption extends SeckillException {
    
    private static final long serialVersionUID = 976183413826855711L;
    
    public SeckillCloseExecption(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
    
    public SeckillCloseExecption(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
    
}

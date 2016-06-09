/**
 * 文件名：SeckillException.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月2日
 * 修改内容：〈修改内容〉
 */
package org.seckill.exception;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉所有秒杀先关异常
 * 
 * @author liumingming
 * @version [版本号, 2016年6月2日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SeckillException extends RuntimeException {
    
    private static final long serialVersionUID = -8181529577964661145L;
    
    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public SeckillException(String message) {
        super(message);
    }
    
}

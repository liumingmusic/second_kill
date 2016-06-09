/**
 * 文件名：RepeatKillException.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月2日
 * 修改内容：〈修改内容〉
 */
package org.seckill.exception;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉重复秒杀异常(运行期异常)
 * 
 * @author liumingming
 * @version [版本号, 2016年6月2日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RepeatKillException extends SeckillException {
    
    private static final long serialVersionUID = 8397838588376825183L;
    
    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public RepeatKillException(String message) {
        super(message);
    }
    
}

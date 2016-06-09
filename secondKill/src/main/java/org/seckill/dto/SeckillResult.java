/**
 * 文件名：SeckillResult.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月6日
 * 修改内容：〈修改内容〉
 */
package org.seckill.dto;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉所有前端ajax返回的数据json格式
 * 
 * @author liumingming
 * @version [版本号, 2016年6月6日]
 * @param <T>
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SeckillResult<T> {
    
    private boolean success;
    
    private T data;
    
    private String error;
    
    public SeckillResult(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }
    
    public SeckillResult(boolean success, String error) {
        super();
        this.success = success;
        this.error = error;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public String getError() {
        return error;
    }
    
    public void setError(String error) {
        this.error = error;
    }
    
}

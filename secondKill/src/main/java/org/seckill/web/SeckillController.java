/**
 * 文件名：SeckillController.java
 * 版权： 小铭科技
 * 描述：〈描述〉
 * 修改时间：2016年6月6日
 * 修改内容：〈修改内容〉
 */
package org.seckill.web;

import java.util.Date;
import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.SeckillEntity;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseExecption;
import org.seckill.service.ISeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 〈一句话功能简述〉
 * 〈功能详细描述〉秒杀控制层
 * 
 * @author liumingming
 * @version [版本号, 2016年6月6日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {
    
    /** 日志对象 */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /** 秒杀业务层接口 */
    @Autowired
    private ISeckillService seckillServce;
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉返回秒杀列表页
     * 
     * @param model 数据信息
     * @return 返回数据信息
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<SeckillEntity> list = seckillServce.getSeckillList();
        model.addAttribute("list", list);
        return "list";
    }
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉秒杀信息详情页
     * 
     * @param seckillId 商品id
     * @param model 实体
     * @return 商品信息
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId,
        Model model) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        SeckillEntity seckill = seckillServce.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉返回秒杀接口地址
     * 
     * @param seckillId 秒杀商品id
     * @return 返回json数据信息
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = {
        "application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(
        @PathVariable("seckillId") Long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillServce.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉执行秒杀功能
     * 
     * @param seckillId 秒杀商品id
     * @param md5 标示位
     * @param userPhone 用户电话号码
     * @return 返回数据信息
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST, produces = {
        "application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(
        @PathVariable("seckillId") Long seckillId,
        @PathVariable("md5") String md5,
        @CookieValue(value = "killPhone", required = false) Long userPhone) {
        // 1、用户没有登录
        if (userPhone == null) {
            return new SeckillResult<SeckillExecution>(false, "未登录");
        }
        // 2、用户登录了
        try {
            SeckillExecution execution =
                seckillServce.executeSeckill(seckillId, userPhone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        }
        // 3、提示用户相应的错误信息
        catch (RepeatKillException e1) {
            SeckillExecution execution =
                new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true, execution);
        }
        catch (SeckillCloseExecption e2) {
            SeckillExecution execution =
                new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(true, execution);
        }
        catch (Exception e) {
            SeckillExecution execution =
                new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(true, execution);
        }
    }
    
    /**
     * 
     * 〈一句话功能简述〉
     * 〈功能详细描述〉返回系统时间
     * 
     * @return 返回服务器当前时间
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time() {
        Date now = new Date();
        return new SeckillResult<Long>(true, now.getTime());
    }
}

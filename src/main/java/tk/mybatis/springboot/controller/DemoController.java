package tk.mybatis.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.springboot.model.Demo;
import tk.mybatis.springboot.service.DemoService;

/**
 * Created by zph on 2017/8/11.
 */

@RestController
public class DemoController extends BaseController {

    DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @RequestMapping("/demo/{id}")
    public Demo dbDemo(@PathVariable("id") Long id) {
        Demo demo = demoService.selectOne(id);
        return demo;
    }

    @RequestMapping("/selectOne2")
    public Demo selectOne2() {
        Demo demo = demoService.selectOne2(1);
        return demo;
    }

    @RequestMapping("/")
    public JSONObject demo() {
        logger.info("demo ........");
        JSONObject data = new JSONObject();
        data.put("code", "1000");
        data.put("msg", "just test 111");
        return data;
    }
}

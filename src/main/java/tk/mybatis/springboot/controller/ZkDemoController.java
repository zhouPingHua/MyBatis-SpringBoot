package tk.mybatis.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.Charset;

/**
 * Created by wenshiliang on 2017/7/11.
 * zk操作demo
 * 详细请谷歌 百度 CuratorFramework api
 */
//@RestController
//@RequestMapping("/zk")
public class ZkDemoController extends BaseController {

    @Autowired
    private CuratorFramework curatorFramework;

    String path = "/test";
    String value = "test";

    @RequestMapping("/create")
    public JSONObject create() {
        JSONObject result = new JSONObject();
        try {
            curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path, value
                    .getBytes(Charset.forName("UTF-8")));
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        result.put("code", "1");
        result.put("msg", "msg");
        return result;
    }

    @RequestMapping("/select")
    public String select() {
        try {
            return new String(curatorFramework.getData().forPath(path), Charset.forName("UTF-8"));
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
        return null;
    }

    @RequestMapping("/delete")
    public void delete() {
        try {
            curatorFramework.delete().forPath(path);
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }
    }
}

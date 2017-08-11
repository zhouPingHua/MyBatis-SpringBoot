package tk.mybatis.springboot.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.springboot.model.Demo;

import java.util.Map;

/**
 * Created by zph  Date：2017/8/11.
 */
public interface DemoMapper extends Mapper<Demo> {
    Demo test(Map<String, Long> param);
}

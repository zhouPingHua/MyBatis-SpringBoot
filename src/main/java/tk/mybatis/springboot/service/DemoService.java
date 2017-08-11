package tk.mybatis.springboot.service;

import tk.mybatis.springboot.model.Demo;

/**
 * Created by zph  Date：2017/8/11.
 */
public interface DemoService {

    Demo selectOne(long id);

    Demo selectOne2(long id);
}

package tk.mybatis.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.mapper.DemoMapper;
import tk.mybatis.springboot.model.Demo;
import tk.mybatis.springboot.service.BaseService;
import tk.mybatis.springboot.service.DemoService;

/**
 * Created by zph  Date：2017/8/11.
 */
@Service
public class DemoServiceImpl extends BaseService implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    //    @Autowired
//    public DemoServiceImpl(DemoMapper demoMapper, RedisTemplate<String, Demo> redisTemplate) {
//        this.demoMapper = demoMapper;
//        this.redisTemplate = redisTemplate;
//    }

    @Override
    public Demo selectOne(long id) {
        logger.info("select one .......");
        Demo result = (Demo)redisTemplate.opsForValue().get("demoServiceImpl.selectOne" + id);
//        Demo result = null;
        if (result == null) {
            Demo demo = new Demo();
            demo.setId(id);
            demo.setAddress("beijing");
            demo.setAge(22);
            demo.setName("been");
            result = demoMapper.selectOne(demo);
            if (result == null) {
                demoMapper.insert(demo);
            }
            redisTemplate.opsForValue().set("demoServiceImpl.selectOne" + id, demo);
        }
        return result;
    }

    @Override
    @Cacheable(value = "selectOne2")
    public Demo selectOne2(long id) {
        Demo demo = new Demo();
        demo.setId(id);
        return demoMapper.selectOne(demo);
    }
}

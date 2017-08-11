package tk.mybatis.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zph  Date：2017/8/11.
 */
@Transactional(rollbackFor = Exception.class)
public abstract class BaseService {
    public Logger logger = LoggerFactory.getLogger(getClass());
}

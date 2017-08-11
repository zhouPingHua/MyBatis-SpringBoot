package tk.mybatis.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zph  Date：2017/8/11.
 */
public abstract class BaseController {
    public Logger logger = LoggerFactory.getLogger(getClass());
}

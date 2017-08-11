package tk.mybatis.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zph  Date：2017/8/11.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"tk.mybatis.springboot"})
@MapperScan(basePackages = "tk.mybatis.springboot.**.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}

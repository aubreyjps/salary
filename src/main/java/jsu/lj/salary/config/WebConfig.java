package jsu.lj.salary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/my").setViewName("my");
        registry.addViewController("/my.html").setViewName("my");
        registry.addViewController("/user/performance.html").setViewName("user/performance");
        registry.addViewController("/user/salary.html").setViewName("user/salary");
        registry.addViewController("/user/userIndex.html").setViewName("user/userIndex");
        registry.addViewController("/admit/admitIndex.html").setViewName("admit/admitIndex");
        registry.addViewController("/admit/salary.html").setViewName("admit/salary");
        registry.addViewController("/admit/performance.html").setViewName("admit/performance");
        registry.addViewController("/admit/info.html").setViewName("admit/info");
        registry.addViewController("/admit/**.action").setViewName("admit/**.action");
        registry.addViewController("/user/**.action").setViewName("user/**.action");
//        registry.addViewController("/user/.html").setViewName("my");

//        registry.addRedirectViewController("/","/login.html");
    }

}

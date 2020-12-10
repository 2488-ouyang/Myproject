package com.ch.ebusiness.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//标注为一个配置类
@Configuration
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取默认的时区和语言

        //从页面中获取参数
        String l = httpServletRequest.getParameter("l");
        //如果存在参数就把默认的时区和语言修改了，不存在则使用默认的
        if (StringUtils.isEmpty(l)) {
            //分割字符串 zh_CN
            Locale locale = Locale.getDefault();
            return locale;

        } else {
            String[] split = l.split("_");
            return new Locale(split[0], split[1]);

        }

    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
    }

    //将组件加入到容器中
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
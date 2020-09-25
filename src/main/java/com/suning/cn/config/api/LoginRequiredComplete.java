package com.suning.cn.config.api;

import com.suning.cn.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by  lzy  on 2020/9/23 11:30
 */
public class LoginRequiredComplete implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        LoginRequired annotation = method.getAnnotation(LoginRequired.class);
        if (ObjectUtils.isEmpty(annotation)){

            String access_token = httpServletRequest.getHeader("token");
            // 判断前台获取的token是否为空
            if (StringUtils.isEmpty(access_token)) {
                throw new RuntimeException("Login:{}获取token异常！");
            }

            Object tokenObj = redisUtils.get(access_token);
            if (ObjectUtils.isEmpty(tokenObj)) {
                throw new RuntimeException("token:{}Redis中的token异常");
            }


            return true;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

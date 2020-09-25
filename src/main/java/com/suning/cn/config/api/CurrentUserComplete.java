package com.suning.cn.config.api;

import com.suning.cn.vo.UsersVo;
import org.springframework.core.MethodParameter;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by  lzy  on 2020/9/23 12:04
 *
 */
public class CurrentUserComplete implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(CurrentUser.class) &&
                methodParameter.getParameterType().isAssignableFrom(UsersVo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        UsersVo usersVo = (UsersVo) nativeWebRequest.getAttribute("loginUsersVo", RequestAttributes.SCOPE_REQUEST);

        if (!ObjectUtils.isEmpty(usersVo)){
            return usersVo;
        }
        return null;
    }

}

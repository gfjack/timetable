package com.education.timetable.config.interceptors;

import com.education.timetable.config.StringResources;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.education.timetable.constants.constants.Constant.AUTHORIZATION;
import static com.education.timetable.constants.constants.Constant.TEMP_PASSWORD;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authorization = request.getHeader(AUTHORIZATION);

        if (!StringUtils.isNumeric(authorization) || !TEMP_PASSWORD.equals(Long.parseLong(authorization))) {
            response.sendError(HttpStatus.FORBIDDEN.value(), StringResources.getString("INCORRECT.CREDENTIALS"));
            return false;
        }

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

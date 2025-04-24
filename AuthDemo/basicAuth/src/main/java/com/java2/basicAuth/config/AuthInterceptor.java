package com.java2.basicAuth.config;

import com.java2.basicAuth.bean.UserBean;
import com.java2.basicAuth.util.MyConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if(requestURI.contains(".")||requestURI.startsWith("/"+ MyConstants.RESOURCE_COMMON+"/")||requestURI.equals("/")){
            return true;
        }
        if(null==request.getSession().getAttribute(MyConstants.FLAG_CURRENTUSER)){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("pleae login first");
            return false;
        }else {
            UserBean currentUser = (UserBean)request.getSession().getAttribute(MyConstants.FLAG_CURRENTUSER);
            if(requestURI.startsWith("/"+MyConstants.RESOURCE_MOBILE+"/")
                    && currentUser.havaPermission(MyConstants.RESOURCE_MOBILE)){
                return true;
            }else if(requestURI.startsWith("/"+MyConstants.RESOURCE_SALARY+"/")
                    && currentUser.havaPermission(MyConstants.RESOURCE_SALARY)){
                return true;
            }else {
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("no auth to visit");
                return false;
            }
        }


    }
}

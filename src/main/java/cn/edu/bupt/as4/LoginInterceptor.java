package cn.edu.bupt.as4;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("++++++++++ preHandle ++++++++++");
        if(request.getSession().getAttribute("loggedIn").equals(true)){
            System.out.println("user access granted");
            return true;
        }
        else{
            System.out.println("user access denied");
            response.sendRedirect("/");
            return false;
        }
    }

}

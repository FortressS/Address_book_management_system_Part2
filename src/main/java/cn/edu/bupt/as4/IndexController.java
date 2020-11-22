package cn.edu.bupt.as4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/loggedIn")
    public ModelAndView loggedIn(){
        return new ModelAndView("loggedIn");
    }

    @PostMapping(value = "/login")
    public String login(HttpSession httpSession,@RequestParam("user") String user, @RequestParam("password") String password){
        if(user.equals("admin")&&password.equals("123456")){
            httpSession.setAttribute("loggedIn",true);
            return "redirect:/loggedIn";
        }
        else {
            httpSession.setAttribute("loggedIn",false);
            return "redirect:/";
        }
    }
}


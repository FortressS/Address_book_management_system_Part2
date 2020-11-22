package cn.edu.bupt.as4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AddressBookController {
    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession){
        httpSession.setAttribute("loggedIn",false);
        return "redirect:/";
    }

    @RequestMapping(value = "/addressList")
    public ModelAndView addressList(HttpSession httpSession, Model model){
        String printStr;
        return new ModelAndView("addressList");
    }

    @RequestMapping(value = "/addNew")
    public ModelAndView addNew(){
        return new ModelAndView("addNewContact");
    }

    @PostMapping(value = "/listAdd")
    public String listAdd(HttpSession httpSession,
                          @RequestParam("name") String name,
                          @RequestParam("tel") String tel,
                          @RequestParam("e-mail") String e_mail,
                          @RequestParam("address") String address,
                          @RequestParam("QQ") String QQ) {
        if(httpSession.getAttribute("listLen") == null){
            httpSession.setAttribute("listLen", 0);
        }
        String atPerson = "person"+httpSession.getAttribute("listLen").toString();
        if(!(name.equals("")&&tel.equals("")&&e_mail.equals("")&&address.equals("")&&QQ.equals(""))) {
            httpSession.setAttribute(atPerson+"name",name);
            httpSession.setAttribute(atPerson+"tel",tel);
            httpSession.setAttribute(atPerson+"e_mail",e_mail);
            httpSession.setAttribute(atPerson+"address",address);
            httpSession.setAttribute(atPerson+"QQ",QQ);
            System.out.println(httpSession.getAttribute("listLen"));
            httpSession.setAttribute("listLen", Integer.parseInt(httpSession.getAttribute("listLen").toString())+1);
        }
        System.out.println(httpSession.getAttribute("listLen"));
        return "redirect:/addressList";
    }

}

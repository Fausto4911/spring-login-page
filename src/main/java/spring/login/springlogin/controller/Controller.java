package spring.login.springlogin.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginRegistration() {
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String homePage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        model.addAttribute("name", name);
        return "home";
    }

}

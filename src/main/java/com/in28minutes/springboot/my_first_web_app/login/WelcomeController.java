package com.in28minutes.springboot.my_first_web_app.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@SessionAttributes("Name")
public class WelcomeController {


    //    @RequestMapping("login")
//    public String login(@RequestParam String name, ModelMap model){
//        model.put("name", name);
//        return "login";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("Name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


}

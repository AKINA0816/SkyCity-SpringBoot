package tv.skycity.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackEndController {
    @RequestMapping("/backend")
    public String login(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // if not login
        if (authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())){
            return "/backend";
        }else { // logined in
            return "redirect:backend/listUser";
        }
    }

//    @RequestMapping("/backend/home")
//    public String data(){
//        return "backend/listUser";
//    }
}

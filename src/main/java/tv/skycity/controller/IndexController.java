package tv.skycity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tv.skycity.util.GetUsernameFromCookie;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String slash(Model model, HttpServletRequest httpServletRequest){
        String username = GetUsernameFromCookie.getUsernameFromCookie(httpServletRequest);
        if (GetUsernameFromCookie.isLoggedIn(username)){
            model.addAttribute("infoAvatar","/CrazyFrog.jpg");
            model.addAttribute("name", username);
        }

        return "index";
    }
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest httpServletRequest){
        String username = GetUsernameFromCookie.getUsernameFromCookie(httpServletRequest);
        if (GetUsernameFromCookie.isLoggedIn(username)){
            model.addAttribute("name", username);
            model.addAttribute("infoAvatar","/CrazyFrog.jpg");
        }
        return "index";
    }

    @RequestMapping("/userSetting")
    public String userSetting(Model model, HttpServletRequest httpServletRequest){
        String username = GetUsernameFromCookie.getUsernameFromCookie(httpServletRequest);
        if (GetUsernameFromCookie.isLoggedIn(username)){
            model.addAttribute("name", username);
            model.addAttribute("infoAvatar","/CrazyFrog.jpg");
        }
        return "userSetting";
    }

    @RequestMapping("/map")
    public String map(Model model, HttpServletRequest httpServletRequest){
        return "map";
    }

}

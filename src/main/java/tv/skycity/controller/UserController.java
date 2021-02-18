package tv.skycity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tv.skycity.mapper.UserMapper;
import tv.skycity.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/register")
    public String addUser(User user){
        userMapper.addUser(user);
        return "index";
    }

    @PostMapping("/login")
        public String login(User user, HttpSession session, HttpServletResponse httpServletResponse, Model model){
        User user1 = userMapper.selectByNameAndPassword(user);
        if (user1 == null){
            // pass
        }else {
            model.addAttribute("name",user1.getName());
            Cookie cookie = new Cookie("username",user1.getName());
            cookie.setMaxAge(24*60*60);  // expire after one day
            httpServletResponse.addCookie(cookie);
        }
        return "index";
    }

    @PostMapping("/findByName")
    @ResponseBody
    public Map<String,Boolean> findByName(HttpServletRequest httpServletRequest){
        String name = httpServletRequest.getParameter("name");
        User user1 = new User();
        user1.setName(name);
        Map<String, Boolean> map = new HashMap<>();

        if (userMapper.selectByName(user1) == null){
            map.put("valid",true);  // 数据库中无此用户名，可以使用
        }else {
            map.put("valid",false);
        }
        return map;
    }

}

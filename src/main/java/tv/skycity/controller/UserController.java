package tv.skycity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tv.skycity.mapper.UserMapper;
import tv.skycity.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/register")
    public String addUser(User user){
        userMapper.addUser(user);
        return "redirect:/index";
    }

    @PostMapping("/login")
    public String login(User user){
        User user1 = userMapper.selectByNameAndPassword(user);
        if (user1 == null){
            return "redirect:/fail";
        }else {
            return "redirect:/index";
        }
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

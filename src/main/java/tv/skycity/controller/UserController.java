package tv.skycity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tv.skycity.mapper.UserMapper;
import tv.skycity.model.User;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/test")
    public List<User> getAll(){
        return userMapper.getAll();
    }

}

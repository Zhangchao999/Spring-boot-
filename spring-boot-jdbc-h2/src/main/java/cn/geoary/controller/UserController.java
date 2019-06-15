package cn.geoary.controller;

import cn.geoary.entity.User;
import cn.geoary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-boot-jdbc-h2
 * @description: user控制层
 * @author: Zhangc
 * @create: 2019-06-15 15:56
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findall")
    public List<User> findAll() {
        return userService.getAll();
    }

    @GetMapping("/add")
    public User addOne() {
        User user = new User("张三", 20, "北京市石景山区");
        return userService.addUser(user);
    }

    @GetMapping("update")
    public User updateOne() {
        User user = userService.getOneById(33);
        user.setName("李四");
        user.setAddress("搬到了山西省太原市");
        return userService.updateUser(user);
    }

    @GetMapping("delete")
    public String deleteOne(){
        try {
            userService.deleteUser(35);
        }catch (Exception e){
            return "删除失败";
        }
        return "删除成功";

    }
}


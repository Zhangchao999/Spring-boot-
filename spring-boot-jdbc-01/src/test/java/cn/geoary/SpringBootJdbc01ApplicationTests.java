package cn.geoary;

import cn.geoary.dao.UserRepository;
import cn.geoary.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbc01ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void initDb(){
        // 添加数据到数据库
        userRepository.save(new User("geoary", "13400000001"));
        userRepository.save(new User("icon man", "15600000000"));
        userRepository.save(new User("Thanos", "17800000000"));
    }

    @Test
    public void test01() {
        // 查询所有数据 调用默认的接口
        List<User> users = userRepository.findAll();
        System.out.println(users);
        // 根据id查询数据 调用默认的接口
        User user = userRepository.findAllById(new Integer(1));
        System.out.println(user);
        // 根据姓名查询数据 调用自己写的接口
        List<User> userList = userRepository.findbyName("Elizabeth Olsen");
        System.out.println(userList);
    }

    @Test
    public void test02(){
        User user = new User("Elizabeth Olsen", "18900000000");
        User userAdded = userRepository.save(user);
        System.out.println(userAdded);
    }

    @Test
    public void test03(){
        userRepository.deleteById(new Integer(11));
    }

    @Test
    public void test04(){
        // 修改之前要先做查询，不然会将未修改过的字段置为空
        User user = userRepository.findAllById(new Integer(10));
        user.setTel("18900000001");
        User userModifyed = userRepository.save(user);
        System.out.println(userModifyed);
    }

    @Test
    @Transactional
    public void test05(){
        userRepository.deleteByUsername("test");
    }
}

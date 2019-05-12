package cn.geoary.dao;

import cn.geoary.entity.User;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @description  UserRepository 继承 JpaRepository， User为仓库中的对象， Integer 为主键类型  JpaRepository 默认未我们提供了很多基本的接口，这里就不需要定义了
 * @param
 * @return
 * @author Zhangc
 * @date 2019/5/11
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    // 此处的User必须为entity中的类名 不能写成 user
    /**
     * @description 根据用户名查询数据
     * @param  username 用户名
     * @return
     * @author Zhangc
     * @date 2019/5/11
     */
    @Query("from User where username=:username")
    List<User> findbyName(@Param("username") String username);

    /**
     * @description 根据id查询数据  Query 默认执行读操作
     * @param id 编号
     * @return
     * @author Zhangc
     * @date 2019/5/11
     */
    @Query("from User where id=:id")
    User findAllById(@Param("id") Integer id);

    /**
     * @description  做update / delete 这类写操作时，要夹@Modifying注解，并且要在调用的方法前加 @Transactional 注解标识进行事务控制
     * @param username 用户名
     * @return
     * @author Zhangc
     * @date 2019/5/11
     */
    @Modifying
    @Query("delete from User where username=:username")
    void deleteByUsername(@Param("username") String username);

}

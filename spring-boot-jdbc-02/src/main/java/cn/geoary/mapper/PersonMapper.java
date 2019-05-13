package cn.geoary.mapper;

import cn.geoary.entity.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PersonMapper {
    @Select("select * from person")
    @Results({
            @Result(property = "name", column = "personname"),
            @Result(property = "age", column = "age")
    })
    List<Person> getList();

    @Select("select * from person where id=#{id}")
    @Results({
            @Result(property = "name", column = "personname"),
            @Result(property = "age", column = "age")
    })
    Person getOneById(Integer id);

    @Insert("insert into person(personname,age) values(#{name}, #{age})")
    void insertPerson(Person person);

    @Update("update person set personname=#{name}, age=#{age} where id=#{id}")
    void updatePerson(Person person);

    @Delete("delete from person where id=#{id}")
    void deletePersonById(Integer id);
}

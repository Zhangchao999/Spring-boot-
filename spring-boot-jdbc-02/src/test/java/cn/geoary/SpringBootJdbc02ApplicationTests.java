package cn.geoary;

import cn.geoary.entity.Person;
import cn.geoary.mapper.PersonMapper;
import cn.geoary.mapper.PersonXmlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbc02ApplicationTests {

    @SuppressWarnings("all")
    @Autowired
    private PersonMapper personMapper;

    @SuppressWarnings("all")
    @Autowired
    private PersonXmlMapper personXmlMapper;

    @Test
    public void test01() {
        personMapper.insertPerson(new Person("geoary", "26"));
        personMapper.insertPerson(new Person("mayun", "40"));
        personMapper.insertPerson(new Person("wangjl", "50"));
    }

    @Test
    public void test02(){
        Person person = personMapper.getOneById(new Integer(3));
        System.out.println(person);
        person.setName("wxz");
        personMapper.updatePerson(person);
        Person person2 = personMapper.getOneById(new Integer(3));
        System.out.println(person2);
    }

    @Test
    public void test03(){
        personMapper.deletePersonById(new Integer(3));
        List<Person> personList = personMapper.getList();
        System.out.println(personList);
    }

    @Test
    public void test04(){
        System.out.println(personMapper.getList());
    }

    @Test
    public void test05(){
        System.out.println(personXmlMapper.getAll());
    }

    @Test
    public void test06(){
        System.out.println(personXmlMapper.getAllMap());
    }

    @Test
    public void test07(){
        System.out.println(personXmlMapper.getOneByName("geoary"));
    }

    @Test
    public void test08(){
        HashMap personMap = new HashMap();
        personMap.put("name", "zhaoyun");
        personMap.put("age", "300");
        personXmlMapper.insertPerson(personMap);
    }

    @Test
    public void test09(){
        HashMap personMap = new HashMap();
        personMap.put("name", "caocao");
        personMap.put("age", "299");
        personMap.put("id", "3");
        personXmlMapper.updatePerson(personMap);
    }

    @Test
    public void test10(){
        personXmlMapper.deletePerson(new Integer(3));
    }

}

package cn.geoary.mapper;

import cn.geoary.entity.Person;

import java.util.HashMap;
import java.util.List;

public interface PersonXmlMapper {
    List<Person> getAll();

    List<HashMap> getAllMap();

    List<HashMap> getOneByName(String name);

    void insertPerson(HashMap hashMap);

    void updatePerson(HashMap hashMap);

    void deletePerson(Integer id);
}

package br.com.erudio.mapper.custom;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setGender(person.getGender());
        vo.setAddress(person.getAddress());
        vo.setLastName(person.getLastName());
        vo.setFirstName(person.getFirstName());
        vo.setBirthDay(new Date());
        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 entity){
        Person person = new Person();
        person.setId(entity.getId());
        person.setGender(entity.getGender());
        person.setAddress(entity.getAddress());
        person.setLastName(entity.getLastName());
        person.setFirstName(entity.getFirstName());
        return person;
    }
}

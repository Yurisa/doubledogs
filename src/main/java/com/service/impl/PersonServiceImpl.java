package com.service.impl;

import com.dao.PersonDao;
import com.entity.Person;
import com.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yurisa on 2017/5/24.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService{
    @Resource
    PersonDao persondao;

    @Override
    public List<Person> getPersonList(){
      return persondao.querylist();
    }
    public boolean checkUser(String email,String password){
        return persondao.checkUser(email,password);
    }
    @Override
    public Person getPerson(String email){
        return persondao.getPerson(email);
    }
    @Override
    public int getTotalCollectNum(int p_id){
        return persondao.getTotalCollectNum(p_id);
    }
    @Override
    public void addPerson(Person person){
        persondao.addPerson(person);
        return;
    }
    @Override
    public void deleteCollection(int f_id,int p_id){
        persondao.deletefp(f_id,p_id);
        return;
    }

}

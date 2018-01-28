package com.service;

import com.entity.Person;

import java.util.List;

/**
 * Created by Yurisa on 2017/5/24.
 */

public interface PersonService {

    public List<Person> getPersonList();
    public boolean checkUser(String email,String password);
    public Person getPerson(String email);
    public int getTotalCollectNum(int p_id);
    public void addPerson(Person person);
    public void deleteCollection(int f_id,int p_id);
}

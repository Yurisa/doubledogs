package com.dao.impl;

import com.dao.PersonDao;
import com.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yurisa on 2017/5/24.
 */
@Repository("personDao")
public class PersonDaoImpl implements PersonDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final RowMapper<Person> personRowMapper = new BeanPropertyRowMapper<Person>(Person.class);

    public static final String baseColumn = " p_id,email,password ";
    @Override
    public List<Person> querylist() {
        String sql = "select"+baseColumn+" from person order by p_id desc";
        List<Person> list = jdbcTemplate.query(sql,personRowMapper);
        return list;
    }

    @Override
    public boolean checkUser(String email, String password) {
        String sql = "select count(*) from person where email=? and password=?";
        int count = jdbcTemplate.queryForObject(sql,Integer.class,new Object[]{email,password});
        return count > 0;
    }

    @Override
    public Person getPerson(String email) {
        String sql = "select" + baseColumn +"from person where email=?";
        try{
            Person person = jdbcTemplate.queryForObject(sql,personRowMapper,new Object[]{email});
            return person;
        }catch (EmptyResultDataAccessException empty){
            return null;
        }
    }

    @Override
    public int getTotalCollectNum(int p_id){
        String sql = "select count(*)from fp where p_id=?";
        int count = jdbcTemplate.queryForObject(sql,Integer.class,new Object[]{p_id});
        return count;
    }
    @Override
    public void addPerson(Person person){
        String sql = "insert into person(email,password) values(?,?)";
        List list = new ArrayList();
        list.add(person.getEmail());
        list.add(person.getPassword());
        jdbcTemplate.update(sql,list.toArray());
        return;
    }
   @Override
   public  void deletefp(int f_id,int p_id){
        String sql = "delete from fp where f_id=? and p_id=?";
        jdbcTemplate.update(sql,new Object[]{f_id,p_id});
        return;
   }
}

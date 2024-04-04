package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long>{

    List<User> findAll();

}

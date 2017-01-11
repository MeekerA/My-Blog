package com.codeup;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Austin on 1/11/17.
 */
public interface Users extends CrudRepository<User, Long> {

    public User findByUsername(String username);

}

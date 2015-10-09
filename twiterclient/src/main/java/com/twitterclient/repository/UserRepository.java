package com.twitterclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitterclient.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}

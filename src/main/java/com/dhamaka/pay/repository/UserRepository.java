package com.dhamaka.pay.repository;

import com.dhamaka.pay.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

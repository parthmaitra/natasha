package com.ppm.app.natasha.reposotories;

import com.ppm.app.natasha.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}

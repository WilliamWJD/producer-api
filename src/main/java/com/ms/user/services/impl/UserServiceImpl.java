package com.ms.user.services.impl;

import com.ms.user.domain.User;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import com.ms.user.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserServiceImpl(final UserRepository userRepositoryImpl, final UserProducer userProducer){
        this.userRepository = userRepositoryImpl;
        this.userProducer = userProducer;
    }
    @Override
    public User save(User user) {
        user = userRepository.save(user);
        userProducer.publishMessageEmail(user);
        return user;
    }
}

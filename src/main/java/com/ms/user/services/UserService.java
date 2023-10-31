package com.ms.user.services;

import com.ms.user.domain.User;

public interface UserService {
    /**
     * Save user.
     *
     * @return the user
     */
    User save(User user);
}

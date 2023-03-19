package com.tapan.movieBookingSystem.services;

import com.tapan.movieBookingSystem.Entities.User;
import com.tapan.movieBookingSystem.Exceptions.UserDetailsNotFound;
import com.tapan.movieBookingSystem.Exceptions.UserNameAlreadyExists;
import com.tapan.movieBookingSystem.Exceptions.UserTypeDetailsNotFound;

public interface UserService {
    /**
     * Save user details
     */
    public User saveUserDetails(User user) throws UserNameAlreadyExists;

    /**
     * get user detail
     */
    public User getUserDetails(User user) throws UserDetailsNotFound;

    public User getUserDetailsByUsername(String username) throws UserDetailsNotFound;

    /**
     * Update User
     * @param id
     * @param user
     * @return
     * @throws UserNameAlreadyExists
     * @throws UserDetailsNotFound
     * @throws UserTypeDetailsNotFound
     */
    public User updateUserDetails(int id, User user) throws UserNameAlreadyExists, UserDetailsNotFound, UserTypeDetailsNotFound;


}

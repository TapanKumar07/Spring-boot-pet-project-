package com.tapan.movieBookingSystem.services.Implementations;

import com.tapan.movieBookingSystem.Entities.User;
import com.tapan.movieBookingSystem.Exceptions.UserDetailsNotFound;
import com.tapan.movieBookingSystem.Exceptions.UserNameAlreadyExists;
import com.tapan.movieBookingSystem.Exceptions.UserTypeDetailsNotFound;
import com.tapan.movieBookingSystem.dao.UserDao;
import com.tapan.movieBookingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class userImpl implements UserService {

    @Autowired
    private UserDao _userdao;

    @Override
    public User saveUserDetails(User user) throws UserNameAlreadyExists {

        User user_find =  _userdao.findByUsername(user.getUsername());
        if(user_find != null) throw new UserNameAlreadyExists("UserName Already Exists");

       return _userdao.save(user);
    }

    @Override
    public User getUserDetails(User user) throws UserDetailsNotFound {
        return _userdao.findById(user.getUserId()).orElseThrow(() -> new UserDetailsNotFound("No User Exists"));
    }

    @Override
    public User getUserDetailsByUsername(String username) throws UserDetailsNotFound {
        User user_find =  _userdao.findByUsername(username);
        if(user_find == null) throw new UserDetailsNotFound("User Details Not Found");
        return user_find;
    }

    @Override
    public User updateUserDetails(int id, User user) throws UserNameAlreadyExists, UserDetailsNotFound, UserTypeDetailsNotFound {
        User retrived_user = _userdao.findById(id).orElseThrow(() -> new UserDetailsNotFound("No User Exists"));
        System.out.println("retrived " + retrived_user);
        User user_find =  _userdao.findByUsername(user.getUsername());
        if(user_find != null) throw new UserNameAlreadyExists("UserName Already Exists");

        //retrived_user.setUserId(user.getUserId());
        retrived_user.setPassword(user.getPassword());
        //retrived_user.setUsername(user.getUsername());
        retrived_user.setDateOfBirth(user.getDateOfBirth());
        retrived_user.setFirstName(user.getFirstName());
        retrived_user.setLastName(user.getLastName());

        System.out.println(retrived_user);

        return _userdao.save(retrived_user);
    }
}

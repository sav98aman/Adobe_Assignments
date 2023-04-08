package com.app.ServiceIntegration;

import com.app.model.UpdateDto;
import com.app.model.User;
import com.app.repointegration.BaseResponse;

import java.util.List;

public interface UserService {

    public BaseResponse createUser(User user) throws Exception;

    public User getUserByID(Integer userId) throws Exception;

    public User updateUserNameorBioById(Integer userId, UpdateDto updateDto) throws Exception;

    public String deleteUserByID(Integer userId) throws Exception;

    public Integer getTotalNumberOFUser() throws Exception;//GET /analytics/users: Retrieve the total number of users.

    public List<User> getTopFiveUserBassedOnTopPost() throws Exception;//GET /analytics/users: Retrieve the total number of users.


}

package com.app.ServiceIntegration.implementation;

import com.app.ServiceIntegration.UserService;
import com.app.model.UpdateDto;
import com.app.model.User;
import com.app.repointegration.BaseResponse;
import com.app.repointegration.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public BaseResponse createUser(User user) throws Exception {
        BaseResponse res = new BaseResponse();
        Optional<User> optUser = userDao.findByEmail(user.getEmail());
        if (optUser.isPresent()) {
            Map<String, String> map = new HashMap<>();
            res.setStatus(false);
            map.put("message", user.getEmail() + "    Email id Is Already Present ");
            res.setData(map);
            return res;
        }
        user.setCreateAtTime(LocalDateTime.now());
        User newUser = userDao.save(user);

        res.setData(true);
        res.setData(newUser);
        return res;

    }

    @Override
    public User getUserByID(Integer userId) throws Exception {
        Optional<User> user = userDao.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception(userId+" this User Id Is Not Persent !");
        }
    }
    @Override
    public User updateUserNameorBioById(Integer userId, UpdateDto updateDto) throws Exception {
        User user=getUserByID(userId);
        // update UserName and bio
        user.setUserName(updateDto.getUserName());
        user.setBio(updateDto.getBio());
        return userDao.saveAndFlush(user);//change Done
    }

    @Override
    public String deleteUserByID(Integer userId) throws Exception {
        User user =getUserByID(userId);
        if(user==null){
            throw new Exception("user Is Not Persent !" );
        }
        userDao.delete(user);
        return "Succesfully Delete this user id "+userId;
    }

    @Override
    public Integer getTotalNumberOFUser() throws Exception {
        Integer noOfUser=userDao.findAll().size();
        if(noOfUser==0){
            throw new Exception(" No Any user Is Persent !");
        }
        return noOfUser;
    }

    @Override
    public List<User> getTopFiveUserBassedOnTopPost() throws Exception {
        return null;
    }
}

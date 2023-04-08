package com.app.controllerintegraion;


import com.app.ServiceIntegration.UserService;
import com.app.model.UpdateDto;
import com.app.model.User;
import com.app.repointegration.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<Object> createNewUser(@RequestBody User user) throws Exception {
        return  BaseResponse.responseBuilderObject("success",userService.createUser(user), HttpStatus.resolve(200));
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Object> getUserByID(@RequestParam("id") Integer id) throws Exception {
        return BaseResponse.responseBuilderObject("success",userService.getUserByID(id),HttpStatus.resolve(200));
    }
    @PutMapping("/users")
    public ResponseEntity<Object> updateUserNameAndBioByUserId(@RequestParam("id") Integer id,@RequestBody UpdateDto updateDto) throws Exception {

        User updateuser=userService.updateUserNameorBioById(id,updateDto);
        if(updateuser.getUserName().equalsIgnoreCase(updateDto.getUserName())&& updateuser.getBio().equalsIgnoreCase(updateDto.getBio())){
            return BaseResponse.responseBuilderObject("success",updateuser,HttpStatus.ACCEPTED);
        }else{
            return BaseResponse.responseBuilderObject("error","",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/users")
    public ResponseEntity<Object> deleteUserByID(@RequestParam("id") Integer id) throws Exception {
        String deleteUserByID=userService.deleteUserByID(id);
        return BaseResponse.responseBuilderObject("success",deleteUserByID,HttpStatus.OK);
    }

    @GetMapping("/analytics/users")
    public ResponseEntity<Object> countNoOfUser() throws Exception {
        Integer totalNumberofUser=userService.getTotalNumberOFUser();
        return BaseResponse.responseBuilderObject("success",totalNumberofUser,HttpStatus.OK);
    }

    @GetMapping("/analytics/users/top-active")
    public ResponseEntity<Object> topFiveActiveUserbassedOnPost() throws Exception {
        List<User> topFiveUser=userService.getTopFiveUserBassedOnTopPost();
        return BaseResponse.responseBuilderObject("success",topFiveUser,HttpStatus.OK);
    }



}

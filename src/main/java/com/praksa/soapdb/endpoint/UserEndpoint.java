package com.praksa.soapdb.endpoint;

import allapis.praksa.com.user.InsertUserRequest;
import allapis.praksa.com.user.InsertUserResponse;
import allapis.praksa.com.user.RetrieveUserByEmailRequest;
import allapis.praksa.com.user.RetrieveUserByEmailResponse;
import com.praksa.soapdb.model.User;
import com.praksa.soapdb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://com.praksa.allapis/user";

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "insertUserRequest")
    @ResponsePayload
    public InsertUserResponse insertUser(@RequestPayload InsertUserRequest request){
        InsertUserResponse response = new InsertUserResponse();

        User user = new User();

        BeanUtils.copyProperties(request.getUser(), user);
        userService.AddUser(user);

        response.setMessage("Content Added Successfully");

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "retrieveUserByEmailRequest")
    @ResponsePayload
    public RetrieveUserByEmailResponse getUserByEmail(@RequestPayload RetrieveUserByEmailRequest request){
        RetrieveUserByEmailResponse response = new RetrieveUserByEmailResponse();

        String email = request.getEmail();

        User user = userService.getUser(email);

        allapis.praksa.com.user.User soapUser = new allapis.praksa.com.user.User();
        soapUser.setId(user.getId().intValue());
        soapUser.setEmail(user.getEmail());
        soapUser.setName(user.getName());
        response.setUser(soapUser);


        return response;
    }
}

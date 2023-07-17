package com.example.springws.soap;

import com.example.springws.services.UserService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import stubs.com.example.springws.ws.user_service.*;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://springws.example.com/ws/user-service";
    private UserService userService;
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        User user = userService.getUserByFirstnameAndLastname(request.getFirstname(), request.getLastname());
        if (user == null) {
            user = User.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .age(37)
                    .address(Address.builder()
                            .street("123 Main St")
                            .city("Artesia")
                            .state(Statecode.CA)
                            .zip(90701)
                            .build())
                    .build();
        }
        GetUserResponse response = new GetUserResponse();
        response.setUser(user);
        return response;
    }
}

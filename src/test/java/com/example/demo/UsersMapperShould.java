package com.example.demo;

import com.example.demo.pojos.User;
import com.example.demo.pojos.UserResponse;
import com.example.demo.pojos.UserStatus;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsersMapperShould {

    private UsersMapper mapper;
    private User userInput;
    private UserResponse expectedOutput;

    @Before
    public void setup() {
        mapper = new UsersMapper();
        userInput = new User("Petros", "Efthymiou", 40, UserStatus.PLATINUM);
        userInput.setId(1);
        expectedOutput = new UserResponse(1, "Petros", "Efthymiou", 40, "platinum");
    }

    @Test
    public void mapUserToUserResponse() {
        UserResponse output = mapper.mapUserToUserResponse(userInput);
        Assert.assertThat(expectedOutput, Matchers.samePropertyValuesAs(output));
    }
}

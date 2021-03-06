package com.tutorpro;

import com.tutorpro.model.User;
import com.tutorpro.services.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class UserServiceTests {
	User user = new User();

	@Autowired
	private UserService userService;

	@BeforeAll
	void setUp() {
		user.setEmail("UnitTest@test.com");
		user.setName("UnitTestUser");
		user.setUserType("student");
		user.setPassword("UnitTest");
	}

	@Test
	@Order(1)
	void testSuccessfulUserCreation() {
		Assertions.assertEquals("User created successfully", userService.createNewUser(user));
	}

	@Test
	@Order(2)
	void testDuplicateUserNotAllowed() {
		Assertions.assertEquals("User already exists", userService.createNewUser(user));
	}

	@Test
	@Order(3)
	void testValidAuthentication() {
		HashMap testUserInfo = new HashMap<>();
		testUserInfo.put("userEmail", user.getEmail());
		testUserInfo.put("userName", user.getName());
		testUserInfo.put("userType", user.getUserType());
		Assertions.assertEquals(testUserInfo, userService.authenticateUserCredentials(user));
	}

	@Test
	@Order(4)
	void testInvalidAuthentication() {
		user.setPassword("bad password");
		HashMap testUserInfo = new HashMap<>();
		testUserInfo.put("userEmail", user.getEmail());
		testUserInfo.put("userName", user.getName());
		testUserInfo.put("userType", user.getUserType());
		Assertions.assertEquals("Username or password is incorrect", userService.authenticateUserCredentials(user));
	}

	@AfterAll
	void deleteUser() {
		userService.deleteUser(user.getEmail());
	}

}

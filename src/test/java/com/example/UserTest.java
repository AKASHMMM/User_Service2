package com.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Entity.User;
import com.example.Repository.UserRespository;
import com.example.Service.Implementation.UserServiceImplementation;




@SpringBootTest
public class UserTest {

    @Mock
    private UserRespository userRepo;

    @InjectMocks
    private UserServiceImplementation userService;
    
    private User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUserName("john");
        user.setPassword("john123");
        user.setEmail("john@example.com");
        user.setUserId(1);
    }

    @Test
    public void testAddUser() {
        // Mock repository method
        when(userRepo.save(any(User.class))).thenReturn(user);
        
        // Call the service method
        User addedUser = userService.addUser(user);
        
        // Verify the result
        assertNotNull(addedUser);
        assertEquals(user, addedUser);
        
        // Verify that the repository method was called
        verify(userRepo, times(1)).save(user);  
    }
    @Test
    public void testDeleteUserById() {
        // Given
        int id = 1;
        User user = new User();
        user.setUserId(id);

        doReturn(Optional.of(user)).when(userRepo).findById(eq(id));
        doNothing().when(userRepo).delete(eq(user));

        // When
        String result = userService.deleteUser(id);

        // Then
        assertEquals("ID deleted successfully", result);
        verify(userRepo).findById(eq(id));
        verify(userRepo).delete(eq(user));
    }

    
    @Test
    public void testUpdateUser() {
        // Given
        int id = 1;
        User existingUser = new User();
        existingUser.setUserId(id);
        existingUser.setUserName("akash237");
        existingUser.setPassword("password1");
        existingUser.setMobileNumber("9876543210");
        existingUser.setEmail("akash237@gmail.com");

        User updatedUser = new User();
        updatedUser.setUserId(id);
        updatedUser.setUserName("userUpdated");
        updatedUser.setPassword("updatedPassword");
        updatedUser.setMobileNumber("MobileNumber Updated");
        updatedUser.setEmail("userUpdated@example.com");

        doReturn(Optional.of(existingUser)).when(userRepo).findById(eq(id));
        doReturn(updatedUser).when(userRepo).save(any(User.class));

        // When
        User result = userService.updateUser(updatedUser, id);

        // Then
        assertEquals(updatedUser, result);
        verify(userRepo).findById(eq(id));
        verify(userRepo).save(any(User.class));
    }
    

    @Test
    public void testGetUserById() {
        
        // Given
        int id = 1;
        User user = new User();
        user.setUserId(id);
        user.setUserName("john");
        user.setPassword("john123");
        user.setMobileNumber("9090909090");
        user.setEmail("john@example.com");

        doReturn(Optional.of(user)).when(userRepo).findById(eq(id));

        // When
        User result = userService.getUserByid(id);

        // Then
        assertNotNull(result);
        assertEquals(user, result);
        verify(userRepo).findById(eq(id));
    }

    @Test
    public void testGetUserByEmail() {
        // Given
        String email = "john@example.com";
        User user = new User();
        user.setUserId(1);
        user.setUserName("john");
        user.setPassword("john123");
        user.setMobileNumber("9090909090");
        user.setEmail(email);

        doReturn(Optional.of(user)).when(userRepo).findByEmail(eq(email));

        // When
        User result = userService.getUserByEmail(email);

        // Then
        assertNotNull(result);
        assertEquals(user, result);
        verify(userRepo).findByEmail(eq(email));
    }

}
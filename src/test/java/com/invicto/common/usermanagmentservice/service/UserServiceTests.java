package com.invicto.common.usermanagmentservice.service;

import com.invicto.common.usermanagmentservice.entity.UserDetail;
import com.invicto.common.usermanagmentservice.exception.UserAlreadyExistException;
import com.invicto.common.usermanagmentservice.exception.UserNotFoundException;
import com.invicto.common.usermanagmentservice.repository.UserDetailRepository;
import com.invicto.common.usermanagmentservice.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static  org.mockito.Mockito.when;
import static  org.mockito.Mockito.doNothing;

import java.util.Date;
import java.util.Optional;

@RunWith(JUnit4.class)
public class UserServiceTests {

    @InjectMocks
    private UserServiceImpl testObj;

    private UserDetailRepository mockedUserRepo = Mockito.mock(UserDetailRepository.class);


    @Before
    public void setUp(){
        UserDetail mockedUser = new UserDetail();
        mockedUser.setUserName("testUser");
        mockedUser.setPassword("testPassword");
        mockedUser.setLocked(false);
        mockedUser.setLastPasswordChangedDate(new Date());
        mockedUser.setFailedLoginCount(0);
        mockedUser.setUserId(1);
        when(mockedUserRepo.findByUserName("testUser")).thenReturn(mockedUser);
        when(mockedUserRepo.findByUserName("testUser1")).thenReturn(null);
        when(mockedUserRepo.findById(1)).thenReturn(Optional.of(mockedUser));
        doNothing().when(mockedUserRepo.save(Mockito.any()));
        when(mockedUserRepo.findById(2)).thenReturn(Optional.of(null));
        when(mockedUserRepo.existsById(1)).thenReturn(true);
        when(mockedUserRepo.existsById(2)).thenReturn(false);


    }

    @Test
    public void  testDeleteById(){


    }

    @Test
    public void testCreateNewUserWithValidInput(){

    }

    @Test
    public void testCreateNewUserWithInvalidInput(){

    }
    @Test()
    public void testCreateNewUserwithValidInputAndUserExists(){

    }
    @Test
    public void testCreateNewUserwithValidInputAndUserNotExists(){

    }
    @Test
    public void testUpdatePasswordWithValidInput(){

    }
    @Test
    public void testUpdatePasswordWithInValidInput(){

    }
    @Test()
    public void testUpdatePasswordWithUserNotExists(){

    }
    @Test()
    public void testUnlockPasswordForUserNotExists(){

    }
    @Test()
    public void testUnlockPasswordForUserExists(){

    }
    
}

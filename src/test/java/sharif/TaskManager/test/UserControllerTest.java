package sharif.TaskManager.test;

import org.junit.*;
import org.junit.runner.*;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.http.MediaType.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sharif.Taskmanager.TaskmanagerApplication;
import sharif.Taskmanager.controller.UserController;
import sharif.Taskmanager.entity.RequestObject;
import sharif.Taskmanager.entity.User;
import sharif.Taskmanager.manager.UserManager;


import javax.validation.constraints.Null;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TaskmanagerApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserManager service;

    @Test
    public void createUserTests()
        throws Exception {
            User mockedUser = new User();
            mockedUser.setEmail("sobhan@gentoo.org");
            mockedUser.setHashedPassword("1234");
            mockedUser.setUserName(null);
            mockedUser.setPhoneNumber(null);
            mockedUser.setID(null);

            RequestObject requestObject = new RequestObject();
            requestObject.setContent(mockedUser);

            String emailPattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0" +
                    "-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

            when(service.addUser(anyObject())).thenAnswer(
                    new Answer() {
                        public Object answer(InvocationOnMock invocation) {
                            Object[] args = invocation.getArguments();
                            Object mock = invocation.getMock();
                            RequestObject req = (RequestObject) args[0];
                            User u = (User) req.getContent();
                            if (
                                    u.getEmail().matches(emailPattern) &&
                                    u.getHashedPassword().length() == 128
                            )
                                return "11";
                            else
                                return "-1";
                        }

            });


            mvc.perform(post("/user/signup")

                    .accept(APPLICATION_JSON)
                    .content(
                            "{\"" +
                                    "email\": \"sobhan@gentoo.org\"," +
                                    "\"hashedPassword\":\"d404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9" +
                                    "de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db\"" +
                            "}")
                    .contentType(APPLICATION_JSON)
            )
                    .andExpect(status().isOk())
                    .andExpect(content().string("11"));

            verify(service, times(1))
                    .addUser(anyObject());

    }
}

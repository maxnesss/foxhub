package com.gfa.foxbook.foxbook.controllers;

import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.security.jwt.JwtUtils;
import com.gfa.foxbook.foxbook.services.interfaces.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private UserService userService;

    @Mock
    private JwtUtils jwtUtils;

    // Test for GET /api/v1/user/person
    @Test
    public void testGetUser() throws Exception {
        // Set up mock behavior
        User mockUser = new User();
        when(jwtUtils.getUserFromRequest(any())).thenReturn(mockUser);

        // Perform the GET request
        ResultActions resultActions = mockMvc.perform(get("/api/v1/user/person"));

        // Verify the response
        resultActions.andExpect(status().isOk());
        verify(jwtUtils, times(1)).getUserFromRequest(any());
    }

    // Test for DELETE /api/v1/user/people
    @Test
    public void testDeletePerson() throws Exception {
        // Set up mock behavior
        User mockUser = new User();
        when(jwtUtils.getUserFromRequest(any())).thenReturn(mockUser);

        // Perform the DELETE request
        ResultActions resultActions = mockMvc.perform(delete("/api/v1/user/people"));

        // Verify the response
        resultActions.andExpect(status().isNoContent());
        verify(userService, times(1)).delete(any());
    }

    // Test for PATCH /api/v1/user/people
    @Test
    public void testUpdateUserByNickname() throws Exception {
        // Set up mock behavior
        User mockUser = new User();
        User updateDTO = new User();
        when(jwtUtils.getUserFromRequest(any())).thenReturn(mockUser);

        // Perform the PATCH request
        ResultActions resultActions = mockMvc.perform(patch("/api/v1/user/people")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateDTO)));

        // Verify the response
        resultActions.andExpect(status().isOk());
        verify(userService, times(1)).updateProfile(any(), any());
    }
}

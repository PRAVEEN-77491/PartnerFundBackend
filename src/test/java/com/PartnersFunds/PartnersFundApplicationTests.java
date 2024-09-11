package com.PartnersFunds;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.PartnersFunds.PartnersFundApplication;
import com.PartnersFunds.dto.UserCredentialsDTO;
import com.PartnersFunds.entities.UserEntity;
import com.PartnersFunds.utils.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PartnersFundApplication.class)
@AutoConfigureMockMvc
public class PartnersFundApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtUtil jwtUtil;
    
    private ObjectMapper mapper = new ObjectMapper();

//    @Test
//    public void testSignup() throws Exception {
//        UserEntity user = new UserEntity();
//        user.setCiscoCecId("hrjaiswa");
//        user.setPassword("password123");
//        user.setEmailAddress("hrjaiswa@cisco.com");
//        String json = "{\"ciscoCecId\":\"hrjaiswa\",\"password\":\"password123\",\"email\":\"hrjaiswa@cisco.com\"}";
//
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/signup")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        String responseContent = result.getResponse().getContentAsString();
//        System.out.println("responseContent===> "+responseContent);
//        UserEntity responseUser = mapper.readValue(responseContent, UserEntity.class);
//        assertEquals(user.getCiscoCecId(), responseUser.getCiscoCecId());
//        assertEquals(user.getEmailAddress(), responseUser.getEmailAddress());
//        assertEquals(user.getPassword(), responseUser.getPassword());
//    }

    @Test
    public void testValidLogin() throws Exception {
        String json = "{\"ciscoCecId\":\"hrjaiswa\",\"password\":\"password123\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }

    @Test
    public void testUpdateRole() throws Exception {
        String token = jwtUtil.generateToken("hrjaiswa", new String[] {"ROLE_Collaborator"});
        String json = "[\"ROLE_Participant\"]";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/updateRole")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetFundDetails() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getFundDetails"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetRoleDetails() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getRoleDetails"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetFundroleDetails() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getFundRoleDetails"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetManageFundPagesDetails() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getManageFundPagesDetails"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetManageFundTablesDetails() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getManageFundTablesDetails"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetManageFundTablesAttrDetailsId() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getManageFundTablesAttrDetailsId")
                .param("table_id", "1")) // Replace with a valid table_id
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetManagePageFeaturesDetails() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getManagePageFeaturesDetails"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetPageFeaturesByPageId() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getPageFeaturesByPageId")
                .param("page_id", "1")) // Replace with a valid page_id
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetManagePageFeatureRbacDetails() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getManagePageFeatureRbacDetails"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetManageFundBpaRbacRolesDetails() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getManageFundBpaRbacRolesDetails"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }
    
    @Test
    public void testGetManageFundTimelinesDetails() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getManageFundTimelinesDetails"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not
    }
    
    @Test
    public void testGetManageFundTimelinesDetailsById() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/funds/getManageFundTimelinesDetailsById")
                .param("fund_id", "1")) // Replace with a valid fund_id
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assertNotNull(responseContent); // Check that the response is not null
    }

}
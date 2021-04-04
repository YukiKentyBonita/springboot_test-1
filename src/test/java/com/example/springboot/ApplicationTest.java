package com.example.springboot;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
     void testOne() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api?post_input_text=userPostedString")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.post("/delete?post_text=userPostedString")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.get("/history").contentType(MediaType.ALL))
                .andExpect(content().string(not(containsString("userPostedString"))));
//        mockMvc.perform(MockMvcRequestBuilders.get("/search?search_text=userPostedString").contentType(MediaType.ALL))
//                .andExpect(content().string(not(containsString("userPostedString"))));

    }

    @Test
    void testTwo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api?post_input_text=userPostedALLUPPERCASE")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.post("/delete?post_text=userPostedalluppercase")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.get("/history").contentType(MediaType.ALL))
                .andExpect(content().string(containsString("userPostedALLUPPERCASE")));
//        mockMvc.perform(MockMvcRequestBuilders.get("/search?search_text=userPostedALLUPPERCASE").contentType(MediaType.ALL))
//                .andExpect(content().string(containsString("userPostedALLUPPERCASE")));

    }

}
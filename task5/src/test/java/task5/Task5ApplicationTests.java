package task5;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import task5.controllers.Controller;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
class Task5ApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    Controller controller;

    @Test
    void createTest() throws Exception {
        this.mockMvc.perform(post("/?name=Audi&price=15000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Audi")))
                .andExpect(content().string(containsString("15000")));
    }

    @Test
    void getTest() throws Exception {
        this.mockMvc.perform(post("/?name=BMW&price=10000"))
                .andDo(print());
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("BMW")))
                .andExpect(content().string(containsString("10000")));
    }

    @Test
    void updateTest() throws Exception {
        this.mockMvc.perform(post("/?name=BMW&price=10000"))
                .andDo(print());
        this.mockMvc.perform(put("/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Mercedes\",\"price\":20000.0}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Mercedes")))
                .andExpect(content().string(containsString("20000")))
                .andExpect(content().string(containsString("1")));
    }

    @Test
    void deleteTest() throws Exception {
        this.mockMvc.perform(post("/?name=Volkswagen&price=5000"))
                .andDo(print());
        this.mockMvc.perform(delete("/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1")));
    }
}

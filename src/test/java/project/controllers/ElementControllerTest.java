package project.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import project.model.Element;
import project.model.Elements;
import project.repositories.ElementRepository;
import project.repositories.ElementsRepository;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Sql(value = {"/insert.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/delete.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class ElementControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ElementsRepository elementsRepository;

    @Autowired
    private ElementRepository elementRepository;


    @Test
    @SneakyThrows
    void getElement() {
        mvc.perform(get("/element/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void addElementToElements() {
        Optional<Elements> elements = elementsRepository.findById(1L);
        String newElement = om.writeValueAsString(new Element(4L, "test", "4444", elements.orElse(new Elements())));
        mvc.perform(post("/element/1").content(newElement)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void deleteElement() {
        mvc.perform(delete("/element/2")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void updateElement() {
        String name = "testName";
        Optional<Element> element = elementRepository.findById(3L);
        Element updElement = element.orElse(new Element());
        updElement.setName(name);
        String resultUpdElement = om.writeValueAsString(updElement);
        mvc.perform(put("/element/update").content(resultUpdElement))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.data.name", is(name)));
    }
}
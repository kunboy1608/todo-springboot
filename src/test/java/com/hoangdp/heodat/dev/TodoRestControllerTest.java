package com.hoangdp.heodat.dev;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hoangdp.heodat.dev.controller.TodoRestController;

/*******************************************************
 * For Vietnamese readers:
 *    Các bạn thân mến, mình rất vui nếu project này giúp 
 * ích được cho các bạn trong việc học tập và công việc. Nếu 
 * bạn sử dụng lại toàn bộ hoặc một phần source code xin để 
 * lại dường dẫn tới github hoặc tên tác giá.
 *    Xin cảm ơn!
 *******************************************************/

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 5/26/2019
 *        Github: https://github.com/loda-kun
 */
@ExtendWith({ SpringExtension.class, MockitoExtension.class })
// Bạn cần cung cấp lớp Controller cho @WebMvcTest
public class TodoRestControllerTest {

    @MockBean
    TodoRepository todoRepository;

    @MockBean
    TodoService todoService;

    @Test
    public void testFindAll() throws Exception {
        // Tạo ra một List<Todo> 10 phần tử
        List<Todo> allTodos = IntStream.range(0, 10)
                .mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i))
                .collect(Collectors.toList());

        // giả lập todoService trả về List mong muốn
        given(todoService.getAll()).willReturn(allTodos);

        MockMvc mvc = MockMvcBuilders.standaloneSetup(new TodoRestController(todoService)).build();

        mvc.perform(get("/api/v2/todo").contentType(MediaType.APPLICATION_JSON)) // Thực hiện GET REQUEST
                .andExpect(status().isOk()) // Mong muốn Server trả về status 200
                .andExpect(jsonPath("$", hasSize(10))) // Hi vọng server trả về List độ dài 10
                .andExpect(jsonPath("$[0].id", is(0))) // Hi vọng phần tử trả về đầu tiên có id = 0
                .andExpect(jsonPath("$[0].title", is("title-0"))) // Hi vọng phần tử trả về đầu tiên có title =
                                                                  // "title-0"
                .andExpect(jsonPath("$[0].detail", is("detail-0")));
    }
}
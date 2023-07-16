package com.hoangdp.heodat.dev;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {


    // @Mock
    // TodoRepository todoRepository;
    static TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @BeforeAll
    public static void setUp() {
        todoRepository = Mockito.mock(TodoRepository.class);        
        Mockito.when(todoRepository.findAll())
               .thenReturn(IntStream.range(0, 10)
                                    .mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i))
                                    .collect(Collectors.toList()));

    }

    @Test
    public void testCount() {
        Assertions.assertEquals(10, todoService.countTodo());    
    }
}

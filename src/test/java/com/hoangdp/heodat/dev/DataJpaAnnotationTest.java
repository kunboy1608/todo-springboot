package com.hoangdp.heodat.dev;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.activation.DataSource;
import jakarta.persistence.EntityManager;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@DataJpaTest
@SpringBootTest
public class DataJpaAnnotationTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void allComponentAreNotNull() {
        Assertions.assertThat(dataSource).isNotNull();
        Assertions.assertThat(jdbcTemplate).isNotNull();
        Assertions.assertThat(entityManager).isNotNull();
        Assertions.assertThat(todoRepository).isNotNull();
    }

    @Test
    public void testTodoRepositoryByCode(){
        todoRepository.save(new Todo(0, "title-1", "detail-1" ));
        todoRepository.save(new Todo(0, "title-2", "detail-2" ));

        Assertions.assertThat(todoRepository.findAll()).hasSize(2);
        Assertions.assertThat(todoRepository.findById(1).getTitle()).isEqualTo("title-1");
    }

    @After(value = "")
    public void clean() {
        todoRepository.deleteAll();
    }

}


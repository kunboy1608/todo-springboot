package com.hoangdp.heodat.dev;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.activation.DataSource;
import jakarta.persistence.EntityManager;

@DataJpaTest
public class DataJpaAnnotationTest {
    @MockBean
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void allComponentAreNotNull() {
        // Assertions.assertThat(dataSource).isNotNull();
        Assertions.assertThat(jdbcTemplate).isNotNull();
        Assertions.assertThat(entityManager).isNotNull();
        Assertions.assertThat(todoRepository).isNotNull();
    }

    @Test
    public void testTodoRepositoryByCode() {
        todoRepository.save(new Todo(1, "title-1", "detail-1"));
        todoRepository.save(new Todo(2, "title-2", "detail-2"));
        Assertions.assertThat(todoRepository.findAll()).hasSize(2);
        Assertions.assertThat(todoRepository.findById(1).getTitle()).isEqualTo("title-1");
    }

    @After(value = "")
    public void clean() {
        todoRepository.deleteAll();
    }
}

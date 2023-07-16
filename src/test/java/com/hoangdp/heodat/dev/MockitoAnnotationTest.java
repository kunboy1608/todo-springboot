package com.hoangdp.heodat.dev;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoAnnotationTest {

    @Mock
    List<String> mockList;

    @Test
    public void testUserMockFunction() {
        Mockito.when(mockList.size()).thenReturn(2);
        Assertions.assertThat(mockList.size()).isEqualTo(2);
    }
}

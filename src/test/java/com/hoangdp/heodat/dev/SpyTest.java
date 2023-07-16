package com.hoangdp.heodat.dev;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpyTest {
    @Spy
    List<String>  list = new ArrayList<>();

    @Test
    public void testSpy(){
        list.add("one");
        list.add("two");

        Mockito.verify(list).add("one");
        Mockito.verify(list).add("two");

        Assertions.assertThat(list.size()).isEqualTo(2);

        Mockito.when(list.size()).thenReturn(100);

        Assertions.assertThat(list.size()).isEqualTo(100);


    }
}

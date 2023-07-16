package com.hoangdp.heodat.dev;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CaptorTest {
    @Mock
    List<Object> list;

    @Captor
    ArgumentCaptor<Object> captor;

    @Test
    public void testCaptor1(){
        list.add(1);

        Mockito.verify(list).add(captor.capture());

        System.out.println(captor.getAllValues());

        Assertions.assertThat(1).isEqualTo(captor.getValue());
    }


}

package com.hoangdp.heodat.dev;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InjectMockTest {
    @Mock
    DatabaseDriver driver;

    /**
     * Inject driver vào superService.
     * Mọi người có thể liên tưởng nó giống với Spring Injection
     */
    @InjectMocks
    SuperService superService;

    @Test    
    public void testInjectMock() throws SQLException {
        // Giả lập cho driver luôn trả về list (3,2,1) khi được gọi tới
        Mockito.doReturn(Arrays.asList(3, 2, 1)).when(driver).get();

        Assertions.assertEquals(driver, superService.getDriver());

        // Test xem superService trả ra ngoài có đúng không?
        Assertions.assertEquals(Arrays.asList(1, 2, 3), superService.getObjects());

        // Giả lập cho driver bắn exception
        assertThrows(SQLException.class, (            
        ) -> {
            driver.get();
            throw new SQLException("Simulated SQLException");
        });
    }
}

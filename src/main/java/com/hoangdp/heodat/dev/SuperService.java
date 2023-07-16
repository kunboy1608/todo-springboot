package com.hoangdp.heodat.dev;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuperService {
    DatabaseDriver driver;

    public List<Object> getObjects() throws SQLException {
        System.out.println("LOG: Getting objects");
        List<Object> list = driver.get();

        System.out.println("LOG: Sorting");
        Collections.sort(list, Comparator.comparingInt(value -> Integer.valueOf(value.toString())));

        System.out.println("LOG: Done");
        return list;
    }
}
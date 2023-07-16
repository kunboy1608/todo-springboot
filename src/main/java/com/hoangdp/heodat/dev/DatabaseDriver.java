package com.hoangdp.heodat.dev;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseDriver {
    List<Object> get() throws SQLException;
}
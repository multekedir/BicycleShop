package com.revature.utility;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class ConnectionUtilTest {
    @Test
    public void TestConnectionUtil() {
        ConnectionUtil conn = ConnectionUtil.getConnectionUtil();
        Connection connection = conn.getConnection();
        assertEquals(connection != null, true);
    }


}
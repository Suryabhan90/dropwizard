package com.suryabhan.core.Mapper;

import com.suryabhan.core.TestDabsejdbi;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by suryabhan on 26/04/16.
 */
public class TestdbjdbiMapper implements ResultSetMapper<TestDabsejdbi> {
    @Override
    public TestDabsejdbi map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        TestDabsejdbi testDabsejdbi=new TestDabsejdbi();
        testDabsejdbi.setId(resultSet.getInt("id"));
        testDabsejdbi.setName(resultSet.getString("name"));
        return testDabsejdbi;
    }
}

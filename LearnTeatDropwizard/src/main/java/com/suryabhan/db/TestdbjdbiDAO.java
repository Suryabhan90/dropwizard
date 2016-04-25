package com.suryabhan.db;

import com.suryabhan.core.Mapper.TestdbjdbiMapper;
import com.suryabhan.core.TestDabsejdbi;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by suryabhan on 26/04/16.
 */

@RegisterMapper(TestdbjdbiMapper.class)
public interface TestdbjdbiDAO {

    @SqlQuery("select * from testtable")
    List<TestDabsejdbi> getAll();

    @SqlQuery("select * from testtable where id=:id")
    TestDabsejdbi getbyid(@Bind("id") int Id);


    @SqlUpdate("insert into testtable (name) values (:name)")
    int insert(@BindBean TestDabsejdbi testdb);

    @SqlUpdate("update testtable set name=:name where id=:id")
    int update(@BindBean TestDabsejdbi testdb);

    @SqlUpdate("delete from testtable where id =:id")
    int deletebyid(@Bind("id") int id);

}

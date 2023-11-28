package vn.edu.iuh.fit.w4.www_tuan4_spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public abstract class AbstractDAO<T,ID> {
    @Autowired
    private DataSource dataSource;
    protected JdbcTemplate jdbcteamplate;
    public AbstractDAO(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcteamplate = new JdbcTemplate(dataSource);
    }

    public abstract void insert(T t);
    public abstract T getByID(ID t);

    public abstract List<T> getAll();
}

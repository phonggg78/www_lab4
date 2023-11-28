package vn.edu.iuh.fit.w4.www_tuan4_spring.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.w4.www_tuan4_spring.etities.Student;

import javax.sql.DataSource;
import java.util.List;
@Component
public class StudentDao extends AbstractDAO<Student, Long>{

    public StudentDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(Student student) {
        String sql = "insert into student values(?,?)";
        jdbcteamplate.update(sql,student.getId(),student.getName());
    }

    @Override
    public Student getByID(Long id) {
        String sql = "select * from student where id=?";
        return jdbcteamplate.queryForObject(sql,new BeanPropertyRowMapper<>(Student.class),id);
    }

    @Override
    public List<Student> getAll() {
        String sql = "select * from student";
        return jdbcteamplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
    }
}

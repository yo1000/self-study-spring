// src/main/java/io/github/yo1000/sss/repository/jdbc/JdbcMemoRepository.java
package io.github.yo1000.sss.repository.jdbc;

import io.github.yo1000.sss.model.Memo;
import io.github.yo1000.sss.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMemoRepository implements MemoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Memo item) {
        getJdbcTemplate().update(
                "INSERT INTO MEMO (MEMO, AUTHOR, CREATED) VALUES (?, ?, CURRENT_TIMESTAMP)",
                item.getMemo(), item.getAuthor());
    }

    @Override
    public List<Memo> find() {
        return getJdbcTemplate().query(
                "SELECT MEMO, AUTHOR FROM MEMO ORDER BY CREATED ASC", (resultSet, i) -> {
                    Memo item = new Memo();
                    item.setMemo(resultSet.getString("MEMO"));
                    item.setAuthor(resultSet.getString("AUTHOR"));
                    return item;
                });
    }

    @Override
    public List<Memo> findByAuthor(String author) {
        return getJdbcTemplate().query(
                "SELECT MEMO, AUTHOR FROM MEMO WHERE AUTHOR = ? ORDER BY CREATED ASC", (resultSet, i) -> {
                    Memo item = new Memo();
                    item.setMemo(resultSet.getString("MEMO"));
                    item.setAuthor(resultSet.getString("AUTHOR"));
                    return item;
                }, author);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}

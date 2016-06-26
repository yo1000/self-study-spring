// src/main/java/io/github/yo1000/sss/repository/MemoRepository.java
package io.github.yo1000.sss.repository;

import io.github.yo1000.sss.model.Memo;

import java.util.List;

public interface MemoRepository {
    List<Memo> find();
    List<Memo> findByAuthor(String author);
    void save(Memo item);
}

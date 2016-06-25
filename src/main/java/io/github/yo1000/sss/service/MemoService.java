// src/main/java/io/github/yo1000/sss/service/MemoService.java
package io.github.yo1000.sss.service;

import io.github.yo1000.sss.model.Memo;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemoService {
    public Memo join(String memo, String author) {
        Memo item = new Memo();
        item.setMemo(memo);
        item.setAuthor(author);
        item.setCreated(new Date());

        return item;
    }
}

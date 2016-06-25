// src/main/java/io/github/yo1000/sss/model/Memo.java
package io.github.yo1000.sss.model;

import java.util.Date;

public class Memo {
    private String memo;
    private String author;
    private Date created;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

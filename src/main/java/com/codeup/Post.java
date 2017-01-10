package com.codeup;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Austin on 1/5/17.
 */

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "Post must have a title")
    @Size(min = 5, message = "A title must be at least 5 characters.")
    private String title;

    @Column(nullable = false, length = 1000)
    @NotBlank(message = "Post must have a description")
    @Size(min = 5, message = "A body must be at least 5 characters.")
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

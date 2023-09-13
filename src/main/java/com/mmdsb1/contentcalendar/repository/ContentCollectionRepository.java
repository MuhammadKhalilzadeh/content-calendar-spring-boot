package com.mmdsb1.contentcalendar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mmdsb1.contentcalendar.model.Content;
import com.mmdsb1.contentcalendar.model.Status;
import com.mmdsb1.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(1, "My Test Content Object", "This is a test object", Status.COMPLETE,
                Type.ARTICLE, null, null, "");

        content.add(c);
    }

    public void save(Content content2) {
        content.removeIf(c -> c.id().equals(content2.id()));
        content.add(content2);
    }

    public boolean existsById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        content.removeIf(c -> c.id().equals(id));
    }
}

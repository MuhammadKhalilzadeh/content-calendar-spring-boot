package com.mmdsb1.contentcalendar.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.mmdsb1.contentcalendar.model.Content;
import com.mmdsb1.contentcalendar.model.Status;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            select * from Content where Status = :status
                """)
    List<Content> listByStatus(Status status);

}

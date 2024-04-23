package com.example.concertservice.specifications;

import com.example.concertservice.models.Event;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class EventSpecifications {

    public static Specification<Event> byCity(String city) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("city"), city);
    }

    public static Specification<Event> byDateRange(Date from, Date to) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("event_date"), from, to);
    }
    public static Specification<Event> byType(Long type){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("event_type_id"), type);

    }
}


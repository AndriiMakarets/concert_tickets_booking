package com.example.concertservice.specifications;

import com.example.concertservice.models.Event;
import com.example.concertservice.models.EventTypes;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class EventSpecifications {

    public static Specification<Event> byCity(String city) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("city"), city);
    }

//    public static Specification<Event> byDateRange(Date from, Date to) {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("event_date"), from, to);
//    }

    public static Specification<Event> byStartDate(Date from) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("saleStartDate"), from);
    }

    public static Specification<Event> byEndDate(Date to) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("saleEndDate"), to);
    }
    public static Specification<Event> byType(EventTypes type){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("eventType"), type);

    }
}


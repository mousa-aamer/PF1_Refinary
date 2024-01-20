package com.mousa.demo.RefineryDemo.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Task {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private Date createdDate;
    private Date completedDate;
}

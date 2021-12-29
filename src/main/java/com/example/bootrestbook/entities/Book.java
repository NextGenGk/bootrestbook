package com.example.bootrestbook.entities;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


@Entity
@Table(name = "books")
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "books_id")
        private int id;
        private String bookName;
        private String authorName;

}

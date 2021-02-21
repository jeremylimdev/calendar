package com.jeremy.calendarApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "db_sequence")
public class DBSequence {

    @Id
    private String id;
    private int seqNo;
}

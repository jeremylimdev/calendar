package com.jeremy.calendarApp.service;

import com.jeremy.calendarApp.model.DBSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String sequenceName) {
        // Fetching the sequence number
        Query query = new Query(Criteria.where("id").is(sequenceName));

        // Updating the sequence number by incrementing it by 1
        Update update = new Update().inc("seqNo", 1);

        DBSequence sequence = mongoOperations
                .findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), DBSequence.class);

        return !Objects.isNull(sequence) ? sequence.getSeqNo() : 1;
    }
}

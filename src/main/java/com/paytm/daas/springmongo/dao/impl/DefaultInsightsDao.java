package com.paytm.daas.springmongo.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.paytm.daas.springmongo.dao.InsightsDao;
import com.paytm.daas.springmongo.entities.InsightMetrics;
import com.paytm.daas.springmongo.enums.ErrorMessages;
import com.paytm.daas.springmongo.exceptions.InvalidMongoException;
import com.paytm.daas.springmongo.utils.LogMessageGenerator;

@Repository
public class DefaultInsightsDao implements InsightsDao {
    
    private MongoOperations mongoOperations;
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultInsightsDao.class);
    
    @Autowired
    public DefaultInsightsDao(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<InsightMetrics> getInsightsBySeverity(Integer severity) throws InvalidMongoException {
        
        Long start = System.currentTimeMillis();
        LOGGER.info("Fetching the data from the DB");
        
        Query query = new Query();
        query.addCriteria(new Criteria().where("trend_severity").is(severity));
        List<InsightMetrics> insightsList = mongoOperations.find(query, InsightMetrics.class);
        
        if (CollectionUtils.isEmpty(insightsList))
            throw new InvalidMongoException(ErrorMessages.INVALID_SEVERITY);
        
        Long timeTaken = System.currentTimeMillis() - start;
        LOGGER.info(LogMessageGenerator.getLogMessage("Time taken to fetch the data from the DB", timeTaken));
        
        return insightsList;
    }

}

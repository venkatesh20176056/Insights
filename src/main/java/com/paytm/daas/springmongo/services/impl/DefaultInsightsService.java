package com.paytm.daas.springmongo.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytm.daas.springmongo.dao.InsightsDao;
import com.paytm.daas.springmongo.entities.InsightMetrics;
import com.paytm.daas.springmongo.exceptions.InvalidMongoException;
import com.paytm.daas.springmongo.services.InsightsService;

@Service
public class DefaultInsightsService implements InsightsService {
    
    private InsightsDao insightsDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultInsightsService.class);
    
    @Autowired
    public DefaultInsightsService(InsightsDao insightsDao) {
        this.insightsDao = insightsDao;
    }

    @Override
    public List<InsightMetrics> getInsightsBySeverity(Integer severity) throws InvalidMongoException {
        LOGGER.info("Trying to fetch the data from the DB");
        
        return insightsDao.getInsightsBySeverity(severity);
    }

}

package com.paytm.daas.springmongo.dao;

import java.util.List;

import com.paytm.daas.springmongo.entities.InsightMetrics;
import com.paytm.daas.springmongo.exceptions.InvalidMongoException;

public interface InsightsDao {
    public List<InsightMetrics> getInsightsBySeverity(Integer severity) throws InvalidMongoException;
}

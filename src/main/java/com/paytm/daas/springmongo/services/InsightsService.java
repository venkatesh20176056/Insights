package com.paytm.daas.springmongo.services;

import java.util.List;

import com.paytm.daas.springmongo.entities.InsightMetrics;
import com.paytm.daas.springmongo.exceptions.InvalidMongoException;

public interface InsightsService {
    public List<InsightMetrics> getInsightsBySeverity(Integer severity) throws InvalidMongoException;
}

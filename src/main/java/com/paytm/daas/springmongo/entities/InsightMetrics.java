package com.paytm.daas.springmongo.entities;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "insight_metrics")
public class InsightMetrics {
    
//    JSON Mongo Collection db.insight_metrics.findOne():
//    { "_id" : ObjectId("5df748ab972ef7a4c4ad6d48"), "metric_name" : "active_cust_yest", 
//        "created_at" : NumberLong("1571237723404"), "metric_value" : 2370, "created_for" : NumberLong("1571097601000"), 
//        "dimensions" : { "state" : "haryana", "channel" : "diy_offline" }, "trend_flag" : 0, 
//        "trend_jump_percent" : 3, "trend_severity" : 5 }
    
    @Field("metric_name")
    private String metricName;
    
    @Field("created_at")
    private Long createdAt;
    
    @Field("metric_value")
    private Long metricValue;
    
    @Field("created_for")
    private Long createdFor;
    
    @Field("dimensions")
    private Map<String, String> dimensions;
    
    @Field("trend_flag")
    private Integer trendFlag;
    
    @Field("trend_jump_percent")
    private Integer trendJumpPercent;
    
    @Field("trend_severity")
    private Integer trendSeverity;

    public String getMetricName() {
        return metricName;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getMetricValue() {
        return metricValue;
    }

    public Long getCreatedFor() {
        return createdFor;
    }

    public Map<String, String> getDimensions() {
        return dimensions;
    }

    public Integer getTrendFlag() {
        return trendFlag;
    }

    public Integer getTrendJumpPercent() {
        return trendJumpPercent;
    }

    public Integer getTrendSeverity() {
        return trendSeverity;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setMetricValue(Long metricValue) {
        this.metricValue = metricValue;
    }

    public void setCreatedFor(Long createdFor) {
        this.createdFor = createdFor;
    }

    public void setDimensions(Map<String, String> dimensions) {
        this.dimensions = dimensions;
    }

    public void setTrendFlag(Integer trendFlag) {
        this.trendFlag = trendFlag;
    }

    public void setTrendJumpPercent(Integer trendJumpPercent) {
        this.trendJumpPercent = trendJumpPercent;
    }

    public void setTrendSeverity(Integer trendSeverity) {
        this.trendSeverity = trendSeverity;
    }
    
}

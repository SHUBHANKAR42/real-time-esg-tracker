package com.portfolio.esg_tracker;

public record EsgMetric(String ticker, double environmentalScore, double socialScore, double governanceScore) {}
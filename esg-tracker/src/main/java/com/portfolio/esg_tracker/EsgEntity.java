package com.portfolio.esg_tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EsgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private double environmentalScore;
    private double socialScore;
    private double governanceScore;

    public EsgEntity() {}

    public EsgEntity(String ticker, double environmentalScore, double socialScore, double governanceScore) {
        this.ticker = ticker;
        this.environmentalScore = environmentalScore;
        this.socialScore = socialScore;
        this.governanceScore = governanceScore;
    }

    public Long getId() { return id; }
    public String getTicker() { return ticker; }
    public double getEnvironmentalScore() { return environmentalScore; }
    public double getSocialScore() { return socialScore; }
    public double getGovernanceScore() { return governanceScore; }
}
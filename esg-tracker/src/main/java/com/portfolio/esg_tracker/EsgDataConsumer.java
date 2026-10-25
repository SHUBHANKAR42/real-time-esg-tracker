package com.portfolio.esg_tracker;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EsgDataConsumer {

    private final EsgRepository esgRepository;

    public EsgDataConsumer(EsgRepository esgRepository) {
        this.esgRepository = esgRepository;
    }

    @KafkaListener(topics = "esg-raw-metrics", groupId = "esg-group")
    public void consumeMetric(EsgMetric metric) {
        // 1. Persist to Database
        EsgEntity entity = new EsgEntity(
            metric.ticker(), 
            metric.environmentalScore(), 
            metric.socialScore(), 
            metric.governanceScore()
        );
        esgRepository.save(entity);
        System.out.println("Saved to DB: " + metric.ticker());

        // 2. Real-Time Threshold Alerting
        boolean isFailingE = metric.environmentalScore() < 50;
        boolean isFailingS = metric.socialScore() < 50;
        boolean isFailingG = metric.governanceScore() < 50;

        if (isFailingE || isFailingS || isFailingG) {
            System.err.println("\n⚠️ COMPLIANCE ALERT: " + metric.ticker() + " dropped below threshold!");
            System.err.printf("   Current Scores -> E: %.2f | S: %.2f | G: %.2f%n\n", 
                metric.environmentalScore(), metric.socialScore(), metric.governanceScore());
        }
    }
}
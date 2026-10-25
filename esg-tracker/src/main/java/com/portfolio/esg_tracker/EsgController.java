package com.portfolio.esg_tracker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/esg")
public class EsgController {

    private final EsgRepository esgRepository;

    public EsgController(EsgRepository esgRepository) {
        this.esgRepository = esgRepository;
    }

    @GetMapping("/metrics")
    public List<EsgEntity> getAllMetrics() {
        return esgRepository.findAll();
    }

    @GetMapping("/metrics/{ticker}")
    public List<EsgEntity> getMetricsByTicker(@PathVariable String ticker) {
        return esgRepository.findByTicker(ticker);
    }

    @GetMapping(value = "/export", produces = "text/csv")
    public ResponseEntity<String> exportToCsv() {
        List<EsgEntity> metrics = esgRepository.findAll();
        StringBuilder csv = new StringBuilder("ID,Ticker,Environmental,Social,Governance\n");
        
        for (EsgEntity m : metrics) {
            csv.append(m.getId()).append(",")
               .append(m.getTicker()).append(",")
               .append(m.getEnvironmentalScore()).append(",")
               .append(m.getSocialScore()).append(",")
               .append(m.getGovernanceScore()).append("\n");
        }
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"esg_portfolio_data.csv\"")
                .body(csv.toString());
    }
}
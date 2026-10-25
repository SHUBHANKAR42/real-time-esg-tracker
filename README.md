# Real-Time Event-Driven ESG Investment Tracker

An end-to-end, event-driven data pipeline that processes real-time Environmental, Social, and Governance (ESG) metrics for NIFTY 50 equities. Built with a robust Java/Spring Boot backend and Apache Kafka, this system ingests simulated market data, evaluates sustainability compliance thresholds, and persists resilient metrics to a PostgreSQL database for live dashboard visualization.

## 🚀 Impact & Overview
**Problem:** Institutional investors and quantitative analysts require low-latency visibility into the ESG compliance of their equity portfolios to mitigate risk and meet regulatory standards. 
**Tools:** Java, Spring Boot, Apache Kafka, PostgreSQL, Docker, HTML/JS.
**Impact:** Engineered a resilient stream-processing pipeline capable of real-time metric evaluation, automated compliance alerting, and live visualization, ensuring continuous data availability through a fallback generation engine.

## 🏗️ System Architecture
1. **Data Producer:** A Spring Boot microservice acting as a Kafka Producer continuously fetches or generates live ESG scores for benchmark tickers (e.g., `RELIANCE.NS`, `HDFCBANK.NS`, `ITC.NS`).
2. **Event Streaming:** Apache Kafka handles high-throughput message brokering, decoupling data ingestion from downstream processing.
3. **Data Consumer:** A Spring Boot Kafka Consumer subscribes to the stream, evaluating E, S, and G scores against predefined institutional thresholds and triggering `COMPLIANCE ALERT` warnings for underperforming assets.
4. **Persistence Layer:** Processed metrics and fallback data are saved to a PostgreSQL database.
5. **Visualization:** A frontend dashboard fetches the latest metrics via REST API to render live, comparative bar charts.

## 💻 Tech Stack
* **Backend:** Java 21, Spring Boot (Web, Data JPA, Kafka)
* **Message Broker:** Apache Kafka, Zookeeper
* **Database:** PostgreSQL
* **Containerization:** Docker, Docker Compose
* **Frontend:** HTML5, CSS3, JavaScript (Chart.js)

## ⚙️ Local Setup & Installation

**Prerequisites:** Docker Desktop, Java Development Kit (JDK), and Git installed on your machine.

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/SHUBHANKAR42/real-time-esg-tracker.git](https://github.com/SHUBHANKAR42/real-time-esg-tracker.git)
   cd real-time-esg-tracker

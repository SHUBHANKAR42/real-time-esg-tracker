# Install ggplot2 if you haven't already: install.packages("ggplot2")
library(ggplot2)

# 1. Ingest the Data
# Ensure the working directory is set to where esg_portfolio_data.csv is located
esg_data <- read.csv("esg_portfolio_data.csv")

# 2. Exploratory Data Analysis: Summary Statistics
print("--- Portfolio Summary Statistics ---")
summary(esg_data)

# 3. Volatility Analysis: Boxplots of Environmental Scores
volatility_plot <- ggplot(esg_data, aes(x = Ticker, y = Environmental, fill = Ticker)) +
  geom_boxplot(alpha = 0.7) +
  theme_minimal() +
  labs(title = "Environmental Score Volatility by Holding",
       x = "Equity Ticker",
       y = "Simulated Score") +
  theme(legend.position = "none")

print(volatility_plot)

# 4. Trend Analysis: Governance Over Time (Using ID as sequential proxy)
trend_plot <- ggplot(esg_data, aes(x = ID, y = Governance, color = Ticker)) +
  geom_line(size = 1, alpha = 0.8) +
  theme_minimal() +
  labs(title = "Live Governance Score Tracking",
       x = "Sequential Reading (Time Proxy)",
       y = "Governance Score")

print(trend_plot)
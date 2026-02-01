# Multi-Currency Money Calculation

##  User Flow (v1.0): 단일 통화 곱셈
```mermaid
graph LR
    A[Given: 5 USD 지갑에 있음] -->|보유| B(상태: 5 USD)
    B -->|When: 2배로 불리기| C[Action: 곱하기 2]
    C -->|Then| D[Result: 10 USD가 됨]

## User Scenario (Gherkin)
```gherkin
Feature: Dollar Calculation

  Scenario: Single currency multiplication
    Given I have 5 USD
    When I multiply it by 2
    Then the result should be 10 USD
```
# Multi-Currency Money Calcultion

## User Flow (v1.0)

```
graph LR
    A[시작: 5 USD] -->|지갑 확인| B(현재 상태: 5 USD)
    B -->|Action: 2배로 불리기| C[System: 5 * 2 계산]
    C -->|결과| D[새로운 상태: 10 USD]
```

## User Scenario (Gherkin)
```gherkin
Feature: Dollar Calculation

    Scenario: Single currency multiplication
        Given I have 5 USD
        When I multiply it by 2
        Then the result should be 10 USD
```
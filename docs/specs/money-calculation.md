# Multi-Currency Money Calculation

## User Flow(v1.0) [SPEC-FLOW-001]

```mermaid
graph LR
    A[시작: 5 USD] -->|지갑 확인| B(현재 상태: 5 USD)
    B -->|Action: 2배로 불리기| C[System: 5 * 2 계산]
    C -->|결과| D[새로운 상태: 10 USD]
```

## Gherkin Scenario [SPEC-GERKIN-001]

```gherkin
Feature: Multi-Currency Money Calculation

  Scenario: 간단한 곱셈 계산
    Given 현재 지갑에 "5" "USD"가 들어있다
    When 금액을 "2"배로 불린다
    Then 결과는 "10" "USD"가 되어야 한다
```

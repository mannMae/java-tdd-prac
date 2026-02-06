# Multi-Currency Money Calculation

## User Flow(v1.0) [SPEC-FLOW-001]

```mermaid
graph LR
    A[시작: 5 USD] -->|지갑 확인| B(현재 상태: 5 USD)
    B -->|Action: 2배로 불리기| C[System: 5 * 2 계산]
    C -->|결과| D[새로운 상태: 10 USD]
```
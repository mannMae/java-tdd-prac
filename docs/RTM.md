# Requirements Traceability Matix (RTM)

[//]: # (RTM_JSON_START)
<!--
{
    "version": "1.1",
    "project": "Money Calculation",
    "requirements": [
        {
            "id": "REQ-MONEY-001",
            "feature": "단일 통화 곱셈",
            "specs": {
                "visual": "docs/specs/money-calculation.md#L3",
                "logical": "docs/specs/money-calculation.md#L14"
            },
            "tests": ["com.inc.tdd_practice.MoneyTest"],
            "status": "Verified"
        }
    ]
}
-->
[//]: # ()

## Traceability Matrix

| ID | Feature | Visual (User Flow) | Logical (Gherkin) | Tests | Status |
|:---|:---|:---|:---|:---|:---|
| REQ-MONEY-001 | 단일 통화 곱셈 | [UC-001](./specs/money-calculation.md#L3) | [BDD-001](./specs/money-calculation.md#L14) | `MoneyTest` | ✅ Verified |
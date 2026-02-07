# Requirements Traceability Matix (RTM)

[//]: # (RTM_JSON_START)
<!--
{
    "version": "1.0",
    "project": "Money Calculation",
    "requirements": [
        {
            "id": "SPEC-FLOW-001",
            "feature": "단일 통화 곱셈 (Visual)",
            "specs": ["docs/specs/money-calculation.md#L3"],
            "tests": "com.inc.tdd_practice.MoneyTest",
            "status": "Verified"
        },
        {
            "id": "SPEC-GERKIN-001",
            "feature": "단일 통화 곱셈 (Logical)",
            "specs": ["docs/specs/money-calculation.md#L14"],
            "tests": "com.inc.tdd_practice.MoneyTest",
            "status": "Verified"
        }
    ]
}
-->
[//]: # ()

## Traceability Matrix

| ID | Feature | Specs | Tests | Status |
|:---|:---|:---|:---|:---|
| SPEC-FLOW-001 | 단일 통화 곱셈 (Visual) | [UC-001](docs/specs/money-calculation.md#L3) | `MoneyTest` | ✅ Verified |
| SPEC-GERKIN-001 | 단일 통화 곱셈 (Logical) | [BDD-001](docs/specs/money-calculation.md#L14) | `MoneyTest` | ✅ Verified |
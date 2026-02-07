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

## 3. AG Audit
"AG, REQ-MONEY-001의 검증 증적을 보여줘"라고 요청하면, 에이전트가 해당 테스트를 즉시 다시 실행하여 결과를 보고합니다.

## 6. Regulatory Compliance (규제 대응)
외부 규제 담당자(Auditor)에게 시스템을 소명할 때 다음을 근거로 사용합니다:
1. **Approval Metadata**: RTM 하단의 `Approver`와 `Date` 필드는 사람이 직접 검토하고 승인했음을 증명합니다.
2. **Commit History (Immutable Audit Trail)**: Git 커밋 메시지에 포함된 Spec ID와 작업 내역은 "누가, 언제, 어떤 명세를 근거로 코드를 바꿨는지"에 대한 **위변조 불가능한 기록**이 됩니다.
3. **Walkthrough Evidence**: AG가 생성한 `walkthrough.md`는 해당 시점의 테스트 성공 결과를 담은 공식 증적(Evidence) 역할을 합니다.

## Traceability Matrix

| ID | Feature | Visual (User Flow) | Logical (Gherkin) | Tests | Status | Approver | Approval Date |
|:---|:---|:---|:---|:---|:---|:---|:---|
| REQ-MONEY-001 | 단일 통화 곱셈 | [UC-001](./specs/money-calculation.md#L3) | [BDD-001](./specs/money-calculation.md#L14) | `MoneyTest` | ✅ Verified | `gimjaeman` | 2026-02-07 |
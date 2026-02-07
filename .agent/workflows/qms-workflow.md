---
description: Antigravity + LLM을 활용한 표준 QMS(Quality Management System) 워크플로우입니다.
---

# Standard QMS Workflow SOP

이 워크플로우는 요구사항 명세(Spec)부터 최종 검증(Verified)까지의 추적성을 유지하며 개발하는 표준 절차입니다.

## 1. Planning: Requirement & Traceability
1. **Spec 작성**: `docs/specs/` 폴더 내에 User Flow(Mermaid)와 Gherkin 시나리오를 포함한 명세 파일을 작성합니다.
2. **RTM 등록**: `docs/RTM.md`에 새 요구사항을 등록합니다. 이때 **한 행에 Visual(User Flow)과 Logical(Gherkin)을 모두 매핑**하여 'Traceability Chain'을 완성하고 상태를 `Draft`로 설정합니다.
3. **Plan 제안**: AG가 `implementation_plan.md`를 생성하여 사용자에게 전체 설계와 QMS 준수 방안을 보고합니다.

## 2. Execution: TDD with Traceability
1. **Red (Fail)**: `@Trace SPEC-ID`를 포함한 테스트 코드를 작성합니다.
   - **Test Granularity (중요)**: 하나의 요구사항(`REQ-ID`)이나 거킨 시나리오가 반드시 하나의 테스트 메서드와 1:1 매핑될 필요는 없습니다. 
   - **Fan-out**: 하나의 거킨 시나리오를 검증하기 위해 여러 개의 유닛 테스트(Happy path, Edge case, Negative test 등)가 생성될 수 있으며, 이 모든 테스트가 통과해야 해당 요구사항이 `Verified` 됩니다.
2. **Green (Pass)**: 테스트를 통과시키는 최소한의 구현을 진행합니다.
3. **Refactor**: 코드를 정돈하고 전체 테스트 성공을 확인합니다.

## 3. Verification: Human Review & Doc Update
1. **Verification (AG)**: 모든 테스트가 성공하면 AG가 `RTM.md`의 상태를 `Verified`로 변경하고 증적을 제출합니다.
2. **Review (User)**: 사용자는 AG가 작성한 **테스트 코드의 의도(Gherkin 주석)와 로직**이 기획 의도와 일치하는지 리뷰합니다. 
   - *핵심: 테스트가 틀리면 결과가 'Pass'여도 품질 결함입니다.*
3. **Approval**: 리뷰가 완료되면 사용자가 최종적으로 Push/Merge하여 품질 게이트를 닫습니다.

## 4. Final: Git Sync
1. 변경사항을 커밋하고 푸시합니다. 커밋 메시지에는 관련된 Spec ID를 명시합니다.

## 5. How to Verify (품질 감사 방법)
사용자가 RTM의 `Verified` 상태를 직접 확인하고 싶을 때 다음 방법을 권장합니다:
1. **Traceability Link**: RTM 테이블의 `Specs` 링크를 클릭하여 명세를 확인하고, 해당 내용이 `MoneyTest.java` 의 주석 및 로직과 일치하는지 대조합니다.
2. **Execution Evidence**: 작업 완료 시 생성된 `walkthrough.md` 를 열어 실제 테스트 실행 로그와 스크린샷(있는 경우)을 확인합니다.
3. **AG Audit**: "AG, REQ-MONEY-001의 검증 증적을 보여줘"라고 요청하면, 에이전트가 해당 테스트를 즉시 다시 실행하여 결과를 보고합니다.

## 6. Regulatory Compliance (규제 대응)
외부 규제 담당자(Auditor)에게 시스템을 소명할 때 다음을 근거로 사용합니다:
1. **Approval Metadata**: RTM 하단의 `Approver` 필드는 **실제 검토 및 승인을 수행한 담당자의 ID (예: Git/GitHub 계정명)**를 기재합니다. 이는 기술적 검증(AI)과 품질 승인(사람)이 분리되어 통제되고 있음을 증명합니다.

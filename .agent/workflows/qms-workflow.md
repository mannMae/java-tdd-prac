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
1. **Red (Fail)**: `@Trace SPEC-ID`를 포함한 테스트 코드를 작성합니다. 이때 **Gherkin 시나리오를 한 줄씩 주석으로 삽입**하고 그 아래에 실행 코드를 작성합니다.
2. **Green (Pass)**: 테스트를 통과시키는 최소한의 구현을 진행합니다.
3. **Refactor**: 코드를 정돈하고 전체 테스트 성공을 확인합니다.

## 3. Verification: Document Update
1. **RTM 업데이트**: 모든 테스트가 성공하면 `RTM.md`의 해당 항목 상태를 `Verified`로 변경합니다. (JSON/Table 동시 업데이트)
2. **Evidence**: `walkthrough.md`를 작성하여 테스트 결과와 최종 RTM 상태를 사용자에게 보고합니다.

## 4. Final: Git Sync
1. 변경사항을 커밋하고 푸시합니다. 커밋 메시지에는 관련된 Spec ID를 명시합니다.

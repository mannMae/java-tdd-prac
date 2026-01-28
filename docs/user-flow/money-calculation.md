# Multi-Currency Money Calculation

## User Flow (v1.0)

```mermaid
graph TD
    A[입력: 5 USD] --> B{통화 확인: USD?}
    B -- Yes --> C[달러 연산 로직: 5 * 2]
    B -- No --> D[지원하지 않는 통화 에러]
    
    C --> E[결과 객체 생성: 10 USD]
    E --> F{기대값과 비교: 10 USD?}
    
    F -- 일치 --> G[최종 결과 성공 반환]
    F -- 불일치 --> H[테스트 실패]
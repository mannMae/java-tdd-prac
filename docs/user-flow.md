# 💵 Multi-Currency Money TDD Practice

## 🗺️ User Flow (v1.0)
```mermaid
graph TD
    Start([자산 입력]) --> Input[금액 및 통화 설정]
    Input --> Check{금액 유효성 검사}
    
    Check -- "마이너스/비숫자" --> Error[에러 메시지 출력]
    Check -- "정상" --> Logic[연산 및 환율 적용]
    
    Logic --> Policy{소수점 정책: 내림}
    Policy -- "결과 도출" --> End([최종 합산 결과 출력])

    %% 스타일링
    style Error fill:#f96,stroke:#333
    style End fill:#bbf,stroke:#333
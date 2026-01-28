# Multi-Currency Money Calculation

## User Flow (v1.0)


```mermaid
graph TD
    Start([자산 입력 시작]) --> Input[금액 및 통화 설정]
    Input --> Check{금액 유효성 검사}

    %% [수정된 부분] 에러 발생 시 다시 입력으로 이동
    Check -- "마이너스/비숫자" --> Error[에러 메세지 출력]
    Error -- "재시도" --> Input

    Check -- "정상" --> Logic[연산 및 환율 적용]

    Logic --> Policy{소수점 정책: 내림}
    Policy -- "결과 도출" --> End([최종 합산 결과 출력])

    %% 스타일링
    style Error fill:#f96,stroke:#333
    style End fill:#bbf,stroke:#333
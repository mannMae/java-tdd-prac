Feature: 달러 곱셈 계산 (USD 전용)

    Scenario: 5달러에 2를 곱하면 10달러가 생성되고 값이 일치해야 한다
        Given 입력 금액이 "5 USD" 일 때
        When "2"를 곱하는 달러 연산 로직을 실행하면
        Then 결과 객체는 "10 USD"와 일치해야 한다
package stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import domain.Money;

public class MoneySteps {
    private Money inputAmount;
    private Money resultAmount;
    private Exception exception;

    @Given("입력 금액이 {string} 일 때")
    public void 입력_금액_설정(String rawInput) {
        // 플로우 A & B: 입력받고 통화가 USD인지 확인
        String[] parts = rawInput.split(" ");
        int amount = Integer.parseInt(parts[0]);
        String currency = parts[1];

        if (!currency.equals("USD")) {
            throw new IllegalArgumentException("지원하지 않는 통화입니다."); // 플로우 D
        }
        this.inputAmount = Money.dollar(amount);
    }

    @When("{string}를 곱하는 달러 연산 로직을 실행하면")
    public void 곱셈_로직_실행(String multiplierStr) {
        // 플로우 C & E: 연산 수행 및 결과 객체 생성
        int multiplier = Integer.parseInt(multiplierStr);
        this.resultAmount = inputAmount.times(multiplier);
    }

    @Then("결과 객체는 {string}와 일치해야 한다")
    public void 결과_객체_비교(String expectedRaw) {
        // 플로우 F & G: 기대값(Amount + Currency)과 실제 객체 비교
        String[] parts = expectedRaw.split(" ");
        int expectedAmount = Integer.parseInt(parts[0]);
        
        Money expectedMoney = Money.dollar(expectedAmount);
        
        // assertEquals는 Money 클래스의 equals()를 사용하여 값과 통화를 모두 검증합니다.
        assertEquals(expectedMoney, resultAmount);
    }
}
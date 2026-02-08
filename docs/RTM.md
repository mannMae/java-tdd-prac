# Requirements Traceability Matrix (RTM)

| Req ID | Description | User Flow ID | Spec ID | Test Case ID | Status |
| :--- | :--- | :--- | :--- | :--- | :--- |
| REQ-MONEY-001 | Dollar Multiplication | FLOW-MONEY-001 | SPEC-MONEY-001 | MoneyTest.testMultiplication | [x] Green |
| REQ-MONEY-002 | Money Equality | FLOW-MONEY-002 | SPEC-MONEY-002 | MoneyTest.testEquality | [ ] Red |
| REQ-MONEY-003 | Currency Exchange | FLOW-MONEY-003 | SPEC-MONEY-003 | MoneyTest.testReduceMoney | [ ] Red |
| REQ-MONEY-004 | Multi-currency Addition | FLOW-MONEY-004 | SPEC-MONEY-004 | MoneyTest.testMixedAddition | [ ] Red |

## Traceability Details

### [REQ-MONEY-001] Money Multiplication
- **User Flow**: [money-calculation.md](file:///Users/gimjaeman/Desktop/coding/practice/tdd-practice/docs/user-flow/money-calculation.md)
- **Gherkin**: [money-calculation.md](file:///Users/gimjaeman/Desktop/coding/practice/tdd-practice/docs/user-flow/money-calculation.md) (Consolidated)
- **Verification**: `MoneyTest.testMultiplication` (Dollar/Franc)

### [REQ-MONEY-002] Money Equality
- **User Flow**: [money-calculation.md](file:///Users/gimjaeman/Desktop/coding/practice/tdd-practice/docs/user-flow/money-calculation.md)
- **Gherkin**: [money-calculation.md](file:///Users/gimjaeman/Desktop/coding/practice/tdd-practice/docs/user-flow/money-calculation.md) (Consolidated)
- **Verification**: `MoneyTest.testEquality`

### [REQ-MONEY-003] Currency Exchange
- **User Flow**: [money-calculation.md](file:///Users/gimjaeman/Desktop/coding/practice/tdd-practice/docs/user-flow/money-calculation.md)
- **Gherkin**: [money-calculation.md](file:///Users/gimjaeman/Desktop/coding/practice/tdd-practice/docs/user-flow/money-calculation.md) (Consolidated)
- **Verification**: `MoneyTest.testReduceMoney`

### [REQ-MONEY-004] Multi-currency Addition
- **User Flow**: [money-calculation.md](file:///Users/gimjaeman/Desktop/coding/practice/tdd-practice/docs/user-flow/money-calculation.md)
- **Gherkin**: [money-calculation.md](file:///Users/gimjaeman/Desktop/coding/practice/tdd-practice/docs/user-flow/money-calculation.md) (Consolidated)
- **Verification**: `MoneyTest.testMixedAddition`

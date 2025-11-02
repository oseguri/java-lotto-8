# java-lotto-precourse
# 3.로또

---

## 문제분석

### 기능요구사항

### 입력

- 구매 가격
    - 로또 1장의 가격은 1000원
    - 입력은 1000단위로 나누어 떨어져야 함
        - 1000단위가 아니거나 0인경우 `IllegalArgumentException`  발생
        - 에러 발생 시 `[ERROR] 1000으로 나누어 떨어지는 1000이상의 숫자여야 합니다` 출력
- 당첨 번호
    - 당첨 번호는 `,` 기준으로 6개 숫자를 입력받는다
        - 입력 형태가 올바르지 않은경우 `IllegalArgumentException`  발생
        - 에러 발생 시 `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.` 출력
- 보너스 번호
    - 1~45 정수 하나
- 입력 간 에러 발생 시 해당 부분부터 다시 입력받는다

### 로또 발행

- 개수 : 구매가격 / 1000
- 로또 숫자 n의 범위는 1≤n≤45
- 발행 시 중복되지 않는 6개의 숫자를 뽑는다

### 당첨 내역 출력

- 당첨 기준 및 금액
  - 6개 번호 일치 : 2,000,000,000
  - 5개 번호 일치 + 보너스 번호 일치 : 30,000,000
  - 5개 번호 일치 : 1,500,000
  - 4개 번호 일치 : 50,000
  - 3개 번호 일치 : 5,000
- 당첨에 해당하는 로또 및 총 수익률을 다음과 같은 형태로 출력한다

    ```
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
    ```


---

## 설계하기

### 입력

- class InputManager
- 기능
    - 구입 금액
        - 입력
        - 구입 금액 입력 검증
    - 당첨 번호
        - 입력
        - 당첨 번호 입력 검증
    - 보너스 번호
        - 입력
        - 보너스 번호 검증

### 로또 발행

- class LottoGenerator
    - 랜덤 번호 6개 생성
        - 랜덤 번호는 `pickUniqueNumbersInRange()` 를 통해 뽑는다
    - 생성한 랜덤 번호를 통해 Lotto 객체 생성
- class Lotto
    - 로또 번호를 `List<String> numbers` 형태로 저장
    - 번호 개수를 검증

### 당첨 내역 계산

- class LottoCalculator
    - 입력 받은 당첨 번호 및 보너스 번호 저장
    - Lotto 객체를 입력 받아서 결과 계산
    - 계산 결과를 LottoResult 객체로 저장
- class LottoResult
    - 당첨 결과 저장

### 출력

- class LottoResultPrinter
    - 입력받은 LottoResult 객체를 정해진 형식으로 출력합니다

위 모든 클래스들을 `class LottoApplication` 내부에서 관리합니다

---

## 체크리스트
- [ ] class LottoApplication
  - [ ] test
    - [ ] 통합 테스트
  - [ ] feat
    - [ ] 전체 기능 수행
- [ ]  class InputManager
    - [ ]  test
        - [ ]  구입 금액 검증
        - [ ]  당첨 번호 검증
        - [ ]  보너스 번호 검증
    - [ ]  feature
        - [ ]  입력 기능
        - [ ]  검증
            - [ ]  구입 금액 검증
            - [ ]  당첨 번호 검증
            - [ ]  보너스 번호 검증
- [ ] class InputValidator
  - [ ] test
    - [x] 구입 금액 검증 
    - [ ] 당첨 번호 검증
    - [ ] 보너스 번호 검증
  - [x] feat
    - [x] 구입 금액 검증
    - [x] 당첨 번호 검증
    - [x] 보너스 번호 검증 
- [ ]  class LottoGenerator
    - [ ]  test
        - [ ]  Lotto 객체 생성 테스트
    - [ ]  feature
        - [ ]  랜덤 번호 6개 생성
        - [ ]  Lotto 객체 생성
- [ ]  class Lotto
    - [ ]  test
        - [ ]  번호 개수 검증 테스트
- [ ]  class LottoCalculator
    - [ ]  test
        - [ ]  클래스 생성 테스트
        - [ ]  Lotto 객체 결과 계산
        - [ ]  LottoResult 객체 생성 테스트
    - [ ]  feature
        - [ ]  lotto 객체 결과 계산
        - [ ]  LottoResult 객체 생성
- [ ]  class LottoResult
    - [ ]  test
        - [ ]  객체 생성 테스트
    - [ ]  feature
        - [ ]  결과 저장
- [ ]  class LottoResultPrinter
    - [ ]  feature
        - [ ]  출력
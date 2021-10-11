# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구 사항

### 모델
- 자동차(Car)
    - 자동차 이름(CarName)
        - 자동차 이름은 문자열로 구성되며, 5자 이하만 가능하다.
    - 자동차 드라이버(CarDriver)
        - 자동차 드라이버는 전진할지 멈출지 결정할 수 있다.
    - 자동차의 운전(Movement)
        - 자동차의 N번 운전 후 각 시행별 위치를 알 수 있다.
- 자동차 경주(RaceCarApplication)
    - 자동차 이름을 쉼표로 구분하여 여러 자동차 이름을 받을 수 있다.
    
# 자동차 경주 게임

## 게임 설명

* 각 자동차에 이름을 부여할 수 있다.
  * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  * 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random값이 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.


## 기능 목록

1. 입/출력
    1. 메시지 출력
        * 매 회수마다 실행 결과
        * 게임 결과
    2. 사용자 입력
        * 경주할 자동차 이름
        * 시도할 횟수
2. core
    1. 최종 우승자 판별


## 프로그램 실행 결과

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi:-
crong:
honux:-

pobi:--
crong:-
honux:--

pobi:---
crong:--
honux:---

pobi:----
crong:---
honux:----

pobi:-----
crong:----
honux:-----

최종 우승자는 pobi,honux 입니다.
```

## 디렉터리 구조

```
└─src
    ├─main
    │  └─java
    │      ├─nextstep
    │      │  └─utils
    │      │          Console.java                  // Console 관련 utils
    │      │          Randoms.java                  // Random 숫자 관련 utils
    │      │
    │      └─racinggame
    │          │  Application.java                  // Game App(게임 시작)
    │          │  GamePlayer.java                   // Game player
    │          │
    │          ├─domain
    │          │      Car.java                      // Car name
    │          │      Cars.java                     // Car name list
    │          │      Result.java                   // Game 결과
    │          │      Step.java                     // Car 전진 step
    │          │      TryCount.java                 // 시도 회수
    │          │
    │          ├─exception
    │          │      GameErrorCode.java            // Game error code
    │          │      GameException.java            // Game 전역 Exception 처리
    │          │      GameExceptionChecker.java     // Game Exception checker
    │          │
    │          └─message
    │                  MessageHandler.java          // Message 처리기
    │                  NoticeMessage.java           // Notice message
    │
    └─test
        └─java
            ├─nextstep
            │  └─test
            │          NSTest.java
            │
            └─racinggame
                │  ApplicationTest.java
                │
                └─domain
                        CarsTest.java
                        CarTest.java
                        StepTest.java
                        TryCountTest.java
```
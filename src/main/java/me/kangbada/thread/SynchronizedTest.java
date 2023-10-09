package me.kangbada.thread;

import javax.security.auth.login.AccountException;

public class SynchronizedTest {
    // 메소드에 synzhronized 키워드를 사용한다.
    // 모니터는 현재 클래스 인스턴스의 락을 검사한다.
    public synchronized String drawingOut(String money) throws AccountException {
        // 기타 고객 데이터 초기화 작업
        initSomething();

        // 1. 잔액을 계산한다.
        // 2. 통장의 잔액이 찾을 금액보다 크다면 정상처리하고 반대일 경우 AccountExeption 을 던진다.

        // 마무리 작업을 하고 남은 금액을 리턴한다.
        finish();
        return "something";
    }

    public void initSomething() {

    }

    public void finish() {

    }
}

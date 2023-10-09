package me.kangbada.thread;

import javax.security.auth.login.AccountException;

public class SynchronizedBlockTest {
    Object userAccount;

    public String drawingOut(String money) throws AccountException {
        // 기타 고객 데이터 초기화 작업
        initSomething();

        // 공유 데이터의 대상인 고객의 통장을 락의 대상으로 설정한다.
        // 모니터는 userAccount 인스턴스의 락을 검사한다.
        synchronized (userAccount) {
            // 1. 잔액을 계산한다.
            // 2. 통장의 잔액이 찾을 금액보다 크다면 정상적으로 처리한다.
            //    반대일 경우에는 AccountException 을 던진다.
            // 이처럼 필요한 부분만 블록 형태로 동기화하는 것이 더 효율적이다.
        }

        // 마무리 작업을 하고 남은 금액을 리턴한다.
        finish();
        return "something";
    }

    public void initSomething() {

    }

    public void finish() {

    }
}

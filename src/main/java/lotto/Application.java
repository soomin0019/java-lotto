package lotto;

import java.io.Console;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //로또 구입 금액 입력
        int lotteryMaxMoney;

        //당첨 번호 입력(고정된 여섯)

        //보너스 번호 입력(하나)
        Lotto.inputLotteryNumber();

        //로또 수량과 구매한 로또 번호 출력(오름차순, 랜덤 출력)

        //당첨 내역 출력

        //수익룰

        //예외처리

    }

    //로또 구입 금액 입력
    private int buyLotteryMoney(int LotteryMaxMoney){
        System.out.println("구입 금액을 입력해주세요.");
        LotteryMaxMoney = Integer.parseInt(Console.readLine());

        if (LotteryMaxMoney > 1000) {
            int MaxLotteryNumber = (int)(LotteryMaxMoney/1000);

        }


        return MaxLotteryNumber;
    }
}

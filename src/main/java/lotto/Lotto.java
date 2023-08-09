package lotto;

import java.util.List;
import java.util.Scanner;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static void inputLotteryNumber() {
        Scanner lotteryNumber = new Scanner(System.in);

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    //로또 숫자 지정 7개(6+1)

    //로또 숫자랑 입력 숫자 정렬해서 비교하면 되지 않을까

    //pickUniqueNumbersInRange()
    

}

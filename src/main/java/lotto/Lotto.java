package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Random.*;

public class Lotto {
    private List<List<Integer>> lotteryNumbers = new ArrayList<>();
    int lotteryMoney;
    final int lotteryPrice = 1000;
    List<Integer> correctLottoNumber = new ArrayList<>();
    final int[] rankNumber = new int[7];

    //public static List<Integer> lottoNumbers()

//    public Lotto(List<Integer> lotteryNumbers) {
//        validate();
//        this.lotteryNumbers = lotteryNumbers;
//    }

    // TODO: 추가 기능 구현
    void Start(){
        buyLotteryMoney();
        randomLotteryNumbers();
        inputLotteryNumber();
        rankResult();
    }

    //로또 구입 금액 입력, 구매한 로또 수량 쿨력
    private int buyLotteryMoney(){
        System.out.println("구입 금액을 입력해주세요.");
        lotteryMoney = Integer.parseInt(Console.readLine());

        if (lotteryMoney < lotteryPrice) {
            System.out.println("!!로또는 1000원 이상입니다. 1000원 이상의 금액을 입력하세요");
            throw new IllegalArgumentException();
        }

        int randomTheNumberOfLottery = (int)(Math.random()*(lotteryMoney/1000)+1);
        System.out.println( randomTheNumberOfLottery + "개를 구매했습니다.");

        return randomTheNumberOfLottery;
    }



    //구매한 로또 번호 출력(오름차순, 랜덤 출력)
    private void randomLotteryNumbers () {
        ;
        for(int lottoPaper=0; lottoPaper < buyLotteryMoney(); lottoPaper++){
            lotteryNumbers.add(getLotteriesNumbers());
        }

        for(List<Integer> lottoNumber : lotteryNumbers){
            System.out.println(lottoNumber);
        }

    }
    //구매할 로또들 랜덤 구하기
    private List<Integer> getLotteriesNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
        //pickUniqueNumbersInRange()
    }

    //로또 번호 6자리 입력 + 보너스 번호 1자리
    public void inputLotteryNumber() {
//        InputStreamReader sixNumber = new InputStreamReader(System.in);
//        BufferedReader lottoNumber = new BufferedReader(sixNumber);

        System.out.println("당첨 번호를 입력해 주세요.");
        correctLottoNumber = Stream.of(Console.readLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("보너스 번호를 입력해주세요.");
        correctLottoNumber.add(Integer.parseInt(Console.readLine()));

        validate();
    }



    //로또 숫자랑 입력 숫자 정렬해서 비교하면 되지 않을까
    private void compareCorrectAndNumbers(List<Integer>lottoNumber){
        int correctNumberDigits = 0;
        for (int digit = 0; digit < lottoNumber.size(); digit++){
            if(correctLottoNumber.get(digit).equals(lottoNumber)){
                correctNumberDigits++;
            }
        }
        if(correctNumberDigits==5 && lottoNumber.contains(correctLottoNumber.get(6))){
            rankNumber[7]++;
        }
        rankNumber[correctNumberDigits]++;

    }

    //당첨 내역 출력
    private void rankResult(){
        for(List<Integer>lottoNumber : lotteryNumbers){
            compareCorrectAndNumbers(lottoNumber);
        }
        System.out.printf("3개 일치 (5,000원) - %d개\n", rankNumber[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", rankNumber[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", rankNumber[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rankNumber[7]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", rankNumber[6]);

        //수익룰
        System.out.printf("총 수익률은 %.1f",
                (float)(rankNumber[3]*5000+rankNumber[4]*50000+rankNumber[5]*1500000+rankNumber[7]*30000000+rankNumber[6]*2000000000)/lotteryMoney);
        System.out.print("%입니다.\n");

    }



    //예외처리 - 로또 자리 6개
    private void validate() {
        if (lotteryNumbers.size() != 6) {
            System.out.println("!!로또 번호 6개");
            throw new IllegalArgumentException();
        }
        for (Integer lottoNumber : correctLottoNumber){
            if (lottoNumber > 45 || lottoNumber < 1){
                System.out.println("!!로또 1부터 45까지 숫자입니다.");
                throw new IllegalArgumentException();
            }
        }
    }

}


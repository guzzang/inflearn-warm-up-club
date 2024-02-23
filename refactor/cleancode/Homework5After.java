package refactor.cleancode;

import java.util.Scanner;

public class Homework5After {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rollCount = returnRollCount(scanner);

        int sideOfDice = selectSideOfDice(scanner);

        int[] diceNumberList = makeDiceNumberListAndMakecalculateResultOfSideOfDice(rollCount, sideOfDice);

        printResults(sideOfDice,diceNumberList);


    }

    static int returnRollCount(Scanner scanner){
        System.out.print("주사위를 몇 번 던질지 입력하세요 : ");
        int rollCount = scanner.nextInt();
        return rollCount;
    }

    static int selectSideOfDice(Scanner scanner){
        System.out.print("주사위가 몇 개의 면을 가지고 있는지 입력하세요 : ");
        int sideOfDice = scanner.nextInt();
        return sideOfDice;
    }

    static int[] makeDiceNumberListAndMakecalculateResultOfSideOfDice(int rollCount, int sideOfDice){
        int[] diceNumberList = new int[sideOfDice + 1];
        for (int i = 0; i < rollCount; i++) {
            int resultNumber = (int)(Math.random() * sideOfDice) + 1;
            diceNumberList[resultNumber]++;
        }
        return diceNumberList;
    }

    // 한 걸음 더 !
    // 주사위가 1~6까지만 있다는 가정이 아닌 1~12 , 1~20 까지 있다면 코드를 많이 수정해야함
    // 따라서 주사위의 숫자 범위가 달라지더라도 코드를 적게 수정할 수 있도록 고민해 볼 수 있다.

    // double b = Math.random() * 6  <- 이 숫자가 주사위가 몇 개의 면을 가지고 있는지를 알려준다.
    // 코드를 확인해보니 주사위가 몇 개의 면을 가지고 있는지를 활용하여 주사위의 각 숫자가 몇 번 나왔는지 알려주고 있었다.
    // 주사위가 몇 개의 면을 가지고 있는지를 input으로 받는 method와
    // 입력 받은 주사위 면 개수 input으로 배열을 만들고 배열의 요소인 결과로 나온 주사위 숫자들을 조건에 맞으면 1씩 증가시켜주는 method라는 생각을 해보았다.
    // 그 결과 selectSideOfDice와 makeDiceNumberListAndMakecalculateResultOfSideOfDice라는 method를 만들어 리팩토링을 할 수 있었다.
    // 이렇게 코드를 짜면 주사위의 숫자 범위가 달라지더라도 함수에 넘겨주는 인수만 변경하면 되기 때문에 코드를 적게 수정할 수 있다.


    static void printResults(int sideOfDice, int[] diceNumberList){
        for(int i = 1; i <= sideOfDice; i++){
            System.out.printf("%d은 %d번 나왔습니다.\n", i, diceNumberList[i]);
        }
    }

}

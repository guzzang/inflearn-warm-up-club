package refactor.cleancode;

import java.util.Scanner;

public class Homework5Before {

    // 클린코드의 기본 법칙 : 클래스는 작아야 하며 하나의 책임만 맡도록, 함수는 최대한 작게 하나의 일만 수행하도록 해야함
    // + 함수명 메서드명 필드명은 최대한 직관적으로 작성해야함

    public static void main(String[] args) {
        System.out.print("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        // 주사위를 던지는 횟수를 input으로 받는 코드 -> method를 활용하여 더 직관적으로 짤 수 있지 않을까 ?

        int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0;

        // int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0; 같은 자료형의 반복 -> 배열로 만들면 훨씬 편하지 않을까 ?

        for (int i = 0; i < a; i++) {
            double b = Math.random() * 6;
            if (b >= 0 && b < 1) {
                r1++;
            } else if (b >= 1 && b < 2) {
                r2++;
            } else if (b >= 2 && b < 3) {
                r3++;
            } else if (b >= 3 && b < 4) {
                r4++;
            } else if (b >= 4 && b < 5) {
                r5++;
            } else if (b >= 5 && b < 6) {
                r6++;
            }
        }

        // 주사위 던지는 수만큼 반복하여 나온 숫자가 몇 번 나왔는지를 알려주는 코드 -> 코드가 덩어리처럼 보인다 -> method로 뽑아낼 수 있지 않을까?


        System.out.printf("1은 %d번 나왔습니다.\n", r1);
        System.out.printf("2은 %d번 나왔습니다.\n", r2);
        System.out.printf("3은 %d번 나왔습니다.\n", r3);
        System.out.printf("4은 %d번 나왔습니다.\n", r4);
        System.out.printf("5은 %d번 나왔습니다.\n", r5);
        System.out.printf("6은 %d번 나왔습니다.\n", r6);

        // System.out.printf 문이 반복되고 한 덩어리처럼 보인다. -> method로 뽑아낼 수 있지 않을까?

    }


}

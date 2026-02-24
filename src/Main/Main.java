package Main;

import java.util.*;
import ru.stryapunin.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Выберите задание(1/2/3)");
        System.out.print(": ");
        int choose_task = scanner.nextInt();
        switch (choose_task) {
            case 1: {
                int switch_choose;
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Выберите задачу(1/3)");
                System.out.print(": ");
                switch_choose = scanner.nextInt();
                switch (switch_choose) {
                    case 1: {
                        int z;
                        System.out.print("Введите число x: ");
                        scanner.nextInt();

                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("Результат: ");
                        break;
                    }
                    case 3: {
                        int x, z;
                        System.out.print("Введите число x: ");
                        x = scanner.nextInt();

                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("Результат: ");
                        break;
                    }
                    default: {
                        System.out.println("Нет задачи в задании");
                        break;
                    }
                }
                break;
            }// Задача 1
            case 2: {
                System.out.println("-----------------------------------------------------------------------------------------");

                System.out.println("-----------------------------------------------------------------------------------------");
                break;
            }// Задача 2
            case 3: {
                int switch_choose;
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Выберите задачу(1/2/3/4)");
                System.out.print(": ");
                switch_choose = scanner.nextInt();
                switch (switch_choose) {
                    case 1: {

                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                    case 2: {

                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                    case 3: {

                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                    case 4: {

                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }

                    default: {
                        System.out.println("Нет задачи в задании");
                        break;
                    }
                }
                break;
            }// Задача 3

        }
    }
}
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
                        Generalized_Box();
                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                    case 3: {
                        Comparable();
                        System.out.println("-----------------------------------------------------------------------------------------");
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

        private static void Generalized_Box() { //Задача 1
            Box<Integer> box = new Box<>();
            while (true) {
                System.out.println("\n1. Положить число: ");
                System.out.println("2. Извлечь число: ");
                System.out.println("3. Посмотреть статус: ");

                int action = input.getInt("Действие: ");

                try {
                    switch (action) {
                        case 1 -> {
                            int value = input.getInt("Введите значение: ");
                            box.put(value);
                        }
                        case 2 -> {
                            Integer value = box.get();
                            if (value == null) {
                                System.out.println("Коробка пуста");
                            } else {
                                System.out.println("Извлечено значение: " + value);
                            }
                        }
                        case 3 -> System.out.println("status: " + box);
                        default -> System.out.println("Неверная команда");
                    }
                } catch (IllegalStateException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }
        private static void Comparable(Object obj){

        }
    }
}
package Main;

import java.util.*;
import ru.stryapunin.Box;
import ru.stryapunin.Comparable;

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
                        generalized_Box();
                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                    case 3: {
                        comparable();
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
                maxBoxes();
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
        private static void generalized_Box() { //Задача 1.1
            Box<Integer> box = new Box<>();
            Scanner scanner1 = new Scanner(System.in);
            while (true) {
                System.out.println("\n1. Положить число: ");
                System.out.println("2. Извлечь число: ");
                System.out.println("3. Посмотреть статус: \n");
                int temp;
                temp = scanner1.nextInt();
                try {
                    switch (temp) {
                        case 1: {
                            System.out.print("введите число: ");
                            int value = scanner1.nextInt();
                            box.put(value);
                            break;
                        }
                        case 2: {
                            Integer value = box.get();
                            if (value == null) {
                                System.out.println("Коробка пуста");
                            } else {
                                System.out.println("Извлечено значение: " + value);
                            }
                            break;
                        }
                        case 3: System.out.println("status: " + box);break;
                        default: System.out.println("Неверная команда"); break;
                    }
                } catch (IllegalStateException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        }

        private static void comparable() { //Задача 1.3
            Scanner scanner2 = new Scanner(System.in);
            class string implements Comparable<String> {
                private String x;

                public string(String x) {
                    this.x = x;
                }

                @Override
                public int compare(String obj) {
                    return this.x.compareTo(obj);
                }
            }
            System.out.print("введите число 1: ");
            String n1 = scanner2.nextLine();
            System.out.print("введите число 2: ");
            String n2 = scanner2.nextLine();
            string x = new string(n1);
            int result = x.compare(n2);
            System.out.println("Сравнение чисел: " + result);
        }
    private static void maxBoxes() { //Задача 2.2
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Введите количество коробок: ");
        int count = scanner3.nextInt();
        if (count <= 0) {
            System.out.println("Количество должно быть больше чем 0");
            return;
        }

        List<Box<? extends Number>> boxes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Box<Double> b = new Box<>();
            System.out.println("Введите число для коробки " + (i + 1) + ": ");
            double val = (double) scanner3.nextInt();
            b.put(val);
            boxes.add(b);
        }

        double max = Double.NEGATIVE_INFINITY;
        for (Box<? extends Number> box : boxes) {
            if (box.isFull()) {
                // Извлекаем значение
                double val = box.get().doubleValue();
                if (val > max) {
                    max = val;
                }
            }
        }
        System.out.println("Максимальное значение среди " + count + " коробок: " + max);
    }

}
package Main;

import java.util.*;
import java.util.function.*;
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
                        task3_1();
                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                    case 2: {
                        task3_2();
                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                    case 3: {
                        task3_3();
                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                    case 4: {
                        task3_4();
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

    private static <T, P> List<P> map(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
    private static void task3_1() { // //Задача 3.1
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengths = map(strings, String::length);
        System.out.println("1. Длины строк " + strings + " : " + lengths);
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> absolutes = map(numbers, Math::abs);
        System.out.println("2. Модули чисел " + numbers + " : " + absolutes);
        List<int[]> arrays = Arrays.asList(
                new int[]{1, 2, 3},
                new int[]{-1, -2, -3},
                new int[]{5, 0, 5}
        );
        List<Integer> maxValues = map(arrays, arr -> Arrays.stream(arr).max().orElse(Integer.MIN_VALUE));
        System.out.print("3. Максимумы массивов: ");
        for (int[] arr : arrays) System.out.print(Arrays.toString(arr) + " ");
        System.out.println("-> " + maxValues);
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
    private static void task3_2() { //Задача 3.2
        System.out.println("--- Задача 3.2. Фильтр ---");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<String> longStrings = filter(strings, s -> s.length() >= 3);
        System.out.println("1. Строки длиной >=3 из " + strings + " : " + longStrings);
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> nonPositive = filter(numbers, n -> n <= 0);
        System.out.println("2. Не положительные числа из " + numbers + " : " + nonPositive);
        List<int[]> arrays = Arrays.asList(
                new int[]{1, 2, 3},
                new int[]{-1, -2, -3},
                new int[]{0, -5, -1}
        );
        List<int[]> noPositiveArrays = filter(arrays, arr -> Arrays.stream(arr).allMatch(n -> n <= 0));
        System.out.print("3. Массивы без положительных элементов: ");
        for (int[] arr : noPositiveArrays) System.out.print(Arrays.toString(arr) + " ");
        System.out.println();
    }

    private static <T> T reduce(List<T> list, T identity, BinaryOperator<T> accumulator) {
        T result = identity;
        for (T item : list) {
            result = accumulator.apply(result, item);
        }
        return result;
    }
    private static void task3_3() { //Задача 3.3
        System.out.println("--- Задача 3.3. Сокращение ---");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        String concatenated = reduce(strings, "", (a, b) -> a + b);
        System.out.println("1. Конкатенация строк " + strings + " : \"" + concatenated + "\"");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        Integer sum = reduce(numbers, 0, Integer::sum);
        System.out.println("2. Сумма чисел " + numbers + " : " + sum);
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6)
        );
        List<Integer> sizes = map(listOfLists, List::size);
        Integer totalElements = reduce(sizes, 0, Integer::sum);
        System.out.println("3. Общее количество элементов в " + listOfLists + " : " + totalElements);
        List<String> empty = Collections.emptyList();
        String emptyResult = reduce(empty, "default", (a, b) -> a + b);
        System.out.println("   Пустой список -> результат: \"" + emptyResult + "\"");
    }

    private static <T, C> C collect(List<T> list, Supplier<C> supplier, BiConsumer<C, T> accumulator) {
        C collection = supplier.get();
        for (T item : list) {
            accumulator.accept(collection, item);
        }
        return collection;
    }
    private static void task3_4() { //Задача 3.4
        System.out.println("--- Задача 3.4. Коллекционирование ---");
        List<Integer> numbers = Arrays.asList(1, -3, 7, -2, 0, 5);
        List<List<Integer>> partitioned = collect(numbers,
                () -> {
                    List<List<Integer>> lists = new ArrayList<>();
                    lists.add(new ArrayList<>());
                    lists.add(new ArrayList<>());
                    return lists;
                },
                (lists, n) -> {
                    if (n > 0) lists.get(0).add(n);
                    else lists.get(1).add(n);
                }
        );
        System.out.println("1. Числа " + numbers + " -> положительные: " + partitioned.get(0)
                + ", не положительные: " + partitioned.get(1));
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw", "abc", "hello");
        Map<Integer, List<String>> groupedByLength = collect(strings,
                HashMap::new,
                (map, s) -> map.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s)
        );
        System.out.println("2. Группировка строк по длине: " + groupedByLength);
        List<String> withDuplicates = Arrays.asList("qwerty", "asdfg", "qwerty", "qw", "asdfg");
        Set<String> uniqueSet = collect(withDuplicates, HashSet::new, Set::add);
        System.out.println("3. Уникальные строки из " + withDuplicates + " : " + uniqueSet);
    }
}
package part1.lesson07;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Класс для подсчета факториалов чисел.
 */
public class FactorialCalculator {
    /**
     * Поле для хранения подсчитанных факториалов
     */
    public static Map<Integer, Future<BigInteger>> factorials = new TreeMap<>();

    /**
     * Получение факториалов всех элементов массива
     *
     * @param numbers список значений, для которых будут вычислены факториалы.
     * @return возвращает список подсчитанных значений факториалов
     */
    public static List<BigInteger> getFactorials(List<Integer> numbers) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        List<BigInteger> results = new ArrayList<>();

        //подготовка потоков вычислений
        for (Integer num : numbers) {
            if (factorials.containsKey(num)) {
                continue;
            }
            factorials.put(num, service.submit(new OneFactorialCalculator(num)));
        }

        //запуск потоков вычислений и сбор результатов
        for (Integer num : numbers) {
            try {
                results.add(factorials.get(num).get());
            } catch (ExecutionException | InterruptedException e) {
                results.add(null);
            }
        }

        return results;
    }
}

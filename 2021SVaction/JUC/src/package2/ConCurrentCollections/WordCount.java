package package2.ConCurrentCollections;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

//单次计数
public class WordCount {
    static final String ALPHA = "abcedfghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        /*int length = ALPHA.length();
        int count = 200;
        List<String> list = new ArrayList<>(length * count);
        //字符串中的每个字母存200份
        for (int i = 0; i < length; i++) {
            char ch = ALPHA.charAt(i);
            for (int j = 0; j < count; j++) {
                list.add(String.valueOf(ch));
            }
        }
        //打乱集合
        Collections.shuffle(list);
        //存入26个文件中
        for (int i = 0; i < 26; i++) {
            try (PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("tmp/" + (i + 1) + ".txt")))) {
                String collect = list.subList(i * count, (i + 1) * count).stream().collect(Collectors.joining("\n"));
                out.print(collect);
            } catch (IOException e) {
            }
        }*/

        /*demo(
                // 创建 map 集合
                // 创建 ConcurrentHashMap 对不对？
                () -> new HashMap<String, Integer>(),
                // 会出现线程安全问题
                (map, words) -> {
                    for (String word : words) {
                        //map中没有返回null
                        Integer counter = map.get(word);
                        int newValue = counter == null ? 1 : counter + 1;
                        map.put(word, newValue);
                    }
                }
        );*/
        demo(
                // 创建 map 集合
                // 创建 ConcurrentHashMap 对不对？
                // 不对,是线程安全集合,只是每个方法是原子的,但多个操作组合起来就不是原子的,不安全
                () -> new ConcurrentHashMap<String, LongAdder>(),
                // 会出现线程安全问题
                (map, words) -> {
                    for (String word : words) {
                        /*
                        //使用synchronized可以,但是锁粒度太大,影响并发度,性能不高
                        synchronized (map) {
                            Integer counter = map.get(word);
                            int newValue = counter == null ? 1 : counter + 1;
                            map.put(word, newValue);
                        }*/

                        //检查是否缺少一个key,如果缺少,则计算生成一个value(1),<key,value>放入map中,返回结果为value值
                        //LongAdder初始值为零
                        LongAdder value = map.computeIfAbsent(word, (key) -> new LongAdder());
                        //执行累加操作(cas)
                        value.increment();
                    }
                }
        );
    }

    /**
     * @param supplier 提供保存结果的map集合
     * @param consumer 消费者
     * @param <V>      泛型
     */
    private static <V> void demo(Supplier<Map<String, V>> supplier, BiConsumer<Map<String, V>, List<String>> consumer) {
        //
        Map<String, V> counterMap = supplier.get();
        //线程集合
        List<Thread> ts = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            int idx = i;
            Thread thread = new Thread(() -> {
                //读取文件,结果存放在words中
                List<String> words = readFromFile(idx);
                consumer.accept(counterMap, words);
            });
            ts.add(thread);
        }
        //启动线程
        ts.forEach(t -> t.start());
        //join: 等待所有线程执行完毕
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //打印每个单词以及对应的次数
        System.out.println(counterMap);
    }

    public static List<String> readFromFile(int i) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src/tmp/" + i + ".txt")))) {
            while (true) {
                //每行单词
                String word = in.readLine();
                if (word == null) {
                    break;
                }
                words.add(word);
            }
            //返回这个文件中的所有单词
            return words;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
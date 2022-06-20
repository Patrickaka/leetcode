package bags;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture的AllOf功能测试，等待所有任务执行完
 */
class CompletableFutureAllOfTest {

    public static void main(String[] args) throws Exception {
        List<String> result = new ArrayList<String>();
        List<String> carOrderList = new ArrayList<String>();
        carOrderList.add("123");
        carOrderList.add("456");
        carOrderList.add("789");
        carOrderList.add("234");
        carOrderList.add("345");
        carOrderList.add("567");
        CompletableFuture[] mysqlFuture = carOrderList.stream().map(s -> CompletableFuture.runAsync(() -> {
            result.add(s);
        })).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(mysqlFuture).join();
        System.out.println(result);
    }

    /**
     * 拆解写法
     *
     * @param
     */
    public static void method1() {
        long start = System.currentTimeMillis();
        // 定义第一个任务
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "cf1";
        });

        cf1.whenComplete((t, u) -> System.out.println("hello " + t));

        // 定义第二个任务
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return "cf2";
        });

        cf2.whenComplete((t, u) -> System.out.println("hello " + t));
        // 开始等待所有任务执行完成
        CompletableFuture<Void> all = CompletableFuture.allOf(cf1, cf2);
        System.out.println("start block");
        all.join();
        System.out.println("block finish, consume time:" + (System.currentTimeMillis() - start));
    }

    /**
     * 合并写法
     *
     * @param
     */
    public static void method2() {
        List<String> testList = new ArrayList<>();
        testList.add("cf1");
        testList.add("cf2");
        long start = System.currentTimeMillis();
        CompletableFuture<Void> all = null;
        for (String str : testList) {
            // 定义任务
            CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return str;
            });

            cf.whenComplete((t, u) -> System.out.println("hello " + t));
            all = CompletableFuture.allOf(cf);
        }
        System.out.println("start block");
        // 开始等待所有任务执行完成
        all.join();
        System.out.println("block finish, consume time:" + (System.currentTimeMillis() - start));
    }

    /**
     * 通过Java8的stream实现，非常简洁
     *
     * @param
     */
    @SuppressWarnings("rawtypes")
    public static void method3() {
        List<String> testList = new ArrayList<>();
        testList.add("cf1");
        testList.add("cf2");
        long start = System.currentTimeMillis();
        CompletableFuture[] cfArr = testList.stream().
                map(t -> CompletableFuture
                        .supplyAsync(() -> pause(t))
                        .whenComplete((result, th) -> {
                            System.out.println("hello" + result);
                        })).toArray(CompletableFuture[]::new);
        // 开始等待所有任务执行完成
        System.out.println("start block");
        CompletableFuture.allOf(cfArr).join();
        System.out.println("block finish, consume time:" + (System.currentTimeMillis() - start));
    }

    public static String pause(String name) {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return name;
    }

}
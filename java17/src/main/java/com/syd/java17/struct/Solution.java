package com.syd.java17.struct;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

import static com.syd.java17.struct.ListNode.parseListNode;
import static com.syd.java17.struct.TreeNode.parseTreeNode;

/**
 * @author asus
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n;
        String s, s2;
        int[] nums, nums2;
        int[][] mat, mat2;
        String[] strs, strs2;
        List<Integer> li;
        List<String> ls;
        char[] cs;
        TreeNode root;
        ListNode node;


    }


    public static void printStringList(Collection<String> list) {
        System.out.print("[");
        Iterator<String> it = list.iterator();
        int n = list.size() - 1;
        for (int i = 0; i < n; i++) {
            System.out.printf("\"%s\", ", it.next());
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.printf("\"%s\"]", it.next());
    }

    public static <T> T parseObject(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    public static int[] parseIntArray(String str) {
        return parseObject(str, int[].class);
    }

    public static int[][] parseIntMatrix(String str) {
        return parseObject(str, int[][].class);
    }

    public static String[] parseStringArray(String str) {
        return parseObject(str, String[].class);
    }

    public static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder("[");
        for (Object o : list) {
            sb.append(o).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }

    public static String arrayToString(Object[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (Object o : array) {
            sb.append(o).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }

    public static Executable[] getExecutableArray(Class<?> clazz, String str, Map<String, Class<?>[]> argTypeMap)
            throws ClassNotFoundException, NoSuchMethodException {
        String[] strings = parseStringArray(str);
        int n = strings.length;
        Executable[] res = new Executable[n];
        res[0] = clazz.getDeclaredConstructor(argTypeMap.get(strings[0]));
        for (int i = 1; i < n; i++) {
            res[i] = clazz.getDeclaredMethod(strings[i], argTypeMap.get(strings[i]));
        }
        return res;
    }

    public static Object[][] getArgsArray(String str) {
        return parseObject(str, Object[][].class);
//        List<Object[]> parse = JSONArray.parseArray(str, Object[].class);
//        return parse.toArray(new Object[0][]);
    }

    public static Object[] getInvokeResults(
            Class<?> clazz, String execStr, String argsStr, Map<String, Class<?>[]> argTypeMap)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Executable[] executables = getExecutableArray(clazz, execStr, argTypeMap);
        Object[][] argsArray = getArgsArray(argsStr);
        assert executables.length == argsArray.length;
        int n = executables.length;
        Object[] results = new Object[n];
        assert executables[0] instanceof Constructor;
        Object obj = ((Constructor<?>) executables[0]).newInstance(argsArray[0]);
        for (int i = 1; i < n; i++) {
            assert executables[i] instanceof Method;
            results[i] = ((Method) executables[i]).invoke(obj, argsArray[i]);
        }
        return results;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class DTO {
        String id;
        AbstractMap<BigInteger, BigDecimal> concurrentMap = new ConcurrentHashMap<>();
        Map<Date, Arrays> map = new TreeMap<>();
        List<Collections> list = new CopyOnWriteArrayList<>();
        Queue<Calendar> collection = new ConcurrentLinkedDeque<>();
        JSONAware json = JSONObject.parseArray(new JSONArray().toJSONString());
        Field field = (Field) Proxy.newProxyInstance(DTO.class.getClassLoader(), DTO.class.getInterfaces(),
                (o, m, a) -> m.invoke(o, a));
        ExecutorService service = Executors.newCachedThreadPool();
        Pattern pattern = Pattern.compile("^.*?$");
        Matcher matcher = pattern.matcher("");
        RoundingMode mode = RoundingMode.CEILING;
        IntStream intStream = StreamSupport.intStream(Spliterators.emptyIntSpliterator(), true);
        DoubleStream doubleStream = StreamSupport.doubleStream(Spliterators.emptyDoubleSpliterator(), true);
        Stream<Integer> stream = Arrays.stream(new int[0]).boxed().collect(Collectors.toList()).stream();


        public static void main(String[] args) {
            parseTreeNode("[]");
            parseListNode("[]");
        }
    }
}



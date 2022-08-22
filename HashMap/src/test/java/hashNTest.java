import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class hashNTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_1")
    public void regressionTest1() throws Exception {
        Integer[] nums1 = {3, 5, 2, 5, 8, 10, 3, 8, 8, 6, 6, 2, 1, 1, 2, 5, 4, 9, 2, 9, 7, 4, 8, 3, 5, 6, 2, 9, 4, 5, 7, 5, 8, 7, 8, 3, 10, 2, 9, 8, 3, 4, 7, 6, 6, 10, 5, 10, 4, 7, 3, 6, 8, 1, 2, 8, 10, 1, 1, 4, 2, 5, 5, 2, 5, 7, 3, 5, 3, 4, 7, 1, 4, 8, 5, 10, 1, 6, 8, 5, 1, 4, 6, 2, 3, 9, 6, 3, 5, 8, 8, 7, 2, 1, 6, 2, 5, 3, 9, 10};
        Integer[] nums1_1 = {2, 3, 5, 6, 8};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_2")
    public void regressionTest2() throws Exception {
        Integer[] nums1 = {6, 10, 5, 1, 7, 3, 4, 6, 4, 10, 7, 9, 3, 4, 7, 10, 9, 10, 5, 10, 8, 3, 1, 7, 8, 4, 7, 3, 3, 9, 6, 6, 2, 1, 9, 1, 8, 10, 6, 6, 9, 2, 2, 10, 2, 3, 6, 9, 6, 3, 8, 7, 3, 9, 6, 8, 6, 3, 10, 3, 8, 6, 3, 2, 10, 9, 5, 9, 5, 5, 2, 4, 1, 6, 1, 5, 8, 7, 2, 5, 2, 6, 5, 2, 4, 10, 10, 7, 1, 2, 5, 3, 2, 2, 10, 6, 8, 4, 6, 4};
        Integer[] nums1_1 = {2, 3, 6, 10};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_3")
    public void regressionTest3() throws Exception {
        Integer[] nums1 = {1, 9, 7, 7, 3, 5, 9, 8, 2, 3, 6, 8, 6, 5, 10, 4, 3, 9, 1, 1, 5, 9, 4, 6, 5, 8, 10, 8, 6, 4, 2, 8, 8, 5, 2, 9, 3, 6, 2, 2, 1, 1, 2, 8, 10, 3, 2, 7, 2, 6, 4, 6, 3, 9, 3, 4, 9, 7, 6, 8, 9, 10, 1, 9, 5, 1, 1, 10, 7, 9, 10, 10, 4, 9, 2, 6, 3, 3, 4, 8, 9, 6, 7, 2, 4, 5, 6, 5, 9, 4, 9, 3, 9, 9, 6, 9, 6, 8, 4, 2};
        Integer[] nums1_1 = {2, 3, 4, 6, 8, 9};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_4")
    public void regressionTest4() throws Exception {
        Integer[] nums1 = {5, 5, 7, 7, 3, 4, 8, 3, 8, 3, 9, 5, 3, 9, 7, 2, 10, 1, 2, 2, 10, 10, 8, 3, 2, 5, 10, 3, 2, 8, 5, 5, 9, 5, 2, 1, 7, 9, 4, 6, 9, 1, 3, 6, 5, 1, 8, 1, 4, 7, 3, 9, 2, 6, 5, 1, 5, 4, 4, 8, 2, 3, 9, 3, 6, 9, 6, 8, 2, 8, 2, 10, 5, 3, 6, 7, 4, 9, 9, 8, 8, 8, 3, 3, 9, 5, 7, 2, 2, 1, 1, 3, 9, 9, 6, 8, 1, 9, 10, 10};
        Integer[] nums1_1 = {2, 3, 5, 8, 9};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_5")
    public void regressionTest5() throws Exception {
        Integer[] nums1 = {4, 2, 9, 7, 2, 7, 2, 2, 5, 8, 1, 8, 3, 5, 10, 10, 10, 8, 7, 9, 2, 5, 10, 10, 3, 9, 2, 2, 6, 3, 4, 4, 1, 10, 1, 10, 1, 3, 7, 2, 9, 8, 6, 6, 5, 3, 8, 4, 1, 1, 10, 1, 3, 2, 2, 8, 1, 6, 1, 7, 9, 1, 10, 2, 7, 10, 6, 7, 5, 9, 9, 6, 8, 10, 6, 2, 6, 1, 9, 6, 6, 1, 7, 3, 4, 3, 4, 3, 5, 9, 9, 9, 5, 2, 4, 2, 9, 4, 2, 8};
        Integer[] nums1_1 = {1, 2, 6, 9, 10};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_6")
    public void regressionTest6() throws Exception {
        Integer[] nums1 = {3, 5, 1, 5, 3, 1, 9, 1, 1, 9, 10, 2, 6, 2, 5, 2, 9, 2, 1, 1, 4, 2, 8, 8, 9, 6, 4, 2, 8, 10, 7, 6, 7, 7, 4, 7, 7, 1, 2, 2, 1, 5, 1, 5, 3, 2, 1, 10, 9, 5, 8, 6, 7, 5, 3, 9, 9, 8, 10, 10, 2, 1, 6, 9, 8, 4, 4, 5, 5, 3, 6, 9, 10, 3, 7, 1, 7, 10, 1, 1, 1, 4, 1, 1, 9, 6, 5, 8, 2, 10, 9, 6, 6, 3, 10, 6, 6, 5, 4, 2};
        Integer[] nums1_1 = {1, 2, 5, 6, 9};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_7")
    public void regressionTest7() throws Exception {
        Integer[] nums1 = {2, 10, 7, 10, 10, 1, 2, 3, 2, 4, 1, 2, 5, 1, 2, 5, 2, 8, 10, 5, 3, 7, 3, 6, 10, 1, 9, 4, 8, 6, 8, 3, 1, 6, 2, 10, 4, 6, 4, 5, 7, 8, 8, 4, 1, 6, 3, 1, 4, 7, 3, 5, 2, 2, 5, 10, 10, 7, 8, 3, 2, 6, 4, 9, 1, 6, 6, 2, 9, 3, 5, 3, 7, 9, 5, 10, 3, 5, 10, 8, 9, 10, 9, 9, 1, 9, 4, 3, 4, 8, 2, 6, 1, 6, 9, 2, 7, 1, 3, 4};
        Integer[] nums1_1 = {1, 2, 3, 4, 6, 10};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_8")
    public void regressionTest8() throws Exception {
        Integer[] nums1 = {6, 10, 5, 9, 8, 3, 1, 4, 6, 3, 5, 1, 9, 8, 9, 7, 10, 3, 1, 2, 5, 2, 8, 3, 8, 6, 1, 7, 5, 9, 8, 1, 4, 10, 6, 7, 4, 5, 4, 6, 2, 10, 4, 2, 2, 7, 4, 6, 6, 9, 4, 4, 10, 7, 7, 10, 8, 2, 8, 10, 10, 2, 5, 3, 7, 5, 3, 4, 3, 8, 2, 4, 8, 3, 7, 10, 4, 7, 2, 8, 5, 8, 10, 9, 4, 2, 7, 3, 9, 1, 4, 7, 9, 8, 4, 10, 3, 3, 10, 3};
        Integer[] nums1_1 = {2, 3, 4, 7, 8, 10};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_9")
    public void regressionTest9() throws Exception {
        Integer[] nums1 = {9, 3, 3, 9, 2, 5, 6, 8, 6, 1, 9, 3, 5, 6, 2, 2, 3, 1, 4, 5, 1, 1, 1, 5, 3, 2, 2, 3, 4, 10, 10, 10, 1, 2, 10, 7, 8, 3, 9, 4, 7, 2, 6, 5, 2, 6, 3, 2, 5, 8, 5, 8, 7, 3, 10, 8, 1, 4, 7, 9, 2, 9, 4, 10, 9, 4, 8, 5, 9, 6, 5, 9, 10, 6, 6, 3, 4, 1, 6, 1, 10, 9, 2, 1, 2, 2, 3, 1, 7, 6, 6, 8, 7, 7, 5, 7, 10, 6, 7, 10};
        Integer[] nums1_1 = {1, 2, 3, 5, 6, 9, 10};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Regression test_10")
    public void regressionTest10() throws Exception {
        Integer[] nums1 = {10, 3, 6, 3, 8, 7, 3, 8, 3, 1, 6, 6, 10, 7, 7, 8, 4, 8, 5, 3, 7, 5, 9, 9, 10, 6, 5, 3, 4, 6, 3, 2, 10, 7, 2, 10, 6, 4, 7, 5, 2, 5, 10, 2, 4, 4, 5, 1, 6, 7, 2, 6, 5, 5, 4, 7, 7, 1, 4, 9, 5, 8, 4, 5, 8, 4, 3, 1, 8, 2, 7, 2, 2, 8, 5, 3, 6, 4, 8, 10, 3, 4, 5, 6, 9, 8, 1, 7, 6, 8, 2, 10, 4, 1, 9, 10, 3, 1, 10, 6};
        Integer[] nums1_1 = {3, 4, 5, 6, 7, 8, 10};

        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums1)); //в список передали массив
        ArrayList<Integer> numList2 = new ArrayList<Integer>(Arrays.asList(nums1_1));
        ArrayList<Integer> methodList = new ArrayList<Integer>(hashN.hashN(numList, 10)); //рез-тат работы метода

        Collections.sort(methodList);
        Collections.sort(numList2);
        Assertions.assertEquals(true, methodList.equals(numList2));
    }
}
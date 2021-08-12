import org.example.ArrayCalc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayCalc {

    private ArrayCalc arrayCalc;

    @BeforeEach
    public void before() {
        arrayCalc = new ArrayCalc();
    }

//    @CsvSource({
//            "5, 1, 4",
//            "15, 7, 8",
//            "50, 30, 20",
//            "8, 8, 0"
//    })
//    @ParameterizedTest
//    public void massTestSum(int sum, int a, int b) {
//        assertEquals(sum, arrayCalc.sum(a, b));
//    }

    public static Stream<Arguments> dataForSumArr() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(5, new int[]{2, 2, 1}));
        list.add(Arguments.arguments(26, new int[]{23, 2, 1}));
        list.add(Arguments.arguments(1, new int[]{0, 0, 1}));
        list.add(Arguments.arguments(36, new int[]{12, 23, 1}));
        list.add(Arguments.arguments(5, new int[]{12, -12, 5}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForSumArr")
    public void massTestSumArr (int sum, int[] arr){
        assertEquals(sum, arrayCalc.sumArr(arr));
    }


    public static Stream<Arguments> dataForConvertArr() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
        list.add(Arguments.arguments(new int[]{2, 3, 1, 7}, new int[]{1, 2, 4, 2, 3, 1, 7}));
        list.add(Arguments.arguments(new int[]{}, new int[]{1, 4}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForConvertArr")
    public void massTestConvertArr (int[] result, int[] arr){
        assertArrayEquals(result,arrayCalc.convertInNewArr(arr));
    }

    @Test
    public void testConvertArr (){
        assertThrows(RuntimeException.class,()->arrayCalc.convertInNewArr(new int[]{1, 2, 3, 1}));
    }


    public static Stream<Arguments> dataForCheckArr() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(true, new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
        list.add(Arguments.arguments(false, new int[]{1, 1, 1, 1}));
        list.add(Arguments.arguments(false, new int[]{4, 4, 4, 4}));
        list.add(Arguments.arguments(false, new int[]{1, 1, 1, 4, 4, 1, 4, 3}));
        list.add(Arguments.arguments(false, new int[]{11, 11, 11, 44, 44}));
        return list.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckArr")
    public void massTestCheckArr (boolean result, int[] arr){
        assertEquals(result, arrayCalc.checkArr(arr));
    }

}

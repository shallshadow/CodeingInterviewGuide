package arrays.test;

import arrays.MaxSumSub;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaxSumSubTest {

    private MaxSumSub sub;
    private ArrayList<Integer> datalist;
    private int sum;

    @Before
    public void init() { 
        sub = new MaxSumSub();
    }

    public MaxSumSubTest(ArrayList<Integer> datas, int sum) {
        this.datalist = datas;
        this.sum = sum;
    }

    @Parameterized.Parameters
    public static Collection arrayDatas() {
        return Arrays.asList(new Object[][] {
                { getDataList(1, 2, 3, 4, 5), 15 },
                { getDataList(-1, -2, -3, -4, -5), 0},
                { getDataList(1, -2, 3, -1, 2, -4, 5), 5 },
                { getDataList(1, -2, 3, -1, 2, -4, 3), 4},
                { getDataList(1, -2, 3, -1, 2, -4), 4}

        });
    }

    private static ArrayList<Integer> getDataList(Integer... datas) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer i : datas) {
            list.add(i);
        }

        return list;
    }

    @Test
    public void testMaxSumSub() {
        System.out.println(datalist + " Sum = " + sum);
        assertEquals(sub.fenzhi(datalist, 0, datalist.size() - 1), sum);
    }
}

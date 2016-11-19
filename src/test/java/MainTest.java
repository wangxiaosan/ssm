import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.alibaba.fastjson.JSON;
import com.aliyun.app.dao.dict.OsType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wangxiaosan on 16/11/14.
 */
public class MainTest {
    public static void main(String[] args) {

        if(args==null||new MainTest(){{MainTest.main(null);}}==null) {
            System.out.println("Hello ");
        } else {
            System.out.println("World!");
        }



    }

    public static boolean sub(String p,String s) {
        char[] pC = p.toCharArray();
        char[] sC = s.toCharArray();
        List<Integer> list = Lists.newArrayList();
        for(int j = 0; j<pC.length; j++) {
            if(pC[j] == sC[0]) {
                list.add(j);
            }
        }
        if(list.isEmpty()) {
            return Boolean.FALSE;
        }
        for(Integer i : list) {

        }


        return Boolean.FALSE;
    }

}

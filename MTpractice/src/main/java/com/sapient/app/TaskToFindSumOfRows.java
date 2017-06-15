package com.sapient.app;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Suraj on 3/17/2017.
 */
public class TaskToFindSumOfRows implements Callable<Long> {

    private static final int ROW_NUM_INDEX = 0;
    private List<String> list;

    public TaskToFindSumOfRows(List<String> list) {
        this.list = list;
    }

    public Long call() throws Exception {
        long sumOfRows=0;
        list.stream().forEach(x->{
            String [] arr = x.split(",");
            String rowName = arr[ROW_NUM_INDEX];
            List<String> row= Arrays.asList(Arrays.copyOfRange(arr,1,arr.length));
            long sumOfRow= row.stream().map( y->
                Long.parseLong(y)).mapToLong(Long::longValue).sum();
            System.out.println(rowName + " : " + sumOfRow);

        });
        return null;
    }
}

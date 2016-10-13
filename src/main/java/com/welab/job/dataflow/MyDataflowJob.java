package com.welab.job.dataflow;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by WXQ on 2016/10/13.
 */
public class MyDataflowJob implements DataflowJob<String> {

    private static AtomicInteger count = new AtomicInteger();

    @Override
    public List fetchData(ShardingContext shardingContext) {
        System.out.println("dataflowJob fetchData，当前分片号为："+shardingContext.getShardingParameter());
        List<String> list = new ArrayList<String>();
        if(count.get() > 5){
            return list;
        }
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        count.addAndGet(1);
        return list;
    }

    @Override
    public void processData(ShardingContext shardingContext, List data) {
        System.out.println("dataflowJob processData，当前分片号为："+shardingContext.getShardingParameter());
        System.out.println(data);
    }
}

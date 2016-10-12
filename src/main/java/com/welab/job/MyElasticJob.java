package com.welab.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyElasticJob implements SimpleJob {

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void execute(ShardingContext shardingContext) {
        // do something by sharding items
        System.out.println("第"+count.addAndGet(1)+"次执行，当前分片号为："+shardingContext.getShardingParameter());

        switch (shardingContext.getShardingItem()){
            case 0:
                // do something by sharding item 0
                break;
            case 1:
                // do something by sharding item 1
                break;
            case 2:
                // do something by sharding item 2
                break;
            default:
                break;
        }

    }
}

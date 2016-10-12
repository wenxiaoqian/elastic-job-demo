package com.welab.job;

import com.dangdang.ddframe.job.api.AbstractOneOffElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyElasticJob extends AbstractOneOffElasticJob {

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    protected void process(JobExecutionMultipleShardingContext context) {
        // do something by sharding items
        System.out.println("第"+count.addAndGet(1)+"次执行，当前分片号为："+context.getShardingItemParameters());
    }

}

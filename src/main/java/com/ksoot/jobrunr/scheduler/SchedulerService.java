package com.ksoot.jobrunr.scheduler;

import org.jobrunr.jobs.context.JobContext;

public interface SchedulerService {

    void doSimpleJob(String anArgument);

    void doRecurringJob();

    void doLongRunningJob(String anArgument);

    void doLongRunningJobWithJobContext(String anArgument, JobContext jobContext);
}

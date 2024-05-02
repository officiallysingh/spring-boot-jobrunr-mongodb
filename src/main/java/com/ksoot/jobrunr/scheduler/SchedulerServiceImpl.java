package com.ksoot.jobrunr.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
//import org.jobrunr.jobs.annotations.Recurring;
import org.jobrunr.jobs.context.JobContext;
import org.jobrunr.jobs.context.JobDashboardProgressBar;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.stereotype.Component;

/** This is a simple spring service */
@Component
@Slf4j
public class SchedulerServiceImpl implements SchedulerService {

  @Recurring(id = "my-recurring-job", cron = "0 0/15 * * *")
  @Job(name = "My recurring job")
  @Override
  public void doRecurringJob() {
    System.out.println("Recurring Cron (0 0/15 * * *) job: Doing some work without arguments");
  }

  @Override
  public void doSimpleJob(String anArgument) {
    System.out.println("Doing some work: " + anArgument);
  }

  @Override
  public void doLongRunningJob(String anArgument) {
    try {
      for (int i = 0; i < 10; i++) {
        System.out.println(String.format("Doing work item %d: %s", i, anArgument));
        Thread.sleep(20000);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public void doLongRunningJobWithJobContext(String anArgument, JobContext jobContext) {
    try {
      log.warn("Starting long running job...");
      final JobDashboardProgressBar progressBar = jobContext.progressBar(10);
      for (int i = 0; i < 10; i++) {
        log.info(String.format("Processing item %d: %s", i, anArgument));
        System.out.println(String.format("Doing work item %d: %s", i, anArgument));
        Thread.sleep(15000);
        progressBar.increaseByOne();
      }
      log.warn("Finished long running job...");
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}

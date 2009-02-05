package org.springframework.batch.sample.common;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class SkipCheckingDecider implements JobExecutionDecider {

	public String decide(JobExecution jobExecution, StepExecution stepExecution) {
		if (!stepExecution.getExitStatus().getExitCode().equals(
				ExitStatus.FAILED.getExitCode())
				&& stepExecution.getSkipCount() > 0) {
			return "COMPLETED WITH SKIPS";
		} else {
			return ExitStatus.COMPLETED.getExitCode();
		}
	}
}
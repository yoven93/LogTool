package be.mercator.atlas.tool.logtool.app;

import be.mercator.atlas.tool.logtool.api.LogProcessor;
import be.mercator.atlas.tool.logtool.api.ReportGenerator;

public class FunctionalityDescription {

	private String description;

	private LogProcessor logProcessor;

	private ReportGenerator reportGenerator;

	public String getDescription() {
		return description;
	}

	public FunctionalityDescription setDescription(String description) {
		this.description = description;
		return this;
	}

	public LogProcessor getLogProcessor() {
		return logProcessor;
	}

	public FunctionalityDescription setLogProcessor(LogProcessor logProcessor) {
		this.logProcessor = logProcessor;
		return this;
	}

	public ReportGenerator getReportGenerator() {
		return reportGenerator;
	}

	public FunctionalityDescription setReportGenerator(ReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
		return this;
	}

}

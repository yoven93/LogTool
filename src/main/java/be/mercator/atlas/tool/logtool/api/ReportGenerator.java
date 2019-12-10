package be.mercator.atlas.tool.logtool.api;

import java.io.IOException;

public interface ReportGenerator {

	public void generateReport(LogProcessorOutput logProcessorOutput) throws IOException;
}

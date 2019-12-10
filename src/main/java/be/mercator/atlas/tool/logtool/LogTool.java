package be.mercator.atlas.tool.logtool;

import java.io.IOException;

import be.mercator.atlas.tool.logtool.api.LogProcessor;
import be.mercator.atlas.tool.logtool.api.LogProcessorOutput;
import be.mercator.atlas.tool.logtool.api.ReportGenerator;
import be.mercator.atlas.tool.logtool.impl.analyzer.ClevaBatchLogAnalyzer;
import be.mercator.atlas.tool.logtool.impl.reportgenerator.ClevaBatchLogAnalyzerReportGenerator;

public class LogTool {

	public static void main(String[] args) {
		
		LogProcessor logProcessor = new ClevaBatchLogAnalyzer();
		ReportGenerator reportGenerator = new ClevaBatchLogAnalyzerReportGenerator();
		
		LogProcessorOutput logProcessorOutput = logProcessor.process();
		
		if (logProcessorOutput != null) {
			
			try {
				reportGenerator.generateReport(logProcessorOutput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Output null");
		}
		
	}

}

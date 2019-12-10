package be.mercator.atlas.tool.logtool.impl.analyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import be.mercator.atlas.tool.logtool.api.LogProcessor;
import be.mercator.atlas.tool.logtool.api.LogProcessorOutput;
import be.mercator.atlas.tool.logtool.constant.RegularExpressions;
import be.mercator.atlas.tool.logtool.impl.result.ClevaBatchLogAnalyzerOutput;
import be.mercator.atlas.tool.logtool.impl.result.template.ClevaBatchLogAnalyzerOutputTemplate;
import be.mercator.atlas.tool.logtool.impl.result.template.ClevaBatchLogErrorTemplate;
import be.mercator.atlas.tool.logtool.util.FileUtils;
import be.mercator.atlas.tool.logtool.util.GeneralUtils;

public class ClevaBatchLogAnalyzer implements LogProcessor {

	/**
	 * The {@link Pattern} to be used to match ERROR present in the log file.
	 */
	private final Pattern errorPattern;

	/**
	 * The {@link Pattern} to be used to match WARN present in the log file.
	 */
	private final Pattern warnPattern;

	/**
	 * The {@link Pattern} to be used to match INFO present in the log file.
	 */
	private final Pattern infoPattern;

	/**
	 * The {@link Pattern} to be used to match the 'Items Selected = $1' part of the
	 * log file.
	 */
	private final Pattern itemsSelectedPattern;

	/**
	 * The {@link Pattern} to be used to match the 'Elements Treated = $1' part of
	 * the log file.
	 */
	private final Pattern elementsTreatedPattern;

	/**
	 * The {@link Pattern} to be used to match the full ERROR together with its
	 * error message. The error message is group inside group 1 ($1).
	 */
	private final Pattern errorMsgPattern;

	/**
	 * No Argument Constructor. Use this to compile all the regular express patterns
	 * with {@link Pattern#compile(String)}.
	 */
	public ClevaBatchLogAnalyzer() {

		this.errorPattern = Pattern.compile(RegularExpressions.BATCH_LOG_ERROR_REGEX);
		this.warnPattern = Pattern.compile(RegularExpressions.BATCH_LOG_WARN_REGEX);
		this.infoPattern = Pattern.compile(RegularExpressions.BATCH_LOG_INFO_REGEX);
		this.itemsSelectedPattern = Pattern.compile(RegularExpressions.BATCH_LOG_ITEMS_SELECTED_REGEX);
		this.elementsTreatedPattern = Pattern.compile(RegularExpressions.BATCH_LOG_ELEMENTS_TREATED_REGEX);
		this.errorMsgPattern = Pattern.compile(RegularExpressions.BATCH_LOG_ERROR_MSG_REGEX);
	}

	/**
	 * {@inheritDoc}.
	 */
	@Override
	public LogProcessorOutput process() {

		ClevaBatchLogAnalyzerOutput output = new ClevaBatchLogAnalyzerOutput();

		List<String> files = FileUtils.getFilesFromDirectory("/Users/yoven/Desktop/LogAnalyzer/input");

		for (String file : files) {
			System.out.println(files);
			this.processLogFile(file, output);
		}

		return output;
	}

	/**
	 * 
	 * @param output
	 */
	private void processLogFile(String file, ClevaBatchLogAnalyzerOutput output) {

		ClevaBatchLogAnalyzerOutputTemplate template = new ClevaBatchLogAnalyzerOutputTemplate();

		Path path = Paths.get(file);

		template.setEnvironment("V10");
		template.setFileProcessed(file);

		// Parse the input log file and populate the BatchLogParserOutput object
		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

			String line;

			while ((line = reader.readLine()) != null) {

				// Get the number of ERROR in the log file
				this.getNumError(template, line);

				// Get the number of WARN in the log file
				this.getNumWarn(template, line);

				// Get the number of INFO in the log file
				this.getNumInfo(template, line);

				// Get the items selected value in the log file
				this.getNumItemsSelected(template, line);

				// Get the elements treated value in the log file
				this.getNumElementsTreated(template, line);

				// Extract the error messages
				this.extractErrorMsg(template, line);
			}

		} catch (IOException e) {

		}

		output.getTemplates().add(template);
	}

	/**
	 * 
	 * @param batchLogParserOutput
	 * @param input
	 */
	private void getNumError(ClevaBatchLogAnalyzerOutputTemplate batchLogParserOutput, String input) {

		Matcher numErrorMatcher = this.errorPattern.matcher(input);

		if (numErrorMatcher.find()) {
			batchLogParserOutput.setNumError(batchLogParserOutput.getNumError() + 1);
		}
	}

	/**
	 * 
	 * @param batchLogParserOutput
	 * @param input
	 */
	private void getNumWarn(ClevaBatchLogAnalyzerOutputTemplate batchLogParserOutput, String input) {

		Matcher numWarnMatcher = this.warnPattern.matcher(input);

		if (numWarnMatcher.find()) {
			batchLogParserOutput.setNumWarn(batchLogParserOutput.getNumWarn() + 1);
		}
	}

	/**
	 * 
	 * @param batchLogParserOutput
	 * @param input
	 */
	private void getNumInfo(ClevaBatchLogAnalyzerOutputTemplate batchLogParserOutput, String input) {

		Matcher numInfoMatcher = this.infoPattern.matcher(input);

		if (numInfoMatcher.find()) {
			batchLogParserOutput.setNumInfo(batchLogParserOutput.getNumInfo() + 1);
		}
	}

	/**
	 * 
	 * @param batchLogParserOutput
	 * @param input
	 */
	private void getNumItemsSelected(ClevaBatchLogAnalyzerOutputTemplate batchLogParserOutput, String input) {

		Matcher numItemsSelectedMatcher = this.itemsSelectedPattern.matcher(input);

		if (numItemsSelectedMatcher.find()) {
			batchLogParserOutput.setNumItemsSelected(numItemsSelectedMatcher.group(1));
		}
	}

	/**
	 * 
	 * @param batchLogParserOutput
	 * @param input
	 */
	private void getNumElementsTreated(ClevaBatchLogAnalyzerOutputTemplate batchLogParserOutput, String input) {

		Matcher numElementsTreatedMatcher = this.elementsTreatedPattern.matcher(input);

		if (numElementsTreatedMatcher.find()) {
			batchLogParserOutput.setNumElementsTreated(numElementsTreatedMatcher.group(1));
		}
	}

	/**
	 * 
	 * @param batchLogParserOutput
	 * @param input
	 */
	private void extractErrorMsg(ClevaBatchLogAnalyzerOutputTemplate template, String input) {

		Matcher errorMsgMatcher = this.errorMsgPattern.matcher(input);

		if (errorMsgMatcher.find()) {
			
			String errorMSg = errorMsgMatcher.group(1);
			
			Map<String[], ClevaBatchLogErrorTemplate> errorMap = template.getErrorMap();
			
			boolean added = false;
			
			for (Map.Entry<String[], ClevaBatchLogErrorTemplate> entry : errorMap.entrySet()) {

				if (GeneralUtils.stringArrayDifferenceCount(entry.getKey(), errorMSg.split(" ")) <= 1 && GeneralUtils.stringArrayDifferenceCount(entry.getKey(), errorMSg.split(" ")) != -1) {

					entry.getValue().setErrorCount(entry.getValue().getErrorCount() + 1);
					added = true;
					break;
				}
			}
			
			if (!added) {
				errorMap.put(errorMSg.split(" "), new ClevaBatchLogErrorTemplate(errorMSg, 1));
			}
		}
	}
}

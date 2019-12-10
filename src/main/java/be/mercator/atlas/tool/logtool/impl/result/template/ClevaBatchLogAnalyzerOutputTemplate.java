package be.mercator.atlas.tool.logtool.impl.result.template;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClevaBatchLogAnalyzerOutputTemplate {

	/**
	 * The file that was processed.
	 */
	private String fileProcessed;

	/**
	 * The environment (e.g. V10 or V14).
	 */
	private String environment;

	/**
	 * Number of INFO that appears in the log.
	 */
	private int numInfo;

	/**
	 * Number of WARN that appears in the log.
	 */
	private int numWarn;

	/**
	 * Number of ERROR that appears in the log.
	 */
	private int numError;

	/**
	 * The Items Selected as it appears in the log. This appears at the end of the
	 * log.
	 */
	private String numItemsSelected;

	/**
	 * The Elements Treated as it appears in the log. This appears at the end of the
	 * log.
	 */
	private String numElementsTreated;

	/**
	 * {@link Map} that stores the errors in the format that can easily be parsed by
	 * the report generator.
	 */
	private Map<String[], ClevaBatchLogErrorTemplate> errorMap = new ConcurrentHashMap<>();

	public String getFileProcessed() {
		return fileProcessed;
	}

	public void setFileProcessed(String fileProcessed) {
		this.fileProcessed = fileProcessed;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public int getNumInfo() {
		return numInfo;
	}

	public void setNumInfo(int numInfo) {
		this.numInfo = numInfo;
	}

	public int getNumWarn() {
		return numWarn;
	}

	public void setNumWarn(int numWarn) {
		this.numWarn = numWarn;
	}

	public int getNumError() {
		return numError;
	}

	public void setNumError(int numError) {
		this.numError = numError;
	}

	public String getNumItemsSelected() {
		return numItemsSelected;
	}

	public void setNumItemsSelected(String numItemsSelected) {
		this.numItemsSelected = numItemsSelected;
	}

	public String getNumElementsTreated() {
		return numElementsTreated;
	}

	public void setNumElementsTreated(String numElementsTreated) {
		this.numElementsTreated = numElementsTreated;
	}

	public Map<String[], ClevaBatchLogErrorTemplate> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String[], ClevaBatchLogErrorTemplate> errorMap) {
		this.errorMap = errorMap;
	}

}

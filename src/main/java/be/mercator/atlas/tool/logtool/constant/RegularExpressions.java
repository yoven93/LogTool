package be.mercator.atlas.tool.logtool.constant;

public class RegularExpressions {

	/**
	 * The regular expression to match the format of the ERROR inside a batch log
	 * file.
	 */
	public static final String BATCH_LOG_ERROR_REGEX = "\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}\\.\\d{3} ERROR\\s+";

	/**
	 * The regular expression to match the format of the WARN inside a batch log
	 * file.
	 */
	public static final String BATCH_LOG_WARN_REGEX = "\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}\\.\\d{3} WARN\\s+";

	/**
	 * The regular expression to match the format of the INFO inside a batch log
	 * file.
	 */
	public static final String BATCH_LOG_INFO_REGEX = "\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}\\.\\d{3} INFO\\s+";

	/**
	 * The regular expression to match the format of the 'Items Selected = $1"
	 * inside a batch log file.
	 */
	public static final String BATCH_LOG_ITEMS_SELECTED_REGEX = "\\bItems selected = ([0-9,]+)";

	/**
	 * The regular expression to match the format of the 'Elements Treated = $1"
	 * inside a batch log file.
	 */
	public static final String BATCH_LOG_ELEMENTS_TREATED_REGEX = "\\bElements treated = ([0-9,]+)";

	/**
	 * The regular expression to match the format of the ERROR and its message
	 * inside a batch log file. The purpose of this regex is to extract the error
	 * message itself as group 1 ($1).
	 */
	public static final String BATCH_LOG_ERROR_MSG_REGEX = "\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}\\.\\d{3} ERROR\\s+-\\s+(.+)";
}

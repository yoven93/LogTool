package be.mercator.atlas.tool.logtool.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GeneralUtils {

	/**
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		return Timestamp.valueOf(LocalDateTime.now()).toString();
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int stringArrayDifferenceCount(String[] a, String[] b) {

		if (a.length == b.length) {

			int differenceCount = 0;

			for (int i = 0; i < a.length; i++) {

				if (!a[i].equals(b[i])) {
					differenceCount++;
				}
			}

			return differenceCount;

		} else {
			return -1;
		}
	}
}

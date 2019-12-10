package be.mercator.atlas.tool.logtool.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

	/**
	 * Move a file from one location to another.
	 * 
	 * @param src  The full path to the file that needs to be moved.
	 * @param dest The full path to where the file needs to be moved.
	 * 
	 * @return true if the move was successful, else false is returned.
	 */
	public static boolean moveFile(String src, String dest) {

		try {
			Files.move(Paths.get(src), Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	/**
	 * Retrieve all file with .log extension from directory provided as argument.
	 * The files retrieved contains both the path and the file name.
	 * 
	 * @param directoryPath The full path to the directory that contains the files.
	 * 
	 * @return {@link List} of file paths in the {@link String} format if
	 *         successful, else null is returned.
	 */
	public static List<String> getFilesFromDirectory(String directoryPath) {

		try (Stream<Path> stream = Files.walk(Paths.get(directoryPath))) {

			return stream
					.filter(file -> !Files.isDirectory(file))
					.map(Path::toString)
					.filter(fileStr -> fileStr.endsWith(".log"))
					.collect(Collectors.toList());

		} catch (IOException e) {

			return null;
		}
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String getFilenameFromPath(String path) {
		return null;
	}
}

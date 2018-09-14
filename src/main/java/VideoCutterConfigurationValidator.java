import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoCutterConfigurationValidator {

	public static final String OUTPUT_PREFIX_REGEX = "[a-zA-z0-9_-]*";

	private Pattern outputPrefixPattern;

	public VideoCutterConfigurationValidator() {

		outputPrefixPattern = Pattern.compile(OUTPUT_PREFIX_REGEX);

	}

	public void validate(VideoCutterConfiguration configuration) {

		try {

			validateInputFile(configuration.getInputFile());
			validateOutputFolder(configuration.getOutputFolder());
			validateSplitSeconds(configuration.getSplitSeconds());
			validateOutputPrefix(configuration.getOutputPrefix());

		} catch (FileNotFoundException e) {

			e.printStackTrace();

			System.exit(1);

		}

	}

	private void validateInputFile(String inputFile) throws FileNotFoundException {

		// check if input file exists
		File file = new File(inputFile);

		if (!file.exists()) {
			throw new FileNotFoundException();
		}

	}

	private void validateOutputFolder(String outputFolder) throws FileNotFoundException {

		// check if output folder exists
		File folder = new File(outputFolder);

		if (!folder.exists()) {
			throw new FileNotFoundException();
		}

	}

	private void validateSplitSeconds(int splitSeconds) {

		// check if split seconds larger than zero
		if (splitSeconds <= 0) {
			throw new IllegalArgumentException();
		}

	}

	private void validateOutputPrefix(String outputPrefix) {

		// check if output prefix contains only valid characters
		Matcher matcher = outputPrefixPattern.matcher(outputPrefix);

		if (!matcher.matches()) {
			throw new IllegalArgumentException();
		}

	}

}

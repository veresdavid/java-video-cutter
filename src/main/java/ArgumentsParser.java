import org.apache.commons.cli.*;

public class ArgumentsParser {

	private Options options;

	public ArgumentsParser() {

		options = new Options();

		Option inputOption = new Option("i", "input", true, "input video file");
		inputOption.setRequired(true);
		options.addOption(inputOption);

		Option splitOption = new Option("s", "split", true, "split by seconds");
		splitOption.setRequired(true);
		options.addOption(splitOption);

		Option outputOption = new Option("o", "output", true, "output folder");
		outputOption.setRequired(true);
		options.addOption(outputOption);

		Option prefixOption = new Option("p", "prefix", true, "output files prefix");
		prefixOption.setRequired(false);
		options.addOption(prefixOption);

	}

	public VideoCutterConfiguration parse(String[] args) {

		CommandLineParser commandLineParser = new DefaultParser();
		HelpFormatter helpFormatter = new HelpFormatter();
		CommandLine commandLine = null;

		try {

			commandLine = commandLineParser.parse(options, args);

		} catch (ParseException e) {

			System.out.println(e.getMessage());
			helpFormatter.printHelp("java-video-cutter", options);

			System.exit(1);

		}

		VideoCutterConfiguration configuration = extractValues(commandLine);

		return configuration;

	}

	private VideoCutterConfiguration extractValues(CommandLine commandLine) {

		VideoCutterConfiguration configuration = new VideoCutterConfiguration();

		// the values
		String inputFile = commandLine.getOptionValue("i");
		String outputFolder = commandLine.getOptionValue("o");
		int splitSeconds = Integer.parseInt(commandLine.getOptionValue("s"));
		String outputPrefix = commandLine.hasOption("p") ? commandLine.getOptionValue("p") : "output_";

		// set up configuration object
		configuration.setInputFile(inputFile);
		configuration.setOutputFolder(outputFolder);
		configuration.setSplitSeconds(splitSeconds);
		configuration.setOutputPrefix(outputPrefix);

		return configuration;

	}

}

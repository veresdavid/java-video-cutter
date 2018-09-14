public class Main {

	public static void main(String[] args) {

		System.out.println("Java Video Cutter");

		// parse command line arguments
		ArgumentsParser argumentsParser = new ArgumentsParser();
		VideoCutterConfiguration videoCutterConfiguration = argumentsParser.parse(args);

		// validate input
		VideoCutterConfigurationValidator validator = new VideoCutterConfigurationValidator();
		validator.validate(videoCutterConfiguration);

		// cut video
		VideoCutter videoCutter = new VideoCutter(videoCutterConfiguration);
		videoCutter.cut();

		// done
		System.out.println("=== DONE ===");

	}

}

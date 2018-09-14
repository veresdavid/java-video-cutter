import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VideoCutter {

	private VideoCutterConfiguration configuration;
	private VideoMetadataService videoMetadataService;

	public VideoCutter(VideoCutterConfiguration configuration) {

		this.configuration = configuration;

		videoMetadataService = new VideoMetadataService();

	}

	public void cut() {

		double videoLength = videoMetadataService.getVideoLengthInSeconds(configuration.getInputFile());
		double start = 0.0;
		double step = (double) configuration.getSplitSeconds();
		int index = 0;

		while (start < videoLength) {

			List<String> argumentList = generateArgumentList(index * configuration.getSplitSeconds(), index, configuration);

			executeVideoCutCommand(argumentList);

			start += step;
			index++;

		}

	}

	private List<String> generateArgumentList(int skipSeconds, int outputIndex, VideoCutterConfiguration configuration) {

		List<String> argumentList = new ArrayList<>();

		argumentList.add("ffmpeg");

		argumentList.add("-y");

		argumentList.add("-i");
		argumentList.add(configuration.getInputFile());

		argumentList.add("-ss");
		argumentList.add(String.valueOf(skipSeconds));

		argumentList.add("-t");
		argumentList.add(String.valueOf(configuration.getSplitSeconds()));

		argumentList.add("-c:v");
		argumentList.add(configuration.getOutputVideoCodec());

		argumentList.add("-c:a");
		argumentList.add(configuration.getOutputAudioCodec());

		argumentList.add(configuration.getOutputFolder() + configuration.getOutputPrefix() + String.valueOf(outputIndex) + "." + configuration.getOutputContainer());

		return argumentList;

	}

	private void executeVideoCutCommand(List<String> argumentList) {

		Process process = null;

		try {

			process = new ProcessBuilder()
					.command(argumentList)
					.redirectErrorStream(true)
					.redirectOutput(ProcessBuilder.Redirect.INHERIT)
					.start();

			process.waitFor();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

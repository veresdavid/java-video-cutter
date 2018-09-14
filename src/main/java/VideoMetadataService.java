import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VideoMetadataService {

	public static final String VIDEO_LENGTH_COMMAND_PREFIX = "ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 ";

	public VideoMetadataService() {
	}

	public double getVideoLengthInSeconds(String videoFile) {

		String command = VIDEO_LENGTH_COMMAND_PREFIX + videoFile;

		Process process = null;

		String result = null;

		try {

			process = Runtime.getRuntime().exec(command);

			process.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;

			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				result = line;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (result == null) {

			System.out.println("ERROR: cant get length of video file!");

			System.exit(1);

		}

		double length = Double.parseDouble(result);

		return length;

	}

}

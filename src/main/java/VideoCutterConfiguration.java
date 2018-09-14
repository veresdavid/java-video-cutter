public class VideoCutterConfiguration {

	public static final String VIDEO_CONTAINER_MP4 = "mp4";
	public static final String VIDEO_CODEC_H264 = "libx264";
	public static final String AUDIO_CODEC_AAC = "aac";

	private String inputFile;
	private String outputFolder;
	private int splitSeconds;
	private String outputPrefix;

	private String outputContainer;
	private String outputVideoCodec;
	private String outputAudioCodec;

	public VideoCutterConfiguration() {

		outputPrefix = "output_";

		outputContainer = VIDEO_CONTAINER_MP4;
		outputVideoCodec = VIDEO_CODEC_H264;
		outputAudioCodec = AUDIO_CODEC_AAC;

	}

	public String getInputFile() {
		return inputFile;
	}

	public String getOutputFolder() {
		return outputFolder;
	}

	public int getSplitSeconds() {
		return splitSeconds;
	}

	public String getOutputPrefix() {
		return outputPrefix;
	}

	public String getOutputContainer() {
		return outputContainer;
	}

	public String getOutputVideoCodec() {
		return outputVideoCodec;
	}

	public String getOutputAudioCodec() {
		return outputAudioCodec;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public void setOutputFolder(String outputFolder) {
		this.outputFolder = outputFolder;
	}

	public void setSplitSeconds(int splitSeconds) {
		this.splitSeconds = splitSeconds;
	}

	public void setOutputPrefix(String outputPrefix) {
		this.outputPrefix = outputPrefix;
	}

	@Override
	public String toString() {
		return "VideoCutterConfiguration{" +
				"inputFile='" + inputFile + '\'' +
				", outputFolder='" + outputFolder + '\'' +
				", splitSeconds=" + splitSeconds +
				", outputPrefix='" + outputPrefix + '\'' +
				", outputContainer='" + outputContainer + '\'' +
				", outputVideoCodec='" + outputVideoCodec + '\'' +
				", outputAudioCodec='" + outputAudioCodec + '\'' +
				'}';
	}

}

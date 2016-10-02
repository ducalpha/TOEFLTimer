package audio;

import java.io.File;
import java.lang.Thread.State;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class SoundHelper {
	String absPath;

	// Constructor with output file
	public SoundHelper(String absPath) {
		super();
		this.absPath = absPath;
	}
	//used to recreate new recorder because I don't know how to stop Thread
	private void recreateRecorder() {
		File outputFile = new File(absPath);
		
		/*
		 * For simplicity, the audio data format used for recording is hardcoded
		 * here. We use PCM 44.1 kHz, 16 bit signed, stereo.
		 */
		AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100.0F, 16, 2, 4, 44100.0F, false);

		/*
		 * Now, we are trying to get a TargetDataLine. The TargetDataLine is
		 * used later to read audio data from it. If requesting the line was
		 * successful, we are opening it (important!).
		 */
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
		TargetDataLine targetDataLine = null;
		try {
			targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
			targetDataLine.open(audioFormat);
		} catch (LineUnavailableException e) {
			out("unable to get a recording line");
			e.printStackTrace();
			System.exit(1);
		}

		/*
		 * Again for simplicity, we've hardcoded the audio file type, too.
		 */
		AudioFileFormat.Type targetType = AudioFileFormat.Type.WAVE;

		/*
		 * Now, we are creating an SimpleAudioRecorder object. It contains the
		 * logic of starting and stopping the recording, reading audio data from
		 * the TargetDataLine and writing the data to a file.
		 */
		recorder = new SimpleAudioRecorder(targetDataLine, targetType, outputFile);
	}

	SimpleAudioRecorder recorder;

	private static void out(Object strMessage) {
		System.out.println(strMessage);
	}

	public void startRecording() {
		// out(recorder.getState().equals(State.NEW));
		recreateRecorder();
		recorder.start();
	}

	public void stopRecording() {
		recorder.stopRecording();
	}

	public void startPlayBack() {
		String[] args = new String[1];
		args[0] = absPath;
		SimpleAudioPlayer.main(args);
	}
}

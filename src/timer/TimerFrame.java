package timer;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import utils.ReadWriteTextFile;
import utils.Utils;
import audio.SoundHelper;

//VS4E -- DO NOT REMOVE THIS LINE!
public class TimerFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField timerTextField;

	public TimerFrame() {
		initComponents();
		jLabelTimesup.setVisible(false);
		recordingLabel.setVisible(false);
		this.setAlwaysOnTop(true);
	}

	private void initComponents() {
		setTitle("TOEFL Timer.v1.3. By BHDuc. HUT. Vietnam. uni4vn@gmail.com");
		setAlwaysOnTop(true);
		setLayout(new GroupLayout());
		add(getJTabbedPane0(), new Constraints(new Bilateral(10, 10, 385), new Bilateral(34, 11, 193)));
		add(getJlableTimesup(), new Constraints(new Leading(106, 196, 238), new Leading(11, 233, 233)));
		add(getTimerTextField(), new Constraints(new Leading(185, 52, 10, 10), new Leading(6, 27, 233, 233)));
		setSize(435, 266);
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Free recording");
		}
		return jLabel0;
	}

	private JSplitPane getJSplitPane0() {
		if (jSplitPane0 == null) {
			jSplitPane0 = new JSplitPane();
			jSplitPane0.setDividerLocation(130);
			jSplitPane0.setLeftComponent(getJPanel1());
			jSplitPane0.setRightComponent(getIntEssayPanel());
		}
		return jSplitPane0;
	}

	private JPanel getJPanel1() {
		if (intReadingPanel == null) {
			intReadingPanel = new JPanel();
			intReadingPanel.setLayout(new GroupLayout());
			intReadingPanel.add(getReadingPassageLabel(), new Constraints(new Leading(3, 10, 10),
					new Leading(8, 10, 10)));
			intReadingPanel.add(getIntegratedScrollPane(), new Constraints(new Bilateral(0, 0, 23), new Bilateral(27,
					0, 23)));
		}
		return intReadingPanel;
	}

	private JPanel getIntEssayPanel() {
		if (intEssayPanel == null) {
			intEssayPanel = new JPanel();
			intEssayPanel.setLayout(new GroupLayout());
			intEssayPanel.add(getEssayLabel(), new Constraints(new Leading(10, 10, 10), new Leading(4, 10, 10)));
			intEssayPanel.add(getIntWritingScrollPane(), new Constraints(new Bilateral(0, 0, 23), new Bilateral(25, 0,
					23)));
		}
		return intEssayPanel;
	}

	private JButton getSec2060Button() {
		if (sec2060Button == null) {
			sec2060Button = new JButton();
			sec2060Button.setText("20+60 seconds");
			sec2060Button.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent event) {
					sec2060ButtonMouseMouseReleased(event);
				}
			});
		}
		return sec2060Button;
	}

	private JButton getSec20Button() {
		if (sec20Button == null) {
			sec20Button = new JButton();
			sec20Button.setText("20 seconds");
			sec20Button.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent event) {
					sec20ButtonMouseMouseReleased(event);
				}
			});
		}
		return sec20Button;
	}

	private JLabel getEssayLabel() {
		if (essayLabel == null) {
			essayLabel = new JLabel();
			essayLabel.setText("Essay");
		}
		return essayLabel;
	}

	private JLabel getReadingPassageLabel() {
		if (readingPassageLabel == null) {
			readingPassageLabel = new JLabel();
			readingPassageLabel.setText("Reading passage");
		}
		return readingPassageLabel;
	}

	private JButton getSaveAsButton() {
		if (saveAsButton == null) {
			saveAsButton = new JButton();
			saveAsButton.setText("Save As...");
			saveAsButton.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent event) {
					saveAsButtonMouseMouseReleased(event);
				}
			});
		}
		return saveAsButton;
	}

	private JTextArea getIntWritingTextArea() {
		if (intWritingTextArea == null) {
			intWritingTextArea = new JTextArea();
			intWritingTextArea.setLineWrap(true);
		}
		return intWritingTextArea;
	}

	private JTextArea getIntegratedTextArea() {
		if (integratedTextArea == null) {
			integratedTextArea = new JTextArea();
			integratedTextArea.setLineWrap(true);
		}
		return integratedTextArea;
	}

	private JScrollPane getIntWritingScrollPane() {
		if (intWritingScrollPane == null) {
			intWritingScrollPane = new JScrollPane();
			intWritingScrollPane.setViewportView(getIntWritingTextArea());
		}
		return intWritingScrollPane;
	}

	private JScrollPane getIntegratedScrollPane() {
		if (integratedScrollPane == null) {
			integratedScrollPane = new JScrollPane();
			integratedScrollPane.setViewportView(getIntegratedTextArea());
		}
		return integratedScrollPane;
	}

	private JPanel getWritingPanel() {
		if (writingPanel == null) {
			writingPanel = new JPanel();
			writingPanel.setLayout(new GroupLayout());
			writingPanel.add(getMin3Button(), new Constraints(new Leading(10, 84, 10, 10), new Leading(7, 10, 10)));
			writingPanel.add(getMin20Button(), new Constraints(new Leading(102, 84, 10, 10), new Leading(7, 11, 11)));
			writingPanel.add(getMin30Button(), new Constraints(new Leading(196, 10, 10), new Leading(7, 11, 11)));
			writingPanel.add(getSaveAsButton(), new Constraints(new Leading(287, 10, 10), new Leading(7, 40, 41)));
			writingPanel.add(getJSplitPane0(), new Constraints(new Bilateral(10, 10, 150), new Bilateral(36, 11, 52)));
		}
		return writingPanel;
	}

	private JPanel getSpeakingPanel() {
		if (speakingPanel == null) {
			speakingPanel = new JPanel();
			speakingPanel.setLayout(new GroupLayout());
			speakingPanel.add(getRecordingLabel(), new Constraints(new Leading(32, 71, 10, 10), new Trailing(11, 21,
					11, 11)));
			speakingPanel.add(getSec15Button(), new Constraints(new Leading(24, 10, 10), new Leading(13, 10, 10)));
			speakingPanel.add(getSec45Button(), new Constraints(new Leading(115, 10, 10), new Leading(13, 10, 10)));
			speakingPanel.add(getSec1545Button(), new Constraints(new Leading(208, 10, 10), new Leading(13, 10, 10)));
			speakingPanel.add(getSec30Button(), new Constraints(new Leading(24, 86, 10, 10), new Leading(42, 39, 43)));
			speakingPanel.add(getSec60Button(), new Constraints(new Leading(114, 88, 10, 10), new Leading(42, 11, 11)));
			speakingPanel.add(getSec3060Button(), new Constraints(new Leading(208, 106, 10, 10),
					new Leading(42, 11, 11)));
			speakingPanel.add(getSec20Button(), new Constraints(new Leading(24, 10, 10), new Leading(71, 39, 43)));
			speakingPanel.add(getSec2060Button(), new Constraints(new Leading(208, 106, 10, 10),
					new Leading(71, 11, 11)));
			speakingPanel.add(getPlayButton(), new Constraints(new Leading(24, 290, 10, 10), new Leading(100, 21, 10,
					10)));
			speakingPanel.add(getJLabel0(), new Constraints(new Leading(12, 10, 10), new Leading(144, 39, 43)));
			speakingPanel.add(getStartRecordingButton(), new Constraints(new Leading(86, 10, 10), new Leading(138, 39,
					43)));
			speakingPanel.add(getStopRecordingButton(), new Constraints(new Leading(199, 10, 10), new Leading(138, 11,
					11)));
		}
		return speakingPanel;
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.setTabPlacement(JTabbedPane.BOTTOM);
			jTabbedPane0.addTab("speakingPanel", getSpeakingPanel());
			jTabbedPane0.addTab("writingPanel", getWritingPanel());
		}
		return jTabbedPane0;
	}

	private JButton getStopRecordingButton() {
		if (stopRecordingButton == null) {
			stopRecordingButton = new JButton();
			stopRecordingButton.setText("Stop Recording");
			stopRecordingButton.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent event) {
					stopRecordingButtonMouseMouseReleased(event);
				}
			});
		}
		return stopRecordingButton;
	}

	private JButton getStartRecordingButton() {
		if (startRecordingButton == null) {
			startRecordingButton = new JButton();
			startRecordingButton.setText("Start Recording");
			startRecordingButton.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent event) {
					startRecordingButtonMouseMouseReleased(event);
				}
			});
		}
		return startRecordingButton;
	}

	private JButton getJButton0() {
		if (stopRecordingButton == null) {
			stopRecordingButton = new JButton();
			stopRecordingButton.setText("jButton0");
		}
		return stopRecordingButton;
	}

	private JLabel getRecordingLabel() {
		if (recordingLabel == null) {
			recordingLabel = new JLabel();
			recordingLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			recordingLabel.setText("Recording");
		}
		return recordingLabel;
	}

	private JButton getPlayButton() {
		if (playButton == null) {
			playButton = new JButton();
			playButton.setText("Play");
			playButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					playButtonActionActionPerformed(event);
				}
			});
		}
		return playButton;
	}

	private JLabel getJlableTimesup() {
		if (jLabelTimesup == null) {
			jLabelTimesup = new JLabel();
			jLabelTimesup.setFont(new Font("Tahoma", Font.PLAIN, 14));
			jLabelTimesup.setText("Time is up!");
		}
		return jLabelTimesup;
	}

	private JButton getMin30Button() {
		if (min30Button == null) {
			min30Button = new JButton();
			min30Button.setText("30 minutes");
			min30Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					min30ButtonActionActionPerformed(event);
				}
			});
		}
		return min30Button;
	}

	private JButton getSec3060Button() {
		if (sec3060Button == null) {
			sec3060Button = new JButton();
			sec3060Button.setText("30+60 seconds");
			sec3060Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sec3060ButtonActionActionPerformed(event);
				}
			});
		}
		return sec3060Button;
	}

	private JButton getSec1545Button() {
		if (sec1545Button == null) {
			sec1545Button = new JButton();
			sec1545Button.setText("15+45 seconds");
			sec1545Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sec1545ButtonActionActionPerformed(event);
				}
			});
		}
		return sec1545Button;
	}

	private JButton getSec60Button() {
		if (sec60Button == null) {
			sec60Button = new JButton();
			sec60Button.setText("60 seconds");
			sec60Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sec60ButtonActionActionPerformed(event);
				}
			});
		}
		return sec60Button;
	}

	private JButton getSec45Button() {
		if (sec45Button == null) {
			sec45Button = new JButton();
			sec45Button.setText("45 seconds");
			sec45Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sec45ButtonActionActionPerformed(event);
				}
			});
		}
		return sec45Button;
	}

	private JButton getSec30Button() {
		if (sec30Button == null) {
			sec30Button = new JButton();
			sec30Button.setText("30 seconds");
			sec30Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sec30ButtonActionActionPerformed(event);
				}
			});
		}
		return sec30Button;
	}

	private JButton getMin20Button() {
		if (min20Button == null) {
			min20Button = new JButton();
			min20Button.setText("20 minutes");
			min20Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					min20ButtonActionActionPerformed(event);
				}
			});
		}
		return min20Button;
	}

	private JButton getSec15Button() {
		if (sec15Button == null) {
			sec15Button = new JButton();
			sec15Button.setText("15 seconds");
			sec15Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					sec15ButtonActionActionPerformed(event);
				}
			});
		}
		return sec15Button;
	}

	private JButton getMin3Button() {
		if (min3Button == null) {
			min3Button = new JButton();
			min3Button.setText("3 minutes");
			min3Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					min3ButtonActionActionPerformed(event);
				}
			});
		}
		return min3Button;
	}

	private JTextField getTimerTextField() {
		if (timerTextField == null) {
			timerTextField = new JTextField();
			timerTextField.setEditable(false);
			timerTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
			timerTextField.setText("00:00");
		}
		return timerTextField;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL + " on this platform:" + e.getMessage());
		}
	}

	Timer timer;
	ShortTime time;

	/**
	 * count down a number of seconds
	 * 
	 * @param seconds
	 *            number of seconds to count down
	 */
	private void countdownSec(int seconds) {
		timer = new Timer(1000, new MyTimerActionListener());
		time = new ShortTime(seconds / 60, seconds % 60);
		// timerTextField.setText(time.toString());
		timer.start();
		// try{
		// Thread.sleep(seconds*1000);
		// }catch(InterruptedException e){
		// e.printStackTrace();
		// }
		// timer.stop();
	}

	ShortTime time1, time2;

	// count down seconds1 secs, wait waitSecs, then count down seconds2 secs
	private void doubleCountdown(int seconds1, int waitSecs, int seconds2) {
		timer = new Timer(1000, new MyTimerActionListener2(waitSecs));
		time1 = new ShortTime(seconds1 / 60, seconds1 % 60);
		time2 = new ShortTime(seconds2 / 60, seconds2 % 60);
		timer.start();
	}

	/**
	 * Main entry of the class. Note: This class is only created so that you can
	 * easily preview the result at runtime. It is not expected to be managed by
	 * the designer. You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TimerFrame frame = new TimerFrame();
				frame.setDefaultCloseOperation(TimerFrame.EXIT_ON_CLOSE);
				// frame.setTitle("Timer");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private JButton min3Button;
	private JButton sec15Button;
	private JButton min20Button;
	private JButton sec30Button;
	private JButton sec45Button;
	private JButton sec60Button;
	private JButton sec1545Button;
	private JButton sec3060Button;
	private JButton min30Button;
	private JLabel jLabelTimesup;

	class MyTimerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!(time.getMin() == 0 && time.getSec() == 0)) {
				timerTextField.setText(time.toString());
				time.decrease();
			} else {
				java.awt.Toolkit.getDefaultToolkit().beep();// beep
				timerTextField.setText(time.toString());
				jLabelTimesup.setVisible(true);
				timer.stop();
			}
		}
	}

	// in order to point to this fream
	// * the designer no longer work!
	TimerFrame thisFrame = this; // *

	class MyTimerActionListener2 implements ActionListener {
		MyTimerActionListener2(int waitSec) {
			this.waitSec = waitSec;
		}

		int waitSec;// init by the constructor
		boolean started = false;

		// Count down time1 seconds, wait 5 secs, then count down time2 seconds.
		public void actionPerformed(ActionEvent e) {
			if (!(time1.getMin() == 0 && time1.getSec() == 0)) {
				time1.decrease();
				timerTextField.setText(time1.toString());
			} else {
				jLabelTimesup.setVisible(true);
				if (waitSec != -1) {
					timerTextField.setText(String.valueOf(waitSec));
					waitSec--;
				} else {// begin count down time2 seconds
					// begin to record to g:\records\a.wav
					if (!started) {// run once
						java.awt.Toolkit.getDefaultToolkit().beep();// beep
						thisFrame.disAllButCont(thisFrame);// *
						getSoundHelper().startRecording();
						started = true;
						recordingLabel.setVisible(true);
					}
					timerTextField.setText(time2.toString());
					jLabelTimesup.setVisible(false);
					if (!(time2.getMin() == 0 && time2.getSec() == 0)) {
						time2.decrease();
						timerTextField.setText(time2.toString());
					} else {// Time is up
						java.awt.Toolkit.getDefaultToolkit().beep();// beep
						recordingLabel.setVisible(false);
						jLabelTimesup.setVisible(true);
						timer.stop();
						soundHelper.stopRecording();
						thisFrame.enAllButCont(thisFrame); // *
					}
				}
			}
		}
	}

	/**
	 * disable all buttons in the container
	 * 
	 * @param container
	 */
	private void disAllButCont(Container container) {
		Component[] comps = container.getComponents();
		for (int i = 0; i < comps.length; i++) {
			Component c = comps[i];
			if (c instanceof Container)
				disAllButCont((Container) c);
			if (c instanceof JButton) {
				c.setEnabled(false);
			}
		}
	}

	private void enAllButCont(Container container) {
		Component[] comps = container.getComponents();
		for (int i = 0; i < comps.length; i++) {
			Component c = comps[i];
			if (c instanceof Container)
				enAllButCont((Container) c);
			if (c instanceof JButton) {
				c.setEnabled(true);
			}
		}
	}

	SoundHelper soundHelper;

	public SoundHelper getSoundHelper() {
		if (soundHelper == null) {
			soundHelper = new SoundHelper(filePath);
		}
		return soundHelper;
	}

	private void min3ButtonActionActionPerformed(ActionEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		countdownSec(180);
	}

	private void sec15ButtonActionActionPerformed(ActionEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		doubleCountdown(0 + 1, 0, 15 + 1);
	}

	private void sec45ButtonActionActionPerformed(ActionEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		doubleCountdown(0 + 1, 0, 45 + 1);
	}

	private void min20ButtonActionActionPerformed(ActionEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		countdownSec(20 * 60);
	}

	private void min30ButtonActionActionPerformed(ActionEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		countdownSec(30 * 60);
	}

	private void sec20ButtonMouseMouseReleased(MouseEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		doubleCountdown(0 + 1, 0, 20 + 1);
	}

	private void sec30ButtonActionActionPerformed(ActionEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		doubleCountdown(0 + 1, 0, 30 + 1);
	}

	private void sec60ButtonActionActionPerformed(ActionEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		doubleCountdown(0 + 1, 0, 60 + 1);
	}

	private void sec1545ButtonActionActionPerformed(ActionEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		doubleCountdown(15 + 1, 2, 45 + 1);
	}

	private void sec2060ButtonMouseMouseReleased(MouseEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		doubleCountdown(20 + 1, 2, 60 + 1);
	}

	private void sec3060ButtonActionActionPerformed(ActionEvent event) {
		if (timer != null)
			timer.stop();
		jLabelTimesup.setVisible(false);
		doubleCountdown(30 + 1, 2, 60 + 1);
	}

	public String filePath = System.getProperty("user.dir") + "\\temp.wav";// Current
	// working
	// directory
	private JButton playButton;
	private JLabel recordingLabel;
	private JButton startRecordingButton;
	private JButton stopRecordingButton;
	private JTabbedPane jTabbedPane0;
	private JPanel speakingPanel;
	private JPanel writingPanel;
	private JScrollPane integratedScrollPane;
	private JScrollPane intWritingScrollPane;
	private JTextArea integratedTextArea;
	private JTextArea intWritingTextArea;
	private JButton saveAsButton;
	private JLabel readingPassageLabel;
	private JLabel essayLabel;
	private JButton sec20Button;
	private JButton sec2060Button;
	private JPanel intEssayPanel;
	private JPanel intReadingPanel;
	private JSplitPane jSplitPane0;
	private JLabel jLabel0;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	private void playButtonActionActionPerformed(ActionEvent event) {
		getSoundHelper().startPlayBack();
	}

	private void startRecordingButtonMouseMouseReleased(MouseEvent event) {
		if (startRecordingButton.isEnabled())
			getSoundHelper().startRecording();
		recordingLabel.setVisible(true);
		disAllButCont(this);
		stopRecordingButton.setEnabled(true);
	}

	private void stopRecordingButtonMouseMouseReleased(MouseEvent event) {
		getSoundHelper().stopRecording();
		recordingLabel.setVisible(false);
		enAllButCont(this);
	}

	private void saveAsButtonMouseMouseReleased(MouseEvent event) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "Text Files";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory())
					return true;
				String ext = Utils.getExtension(f);
				if (ext != null)
					if (ext.equals(Utils.txt))
						return true;
					else
						return false;
				return false;
			}
		});
		while (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile(); // plus the rest of your code
			File f = new File(Utils.formatFileName(file.getAbsolutePath(), Utils.txt));
			if (file.exists() || f.exists()) {
				int answer = JOptionPane.showConfirmDialog(this, f.getName() + " exists. Replace?");
				if (answer != JOptionPane.OK_OPTION) {
					// start the loop again
					continue;
				}
			}
			// do the rest of your code
			try {
				// format file name :)
				f.delete();
				f.createNewFile();
				ReadWriteTextFile.setContents(f, getIntWritingTextArea().getText());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}
}

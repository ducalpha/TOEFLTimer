package testcase;

//import org.junit.Test;

import audio.Mp3Encoder;


public class Mp3Test {
	//@Test
	public void testMP3(){
		String[] args=new String[10];
//		args[0]="-q";
//		args[1]="middle"; 
//		args[2]="-b";
//		args[3]="128";
//		args[4]="-v";
		args[0]="a.wav";
		Mp3Encoder.main(args);
	}
}

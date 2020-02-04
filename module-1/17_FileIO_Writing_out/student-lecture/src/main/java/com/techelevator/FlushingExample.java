package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FlushingExample {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String message = "Test Line\n";
		
		String filePath = "flushExample";
		
		File file = new File(filePath);
		
		try ( PrintWriter printWriter = new PrintWriter (file );
				BufferedWriter bufferedWriter = new BufferedWriter( printWriter ) ) {
			
				while (true) {
					bufferedWriter.write( message );
					Thread.sleep(500); //can only write 2x per second but will not push into the file yet 
					//unless we flush the stream
					bufferedWriter.flush();
		}

	}

}
}

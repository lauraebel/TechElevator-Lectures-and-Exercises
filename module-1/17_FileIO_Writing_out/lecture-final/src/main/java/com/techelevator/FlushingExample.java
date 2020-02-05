package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FlushingExample {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String message = "Test Line\n";
		
		String filePath = "flushExample2";
		
		File file = new File(filePath);
		
		try ( PrintWriter printWriter = new PrintWriter (file );
				BufferedWriter bufferedWriter = new BufferedWriter( printWriter ) ) {
			
				while (true) {
					bufferedWriter.write( message );
					Thread.sleep(500);
					bufferedWriter.flush();
				}
		}

	}

}

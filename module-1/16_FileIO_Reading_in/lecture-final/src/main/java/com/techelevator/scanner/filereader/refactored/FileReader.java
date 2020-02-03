package com.techelevator.scanner.filereader.refactored;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileReader {

	List<String> read(int lineCount) throws FileNotFoundException;
	
}

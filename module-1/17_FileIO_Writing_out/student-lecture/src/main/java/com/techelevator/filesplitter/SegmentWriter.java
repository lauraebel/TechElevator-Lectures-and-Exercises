package com.techelevator.filesplitter;

import java.util.List;

public interface SegmentWriter {
	
	void write(List<String> lines, int segment) throws SegmentWriterException ;

}

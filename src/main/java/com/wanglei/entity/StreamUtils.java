package com.wanglei.entity;

import java.io.Closeable;
import java.io.IOException;

public class StreamUtils {
	
	public static void closeStream(Closeable ... streams) throws IOException {
		
		for (int i = 0; i < streams.length; i++) {
			streams[i].close();
		}
		
	}

}

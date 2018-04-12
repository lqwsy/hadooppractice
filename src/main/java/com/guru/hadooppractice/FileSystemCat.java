package com.guru.hadooppractice;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileSystemCat {
	
	public static void main(String[] args) {
		FSDataInputStream in = null;
		String uri = args[0];
		Configuration conf = new Configuration();
    	try {
			FileSystem fs = FileSystem.get(URI.create(uri), conf);
			in = fs.open(new Path(uri));
			IOUtils.copyBytes(in, System.out, 4096,false);
			in.seek(0);
			System.out.println("===seek to 0 type again===");
			IOUtils.copyBytes(in, System.out, 4096,false);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeStream(in);
		}
	}
	
}

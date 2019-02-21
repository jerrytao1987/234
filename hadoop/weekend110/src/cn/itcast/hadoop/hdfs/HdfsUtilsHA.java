package cn.itcast.hadoop.hdfs;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HdfsUtilsHA {
	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		FileSystem fs = FileSystem.get(new URI("hdfs://ns1/"), conf, "root");
		fs.copyFromLocalFile(new Path("D:/hadoop/srcdata/word.log"), new Path("hdfs://ns1/"));
	}
}

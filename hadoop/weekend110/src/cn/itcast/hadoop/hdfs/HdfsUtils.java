package cn.itcast.hadoop.hdfs;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

public class HdfsUtils {
	private FileSystem fs;
	@Before
	public void init() throws Exception{
		//读取classpath下的xxx-site.xml配置文件
		Configuration conf = new Configuration();
		//手动设置配置项
		conf.set("fs.defaultFS", "hdfs://CentOS:9000");
		fs = FileSystem.get(new URI("hdfs://CentOS:9000/"), conf, "root");
	}
	@Test
	public void testDownload() throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://CentOS:9000");
		FileSystem fs = FileSystem.get(conf );
		FSDataInputStream in = fs.open(new Path("hdfs://CentOS:9000/jdk-7u71-linux-i586.tar.gz"));
		FileOutputStream out = new FileOutputStream("D:/hadoop/download/jdk-7u71-linux-i586.tar.gz");
		IOUtils.copy(in, out);
	}
	/**
	 * 比较底层的写法
	 * @throws Exception
	 */
	@Test
	public void testUpload() throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://CentOS:9000");
		FileSystem fs = FileSystem.get(conf );
		Path dst = new Path("hdfs://CentOS:9000/aa/hadoop-shell.pdf");
		FSDataOutputStream out = fs.create(dst);
		FileInputStream in = new FileInputStream("D:/hadoop/download/hadoop-shell.pdf");
		IOUtils.copy(in, out);
	}
	/**
	 * 上传文件，封装好的方法
	 * @throws Exception
	 */
	@Test
	public void testUpload2() throws Exception {
		fs.copyFromLocalFile(new Path("D:/hadoop/download/hadoop-shell.pdf"), new Path("hdfs://CentOS:9000/aaa/bbb/ccc/hadoop-shell.pdf"));
	}
	@Test
	public void testDownload2() throws Exception {
		//fs.copyToLocalFile(new Path("hdfs://CentOS:9000/aa/hadoop-shell.pdf"), new Path("D:/hadoop/download/hadoop-shell.pdf"));
		fs.copyToLocalFile(false, new Path("hdfs://CentOS:9000/aa/hadoop-shell.pdf"), new Path("D:/hadoop/download/hadoop-shell.pdf"), true);
	}
	/**
	 * 创建目录
	 * @throws Exception
	 */
	@Test
	public void testMkdir() throws Exception {
		fs.mkdirs(new Path("/aaa/bbb/ccc"));
	}
	/**
	 * 删除文件或文件夹
	 * @throws Exception
	 */
	@Test
	public void testRm() throws Exception {
		fs.delete(new Path("/aa"), true);
	}
	/**
	 * 查看文件信息
	 * @throws Exception
	 */
	@Test
	public void testListFiles() throws Exception {
		//递归遍历文件，如果第二个参数为false，则不进行递归遍历
		RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
		while(listFiles.hasNext()){
			LocatedFileStatus file = listFiles.next();
			String name = file.getPath().getName();
			System.out.println(name);
		}
		System.out.println("------------------------");
		//遍历文件和目录
		FileStatus[] listStatus = fs.listStatus(new Path("/"));
		for (FileStatus fileStatus : listStatus) {
			String name = fileStatus.getPath().getName();
			System.out.println(name+"  isdirectory:"+(fileStatus.isDirectory()?"yes":"no"));
		}
	}
}

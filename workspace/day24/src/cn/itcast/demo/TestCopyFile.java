package cn.itcast.demo;

import java.io.File;

import copyFiles.CopyFile;

public class TestCopyFile {

	public static void main(String[] args) {
		File fileSource = new File("D:\\php5630");
		File fileDestination = new File("e:");
		CopyFile.copyFiles(fileSource, fileDestination);
	}

}

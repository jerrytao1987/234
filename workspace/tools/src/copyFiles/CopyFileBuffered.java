package copyFiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 高效复制文件的类
 * @author dengting
 * @version 2.0
 */
public class CopyFileBuffered {
	/**
	 * 静态方法copyFiles，直接类名调用，无返回值，需要传递两个File对象，传递需要复制的源目录file对象和需要复制到的目的目录file对象
	 * @param fileSource
	 * @param fileDestination
	 * 
	 */
	public static void copyFiles(File fileSource,File fileDestination) {
		if(fileSource.exists()){
			if(fileSource.isDirectory()){
				if(fileDestination.exists()){
					fileDestination = new File(fileDestination,fileSource.getName());
					fileDestination.mkdir();
				}else{
					fileDestination.mkdirs();
					fileDestination = new File(fileDestination,fileSource.getName());
					fileDestination.mkdir();
				}
				File[] listFiles = fileSource.listFiles();
				for (File file : listFiles) {
					if(file.isFile()){
						File fileDestination1 = new File(fileDestination,file.getName());
						BufferedInputStream bis = null;
						BufferedOutputStream bos =null;
						byte[] b = new byte[1024*10];
						int len = 0;
						try {
							bis = new BufferedInputStream(new FileInputStream(file));
							bos = new BufferedOutputStream(new FileOutputStream(fileDestination1));
							while((len = bis.read(b))!=-1){
								bos.write(b, 0, len);
							}
						} catch (Exception e) {
							throw new RuntimeException("文件复制失败");
						} finally {
							try {
								if(bos != null){
									bos.close();
								}
							} catch (IOException e) {
								throw new RuntimeException("释放资源失败");
							} finally {
								try {
									if(bis != null)
										bis.close();
								} catch (Exception e2) {
									throw new RuntimeException("释放资源失败");
								}
							}
						}
					}
				}
				for (File file : listFiles) {
					if(file.isDirectory()){
						copyFiles(file,fileDestination);
					}
				}
			} else {
				File fileDestination1 = new File(fileDestination,fileSource.getName());
				BufferedInputStream bis = null;
				BufferedOutputStream bos =null;
				byte[] b = new byte[1024*10];
				int len = 0;
				try {
					bis = new BufferedInputStream(new FileInputStream(fileSource));
					bos = new BufferedOutputStream(new FileOutputStream(fileDestination1));
					while((len = bis.read(b))!=-1){
						bos.write(b, 0, len);
					}
				} catch (Exception e) {
					throw new RuntimeException("文件复制失败");
				} finally {
					try {
						if(bos != null){
							bos.close();
						}
					} catch (IOException e) {
						throw new RuntimeException("释放资源失败");
					} finally {
						try {
							if(bis != null)
								bis.close();
						} catch (Exception e2) {
							throw new RuntimeException("释放资源失败");
						}
					}
				}
			}
		}else{
			System.out.println("文件目录不存在");
		}
	}

}

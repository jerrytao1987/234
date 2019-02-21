package cn.itcast.hadoop.mr.ii;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import cn.itcast.hadoop.mr.ii.InverseIndexStepOne.StepOneMapper;
import cn.itcast.hadoop.mr.ii.InverseIndexStepOne.StepOneReducer;

public class InverseIndexStepTwo {
	
	public static class StepTwoMapper extends Mapper<LongWritable, Text, Text, Text>{
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			String line = value.toString();
			String[] fields = StringUtils.split(line, "\t");
			String[] wordAndFilename = StringUtils.split(fields[0], "-->");
			
			String word = wordAndFilename[0];
			String filename = wordAndFilename[1];
			long count = Long.parseLong(fields[1]);
			//map的输出结果:<hello,a.txt-->3>
			context.write(new Text(word), new Text(filename+"-->"+count));
		}
	}
	
	public static class StepTwoReducer extends Reducer<Text, Text, Text, Text>{
		@Override
		protected void reduce(Text key, Iterable<Text> values,
				Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
			StringBuffer result = new StringBuffer();
			for (Text value : values) {
				result.append(value+","); 
			}
			int length = result.length();
			String result1 = result.substring(0, length-1);
			context.write(key, new Text(result1));
		}
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		//构造job_one
//		Job job_one = Job.getInstance(conf);
//		job_one.setJarByClass(InverseIndexStepTwo.class);
//		job_one.setMapperClass(StepOneMapper.class);
//		job_one.setReducerClass(StepOneReducer.class);
		//.....
		
		//构造job_two
		Job job_two = Job.getInstance(conf);
		
		job_two.setJarByClass(InverseIndexStepTwo.class);
		
		job_two.setMapperClass(StepTwoMapper.class);
		job_two.setReducerClass(StepTwoReducer.class);
		
		job_two.setOutputKeyClass(Text.class);
		job_two.setOutputValueClass(Text.class);
		
		FileInputFormat.setInputPaths(job_two, new Path(args[0]));
		//检查参数所输出的路径是否存在，如果已存在就先删除
		Path output = new Path(args[1]);
		FileSystem fs = FileSystem.get(conf);
		if(fs.exists(output)){
			fs.delete(output, true);
		}
		
		FileOutputFormat.setOutputPath(job_two, output);
		
//		boolean one_result = job_one.waitForCompletion(true);
//		if(one_result){
//			System.exit(job_two.waitForCompletion(true)?0:1);
//		}
		System.exit(job_two.waitForCompletion(true)?0:1);
	}
}

package cn.itcast.hadoop.mr.areapartition;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.OutputFormat;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import cn.itcast.hadoop.mr.flowsum.FlowBean;
/**
 * 对流量原始日志进行流量统计，将不同省份的用户统计结果输出到不同文件
 * 需要自定义改造两个机制：
 * 1.改造分区的逻辑，自定义一个partitioner
 * 2.自定义reducer task的并发任务数
 * @author dengting
 *
 */
public class FlowSumArea {
	
	public static class FlowSumAreaMapper extends Mapper<LongWritable, Text, Text, FlowBean>{
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context)
				throws IOException, InterruptedException {
			//拿一行数据
			String line = value.toString();
			String[] fields = StringUtils.split(line, "\t");
			String phoneNB = fields[1];
			long up_flow = Long.parseLong(fields[7]);
			long d_flow = Long.parseLong(fields[8]);
			context.write(new Text(phoneNB), new FlowBean(phoneNB, up_flow, d_flow));
		}
	}
	
	public static class FlowSumAreaReducer extends Reducer<Text, FlowBean, Text, FlowBean>{
		@Override
		protected void reduce(Text key, Iterable<FlowBean> values, Reducer<Text, FlowBean, Text, FlowBean>.Context context)
				throws IOException, InterruptedException {
			long up_flow_counter = 0;
			long d_flow_counter = 0;
			for (FlowBean flowBean : values) {
				up_flow_counter += flowBean.getUp_flow();
				d_flow_counter += flowBean.getD_flow();
			}
			context.write(key, new FlowBean(key.toString(), up_flow_counter, d_flow_counter));
		}
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(FlowSumArea.class);
		
		job.setMapperClass(FlowSumAreaMapper.class);
		job.setReducerClass(FlowSumAreaReducer.class);
		//设置我们自定义的分组逻辑定义
		job.setPartitionerClass(AreaPartitioner.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FlowBean.class);
		//设置reduce的任务并发数，应该和分组的数量保持一致
		job.setNumReduceTasks(6);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		//InputFormat in = null;
		//OutputFormat out = null;
		
		System.exit(job.waitForCompletion(true)?0:1);
	}
}

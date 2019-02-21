package cn.itcast.hadoop.mr.flowsum;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowSumMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
	//拿到日志中的一行数据，切分各个字段，抽取出我们需要的字段：手机号，上行流量，下行流量，然后封装成kv发送出去
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

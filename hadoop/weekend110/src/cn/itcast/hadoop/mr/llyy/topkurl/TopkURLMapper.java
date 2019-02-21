package cn.itcast.hadoop.mr.llyy.topkurl;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import cn.itcast.hadoop.mr.flowsum.FlowBean;

public class TopkURLMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
	
	private FlowBean bean = new FlowBean();
	private Text k = new Text();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		String[] fields = StringUtils.split(line,"\t");
		String url = fields[26];
		long up_flow = Long.parseLong(fields[30]);
		long d_flow = Long.parseLong(fields[31]);
		k.set(url);
		bean.set("", up_flow, d_flow);
		context.write(k, bean);
	}
	
	
}

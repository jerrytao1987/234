package cn.itcast.hadoop.mr.llyy.topkurl;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import cn.itcast.hadoop.mr.flowsum.FlowBean;

public class TopkURLReducer extends Reducer<Text, FlowBean, Text, LongWritable> {
	private TreeMap<FlowBean,String> treeMap = new TreeMap<FlowBean,String>();
	private double globalCount;
	//<url,{bean,bean,...bean}
	@Override
	protected void reduce(Text key, Iterable<FlowBean> values, Reducer<Text, FlowBean, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		Text url = key;
		long up_sum = 0;
		long d_sum = 0;
		for (FlowBean bean : values) {
			up_sum += bean.getUp_flow();
			d_sum += bean.getD_flow();
		}
		FlowBean bean = new FlowBean("", up_sum, d_sum);
		globalCount += bean.getS_flow();
		treeMap.put(bean,url.toString());
		
	}
	//reduce方法执行完成后再执行一次cleanup方法
	@Override
	protected void cleanup(Reducer<Text, FlowBean, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		Set<Entry<FlowBean, String>> entrySet = treeMap.entrySet();
		double tempCount = 0;
		for (Entry<FlowBean, String> entry : entrySet) {
			if(tempCount/globalCount < 0.8){
				context.write(new Text(entry.getValue()), new LongWritable(entry.getKey().getS_flow()));
				tempCount += entry.getKey().getS_flow();
			}else{
				return;
			}
		}
	}
	
	
}

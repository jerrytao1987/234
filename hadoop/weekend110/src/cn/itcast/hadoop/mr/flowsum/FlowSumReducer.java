package cn.itcast.hadoop.mr.flowsum;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlowSumReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
	
	//框架每传递一组数据<138778654,{flowbean,flowbean,...,flowbean}>调用一次我们的reduce方法
	//reduce中的业务逻辑就是遍历values,然后进行累加求和再输出
	@Override
	protected void reduce(Text key, Iterable<FlowBean> values, Reducer<Text, FlowBean, Text, FlowBean>.Context context)
			throws IOException, InterruptedException {
		long up_flow_counter=0L;
		long d_flow_counter=0L;
		for (FlowBean flowBean : values) {
			up_flow_counter += flowBean.getUp_flow();
			d_flow_counter += flowBean.getD_flow();
		}
		context.write(key, new FlowBean(key.toString(), up_flow_counter, d_flow_counter));
	}
	
	
}

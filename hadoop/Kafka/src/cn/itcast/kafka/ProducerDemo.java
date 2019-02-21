package cn.itcast.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class ProducerDemo {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put("zk.connect", "hadoop01:2181,hadoop02:2181,hadoop03:2181");
		props.put("metadata.broker.list","hadoop01:9092,hadoop02:9092,hadoop03:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);

		// 发送业务消息
		// 读取文件 读取内存数据库 读socket端口
		for (int i = 1; i <= 100; i++) {
			Thread.sleep(1000);
			producer.send(new KeyedMessage<String, String>("mygirls",
					"i said i love you for" + i + "times,will you have a nice day with me tomorrow"));
		}

	}
}
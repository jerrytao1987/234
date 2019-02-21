package cn.e3mall.search.message;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemDelMessageListener implements MessageListener {
	
	@Autowired
	private SolrServer solrServer;
	@Override
	public void onMessage(Message message) {
		try {
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			String[] ids = text.split(",");
			for (String id : ids) {
				solrServer.deleteByQuery("id:"+id);
			}
			// 提交
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

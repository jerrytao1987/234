package cn.e3mall.solrj;

import static org.junit.Assert.*;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrCloud {

	@Test
	public void testAddDocument() throws Exception {
		// 创建一个集群的连接，应该使用CloudSolrServer创建
		CloudSolrServer solrServer = new CloudSolrServer("192.168.44.129:2182,192.168.44.129:2183,192.168.44.129:2184");
		// zkHost:zookeeper的地址列表
		// 设置一个defaultCollection属性
		solrServer.setDefaultCollection("collection2");
		// 创建一个文档对象
		SolrInputDocument document = new SolrInputDocument();
		// 向文档对象中添加域，文档中必须包含一个id域，所有的域的名称必须在schema.xml中定义
		document.setField("id", "solrcloud01");
		document.setField("item_title", "测试商品01");
		document.setField("item_price", 1000);
		// 把文档写入索引库
		solrServer.add(document);
		// 提交
		solrServer.commit();

	}

	@Test
	public void testQueryDocument() throws Exception {
		// 创建一个集群的连接，应该使用CloudSolrServer创建
		CloudSolrServer solrServer = new CloudSolrServer("192.168.44.129:2182,192.168.44.129:2183,192.168.44.129:2184");
		// zkHost:zookeeper的地址列表
		// 设置一个defaultCollection属性
		solrServer.setDefaultCollection("collection2");
		// 创建一个SolrQuery对象
		SolrQuery query = new SolrQuery();
		// 设置查询条件
		// query.setQuery("*:*");
		query.set("q", "*:*");
		// 执行查询，QueryResponse对象
		QueryResponse queryResponse = solrServer.query(query);
		// 取文档列表,取查询结果的总记录数
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
		// 遍历文档列表，从取域的内容
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_sell_point"));
			System.out.println(solrDocument.get("item_price"));
			System.out.println(solrDocument.get("item_image"));
			System.out.println(solrDocument.get("item_category_name"));
		}
	}

	@Test
	public void deleteDocument() throws Exception {
		// 创建一个集群的连接，应该使用CloudSolrServer创建
		CloudSolrServer solrServer = new CloudSolrServer("192.168.44.129:2182,192.168.44.129:2183,192.168.44.129:2184");
		// zkHost:zookeeper的地址列表
		// 设置一个defaultCollection属性
		solrServer.setDefaultCollection("collection2");
		// solrServer.deleteById("doc01");
		solrServer.deleteByQuery("id:solrcloud01");
		// 提交
		solrServer.commit();
	}
}

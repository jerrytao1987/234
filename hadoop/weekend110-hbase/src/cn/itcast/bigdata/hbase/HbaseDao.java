package cn.itcast.bigdata.hbase;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.BinaryPrefixComparator;
import org.apache.hadoop.hbase.filter.ByteArrayComparable;
import org.apache.hadoop.hbase.filter.ColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.FamilyFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.MultipleColumnPrefixFilter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.QualifierFilter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

public class HbaseDao {

	public static void main(String[] args) throws Exception {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "hadoop01:2181,hadoop02:2181,hadoop03:2181");
		HBaseAdmin admin = new HBaseAdmin(conf);
		TableName name = TableName.valueOf("wk110");
		HTableDescriptor desc = new HTableDescriptor(name);
		HColumnDescriptor bifamily = new HColumnDescriptor("base_info");
		HColumnDescriptor eifamily = new HColumnDescriptor("extra_info");
		bifamily.setMaxVersions(5);
		desc.addFamily(bifamily);
		desc.addFamily(eifamily);
		admin.createTable(desc);
	}

	private Configuration conf = null;

	@Before
	public void init() {
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "hadoop01:2181,hadoop02:2181,hadoop03:2181");
	}

	@Test
	public void testPut() throws Exception {
		HTable wk110 = new HTable(conf, "wk110");
		Put put = new Put(Bytes.toBytes("rk00001"));
		put.add(Bytes.toBytes("base_info"), Bytes.toBytes("name"), Bytes.toBytes("xiaoming"));
		Put age = new Put(Bytes.toBytes("rk00001"));
		age.add(Bytes.toBytes("base_info"), Bytes.toBytes("age"), Bytes.toBytes(18));
		ArrayList<Put> puts = new ArrayList<Put>();
		puts.add(put);
		puts.add(age);
		wk110.put(puts);
		wk110.close();
	}

	@Test
	public void testDrop() throws Exception {
		HBaseAdmin admin = new HBaseAdmin(conf);
		admin.disableTable("wk110");
		admin.deleteTable("wk110");
		admin.close();
	}

	@Test
	public void testGet() throws Exception {
		// HTablePool pool = new HTablePool(conf, 10);
		// HTable table = (HTable) pool.getTable("user");
		HTable table = new HTable(conf, "wk110");
		Get get = new Get(Bytes.toBytes("rk00001"));
		// get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"));
		get.setMaxVersions(5);
		Result result = table.get(get);
		// result.getValue(family, qualifier)
		for (KeyValue kv : result.list()) {
			String family = new String(kv.getFamily());
			System.out.println(family);
			String qualifier = new String(kv.getQualifier());
			System.out.println(qualifier);
			System.out.println(new String(kv.getValue()));
		}
		table.close();
	}
	@Test
	public void testScan() throws Exception {
		//HTablePool pool = new HTablePool(conf, 10);
		//HTableInterface table = pool.getTable("user");
		HTable table = new HTable(conf, "wk110");
		Scan scan = new Scan(Bytes.toBytes("rk00001"));
		//前缀过滤器
		Filter filter = new PrefixFilter(Bytes.toBytes("rk"));
		//行过滤器
		/*ByteArrayComparable rowComparator = new BinaryComparator(Bytes.toBytes(""));
		RowFilter rf = new RowFilter(CompareOp.LESS_OR_EQUAL, rowComparator);
		
		//rf = new RowFilter(CompareOp.EQUAL, new SubstringComparator("_2014-12-21"));
		//单值过滤器1 完整匹配字节数组
		new SingleColumnValueFilter("base_info".getBytes(), "name".getBytes(), CompareOp.EQUAL, "".getBytes());
		//单值过滤器2匹配正则表达式
		ByteArrayComparable comparator = new RegexStringComparator("zhang.");
		new SingleColumnValueFilter("base_info".getBytes(), "name".getBytes(), CompareOp.EQUAL, comparator);
		//单值过滤器2匹配是否包含子串，大小写不敏感
		comparator = new SubstringComparator("wu");
		new SingleColumnValueFilter("base_info".getBytes(), "name".getBytes(), CompareOp.EQUAL, comparator);
		//键值对元数据过滤-----family过滤-----字节数组完整匹配
		FamilyFilter ff = new FamilyFilter(CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("base_info")));
		//键值对元数据过滤-----family过滤-----字节数组前缀匹配
		ff = new FamilyFilter(CompareOp.EQUAL, new BinaryPrefixComparator(Bytes.toBytes("base")));
		//键值对元数据过滤-----qualifier过滤-----字节数组完整匹配
		filter = new QualifierFilter(CompareOp.EQUAL, new BinaryComparator(Bytes.toBytes("name")));
		//键值对元数据过滤-----qualifier过滤-----字节数组前缀匹配
		filter = new QualifierFilter(CompareOp.EQUAL, new BinaryPrefixComparator(Bytes.toBytes("na")));
		//基于列名（即Qualifier)前缀过滤数据的ColumnPrefixFilter
		filter = new ColumnPrefixFilter("na".getBytes());
		//基于列名（即Qualifier)多个前缀过滤数据的MultipleColumnPrefixFilter
		byte[][] prefixes=new byte[][]{Bytes.toBytes("na"),Bytes.toBytes("me")};
		filter = new MultipleColumnPrefixFilter(prefixes);*/
		
		//为查询设置过滤条件
		scan.setFilter(filter);
		scan.addFamily(Bytes.toBytes("base_info"));
		ResultScanner scanner = table.getScanner(scan);
		for(Result r : scanner){
			/**
			for(KeyValue kv : r.list()){
				String family = new String(kv.getFamily());
				System.out.println(family);
				String qualifier = new String(kv.getQualifier());
				System.out.println(qualifier);
				System.out.println(new String(kv.getValue()));
			}
			*/
			byte[] value = r.getValue(Bytes.toBytes("base_info"), Bytes.toBytes("name"));
			System.out.println(new String(value));
		}
		table.close();
	}
	@Test
	public void testDel() throws Exception {
		HTable table = new HTable(conf, "wk110");
		Delete del = new Delete(Bytes.toBytes("rk00001"));
		del.deleteColumn(Bytes.toBytes("data"), Bytes.toBytes("pic"));
		table.delete(del);
		table.close();
	}
}

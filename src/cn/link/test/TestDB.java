package cn.link.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.text.AbstractDocument.LeafElement;

import org.junit.Before;
import org.junit.Test;

public class TestDB {

	Connection conn1;
	Connection conn2;
	Connection conn8;
	Statement stmt1;
	PreparedStatement stmt2;
	/**
	 * 
	 * 除去重复对应关系：

查看重复多字段：
SELECT * FROM zzall_zzguifan WHERE (zzall_id,zzguifan_id) in(SELECT zzall_id,zzguifan_id FROM zzall_zzguifan GROUP BY zzall_id,zzguifan_id HAVING COUNT(*)>1) ORDER BY zzall_id;

创建临时重复字段表：
CREATE TABLE tmp_zzall_zzuifan SELECT zzall_id,zzguifan_id FROM zzall_zzguifan GROUP BY zzall_id,zzguifan_id HAVING COUNT(*)>1

创建临时重复字段的最小ID表：
create table tmp_minid SELECT zzall_zzguifan.id zzall_zzguifan_id FROM zzall_zzguifan GROUP BY zzall_id,zzguifan_id HAVING COUNT(*)>1

基于临时表删除重复的行：
DELETE FROM zzall_zzguifan WHERE(zzall_zzguifan.zzall_id,zzall_zzguifan.zzguifan_id) in (SELECT tmp_zzall_zzuifan.zzall_id,tmp_zzall_zzuifan.zzguifan_id FROM tmp_zzall_zzuifan) AND zzall_zzguifan.id NOT IN (SELECT tmp_minid.zzall_zzguifan_id FROM tmp_minid);
	 * 
	 * 
	 * @throws Exception
	 */
	
	
	
	@Before
	public void init() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhengzhuang?user=root&password=123456");
		conn8 = DriverManager.getConnection("jdbc:mysql://localhost:3306/kde_cm?user=root&password=123456");
		conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/union_kde_cm_data?characterEncoding=utf8&user=root&password=123456");
		stmt1 = conn1.createStatement();
	}
	
	
	/**
	 * 重新构建规则
	 * @throws Exception
	 */
	@Test
	public void reCreateRuleTable() throws Exception{
		stmt1 = conn2.createStatement();
		
		stmt1.execute("DROP TABLE tmp_formula_zz");
		stmt1.execute("DROP TABLE tmp_formula_zh");
		stmt1.execute("CREATE TABLE tmp_formula_zz SELECT formula.id formula_id,zzguifan.id zz_id,zzguifan.zhengzhuang_name zzname FROM formula,formula_zzall,zzall_zzguifan,zzguifan WHERE formula.id=formula_zzall.formula_id AND formula_zzall.zzall_id=zzall_zzguifan.zzall_id AND zzall_zzguifan.zzguifan_id=zzguifan.id;");
		stmt1.execute("CREATE TABLE tmp_formula_zh SELECT formula.id formula_id,zhguifan.id zh_id,zhguifan.zhenghou_name zhname FROM formula,formula_zhall,zhall_zhguifan,zhguifan WHERE formula.id=formula_zhall.formula_id AND formula_zhall.zhall_id=zhall_zhguifan.zhall_id AND zhall_zhguifan.zhguifan_id=zhguifan.id;");
	
	}
	/*
	@Test
	public void initCnkiTemp0() throws Exception{
		stmt2 = conn2.prepareStatement("insert into temp_cnki_formula(formula_id) values (?)");
		for(int i=1;i<=1433;i++){
			stmt2.setInt(1, i);
			stmt2.executeUpdate();
		}
		
	}*/
	/**
	 * 删除重复的症状全集_症状规范关系!
	 * @throws Exception
	 */
	@Test
	public void deleteChongfuZz() throws Exception{
		stmt1 = conn2.createStatement();
		stmt1.execute("SELECT * FROM zzall_zzguifan WHERE (zzall_id,zzguifan_id) in(SELECT zzall_id,zzguifan_id FROM zzall_zzguifan GROUP BY zzall_id,zzguifan_id HAVING COUNT(*)>1) ORDER BY zzall_id");
		stmt1.execute("DROP TABLE tmp_minid");
		stmt1.execute("DROP TABLE tmp_zzall_zzuifan");
		stmt1.execute("CREATE TABLE tmp_zzall_zzuifan SELECT zzall_id,zzguifan_id FROM zzall_zzguifan GROUP BY zzall_id,zzguifan_id HAVING COUNT(*)>1");
		stmt1.execute("create table tmp_minid SELECT zzall_zzguifan.id zzall_zzguifan_id FROM zzall_zzguifan GROUP BY zzall_id,zzguifan_id HAVING COUNT(*)>1");
		stmt1.execute("DELETE FROM zzall_zzguifan WHERE(zzall_zzguifan.zzall_id,zzall_zzguifan.zzguifan_id) in (SELECT tmp_zzall_zzuifan.zzall_id,tmp_zzall_zzuifan.zzguifan_id FROM tmp_zzall_zzuifan) AND zzall_zzguifan.id NOT IN (SELECT tmp_minid.zzall_zzguifan_id FROM tmp_minid)");
	}
	
	
	/**
	 * 快速规范相同名称的症状
	 * @throws Exception 
	 */
	@Test
	public void quickStandardZz() throws Exception{
		Connection conn22 = DriverManager.getConnection("jdbc:mysql://localhost:3306/union_kde_cm_data?characterEncoding=utf8&user=root&password=123456");
		Connection conn222 = DriverManager.getConnection("jdbc:mysql://localhost:3306/union_kde_cm_data?characterEncoding=utf8&user=root&password=123456");
		stmt1 = conn2.createStatement();
		Statement stmt11 = conn2.createStatement();
		Statement stmt111 = conn2.createStatement();
		stmt2 = conn22.prepareStatement("insert zzall_zzguifan(zzall_id,zzguifan_id) values(?,?)");
		PreparedStatement stmt3 = conn222.prepareStatement("update zzall set type=2002 where id=?");
		ResultSet rs = stmt1.executeQuery("select id,zhengzhuang_name from zzall where type=2002");
		HashMap<String, Integer> sourceMap = new HashMap<String, Integer>();
		while(rs.next()){
			sourceMap.put(rs.getString(2), rs.getInt(1));
		}
		ResultSet rs3 = stmt11.executeQuery("select id,zhengzhuang_name from zzall where type=2010");
		while(rs3.next()){
			int fid = rs3.getInt(1);
			String str = rs3.getString(2);
			str = str.trim();
			if(sourceMap.containsKey(str)){
				int id = sourceMap.get(str);
				ResultSet rs2 = stmt111.executeQuery("select zzguifan_id from zzall_zzguifan where zzall_id="+id);
				while(rs2.next()){
					stmt2.setInt(1, id);
					stmt2.setInt(2, rs2.getInt(1));
					stmt2.executeUpdate();
				}
				stmt3.setInt(1, fid);
				stmt3.executeUpdate();
			}
		}
	}
	
	
	@Test
	public void initCnkiTemp1() throws Exception{
		stmt1 = conn8.createStatement();
		stmt2 = conn2.prepareStatement("update temp_cnki_formula set zhstr=(?) where formula_id=(?)");
		ResultSet rs = stmt1.executeQuery("SELECT f_s.formulaid formula_id,symptom.symptomname zhenghou FROM f_s,symptom WHERE symptomtype=2 AND f_s.symptomid=symptom.symptomid;");
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		while(rs.next()){
			int fid = rs.getInt(1);
			String zhstr = rs.getString(2);
			if(!map.containsKey(fid)){
				map.put(fid, zhstr);
			}else{
				String tempStr = map.get(fid);
				tempStr+="，"+zhstr;
			}
		}
		for(Entry<Integer,String> e:map.entrySet()){
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			stmt2.setString(1, e.getValue());
			stmt2.setInt(2, e.getKey());
			stmt2.executeUpdate();
		}
		
	}
	
	@Test
	public void initCnkiTemp2() throws Exception{
		stmt1 = conn8.createStatement();
		stmt2 = conn2.prepareStatement("update temp_cnki_formula set zzstr=(?) where formula_id=(?)");
		ResultSet rs = stmt1.executeQuery("SELECT f_s.formulaid formula_id,symptom.symptomname zhenghou FROM f_s,symptom WHERE symptomtype=1 AND f_s.symptomid=symptom.symptomid;");
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		while(rs.next()){
			int fid = rs.getInt(1);
			String zhstr = rs.getString(2);
			if(!map.containsKey(fid)){
				map.put(fid, zhstr);
			}else{
				String tempStr = map.get(fid);
				
				tempStr+="，"+zhstr;
				map.put(fid, tempStr);
			}
		}
		for(Entry<Integer,String> e:map.entrySet()){
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			stmt2.setString(1, e.getValue());
			stmt2.setInt(2, e.getKey());
			stmt2.executeUpdate();
		}
		
	}
	
	@Test
	public void initCnkiTemp3() throws Exception{
		stmt1 = conn8.createStatement();
		stmt2 = conn2.prepareStatement("update temp_cnki_formula set zzstr=(?) where formula_id=(?)");
		ResultSet rs = stmt1.executeQuery("SELECT f_s.formulaid formula_id,symptom.symptomname zhenghou FROM f_s,symptom WHERE symptomtype=1 AND f_s.symptomid=symptom.symptomid;");
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		while(rs.next()){
			int fid = rs.getInt(1);
			String zhstr = rs.getString(2);
			if(!map.containsKey(fid)){
				map.put(fid, zhstr);
			}else{
				String tempStr = map.get(fid);
				
				tempStr+="，"+zhstr;
				map.put(fid, tempStr);
			}
		}
		for(Entry<Integer,String> e:map.entrySet()){
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			stmt2.setString(1, e.getValue());
			stmt2.setInt(2, e.getKey());
			stmt2.executeUpdate();
		}
		
	}
	
	@Test
	public void initFangjixue() throws Exception{
		stmt1 = conn2.createStatement();
		stmt2 = conn2.prepareStatement("insert into zhall (zhenghou_name,source_id,type) values (?,?,?)");
		ResultSet rs = stmt1.executeQuery("select zhenghou from fangjixuezh where whetherzhenghou=1");
		List<String> zhList =new ArrayList<String>();
		while(rs.next()){
			String str = rs.getString(1);
			System.out.println(str);
			zhList.add(str);
		}
		for(String temp :zhList){
			stmt2.setString(1, temp);
			stmt2.setInt(2, 10);
			stmt2.setInt(3, 10);
			stmt2.executeUpdate();
		}
		
		
	}
	
	
	
	/**
	 * 初始化CNKI期刊的方剂数据到全集库中，包括详细来源，和详细内容！
	 * @throws Exception 
	 */
	@Test
	public void showCnkiFormula() throws Exception{
		stmt1 = conn2.createStatement();
		ResultSet rs = stmt1.executeQuery("");
		
		
	}
	
	
	/**
	 * 下面全部是初始化症状和证候数据到全集库中~
	 * @throws Exception
	 */
	
	
	@Test
	public void initCnkiZh() throws Exception{
		Statement stmt3=conn8.createStatement();
		stmt2 = conn2.prepareStatement("insert into zhall (zhenghou_name,source_id,type) values (?,?,?)");
		ResultSet rs = stmt3.executeQuery("select symptomname from symptom where symptomtype=2;");
		List<String> zhList =new ArrayList<String>();
		while(rs.next()){
			String temp =rs.getString(1);
			//System.out.println(rs.getString(1));
			if(temp!=null){
				temp = temp.trim();
				if(!temp.equals("")){
					zhList.add(temp);
				}
			}
		}
		
		for(String temp :zhList){
			stmt2.setString(1, temp);
			stmt2.setInt(2, 4);
			stmt2.setInt(3, 10);
			stmt2.executeUpdate();
		}
		
	}
	
	
	@Test
	public void initGbZh() throws Exception{
		stmt2 = conn2.prepareStatement("insert into zhall (zhenghou_name,source_id,type) values (?,?,?)");
		ResultSet rs = stmt1.executeQuery("select zhenghou from bingji2zhenghou;");
		List<String> zhList =new ArrayList<String>();
		while(rs.next()){
			String temp =rs.getString(1);
			
			if(temp!=null){
				System.out.println(rs.getString(1));
				temp = temp.trim();
				if(!temp.equals("")){
					zhList.add(temp);
				}
			}
		}
		
		for(String temp :zhList){
			stmt2.setString(1, temp);
			stmt2.setInt(2, 9);
			stmt2.setInt(3, 10);
			stmt2.executeUpdate();
		}
		
	}
	
	
	@Test
	public void initNeikexueZh() throws Exception{
		stmt2 = conn2.prepareStatement("insert into zhall (zhenghou_name,source_id,type) values (?,?,?)");
		ResultSet rs = stmt1.executeQuery("select zhenghou from neikexue;");
		List<String> zhList =new ArrayList<String>();
		while(rs.next()){
			String temp =rs.getString(1);
			
			if(temp!=null){
				
				temp = temp.trim();
				if(!temp.equals("")){
					System.out.println(rs.getString(1));
					zhList.add(temp);
				}
			}
		}
		
		for(String temp :zhList){
			stmt2.setString(1, temp);
			stmt2.setInt(2, 5);
			stmt2.setInt(3, 10);
			stmt2.executeUpdate();
		}
		
	}
	
	@Test
	public void initZhongxiyiZh() throws Exception{
		stmt2 = conn2.prepareStatement("insert into zhall (zhenghou_name,source_id,type) values (?,?,?)");
		ResultSet rs = stmt1.executeQuery("select zhongyi_zhiliao from zhong_xiyi;");
		List<String> zhList =new ArrayList<String>();
		while(rs.next()){
			String temp =rs.getString(1);
			
			if(temp!=null){
				
				temp = temp.trim();
				temp = temp.replace(":", "：");
				if(!temp.equals("")){
					String[] ts = temp.split("；");
					for(String s : ts){
						
						if(s.contains(".")){
							int start = s.indexOf(".");
							int end = s.indexOf("：");
							String newtempStr = s.substring(start+1, end);
							if(newtempStr.equals("（"))
								newtempStr = "邪壅三焦证";
							else if(newtempStr.contains("2."))
								newtempStr = "阴虚阳亢证";
							zhList.add(newtempStr);
							System.out.println(newtempStr);
						}
						
					}
					
					
					
				}
			}
		}
		
		for(String temp :zhList){
			stmt2.setString(1, temp);
			stmt2.setInt(2, 6);
			stmt2.setInt(3, 10);
			stmt2.executeUpdate();
		}
		
	}
	
	
	//导入中国药典数据到全集表中
	@Test
	public void initYaodian() throws Exception{
		
		stmt2 = conn2.prepareStatement("insert into zzall (zhengzhuang_name,source_id,type) values (?,?,?)");
		Statement stmt3=conn8.createStatement();
		ResultSet rs = stmt3.executeQuery("select attending from drug;");
		List<String> zzs = new ArrayList<String>();
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		while(rs.next()){
				String temp = rs.getString(1);
				
				
				if(temp!=null){
					temp = temp.trim();
					temp.replace("；", "，");
					if(!temp.equals("")){
						if(temp.contains("用于")){
							temp = temp.substring((temp.indexOf("用于")+"用于".length()),temp.length());
						}
						
						//System.out.println(temp);
						String[] temps = temp.split("，");
						
						for(String s :temps){
							System.out.println(s);
							map.put(s, 1);
							
						}
					    zzs.add(temp);
					}
					
				}
				
		}
		
		for(Entry<String, Integer> et :map.entrySet()){
			stmt2.setString(1, et.getKey());
			stmt2.setInt(2, 3);
			stmt2.setInt(3, 10);
			stmt2.executeUpdate();
		}
		
	}
	
	
	//导入CNKI症状数据到全集表中
		@Test
		public void initCnki() throws Exception{
			
			stmt2 = conn2.prepareStatement("insert into zzall (zhengzhuang_name,source_id,type) values (?,?,?)");
			ResultSet rs = stmt1.executeQuery("select zhengzhuang from neikexue;");
			List<String> zzs = new ArrayList<String>();
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			while(rs.next()){
					String temp = rs.getString(1);
					
					
					
					if(temp!=null){
						temp = temp.trim();
						if(!temp.equals("")){
							
							//System.out.println(temp);
							String[] temps = temp.split("，");
							
							for(String s :temps){
								System.out.println(s);
								map.put(s, 1);
								
							}
						    zzs.add(temp);
						}
						
					}
						
					
					
			}
			
			for(Entry<String, Integer> et :map.entrySet()){
//				stmt2.setString(1, et.getKey());
//				stmt2.setInt(2, 4);
//				stmt2.setInt(3, 10);
//				stmt2.executeUpdate();
				System.out.println(et.getKey());
			}
			
		}
	
	
		@Test
		public void initNeikexue() throws Exception{
			
			stmt2 = conn2.prepareStatement("insert into zzall (zhengzhuang_name,source_id,type) values (?,?,?)");
			ResultSet rs = stmt1.executeQuery("select zhengzhuang from neikexue;");
			List<String> zzs = new ArrayList<String>();
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			while(rs.next()){
					String temp = rs.getString(1);
					
					
					if(temp!=null){
						temp = temp.trim();
						temp = temp.replace(",", "，");
						if(!temp.equals("")){
							
							String[] temps = temp.split("，");
							
							for(String s :temps){
								System.out.println(s);
								map.put(s, 1);
								
							}
						    zzs.add(temp);
						}
						
					}
						
						
					
					
			}
			
			for(Entry<String, Integer> et :map.entrySet()){
				stmt2.setString(1, et.getKey());
				stmt2.setInt(2, 5);
				stmt2.setInt(3, 10);
				stmt2.executeUpdate();
				System.out.println(et.getKey());
			}
			
		}
		
		
		@Test
		public void initNeikexueZhusu() throws Exception{
			
			stmt2 = conn2.prepareStatement("insert into zzall (zhengzhuang_name,source_id,type) values (?,?,?)");
			ResultSet rs = stmt1.executeQuery("select zhuzheng from neikexue;");
			List<String> zzs = new ArrayList<String>();
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			while(rs.next()){
					String temp = rs.getString(1);
					
					
					if(temp!=null){
						temp = temp.trim();
						temp = temp.replace("、", "，");
						temp = temp.replace("；", "，");
						if(!temp.equals("")){
							
							String[] temps = temp.split("，");
							
							for(String s :temps){
								System.out.println(s);
								map.put(s, 1);
								
							}
						    zzs.add(temp);
						}
						
					}
						
						
					
					
			}
			
			for(Entry<String, Integer> et :map.entrySet()){
				stmt2.setString(1, et.getKey());
				stmt2.setInt(2, 7);
				stmt2.setInt(3, 10);
				stmt2.executeUpdate();
				System.out.println(et.getKey());
			}
			
		}
	
		

		@Test
		public void initZhongxiYi() throws Exception{
			
			stmt2 = conn2.prepareStatement("insert into zzall (zhengzhuang_name,source_id,type) values (?,?,?)");
			ResultSet rs = stmt1.executeQuery("select zhuyaozhengzhuang from zhong_xiyi;");
			List<String> zzs = new ArrayList<String>();
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			while(rs.next()){
					String temp = rs.getString(1);
					
					
					if(temp!=null){
						temp = temp.trim();
						if(!temp.equals("")){
							String[] temps = temp.split("；");
							for(String s:temps){
								s= s.trim();
								if(!s.equals("")){
									System.out.println(s);
									
									map.put(s, 1);
								}
								
							}
							
						}
						
					}
						
						
					
					
			}
			
			for(Entry<String, Integer> et :map.entrySet()){
//				stmt2.setString(1, et.getKey());
//				stmt2.setInt(2, 6);
//				stmt2.setInt(3, 10);
//				stmt2.executeUpdate();
				System.out.println(et.getKey());
			}
			
		}
		
		
		@Test
		public void initZhongxiYiZhuyaoTizheng() throws Exception{
			
			stmt2 = conn2.prepareStatement("insert into zzall (zhengzhuang_name,source_id,type) values (?,?,?)");
			ResultSet rs = stmt1.executeQuery("select zhuyaotizheng from zhong_xiyi;");
			List<String> zzs = new ArrayList<String>();
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			while(rs.next()){
					String temp = rs.getString(1);
					
					
					if(temp!=null){
						temp = temp.trim();
						if(!temp.equals("")){
							String[] temps = temp.split("；");
							for(String s:temps){
								s= s.trim();
								if(!s.equals("")){
									System.out.println(s);
									
									map.put(s, 1);
								}
								
							}
							
						}
						
					}
						
						
					
					
			}
			
			for(Entry<String, Integer> et :map.entrySet()){
				stmt2.setString(1, et.getKey());
				stmt2.setInt(2, 8);
				stmt2.setInt(3, 10);
				stmt2.executeUpdate();
				System.out.println(et.getKey());
			}
			
		}
	
//	@Test
//	public void initAllToGuifan() throws Exception{
//		Statement stmt3=conn2.createStatement();
//		ResultSet rs = stmt3.executeQuery("select id,zhengzhuang_name from zzall;");
//		stmt2 = conn2.prepareStatement("insert into zzall_zzguifan (zzall_id,zzguifan_id) values (?,?)");
//		
//		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
//		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
//		List<String> zs = new ArrayList<String>();
//		while(rs.next()){
//			   map1.put(rs.getString(2), rs.getInt(1));
//			    zs.add(rs.getString(2));
//		}
//		rs = stmt3.executeQuery("select id,zhengzhuang_name from zzguifan;");
//		while(rs.next()){
//			   map2.put(rs.getString(2), rs.getInt(1));
//		}
//		
//		
//		for(String s : zs){
//			
//			if(map2.containsKey(s)){
//				stmt2.setInt(1, map1.get(s));
//				stmt2.setInt(2, map2.get(s));
//				stmt2.executeUpdate();
//			}
//		}
//	}
	
//	class zznode{
//		String zz;
//		String code;
//		zznode parent;
//		int level;
//		List<zznode> childs;
//	}
	
	//导入四诊标准症状数据到全集表中
//		@Test
//	public void initSizhen() throws Exception{
//			ResultSet rs = stmt1.executeQuery("select zz,code from zhengz;");
//			List<zznode> nodes = new ArrayList<zznode>();
//			while(rs.next()){
//			    System.out.println("---------------------------");
//			    System.out.print(rs.getString(1)+"\t");
//			    System.out.print(rs.getString(2)+"\t");
//			    System.out.println();
//			    zznode node = new zznode();
//			    node.zz = rs.getString(1);
//			    node.code = rs.getString(2);
//			    nodes.add(node);
//			}
//			for(zznode node:nodes){
//				String temp = node.code.substring(0, node.code.length()-2);
//				for(zznode node2:nodes){
//					if(node2.code.equals(temp)){
//						node.parent = node2;
//						break;
//					}
//				}
//			}
//			zznode head = null;
//			for(zznode node:nodes){
//				if(node.parent==null)
//					head = node;
//				node.childs = new ArrayList<TestDB.zznode>();
//				for(zznode node2:nodes){
//					if(node2.parent!=null&&node2.parent==node)
//						node.childs.add(node2);
//						
//				}
//				
//			}
//			zznode now = head;
//			//print(now,1);
//			
//			Statement stmt3=conn2.createStatement();
//			stmt2 = conn2.prepareStatement("insert into zzguifan_attr (zzguifan_id,attr_id) values (?,?)");
//			rs = stmt3.executeQuery("select id,code from attrall;");
//			HashMap<String, Integer> map1 = new HashMap<String, Integer>();
//			HashMap<Integer, String> map2 = new HashMap<Integer, String>();
//			
//			List<String> zzs = new ArrayList<String>();//code
//			
//			while(rs.next()){
//			    map1.put(rs.getString(2), rs.getInt(1));
//			    map2.put(rs.getInt(1),rs.getString(2));
//			    zzs.add(rs.getString(2));
//			}
//			
//			
//			
//			
//			rs = stmt3.executeQuery("select id,zhengzhuang_name from zzguifan;");
//			
//			
//			HashMap<String, Integer> map3 = new HashMap<String, Integer>();
//			HashMap<Integer, String> map4 = new HashMap<Integer, String>();
//			
//			
//			List<String> zzzs = new ArrayList<String>();//症状
//			
//			
//			
//			while(rs.next()){
//			    map3.put(rs.getString(2), rs.getInt(1));
//			    map4.put(rs.getInt(1),rs.getString(2));
//			    zzzs.add(rs.getString(2));
//			}
//			
//			for(String s : zzzs){
//				String codeparents = null;
//				for(zznode node:nodes){
//					if(node.zz.equals(s)){
//						if(node.parent!=null){
//							codeparents = node.parent.code;
//						}
//						break;
//					}
//				}
//				if(codeparents!=null){
//					stmt2.setInt(1, map3.get(s));
//					stmt2.setInt(2, map1.get(codeparents));
//					stmt2.executeUpdate();
//				}
//			}
//			
//			
//	}
//		
//		private void print(zznode now,int level) throws Exception {
//			if(now.childs.size()!=0){
//				System.out.println(now.zz+"----"+now.code);
//				stmt2 = conn2.prepareStatement("insert into attrall (attr_name,attr_dependency,code,level) values (?,?,?,?)");
//				stmt2.setString(1, now.zz);
//				stmt2.setString(2, "四诊");
//				stmt2.setString(3, now.code);
//				stmt2.setInt(4, level);
//				stmt2.executeUpdate();
//			}
//		
//			if(now.childs.size()!=0){
//				for(zznode temp:now.childs){
//					print(temp,level+1);
//				}
//			}
//		}
//		
		
		
		
		
		@Test
		public void testFunction(){
			System.out.println();
		}
}

package cn.link.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.link.tcm.mapper.AttrallMapper;
import cn.link.tcm.mapper.FormulaTemplateMapper;
import cn.link.tcm.mapper.SourceMapper;
import cn.link.tcm.mapper.ZhallMapper;
import cn.link.tcm.mapper.ZzallMapper;
import cn.link.tcm.mapper.ZzallZzguifanVoMapper;
import cn.link.tcm.mapper.ZzguifanAttrVoMapper;
import cn.link.tcm.mapper.ZzguifanMapper;
import cn.link.tcm.po.Attrall;
import cn.link.tcm.po.FormulaTemplate;
import cn.link.tcm.po.FormulaVo;
import cn.link.tcm.po.Zhall;
import cn.link.tcm.po.Zzall;
import cn.link.tcm.po.ZzallZzguifanVo;
import cn.link.tcm.po.Zzguifan;
import cn.link.tcm.po.ZzguifanAttrVo;

public class TestMyBatis {
	
	private ApplicationContext applicationContext;
	@Before
	public void setupInit(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
	}
	
	/**
	 * 导入方剂学方剂数据
	 */
	@Test
	public void insertFangjixue(){
		FormulaTemplateMapper formulaTemplateMapper = (FormulaTemplateMapper) applicationContext.getBean("formulaTemplateMapper");
		ZzallMapper zzallMapper = (ZzallMapper) applicationContext.getBean("zzallMapper");
		ZhallMapper zhallMapper = (ZhallMapper) applicationContext.getBean("zhallMapper");
		List<Zzall> listzz = zzallMapper.findAllZzall();
		List<Zhall> listzh = zhallMapper.findAllZhall();
		HashMap<FormulaTemplate, List<Integer>> zzmap = new HashMap<FormulaTemplate, List<Integer>>();
		HashMap<FormulaTemplate, List<Integer>> zhmap = new HashMap<FormulaTemplate, List<Integer>>();
		
		List<FormulaTemplate> listFt = formulaTemplateMapper.getFormulaTemplateFromFangjixue();
		for(FormulaTemplate ft:listFt){
			FormulaVo formulaVo = new FormulaVo();
			formulaVo.setFormula_detail(ft.getZzStr());
			formulaVo.setSource_detail(ft.getSourceStr());
			formulaVo.setSource_id(10);
			formulaVo.setZhifadetail(ft.getZhifaStr());
			formulaTemplateMapper.insertFormulaVoInFormula(formulaVo);
			
			
			zzmap.put(ft, new ArrayList<Integer>());
			zhmap.put(ft, new ArrayList<Integer>());
			for(Zzall zzall:listzz){
				if(ft.getZzStr().contains(zzall.getZhengzhuang_name()))
				{
					zzmap.get(ft).add(zzall.getId());
					formulaVo.setZzall_id(zzall.getId());
					formulaTemplateMapper.insertFormulaVoInFormulazz(formulaVo);
				}
			}
			for(Zhall zhall:listzh){
				if(ft.getZhStr().contains(zhall.getZhenghou_name()))
				{
					
					zhmap.get(ft).add(zhall.getId());
					formulaVo.setZhall_id(zhall.getId());
					formulaTemplateMapper.insertFormulaVoInFormulazh(formulaVo);
				}
			}
		}
		System.out.println(listFt);
	}
	
	
	
	
	
	
	
	
	@Test
	public void showNeikexue() throws Exception{
		File file = new File("D:/ruleResult.txt");
		if(!file.exists()){
			try {
			file.createNewFile();
			} catch (IOException e) {
			e.printStackTrace();
			}
		}
		FileWriter fw = new FileWriter(file);
		FormulaTemplateMapper formulaTemplateMapper = (FormulaTemplateMapper) applicationContext.getBean("formulaTemplateMapper");
		ZzallMapper zzallMapper = (ZzallMapper) applicationContext.getBean("zzallMapper");
		ZhallMapper zhallMapper = (ZhallMapper) applicationContext.getBean("zhallMapper");
		SourceMapper sourceMapper = (SourceMapper) applicationContext.getBean("sourceMapper");
		List<FormulaVo> listFv = formulaTemplateMapper.findAllFormulaVo();
		System.out.println(listFv);
		
		for(FormulaVo formulaVo:listFv){
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			fw.write("第"+formulaVo.getId()+"条规则：\r\n");
			fw.write("*************规则开始***************\r\n");
			List<Integer> zzList = formulaTemplateMapper.findZzidByFormulaId(formulaVo.getId());
			String zzs = "";
			for(Integer i:zzList){
				String zz = zzallMapper.findZzallById(i).getZhengzhuang_name();
				if(!map.containsKey(zz)){
					map.put(zz, 1);
					zzs+=zz+"，";
				}
				
				
			}
			fw.write("前件："+zzs+"\r\n");
			List<Integer> zhList = formulaTemplateMapper.findZhidByFormulaId(formulaVo.getId());
			String zhs = "";
			for(Integer i:zhList){
				String zh = zhallMapper.findZhallById(i).getZhenghou_name();
				if(!map.containsKey(zh)){
					map.put(zh, 1);
					zhs+=zh+"，";
				}
				
				
			}
			fw.write("后件："+zhs+"\r\n");
			fw.write("*************规则结束***************"+"\r\n");
			fw.write("*************源开始***************"+"\r\n");
			fw.write("原始方剂："+formulaVo.getFormula_detail()+"\r\n");
			fw.write("原始治法："+formulaVo.getZhifadetail()+"\r\n");
			fw.write("来源书籍:《"+sourceMapper.findSourceById(formulaVo.getSource_id()).getSource_name()+"》"+"\r\n");
			fw.write("详细来源:"+formulaVo.getSource_detail()+"\r\n");
			
			
			fw.write("*************源结束***************"+"\r\n");
			
			
		}
		  fw.close();  
		
	}
	
	/**
	 * 导入CNKI方剂数据
	 */
	@Test
	public void initCnkiFangji(){
		FormulaTemplateMapper formulaTemplateMapper = (FormulaTemplateMapper) applicationContext.getBean("formulaTemplateMapper");
		ZzallMapper zzallMapper = (ZzallMapper) applicationContext.getBean("zzallMapper");
		ZhallMapper zhallMapper = (ZhallMapper) applicationContext.getBean("zhallMapper");
		List<Zzall> listzz = zzallMapper.findAllZzall();
		List<Zhall> listzh = zhallMapper.findAllZhall();
		HashMap<FormulaTemplate, List<Integer>> zzmap = new HashMap<FormulaTemplate, List<Integer>>();
		HashMap<FormulaTemplate, List<Integer>> zhmap = new HashMap<FormulaTemplate, List<Integer>>();
		
		List<FormulaTemplate> listFt = formulaTemplateMapper.getFormulaTemplate();
	}
	
	
	/**
	 * 导入内科学方剂数据
	 */
	@Test
	public void insertNeikexue(){
		FormulaTemplateMapper formulaTemplateMapper = (FormulaTemplateMapper) applicationContext.getBean("formulaTemplateMapper");
		ZzallMapper zzallMapper = (ZzallMapper) applicationContext.getBean("zzallMapper");
		ZhallMapper zhallMapper = (ZhallMapper) applicationContext.getBean("zhallMapper");
		List<Zzall> listzz = zzallMapper.findAllZzall();
		List<Zhall> listzh = zhallMapper.findAllZhall();
		HashMap<FormulaTemplate, List<Integer>> zzmap = new HashMap<FormulaTemplate, List<Integer>>();
		HashMap<FormulaTemplate, List<Integer>> zhmap = new HashMap<FormulaTemplate, List<Integer>>();
		
		List<FormulaTemplate> listFt = formulaTemplateMapper.getFormulaTemplate();
		for(FormulaTemplate ft:listFt){
			FormulaVo formulaVo = new FormulaVo();
			formulaVo.setFormula_detail("症状："+ft.getZzStr()+"；证候："+ft.getZhStr());
			formulaVo.setSource_detail(ft.getSourceStr());
			formulaVo.setSource_id(5);
			formulaVo.setZhifadetail(ft.getZhifaStr());
			formulaTemplateMapper.insertFormulaVoInFormula(formulaVo);
			
			
			zzmap.put(ft, new ArrayList<Integer>());
			zhmap.put(ft, new ArrayList<Integer>());
			for(Zzall zzall:listzz){
				if(ft.getZzStr().contains(zzall.getZhengzhuang_name()))
				{
					zzmap.get(ft).add(zzall.getId());
					formulaVo.setZzall_id(zzall.getId());
					formulaTemplateMapper.insertFormulaVoInFormulazz(formulaVo);
				}
			}
			for(Zhall zhall:listzh){
				if(ft.getZhStr().contains(zhall.getZhenghou_name()))
				{
					
					zhmap.get(ft).add(zhall.getId());
					formulaVo.setZhall_id(zhall.getId());
					formulaTemplateMapper.insertFormulaVoInFormulazh(formulaVo);
				}
			}
		}
		System.out.println(listFt);
	}
	
	
	@Test
	public void testService() throws Exception{
		ZzallMapper zzallMapper = (ZzallMapper) applicationContext.getBean("zzallMapper");
		Zzall zz = zzallMapper.findZzallById(302);
		System.out.println(zz);
		
	}
	
	@Test
	public void testZzall() throws Exception{
		ZzallMapper zzallMapper = (ZzallMapper) applicationContext.getBean("zzallMapper");
		Zzall zz = zzallMapper.findZzallById(302);
		System.out.println(zz);
		
	}
	
	@Test
	public void testZzGUifan() throws Exception{
		ZzguifanMapper zzallMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		Zzguifan zz = zzallMapper.findZzguifanById(5);
		System.out.println(zz);
		
	}
	
	@Test
	public void testZzGUifan2() throws Exception{
		ZzguifanMapper zzallMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		List<Zzguifan> zzs = zzallMapper.findAllZzguifan();
		System.out.println(zzs.size());
		
	}
	
	@Test
	public void testZzGUifan3() throws Exception{
		ZzguifanMapper zzallMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		Zzguifan zz = new Zzguifan();
		zz.setZhengzhuang_name("测试规范3");
		
		zzallMapper.addZzguifan(zz);
		
		System.out.println(zz.getId());
//		
//		zz.setZhengzhuang_name("测试2");
//		zzallMapper.updateZzguifanZhengzhuangName(zz);
//		
//		zz = zzallMapper.findZzguifanById(zz.getId());
//		
//		System.out.println(zz);
//		
//		zzallMapper.deleteZzguifanById(zz.getId());
//		
//		zz = zzallMapper.findZzguifanById(zz.getId());
//		
//		System.out.println(zz);
	}
	
	@Test
	public void testAttr(){
		AttrallMapper attrallMapper = (AttrallMapper) applicationContext.getBean("attrallMapper");
		Attrall attrall = attrallMapper.findAttrallById(385);
		System.out.println(attrall);
		
		List<Attrall> list = attrallMapper.findAttrsByParentId(attrall.getId());
		for(Attrall attr:list){
			System.out.println(attr);
		}
		
		Attrall newattr = new Attrall();
		newattr.setAttr_dependency("人工");
		newattr.setAttr_name("测试珍2");
		newattr.setCode("0107");
		newattr.setLevel(attrall.getLevel()+1);
		newattr.setParent_id(attrall.getId());
		
		attrallMapper.addAttrall(newattr);
		System.out.println(newattr);
		
//		list = attrallMapper.findAttrsByParentId(attrall.getId());
//		for(Attrall attr:list){
//			System.out.println(attr);
//		}
	}
	
	@Test
	public void testZzallZzguifanVo(){
		ZzallZzguifanVoMapper zzVoMapper = (ZzallZzguifanVoMapper) applicationContext.getBean("zzallZzguifanVoMapper");
		ZzallZzguifanVo zzVo = zzVoMapper.findZzallZzguifanVoById(11337);
//		System.out.println(zzVo);
//		
		ZzguifanMapper zzallMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		Zzguifan zz = zzallMapper.findZzguifanById(307);
//		zzVo.getList().add(zz);
//		
//		zz = zzallMapper.findZzguifanById(306);
//		zzVo.getList().add(zz);
//		
//		zzVoMapper.addZzallZzguifanVo(zzVo);
//		
//		zzVo = zzVoMapper.findZzallZzguifanVoById(11337);
		
		System.out.println(zzVo);
		
		List<Zzguifan> list = zzVo.getList();
		Zzguifan dzz = null;
		for(Zzguifan zzzz:list){
			if(zzzz.getZhengzhuang_name().equals("测试规范2"))
				dzz = zzzz;
		}
		list.remove(dzz);
		list.add(zz);
		
		zzVoMapper.deleteZzallZzguifanVo(zzVo);
		zzVoMapper.addZzallZzguifanVo(zzVo);
		
		zzVo = zzVoMapper.findZzallZzguifanVoById(11337);
		
		System.out.println(zzVo);
		
	}
	
	@Test
	public void testZzguifanAttrVo(){
		ZzguifanAttrVoMapper zzMapper = (ZzguifanAttrVoMapper) applicationContext.getBean("zzguifanAttrVoMapper");
		ZzguifanMapper zzguifanMapper = (ZzguifanMapper) applicationContext.getBean("zzguifanMapper");
		AttrallMapper attrallMapper = (AttrallMapper) applicationContext.getBean("attrallMapper");
		
		ZzguifanAttrVo zz = zzMapper.findZzguifanAttrVoById(305);
		
		Attrall a1 = attrallMapper.findAttrallById(459);
		Attrall a2 = attrallMapper.findAttrallById(460);
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(zz);
		
		zz.getList().add(a1);
		zzMapper.addZzguifanAttrVo(zz);
		
		zz = zzMapper.findZzguifanAttrVoById(305);
		System.out.println(zz);
		
		zz.getList().remove(0);
		
		zzMapper.deleteZzguifanAttrVo(zz);
		zz = zzMapper.findZzguifanAttrVoById(305);
		System.out.println(zz);
		
	}
	
	@Test
	public void testTest() throws Exception{
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory factory = new  SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = factory.openSession();
		
		Zzall zz = sqlSession.selectOne("test.findZzallById",310);
		
		System.out.println(zz);
		
		
	}
}

package cn.link.tcm.mapper;

import java.util.List;

import cn.link.tcm.po.FormulaTemplate;
import cn.link.tcm.po.FormulaVo;

public interface FormulaTemplateMapper {

	public List<FormulaTemplate> getFormulaTemplate();
	
	public List<FormulaTemplate> getFormulaTemplateFromFangjixue();
	
	public void insertFormulaVoInFormula(FormulaVo formulaVo);
	
	public void insertFormulaVoInFormulazh(FormulaVo formulaVo);
	
	public void insertFormulaVoInFormulazz(FormulaVo formulaVo);
	
	public List<FormulaVo> findAllFormulaVo();
	
	public List<Integer> findZzidByFormulaId(int formulaId);
	
	public List<Integer> findZhidByFormulaId(int formulaId);
}

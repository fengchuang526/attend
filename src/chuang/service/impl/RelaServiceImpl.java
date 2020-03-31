package chuang.service.impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chuang.dao.IRelaDao;
import chuang.entity.Rela;
import chuang.service.IRelaService;
import chuang.util.AppUtil;
import chuang.util.ResponsePage;

/*
 *	相关方
 */
@Service
public class RelaServiceImpl implements IRelaService {

	@Autowired
	private IRelaDao iRelaDao;
	
	@Override
	public Map<String, Object> findAllRela(Long page, Integer size) {
		List<Rela> list = iRelaDao.findAllRela();
		ResponsePage<Rela> response = new ResponsePage<Rela>();
		response.setAllData(list);
		response.setNumber(page);
		response.setSize(size);
		return AppUtil.getMap(response);
	}

	@Override
	public Map<String, Object> saveRela(String data) throws Exception {
		if(StringUtils.isBlank(data)){
			return AppUtil.getMap(false, "无法保存：传入的信息为空！");
		}
		JSONObject json = JSONObject.fromObject(data);
		Rela rela = (Rela)JSONObject.toBean(json, Rela.class);
		String id = json.getString("id");
		if(StringUtils.isBlank(id)){//新增
			iRelaDao.saveRela(rela);
		}else{//编辑
			iRelaDao.updateRela(rela);
		}
		return AppUtil.getMap(true,"保存成功！");
	}

}

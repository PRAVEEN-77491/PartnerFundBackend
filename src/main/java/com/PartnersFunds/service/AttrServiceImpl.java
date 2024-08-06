package com.PartnersFunds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PartnersFunds.Entities.pageAttrPropertiesEntity;
import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pagesEntity;
import com.PartnersFunds.Repo.pageAttrPropertiesRepo;
import com.PartnersFunds.Repo.pageAttributesRepo;
import com.PartnersFunds.Repo.pagesRepo;


@Service
public class AttrServiceImpl implements AttrService{

	@Autowired
	pagesRepo Pagerepo;
	@Autowired
	pageAttributesRepo Attrrepo;
	@Autowired
	pageAttrPropertiesRepo AttrPropertiesrepo;
	
	public List<pagesEntity> getPages(){
		try {
			return Pagerepo.findAll();
		}catch(Exception e) {
			System.out.println("Exception Error "+e);
		}
		return null;
		
	}
	
	public List<pageAttributesEntity> getPageAttributes(){
		try {
			return Attrrepo.findAll();
		}catch(Exception e) {
			System.out.println("Exception Error "+e);
		}
		return null;
		
	}
	
	public List<pageAttrPropertiesEntity> getPageProperties(){
		try {
			return AttrPropertiesrepo.findAll();
		}catch(Exception e) {
			System.out.println("Exception Error "+e);
		}
		return null;
		
	}

	@Override
	public pagesEntity getPageById(int page_id) {
		try {
			return Pagerepo.findByPage_id(page_id);
			
		}catch(Exception e) {
			return null;
		}
		
	}

}

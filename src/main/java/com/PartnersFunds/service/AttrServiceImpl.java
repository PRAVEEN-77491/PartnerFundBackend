package com.PartnersFunds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PartnersFunds.Entities.PageAttrPropertiesEntity;
import com.PartnersFunds.Entities.PageAttributesEntity;
import com.PartnersFunds.Entities.PagesEntity;
import com.PartnersFunds.Repo.PageAttrPropertiesRepo;
import com.PartnersFunds.Repo.PageAttributesRepo;
import com.PartnersFunds.Repo.PagesRepo;


@Service
public class AttrServiceImpl implements AttrService{

	@Autowired
	PagesRepo Pagerepo;
	@Autowired
	PageAttributesRepo Attrrepo;
	@Autowired
	PageAttrPropertiesRepo AttrPropertiesrepo;
	
	public List<PagesEntity> getPages(){
		try {
			return Pagerepo.findAll();
		}catch(Exception e) {
			System.out.println("Exception Error "+e);
		}
		return null;
		
	}
	
	public List<PageAttributesEntity> getPageAttributes(){
		try {
			return Attrrepo.findAll();
		}catch(Exception e) {
			System.out.println("Exception Error "+e);
		}
		return null;
		
	}
	
	public List<PageAttrPropertiesEntity> getPageProperties(){
		try {
			return AttrPropertiesrepo.findAll();
		}catch(Exception e) {
			System.out.println("Exception Error "+e);
		}
		return null;
		
	}

	@Override
	public PagesEntity getPageById(int page_id) {
		try {
			return Pagerepo.findByPage_id(page_id);
			
		}catch(Exception e) {
			return null;
		}
		
	}

}

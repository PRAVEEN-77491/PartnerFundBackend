package com.PartnersFunds.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.PartnersFunds.Entities.pageAttrPropertiesEntity;
import com.PartnersFunds.Entities.pageAttributesEntity;
import com.PartnersFunds.Entities.pagesEntity;;

@Service
public interface AttrService {

	public List<pagesEntity> getPages();
	public List<pageAttributesEntity> getPageAttributes();
	public List<pageAttrPropertiesEntity> getPageProperties();
	
	public pagesEntity getPageById(int page_id);
}

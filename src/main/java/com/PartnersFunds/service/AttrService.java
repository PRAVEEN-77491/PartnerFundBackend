package com.PartnersFunds.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.PartnersFunds.Entities.PageAttrPropertiesEntity;
import com.PartnersFunds.Entities.PageAttributesEntity;
import com.PartnersFunds.Entities.PagesEntity;;

@Service
public interface AttrService {

	public List<PagesEntity> getPages();
	public List<PageAttributesEntity> getPageAttributes();
	public List<PageAttrPropertiesEntity> getPageProperties();
	
	public PagesEntity getPageById(int page_id);
}

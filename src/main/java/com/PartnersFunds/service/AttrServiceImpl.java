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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PagesRepo Pagerepo;

    @Autowired
    PageAttributesRepo Attrrepo;

    @Autowired
    PageAttrPropertiesRepo AttrPropertiesrepo;

    private static final Logger logger = LoggerFactory.getLogger(AttrServiceImpl.class);

    public List<PagesEntity> getPages() {
        try {
            logger.info("Fetching all pages");
            return Pagerepo.findAll();
        } catch (Exception e) {
            logger.error("Error fetching pages: {}", e.getMessage(), e);
        }
        return null;
    }

    public List<PageAttributesEntity> getPageAttributes() {
        try {
            logger.info("Fetching all page attributes");
            return Attrrepo.findAll();
        } catch (Exception e) {
            logger.error("Error fetching page attributes: {}", e.getMessage(), e);
        }
        return null;
    }

    public List<PageAttrPropertiesEntity> getPageProperties() {
        try {
            logger.info("Fetching all page properties");
            return AttrPropertiesrepo.findAll();
        } catch (Exception e) {
            logger.error("Error fetching page properties: {}", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PagesEntity getPageById(int page_id) {
        try {
            logger.info("Fetching page by ID: {}", page_id);
            return Pagerepo.findByPage_id(page_id);
        } catch (Exception e) {
            logger.error("Error fetching page by ID: {}", e.getMessage(), e);
            return null;
        }
    }
}

package com.PartnersFunds.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.PartnersFunds.service.PageService;
import com.PartnersFunds.service.pagesDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pageDetails")
public class PageController {
    @Autowired
    private PageService pageService;

//    @PostMapping
//    public pagesEntity createPage(@RequestBody CustomPageDTO pageDto) {
//    	System.out.println(pageDto.getId());
//        return pageService.savePage(pageDto);
//    }
    
    @PostMapping("/save")
    public String savePageData(@RequestBody List<pagesDTO> pageDataList) {
        pageService.savePageData(pageDataList);
        return "Page data saved successfully!";
    }
}

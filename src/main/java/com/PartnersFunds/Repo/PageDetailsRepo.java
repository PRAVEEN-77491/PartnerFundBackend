package com.PartnersFunds.Repo;

import com.PartnersFunds.Entities.pagesEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PageDetailsRepo extends JpaRepository<pagesEntity, Integer> {
   @Query(
      value = "SELECT xp.page_id,xp.page_name,\r\n         xp.page_file_name,\r\n         xp.Page_title,\r\n         xpa.attribute_name,\r\n         xpa.attribute_type,\r\n         JSON_OBJECTAGG (property_tag, property_value) AS json_data\r\n    FROM xxpf_pages              xp,\r\n         xxpf_page_attributes    xpa,\r\n         xxpf_page_attr_properties prop\r\n   WHERE xp.page_id = xpa.page_id AND xpa.attribute_id = prop.attribute_id\r\nGROUP BY xp.page_name,\r\n         xp.page_file_name,\r\n         xp.Page_title,\r\n         xpa.attribute_name,\r\n         xpa.attribute_type,\r\n         xpa.attribute_id,\r\n         xp.page_id\r\nORDER BY xpa.attribute_id",
      nativeQuery = true
   )
   List<Object[]> allDetails();
}

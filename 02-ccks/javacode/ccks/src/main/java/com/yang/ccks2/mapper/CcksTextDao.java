package com.yang.ccks2.mapper;

import com.github.pagehelper.PageInfo;
import com.yang.ccks2.model.CcksText;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CcksTextDao {
    @Select("SELECT * FROM ccks_text WHERE text_content LIKE '%胃癌%'")
    List<CcksText> findCcksTextListByContentBypage();
}

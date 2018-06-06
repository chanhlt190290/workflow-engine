package workflow.engine.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import workflow.engine.model.mybatis.Request;


@Mapper
public interface RequestMapper{

    public Request getRequest(@Param("id") int id);

}
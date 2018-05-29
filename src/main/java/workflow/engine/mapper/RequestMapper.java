/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import workflow.engine.model.Request;

/**
 *
 * @author trungchanh
 */
@Mapper
public interface RequestMapper {

    public Request getRequest(@Param("id") int id);

}

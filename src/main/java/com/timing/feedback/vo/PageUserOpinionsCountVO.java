package com.timing.feedback.vo;

import com.timing.feedback.entity.UserOpinionsCount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: cwh
 * @since 2021-05-30
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageUserOpinionsCountVO {
    /**
    * UserOpinionsCountVO集合
    **/
    private List<UserOpinionsCountVO> countList;


    /**
     * 当前第几页
     **/
    private Long current;

    /**
     * 当前页数目
     **/
    private Long size;


    /**
    * 总页数
    **/
    private Long page;


}

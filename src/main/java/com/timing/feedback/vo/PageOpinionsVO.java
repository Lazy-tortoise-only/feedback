package com.timing.feedback.vo;

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
 * @since 2021-05-31
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageOpinionsVO {
    /**
     * OpinionsVO集合
     **/
    private List<OpinionsVO> opinionsList;

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

package com.cqtalk.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cqtalk.util.levelName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@ApiModel("竞赛实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contest implements Serializable {

    @ApiModelProperty("竞赛id")
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @ApiModelProperty("竞赛名称")
    private String contestName;
    @ApiModelProperty("竞赛简称")
    private String abbreviation;

    @ApiModelProperty("竞赛级别")
    private com.cqtalk.util.levelName levelName;
    @ApiModelProperty("举办学院名")
    private String collegeName;
    @ApiModelProperty("其他信息")
    private String otherInformation;
    @ApiModelProperty("详细信息链接")
    private String detailInformation;
    @ApiModelProperty("评论链接")
    private String commentLink;

    @ApiModelProperty("管理员")
    private int administrators;
    @ApiModelProperty("竞赛状态0：未删除，1：已删除，2：审核中")
    private int status;
}


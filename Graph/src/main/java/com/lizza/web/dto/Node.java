package com.lizza.web.dto;

import com.lizza.web.service.AbstractFactor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 节点
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    /** 当前节点完成情况 **/
    private AtomicBoolean completed = new AtomicBoolean(false);

    private AbstractFactor factor;

    /** 模拟业务逻辑 & 耗时: 计算节点求和 **/
    @Deprecated
    private int value;
}

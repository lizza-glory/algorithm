package com.lizza.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 上下文
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Context {

    /** 模拟业务计算结果 **/
    private AtomicInteger result;
}

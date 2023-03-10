package com.lizza.web.dto;

import com.google.common.graph.ImmutableGraph;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    private String channel;

    private String stage;

    private ImmutableGraph<Node> graph;
}

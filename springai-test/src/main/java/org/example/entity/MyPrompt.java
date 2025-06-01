package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.modelcontextprotocol.spec.McpSchema;

import java.util.List;

public class MyPrompt {

     String name;
     String description;
    List<McpSchema.PromptArgument> arguments;




}

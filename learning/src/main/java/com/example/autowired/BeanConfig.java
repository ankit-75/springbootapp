package com.example.autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ShapeConfig.class})
public class BeanConfig {


}





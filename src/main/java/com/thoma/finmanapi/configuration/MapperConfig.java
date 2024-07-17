package com.thoma.finmanapi.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.thoma.finmanapi.mapper.BaseDetailMapper;
import org.mapstruct.factory.Mappers;

@Configuration
@org.mapstruct.MapperConfig
public class MapperConfig {

    @Bean
    public BaseDetailMapper baseDetailMapper() {
        return Mappers.getMapper(BaseDetailMapper.class);
    }
}

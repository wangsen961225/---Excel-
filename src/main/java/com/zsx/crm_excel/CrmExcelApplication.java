package com.zsx.crm_excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.zsx.crm_excel")
public class CrmExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmExcelApplication.class, args);
    }

}


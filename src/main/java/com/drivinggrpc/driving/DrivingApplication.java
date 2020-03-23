package com.drivinggrpc.driving;

import com.drivinggrpc.driving.tools.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class DrivingApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DrivingApplication.class, args);
        Map<String, Object> grpcServiceBeanMap =  context.getBeansWithAnnotation(GrpcService.class);
        RpcServer grpcServer = context.getBean("grpcServer", RpcServer.class);
        grpcServer.grpcStart(grpcServiceBeanMap);
    }

}

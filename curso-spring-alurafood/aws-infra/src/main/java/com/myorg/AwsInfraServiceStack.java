package com.myorg;

import software.amazon.awscdk.Fn;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ecs.Cluster;
import software.amazon.awscdk.services.ecs.ContainerImage;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateService;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedTaskImageOptions;
import software.constructs.Construct;

import java.util.HashMap;
import java.util.Map;

public class AwsInfraServiceStack extends Stack {

    public AwsInfraServiceStack(final Construct scope, final String id, final Cluster cluster) {
        this(scope, id, null, cluster);
    }

    public AwsInfraServiceStack(final Construct scope, final String id, final StackProps props, final Cluster cluster) {
        super(scope, id, props);

        Map<String, String> autenticacao = new HashMap<>();
        autenticacao.put("SPRING_DATASOURCE_URL", "jdbc:postgresql://" + Fn.importValue("pedidos-db-endpoint") + ":5432/alurafoodpedido");
        autenticacao.put("SPRING_DATASOURCE_USERNAME", "postgres");
        autenticacao.put("SPRING_DATASOURCE_PASSWORD", Fn.importValue("pedidos-db-senha"));

        ApplicationLoadBalancedFargateService.Builder.create(this, "pieropan-service")
                .cluster(cluster).cpu(256).desiredCount(1).listenerPort(8080).assignPublicIp(true)
                .taskImageOptions(ApplicationLoadBalancedTaskImageOptions.builder()
                        .image(ContainerImage.fromRegistry("jacquelineoliveira/ola:1.0"))
                        .containerPort(8080)
                        .containerName("app_ola")
                        .environment(autenticacao)
                        .build())
                .memoryLimitMiB(1024).publicLoadBalancer(true).build();
    }
}
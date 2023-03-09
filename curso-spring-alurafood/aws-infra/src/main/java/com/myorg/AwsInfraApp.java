package com.myorg;

import software.amazon.awscdk.App;

public class AwsInfraApp {

    public static void main(final String[] args) {
        App app = new App();

        AwsInfraVpcStack vpc = new AwsInfraVpcStack(app, "vpc");
        AwsInfraClusterStack cluster = new AwsInfraClusterStack(app, "Cluster", vpc.getVpc());
        cluster.addDependency(vpc);

        AwsInfraRdsStack rds = new AwsInfraRdsStack(app, "rds", vpc.getVpc());
        rds.addDependency(vpc);

        AwsInfraServiceStack service = new AwsInfraServiceStack(app, "Service", cluster.getCluster());
        service.addDependency(cluster);
        service.addDependency(rds);
        app.synth();
    }
}
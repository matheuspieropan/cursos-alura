package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;

public class AwsInfraVpcStack extends Stack {
    Vpc vpc;

    public AwsInfraVpcStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public AwsInfraVpcStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);
        vpc = Vpc.Builder.create(this, "matheus-vpc").maxAzs(3).build();
    }

    public Vpc getVpc() {
        return vpc;
    }
}
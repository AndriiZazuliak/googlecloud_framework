package org.as.ta.services;

import org.as.ta.model.Estimation;

public class EstimationCreator {
    public static final String NUMBER_OF_INSTANCES = "number_of_instances";
    public static final String OPERATING_SYSTEM_SOFTWARE = "operating_system_software";
    public static final String PROVISIONING_MODEL = "provisioning_model";
    public static final String MACHINE_FAMILY = "machine_family";
    public static final String SERIES = "series";
    public static final String MACHINE_TYPE = "machine_type";
    public static final String GPU_TYPE = "gpu_type";
    public static final String AMOUNT_OF_GPUS = "amount_of_gpus";
    public static final String LOCAL_SSD = "local_ssd";
    public static final String DATACENTER_LOCATION = "datacenter_location";
    public static final String COMMITTED_USAGE = "committed_usage";

    public static Estimation withData(){
        return new Estimation(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(OPERATING_SYSTEM_SOFTWARE),
                TestDataReader.getTestData(PROVISIONING_MODEL),
                TestDataReader.getTestData(MACHINE_FAMILY),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(AMOUNT_OF_GPUS),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE));
    }

}

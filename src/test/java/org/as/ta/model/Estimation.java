package org.as.ta.model;

import java.util.Objects;

public class Estimation {
    private final String number_of_instances;
    private final String operating_system_software;
    private final String provisioning_model;
    private final String machine_family;
    private final String series;
    private final String machine_type;
    private final String gpu_type;
    private final String amount_of_gpus;
    private final String local_ssd;
    private final String datacenter_location;
    private final String committed_usage;

    public Estimation(String number_of_instances, String operating_system_software,
                      String provisioning_model, String machine_family, String series,
                      String machine_type, String gpu_type, String amount_of_gpus,
                      String local_ssd, String datacenter_location, String committed_usage) {
        this.number_of_instances = number_of_instances;
        this.operating_system_software = operating_system_software;
        this.provisioning_model = provisioning_model;
        this.machine_family = machine_family;
        this.series = series;
        this.machine_type = machine_type;
        this.gpu_type = gpu_type;
        this.amount_of_gpus = amount_of_gpus;
        this.local_ssd = local_ssd;
        this.datacenter_location = datacenter_location;
        this.committed_usage = committed_usage;
    }

    public String getNumberOfInstances() {
        return number_of_instances;
    }
    public String getOperatingSystemSoftware() {
        return operating_system_software;
    }
    public String getProvisioningModel() {
        return provisioning_model;
    }
    public String getMachineFamily() {
        return machine_family;
    }
    public String getSeries() {
        return series;
    }
    public String getMachineType() {
        return machine_type;
    }
    public String getGpuType() {
        return gpu_type;
    }
    public String getAmountOfGPUs() {
        return amount_of_gpus;
    }
    public String getLocalSSD() {
        return local_ssd;
    }
    public String getDatacenterLocation() {
        return datacenter_location;
    }
    public String getCommittedUsage() {
        return committed_usage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstances(), getOperatingSystemSoftware(),
                getProvisioningModel(), getMachineFamily(), getSeries(), getMachineType(),
                getGpuType(), getAmountOfGPUs(), getLocalSSD(), getDatacenterLocation(), getCommittedUsage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estimation)) return false;
        Estimation estimation = (Estimation) o;
        return  Objects.equals(getNumberOfInstances(), estimation.getNumberOfInstances()) &&
                Objects.equals(getOperatingSystemSoftware(), estimation.getOperatingSystemSoftware()) &&
                Objects.equals(getProvisioningModel(), estimation.getProvisioningModel()) &&
                Objects.equals(getMachineFamily(), estimation.getMachineFamily()) &&
                Objects.equals(getSeries(), estimation.getSeries()) &&
                Objects.equals(getMachineType(), estimation.getMachineType()) &&
                Objects.equals(getGpuType(), estimation.getGpuType()) &&
                Objects.equals(getAmountOfGPUs(), estimation.getAmountOfGPUs()) &&
                Objects.equals(getLocalSSD(), estimation.getLocalSSD()) &&
                Objects.equals(getDatacenterLocation(), estimation.getDatacenterLocation()) &&
                Objects.equals(getCommittedUsage(), estimation.getCommittedUsage());
    }
}

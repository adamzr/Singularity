package com.hubspot.singularity.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class SingularityScaleRequest extends SingularityExpiringRequestParent {

  private final Optional<Integer> instances;
  private final Optional<Boolean> skipHealthchecks;
  private final Optional<Boolean> bounce;
  private final Optional<Boolean> incremental;

  @JsonCreator
  public SingularityScaleRequest(@JsonProperty("instances") Optional<Integer> instances, @JsonProperty("durationMillis") Optional<Long> durationMillis,
      @JsonProperty("skipHealthchecks") Optional<Boolean> skipHealthchecks, @JsonProperty("actionId") Optional<String> actionId, @JsonProperty("message") Optional<String> message,
      @JsonProperty("bounce") Optional<Boolean> bounce, @JsonProperty("incremental") Optional<Boolean> incremental) {
    super(durationMillis, actionId, message);
    this.instances = instances;
    this.skipHealthchecks = skipHealthchecks;
    this.bounce = bounce;
    this.incremental = incremental;
  }

  @ApiModelProperty(required=false, value="If set to true, healthchecks will be skipped while scaling this request (only)")
  public Optional<Boolean> getSkipHealthchecks() {
    return skipHealthchecks;
  }

  @ApiModelProperty(required=false, value="The number of instances to scale to")
  public Optional<Integer> getInstances() {
    return instances;
  }

  @ApiModelProperty(required=false, value="Bounce the request to get to the new scale")
  public Optional<Boolean> getBounce() {
    return bounce;
  }

  @ApiModelProperty(required=false, value="If present and set to true, old tasks will be killed as soon as replacement tasks are available, instead of waiting for all replacement tasks to be healthy")
  public Optional<Boolean> getIncremental() {
    return incremental;
  }

  @Override
  public String toString() {
    return "SingularityScaleRequest{" +
        "instances=" + instances +
        ", skipHealthchecks=" + skipHealthchecks +
        ", bounce=" + bounce +
        ", incremental=" + incremental +
        "} " + super.toString();
  }
}

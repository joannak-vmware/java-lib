package com.wavefront.api.agent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wavefront.api.json.InstantMarshaller;

import org.joda.time.Instant;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

/**
 * A POJO representing the shell output from running commands in a work unit. The {@link Default}
 * validation group is intended for submission from the daemon to the server.
 *
 * @author Clement Pang (clement@wavefront.com).
 */
public class ShellOutputDTO implements Serializable {
  @NotNull
  public UUID id;
  @NotNull
  public UUID targetId;
  /**
   * Computed by the server.
   */
  @Null(groups = Default.class)
  public UUID machineId;
  @NotNull
  public UUID workUnitId;
  @NotNull
  public UUID sshDaemonId;
  @NotNull
  public String output;
  @NotNull
  public Integer exitCode;
  @NotNull
  @JsonSerialize(using = InstantMarshaller.Serializer.class)
  @JsonDeserialize(using = InstantMarshaller.Deserializer.class)
  public Instant commandStartTime;
  @NotNull
  @JsonSerialize(using = InstantMarshaller.Serializer.class)
  @JsonDeserialize(using = InstantMarshaller.Deserializer.class)
  public Instant commandEndTime;
  /**
   * Filled-in by the server.
   */
  @Null(groups = Default.class)
  @JsonSerialize(using = InstantMarshaller.Serializer.class)
  @JsonDeserialize(using = InstantMarshaller.Deserializer.class)
  public Instant serverTime;
  /**
   * Filled-in by the server.
   */
  @Null(groups = Default.class)
  public String customerId;
}

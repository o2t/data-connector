package com.one2team.dataconnector;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldMappingConfig {

  public static class Builder extends MetadataBuilder<Builder> {

    public FieldMappingConfig build () {
      return new FieldMappingConfig (this);
    }
  }

  @JsonProperty ("metadata")
  private Map<String, String> metadata;

  public FieldMappingConfig (Builder builder) {
    this.metadata = builder.getMetadata ();
  }

  public static MappingConfig.Builder builder () {
    return new MappingConfig.Builder ();
  }

  public String getMetadata (String name) {
    return metadata.get (name);
  }
}

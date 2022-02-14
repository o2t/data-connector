package com.one2team.dataconnector;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import static java.util.Objects.requireNonNull;

public class DocumentClassMappingConfig {

  public static class Builder extends MetadataBuilder<Builder> {

    private final Map<String, FieldMappingConfig> fields = new HashMap<> ();

    public Builder addField (String name, Consumer<FieldMappingConfig.Builder> consumer) {
      requireNonNull (consumer);
      requireNonNull (name);
      FieldMappingConfig.Builder builder = new FieldMappingConfig.Builder ();
      consumer.accept (builder);
      fields.put (name, builder.build ());
      return this;
    }

    public DocumentClassMappingConfig build () {
      return new DocumentClassMappingConfig (this);
    }
  }

  public DocumentClassMappingConfig (Builder builder) {
    this.fields = ImmutableMap.copyOf (builder.fields);
    this.metadata = ImmutableMap.copyOf (builder.getMetadata ());
  }

  public static Builder builder () {
    return new Builder ();
  }

  @JsonProperty ("metadata")
  private Map<String, String> metadata;

  @JsonProperty ("fields")
  private Map<String, FieldMappingConfig> fields;

  @JsonIgnore
  public Map<String, FieldMappingConfig> getFields () {
    return fields;
  }

  @JsonIgnore
  public String getMetadata (String name) {
    return metadata.get (name);
  }
}

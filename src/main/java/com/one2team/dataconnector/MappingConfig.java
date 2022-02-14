package com.one2team.dataconnector;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import static java.util.Objects.requireNonNull;

public class MappingConfig {

  public static class Builder {

    private final Map<String, DocumentClassMappingConfig> documentClasses = new HashMap<> ();

    public Builder addDocumentClass (String name, Consumer<DocumentClassMappingConfig.Builder> consumer) {
      requireNonNull (consumer);
      requireNonNull (name);
      DocumentClassMappingConfig.Builder builder = new DocumentClassMappingConfig.Builder ();
      consumer.accept (builder);
      documentClasses.put (name, builder.build ());
      return this;
    }

    public MappingConfig build () {
      return new MappingConfig (this);
    }
  }

  public static Builder builder () {
    return new Builder ();
  }

  @JsonProperty ("document-classes")
  private Map<String, DocumentClassMappingConfig> documentClasses;

  public MappingConfig (Builder builder) {
    this.documentClasses = ImmutableMap.copyOf (builder.documentClasses);
  }

  @JsonIgnore
  public Map<String, DocumentClassMappingConfig> getDocumentClasses () {
    return ImmutableMap.copyOf (documentClasses);
  }
}

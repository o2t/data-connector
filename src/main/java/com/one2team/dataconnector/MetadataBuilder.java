package com.one2team.dataconnector;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class MetadataBuilder<B extends MetadataBuilder<B>> {

  private final Map<String, String> metadata = new HashMap<> ();

  public B addMetadata (String name, String value) {
    requireNonNull (name);
    requireNonNull (value);
    metadata.put (name, value);
    return cast ();
  }

  @SuppressWarnings ("unchecked")
  private B cast () {
    return (B) this;
  }

  Map<String, String> getMetadata () {
    return metadata;
  }
}

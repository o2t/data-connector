package com.one2team.dataconnector;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

  @JsonProperty ("shared-uuid")
  private UUID sharedUUID;

  @JsonProperty ("event")
  private EventType eventType;

  @JsonProperty ("document-class")
  private String documentClass;

  @JsonProperty ("values")
  private Map<String, Value> values;

  public Event () {
    values = new LinkedHashMap<> ();
  }

  public EventType getEventType () {
    return eventType;
  }

  public Map<String, Value> getValues () {
    return values;
  }

  public String getDocumentClass () {
    return documentClass;
  }

  public UUID getSharedUUID () {
    return sharedUUID;
  }
}

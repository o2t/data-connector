package com.one2team.dataconnector;

import java.util.ArrayList;

import static java.util.Objects.requireNonNull;

public class Value extends ArrayList<Object> {

  @Override
  public boolean add (Object t) {
    requireNonNull (t);
    return super.add (t);
  }
}

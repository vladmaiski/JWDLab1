package com.epam.jwd.storage.api;

import com.epam.jwd.model.Shape;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStorage<E extends Shape> {

    List<E> storage = new ArrayList<>();



}

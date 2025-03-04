package com.javaee.service;

import com.javaee.entity.Country;
import java.util.List;

public interface CountryService {

  List<Country> findAll(String search, int offset, int recordPerPage);

  void save(Country country);

  void update(Country country);

  void delete(int id);

  Country findById(int id);

  int count(String search);
}

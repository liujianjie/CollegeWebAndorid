package org.ht.service;

import java.util.List;

import org.ht.pojo.Informations;

public interface InformationsService {
List<Informations> findInfos();
Informations findById(Integer id);
}

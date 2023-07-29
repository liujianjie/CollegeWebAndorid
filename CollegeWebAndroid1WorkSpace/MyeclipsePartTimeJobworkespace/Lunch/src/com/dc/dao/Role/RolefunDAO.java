package com.dc.dao.Role;

import java.util.List;

public interface RolefunDAO {
  public List Findfunparent(String roleid);
  public List Findfunson(String roleid,String parentid);
  public int updateAllFunction(String roleid,String[] functionid);
}

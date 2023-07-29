package serviceI;

import java.util.List;
import java.util.Map;

import bean.Dept;

public interface DeptI {
	public List<Dept> selDept();
	public Dept getDept(Map<String, Object> map);
	public int add(Map<String, Object> map);
	public int update(Dept dept);
	public int delete(Integer deptnos);
}

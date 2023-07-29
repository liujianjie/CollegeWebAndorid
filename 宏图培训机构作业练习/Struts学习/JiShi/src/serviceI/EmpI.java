package serviceI;

import java.util.List;

import form.EmpForm;

public interface EmpI {
	public List selemp();
	
	public void delemp(int id);
	
	public EmpForm toalter(int id);
	
	public void alter(EmpForm emp);
	
	public void addemp(EmpForm emp);
}

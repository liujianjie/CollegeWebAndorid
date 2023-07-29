#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	float a, b;
	cin >> a >> b;
	cout << setiosflags(ios::fixed) << setprecision(3); 
	cout << a / b << " km/l";
	
	return 0;
}

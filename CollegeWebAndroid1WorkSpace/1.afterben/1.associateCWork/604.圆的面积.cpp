#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	float pie = 3.14159;
	float r;
	cin >> r;
	cout << setiosflags(ios::fixed) << setprecision(4);
	cout << "A=" << (pie * r * r);

	 
	
	return 0;
}

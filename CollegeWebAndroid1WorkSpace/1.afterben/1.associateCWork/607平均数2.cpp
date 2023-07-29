#include <iostream>
#include <iomanip> 
using namespace std;

int main()
{
	float a, b, c;
	cin >> a >> b >> c;
	cout << setiosflags(ios::fixed) << setprecision(1);
	cout << "MEDIA = " << (a * 2 + b * 3 + c * 5) / 10;
	
	return 0;
}

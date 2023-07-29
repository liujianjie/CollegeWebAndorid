#include <Windows.h>

int WINAPI WinMain(HINSTANCE hInstance,
	HINSTANCE hPrevInstance,
	LPSTR lpCmdLine,
	int nShowCmd) 
{
	MessageBox(NULL, TEXT("hello,world"), TEXT("MessageBox"), MB_OK | MB_DEFBUTTON2 | MB_ICONQUESTION);
	return 0;
}
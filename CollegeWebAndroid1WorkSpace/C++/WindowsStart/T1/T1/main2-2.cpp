#include <Windows.h>
#include <TCHAR.H>
#pragma warning(disable:4996)
int nMsg = 0;
TCHAR szMsgNumber[10];

LRESULT CALLBACK WndProc(HWND, UINT, WPARAM, LPARAM);

int WINAPI WinMain(HINSTANCE hInstance,
	HINSTANCE hPrevInstance,
	LPSTR lpCmdLine,
	int nCmdShow)
{
	HWND hwnd;
	MSG Msg;
	WNDCLASS wndclass;
	TCHAR lpszTitle[] = TEXT("Αυ½¨½ά 183052745");

	wndclass.style = 0;
	wndclass.lpfnWndProc = WndProc;
	wndclass.cbClsExtra = 0;
	wndclass.cbWndExtra = 0;
	wndclass.hInstance = hInstance;
	wndclass.hIcon = LoadIcon(NULL, IDI_ASTERISK);
	wndclass.hCursor = LoadCursor(NULL, IDC_CROSS);
	wndclass.lpszMenuName = NULL;
	wndclass.hbrBackground = (HBRUSH)GetStockObject(BLACK_BRUSH);
	wndclass.lpszClassName = TEXT("MyClass");

	// register
	if (!RegisterClass(&wndclass)) {
		MessageBox(NULL, TEXT("RegisterClass fail"), TEXT("ERROR"), MB_ICONERROR);
		return 0;
	}
	// CREATE window
	hwnd = CreateWindow(
		TEXT("MyClass"),
		lpszTitle,
		WS_OVERLAPPEDWINDOW,
		100,
		200,
		400,
		300,
		NULL,
		NULL,
		hInstance,
		NULL
	);
	if (!hwnd) {
		MessageBox(NULL, TEXT("CreateWindow fail"), TEXT("ERROR"), MB_ICONERROR);
		return 0;
	}
	// show window
	ShowWindow(hwnd, nCmdShow);

	// message loop
	while (GetMessage(&Msg, NULL, 0, 0)) {
		TranslateMessage(&Msg);
		DispatchMessage(&Msg);
		nMsg++;
	}
	_stprintf(szMsgNumber, TEXT("% d"),nMsg);
	MessageBox(NULL, szMsgNumber, TEXT(""), 0);

	return Msg.wParam;
}

LRESULT CALLBACK WndProc(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam)
{
	HDC hdc;
	PAINTSTRUCT ps;
	RECT rect;
	switch (message)
	{
	case WM_DESTROY:
		PostQuitMessage(0);
		return 0;
	case WM_PAINT:
		hdc = BeginPaint(hwnd, &ps);
		GetClientRect(hwnd, &rect);
		DrawText(hdc, TEXT("Hello World"),-1,&rect,DT_SINGLELINE|DT_CENTER|DT_VCENTER);
	}
	return DefWindowProc(hwnd, message, wParam, lParam);
}
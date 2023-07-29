#include <Windows.h>
#include <TCHAR.H>
LRESULT CALLBACK WndProc(HWND, UINT, WPARAM, LPARAM);

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInst, LPSTR lpszCmdLine, int nCmdShow)
{
	HWND hwnd;
	MSG Msg;
	WNDCLASS wndclass;
	TCHAR lpszTitle[] = TEXT("MyDemo");

	wndclass.style = CS_HREDRAW | CS_VREDRAW;
	wndclass.lpfnWndProc = WndProc;
	wndclass.cbClsExtra = 0;
	wndclass.cbWndExtra = 0;
	wndclass.hInstance = hInstance;
	wndclass.hIcon = LoadIcon(NULL, IDI_APPLICATION);
	wndclass.hCursor = LoadCursor(NULL, IDC_ARROW);
	wndclass.lpszMenuName = NULL;
	wndclass.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH);
	wndclass.lpszClassName = TEXT("MyClass");

	if (!RegisterClass(&wndclass)) {
		MessageBox(NULL, TEXT("FAIL REGISTER"), TEXT("ERROR"), MB_ICONERROR);
		return 0;
	}

	hwnd = CreateWindow(
		TEXT("MyClass"),
		lpszTitle,
		WS_OVERLAPPEDWINDOW,
		CW_USEDEFAULT,
		CW_USEDEFAULT,
		CW_USEDEFAULT,
		CW_USEDEFAULT,
		NULL,
		NULL,
		hInstance,
		NULL
	);
	if (!hwnd) {
		MessageBox(NULL, TEXT("Create fail "), TEXT("ERROR"), MB_ICONERROR);
		return 0;
	}
	ShowWindow(hwnd, nCmdShow);
	UpdateWindow(hwnd);

	while (GetMessage(&Msg, NULL, 0, 0))
	{
		TranslateMessage(&Msg);
		DispatchMessage(&Msg);
	}
	return Msg.wParam;
}

LRESULT  CALLBACK WndProc(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam)
{
	HDC hdc;
	PAINTSTRUCT ps;
	RECT rect;

	HFONT hfont1, holdfont1;

	static TCHAR lpStr[] = TEXT("HELLO WORLD! 世界你好！");
	int len = lstrlen(lpStr);

	switch (message)
	{
	case WM_DESTROY:
		PostQuitMessage(0);
		return 0;
	case WM_PAINT:
		hdc = BeginPaint(hwnd, &ps);
		GetClientRect(hwnd, &rect);
		hfont1 = CreateFont(30,0,100,900,FW_BOLD,0,0,1,1,0,0,0,0,TEXT("隶书"));
		holdfont1 = (HFONT)SelectObject(hdc, hfont1);

		TextOut(hdc,50,100,lpStr, len);

		SetGraphicsMode(hdc, GM_ADVANCED);
		TextOut(hdc, 50, 170, lpStr, len);

		DeleteObject(hfont1);
		SelectObject(hdc, holdfont1);

		EndPaint(hwnd, &ps);
		return 0;
	}
	return DefWindowProc(hwnd, message, wParam, lParam);
}
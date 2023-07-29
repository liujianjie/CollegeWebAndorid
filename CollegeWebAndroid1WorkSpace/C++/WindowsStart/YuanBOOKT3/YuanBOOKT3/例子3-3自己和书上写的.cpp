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

	RECT rect1 = { 50,50,300,150 };
	RECT rect2 = { 350,50,500,150 };

	static TCHAR lpStr[] = TEXT("HELLO WORLD! 世界你好！");
	static int len = lstrlen(lpStr);

	HBRUSH hbrush1, hOldbrush;

	switch (message)
	{
	case WM_DESTROY:
		PostQuitMessage(0);
		return 0;
	case WM_PAINT:
		hdc = BeginPaint(hwnd, &ps);
		SaveDC(hdc);

		GetClientRect(hwnd, &rect);

		hbrush1 = (HBRUSH)GetStockObject(LTGRAY_BRUSH);
		hOldbrush = (HBRUSH)SelectObject(hdc,hbrush1);

		Rectangle(hdc, rect1.left, rect1.top, rect1.right, rect1.bottom);
		DrawText(hdc, lpStr, -1, &rect1, DT_VCENTER | DT_SINGLELINE | DT_CENTER);

		Rectangle(hdc, rect2.left, rect2.top, rect2.right, rect2.bottom);
		DrawText(hdc, lpStr, -1, &rect2, 0);

		TextOut(hdc, 50, 200, lpStr, len);

		SetBkColor(hdc, RGB(220, 220, 220));
		SetTextColor(hdc, RGB(250, 50, 50));
		TextOut(hdc, 50, 220, lpStr, len);

		SetBkColor(hdc, RGB(255, 255, 0));
		SetTextColor(hdc, RGB(255, 0, 0));
		TextOut(hdc, 250, 220, lpStr, len);

		RestoreDC(hdc, -1);
		TextOut(hdc, 50, 250, lpStr, len);
		TextOut(hdc, 100, 250, lpStr, len);

		// 
		SetBkMode(hdc,TRANSPARENT);// 透明背景
		TextOut(hdc, 50, 270, lpStr, len);
		TextOut(hdc, 100, 270, lpStr, len);

		DeleteObject(hbrush1);
		SelectObject(hdc, hOldbrush);

		EndPaint(hwnd, &ps);
		return 0;
	}
	return DefWindowProc(hwnd, message, wParam, lParam);
}
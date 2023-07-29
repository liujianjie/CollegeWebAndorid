#include <Windows.h>
#include <TCHAR.H>
#pragma warning(disable:4996)

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

	static TCHAR lpStr[] = TEXT("HELLO WORLD! 世界你好!");
	static int len = lstrlen(lpStr);

	HFONT hFont, hOldFont;
	TEXTMETRIC tm;
	int x = 50, y = 100;
	TCHAR lpMsg[100];// 存储字体信息字符串

	switch (message)
	{
	case WM_DESTROY:
		PostQuitMessage(0);
		return 0;
	case WM_PAINT:
		hdc = BeginPaint(hwnd, &ps);
		GetTextMetrics(hdc, &tm);
		_stprintf(lpMsg, TEXT("系统默认字体外行距：%d,内行距：%d，高：%d"),
			tm.tmExternalLeading,tm.tmInternalLeading,tm.tmHeight);
		TextOut(hdc,10,20,lpMsg,lstrlen(lpMsg));

		hFont = CreateFont(25, 10, 0, 0, 700, 0, 0, 0, CHINESEBIG5_CHARSET, 0, 0, 0, 0, NULL);
		hOldFont = (HFONT)SelectObject(hdc, hFont);

		GetTextMetrics(hdc, &tm);
		_stprintf(lpMsg, TEXT("新字体外行距：% d,内 行 距：% d，高：% d"),
			tm.tmExternalLeading, tm.tmInternalLeading, tm.tmHeight);
		TextOut(hdc, 10, 50, lpMsg, lstrlen(lpMsg));

		TextOut(hdc, x, y, lpStr, len);
		TextOut(hdc, x + tm.tmAveCharWidth * len, y  , lpStr, len);

		TextOut(hdc, x, y + tm.tmHeight, lpStr, len);
		TextOut(hdc, x, y + tm.tmHeight + tm.tmExternalLeading + 8, lpStr, len);

		SelectObject(hdc,hOldFont);
		DeleteObject(hFont);

		EndPaint(hwnd, &ps);
		return 0;
	}
	return DefWindowProc(hwnd, message, wParam, lParam);
}
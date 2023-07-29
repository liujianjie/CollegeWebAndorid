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

	// 
	HPEN hpen1, hpen2, hpen3, hOldpen;
	HBRUSH hbrush1, hbrush2, hbrush3, hbrush4, hbrush5, hOldbrush;

	int rect1[] = {200,50,300,150};

	int rect2[] = { 350,50,450,150 };

	int rect3[] = { 50,200,150,300 };

	int rect4[] = { 200,200,300,300 };

	int rect5[] = { 350,200,450,300 };

	switch (message)
	{
	case WM_DESTROY:
		PostQuitMessage(0);
		return 0;
	case WM_PAINT:
		hdc = BeginPaint(hwnd, &ps);
		GetClientRect(hwnd, &rect);

		hOldpen = (HPEN)GetStockObject(BLACK_PEN);
		hpen1 = CreatePen(PS_DOT,1,RGB(0,0,0));
		hpen2 = CreatePen(PS_DASHDOT,1, RGB(120, 20, 30));
		hpen3 = CreatePen(PS_SOLID, 5, RGB(10, 30, 40));

		SelectObject(hdc,hpen1);
		MoveToEx(hdc,50,50,NULL);
		LineTo(hdc,150,50);

		SelectObject(hdc, hpen2);
		MoveToEx(hdc, 50, 83, NULL);
		LineTo(hdc, 150, 83);

		SelectObject(hdc, hpen3);
		MoveToEx(hdc, 50, 150, NULL);
		LineTo(hdc, 150, 150);
	
		// »Ö¸´Ô­À´»­±Ê
		SelectObject(hdc,hOldpen);

		hbrush1 = (HBRUSH)GetStockObject(LTGRAY_BRUSH);
		hbrush2 = (HBRUSH)GetStockObject(DKGRAY_BRUSH);
		hbrush3 = (HBRUSH)CreateHatchBrush(HS_CROSS, RGB(0, 0, 0));
		hbrush4 = (HBRUSH)CreateHatchBrush(HS_DIAGCROSS, RGB(220, 30, 50));
		hbrush5 = (HBRUSH)CreateHatchBrush(HS_FDIAGONAL, RGB(0, 0, 0));
		hOldbrush =(HBRUSH) SelectObject(hdc,hbrush1);
		Rectangle(hdc, rect1[0], rect1[1], rect1[2], rect1[3]);

		SelectObject(hdc, hbrush2);
		Rectangle(hdc, rect2[0], rect2[1], rect2[2], rect2[3]);

		SelectObject(hdc, hbrush3);
		Rectangle(hdc, rect3[0], rect3[1], rect3[2], rect3[3]);

		SelectObject(hdc, hbrush4);
		Rectangle(hdc, rect4[0], rect4[1], rect4[2], rect4[3]);

		SelectObject(hdc, hbrush5);
		Rectangle(hdc, rect5[0], rect5[1], rect5[2], rect5[3]);
		
		// »Ö¸´Ïú»Ù
		SelectObject(hdc, hOldpen);
		SelectObject(hdc,hOldbrush);

		DeleteObject(hpen1);
		DeleteObject(hpen2);
		DeleteObject(hpen3);

		DeleteObject(hbrush1);
		DeleteObject(hbrush2);
		DeleteObject(hbrush3);
		DeleteObject(hbrush4);
		DeleteObject(hbrush5);

		EndPaint(hwnd, &ps);
		return 0;
	}
	return DefWindowProc(hwnd, message, wParam, lParam);
}
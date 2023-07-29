#include <Windows.h>
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
	wndclass.hIcon = LoadIcon(NULL,IDI_APPLICATION);
	wndclass.hCursor = LoadCursor(NULL, IDC_ARROW);
	wndclass.lpszMenuName = NULL;
	wndclass.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH);
	wndclass.lpszClassName = TEXT("MyClass");

	if(!RegisterClass(&wndclass)){
		MessageBox(NULL, TEXT("FAIL REGISTER"),TEXT("ERROR"),MB_ICONERROR);
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
		MessageBox(NULL,TEXT("Create fail "),TEXT("ERROR"),MB_ICONERROR);
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

	POINT lpPt1[6] = {300,10,395,79,359,191,241,191,205,79,300,10};
	POINT lpPt2[6] = { 550,10,645,79,609,191,491,191,455,79,550,10 };

	HBRUSH hBrush, hOldBrush;

	switch (message)
	{
	case WM_DESTROY:
		PostQuitMessage(0);
		return 0;
	case WM_PAINT:
		hdc = BeginPaint(hwnd, &ps);
		GetClientRect(hwnd, &rect);

		// 浅灰
		hBrush = (HBRUSH)GetStockObject(LTGRAY_BRUSH);

		hOldBrush = (HBRUSH)SelectObject(hdc,hBrush);

		for (int i = 50; i < 150; ++i) 
		{
			SetPixel(hdc, i, 100, RGB(0, 0, 0));
		}
		MoveToEx(hdc, 100, 50, NULL);
		LineTo(hdc,100,150);

		Polyline(hdc, lpPt1, 5);//5个点

		Polygon(hdc, lpPt2, 6);

		Rectangle(hdc, 40, 220, 230, 350);
		RoundRect(hdc, 40, 220, 230, 350, 30, 20);

		Ellipse(hdc, 40, 220, 40 + 30, 220 + 20);//左上角画椭圆

		Ellipse(hdc, 40, 220, 230, 350);

		Arc(hdc, 180, 220, 370, 350, 450, 285, 275, 200);
		Chord(hdc, 300, 220, 490, 350, 570, 285, 395, 200);
		Pie(hdc, 420, 220, 610, 350, 690, 285, 515, 200);

		// 恢复设备环境
		SelectObject(hdc, hOldBrush);
		// 删除创建的画刷
		DeleteObject(hBrush);
		EndPaint(hwnd,&ps);
		return 0;
	}
	return DefWindowProc(hwnd, message, wParam, lParam);
}
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
	POINT erpt[5] = { 300,0,395,69,359,181,241,181,205,69 };

	POINT sanpt[5] = { 500,0,559,181,405,69,595,69,441,181 };

	int sipos[4] = { 50,200,250,300 };

	int wupos[4] = { 350,200,550,300 };
	int wujiequ[4] = {550,250,450,200};

	int liupos[4] = { 550,200,750,300 };
	int liujiequ[4] = { 750,250,650,200 };

	int qipos[4] = { 750,200,950,300 };
	int qijiequ[4] = { 950,250,850,200 };
	switch (message)
	{
	case WM_PAINT:
		hdc = BeginPaint(hwnd, &ps);
		GetClientRect(hwnd, &rect);
		
		// yi
		for (int i = 0; i < 100; ++i) 
		{
			SetPixel(hdc, 20 + i, 30, RGB(255, 0, 0));
		}
		MoveToEx(hdc, 50, 10, NULL);
		LineTo(hdc, 50,60);

		// er
		Polyline(hdc, erpt, 5);

		// san
		SelectObject(hdc,(HBRUSH)GetStockObject(LTGRAY_BRUSH));
		Polygon(hdc, sanpt, 5);

		// si
		Rectangle(hdc, sipos[0], sipos[1], sipos[2], sipos[3]);
		RoundRect(hdc, sipos[0], sipos[1], sipos[2], sipos[3], 50, 30);
		Ellipse(hdc, sipos[0], sipos[1], sipos[2], sipos[3]);
		Ellipse(hdc, sipos[0], sipos[1], sipos[0] + 50, sipos[1] + 30);

		// wu
		Arc(hdc, wupos[0], wupos[1], wupos[2], wupos[3], wujiequ[0], wujiequ[1], wujiequ[2], wujiequ[3]);
		// liu
		Chord(hdc, liupos[0], liupos[1], liupos[2], liupos[3], liujiequ[0], liujiequ[1], liujiequ[2], liujiequ[3]);
		// qi
		Pie(hdc, qipos[0], qipos[1], qipos[2], qipos[3], qijiequ[0], qijiequ[1], qijiequ[2], qijiequ[3]);
		EndPaint(hwnd, &ps);
		return 0;
	case WM_DESTROY:
		PostQuitMessage(0);
		return 0;

	}
	return DefWindowProc(hwnd, message, wParam, lParam);
}
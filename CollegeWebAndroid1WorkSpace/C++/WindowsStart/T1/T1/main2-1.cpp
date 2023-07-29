#include <Windows.h>


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

	}
	return Msg.wParam;
}

LRESULT CALLBACK WndProc(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam)
{
	switch (message)
	{
		case WM_DESTROY:
			PostQuitMessage(0);
		return 0;
	}
	return DefWindowProc(hwnd, message,wParam, lParam);
}
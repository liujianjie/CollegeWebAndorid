// 1.TestOne.cpp : ����Ӧ�ó������ڵ㡣
//

#include <windows.h>
#include <stdio.h>

LRESULT CALLBACK WinSunProc
(
HWND hwnd,
UINT uMsg,
WPARAM wParam,
LPARAM lparam);

int WINAPI WinMain( HINSTANCE hInstance,
                      HINSTANCE hPrevInstance,
                      LPSTR    lpCmdLine,
                      int       nCmdShow)
{
	WNDCLASS wcex;

	wcex.cbClsExtra = 0;
	wcex.cbWndExtra = 0;
	wcex.hbrBackground = (HBRUSH)(COLOR_WINDOW + 1);
	wcex.hCursor = LoadCursor(nullptr, IDC_ARROW);
	wcex.lpfnWndProc = WinSunProc;
	wcex.hInstance = hInstance;
	wcex.hIcon = LoadIcon(hInstance, IDC_CROSS);
	wcex.lpszClassName = L"C++ GAME";
	wcex.lpszMenuName = NULL;
	wcex.style = CS_HREDRAW | CS_VREDRAW;
	RegisterClass(&wcex);

	HWND hwnd = CreateWindow(L"C++ GAME", L"C++ GAME", WS_OVERLAPPEDWINDOW,
		200, 200, 600, 400, nullptr, nullptr, hInstance, nullptr);

	ShowWindow(hwnd, SW_SHOWNORMAL);
	UpdateWindow(hwnd);

    MSG msg;

    // ����Ϣѭ��: 
    while (GetMessage(&msg, nullptr, 0, 0))
    {
            TranslateMessage(&msg);
            DispatchMessage(&msg);
    }

    return 0;
}

//
//  ����: WndProc(HWND, UINT, WPARAM, LPARAM)
//
//  Ŀ��:    ���������ڵ���Ϣ��
//
//  WM_COMMAND  - ����Ӧ�ó���˵�
//  WM_PAINT    - ����������
//  WM_DESTROY  - �����˳���Ϣ������
//
//
LRESULT CALLBACK WinSunProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
	PAINTSTRUCT ps;
	HDC hdc;
    switch (message)
    {
		
		case WM_PAINT:
			hdc = BeginPaint(hWnd, &ps);
			// TODO: �ڴ˴����ʹ�� hdc ���κλ�ͼ����...
			TextOut(hdc, 200, 0, L"C++ gAME", strlen("Game"));
			EndPaint(hWnd, &ps);
		break;
		case WM_CLOSE:
			if (IDYES == MessageBox(hWnd, L"is real", L"game", MB_YESNO))
			{
				DestroyWindow(hWnd);
			}
			break;
		case WM_DESTROY:
			PostQuitMessage(0);
			break;
		default:
			return DefWindowProc(hWnd, message, wParam, lParam);
    }
    return 0;
}


package shop.book;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class AddPhotoServlet
 */
@WebServlet("/AddPhotoServlet")
public class AddPhotoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //����ContentType�ֶ�ֵ
            response.setContentType("text/html;charset=utf-8");
            // ����DiskFileItemFactory��������
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //�����ļ�����Ŀ¼�������Ŀ¼���������´���һ��
            File f = new File("E:\\TempFolder");
            if (!f.exists()) {
                f.mkdirs();
            }
            // �����ļ��Ļ���·��
            factory.setRepository(f);
            // ���� ServletFileUpload����
            ServletFileUpload fileupload = new ServletFileUpload(factory);
            //�����ַ�����
            fileupload.setHeaderEncoding("utf-8");
            // ���� request���õ��ϴ��ļ���FileItem����
            List<FileItem> fileitems = fileupload.parseRequest(request);
            //��ȡ�ַ���
            PrintWriter writer = response.getWriter();
            // ��������
            for (FileItem fileitem : fileitems) {
                // �ж��Ƿ�Ϊ��ͨ�ֶ�
                if (fileitem.isFormField()) {
                    // ����ֶ������ֶ�ֵ
                    String name = fileitem.getFieldName();
                    if (name.equals("name")) {
                        //����ļ���Ϊ�գ����䱣����value��
                        if (!fileitem.getString().equals("")) {
                            String value = fileitem.getString("utf-8");
                            writer.print("�ϴ��ߣ�" + value + "<br>");
                        }
                    }
                } else {
                    System.out.println("sdfsdf");
                    // ��ȡ�ϴ����ļ���
                    String filename = fileitem.getName();
                    //�����ϴ��ļ�
                    if (filename != null && !filename.equals("")) {
                        writer.print("�ϴ����ļ������ǣ�" + filename + "<br>");
                        // ��ȡ���ļ���
                        filename = filename.substring(filename.lastIndexOf("\\") + 1);
                        // �ļ�����ҪΨһ
                        //filename = UUID.randomUUID().toString() + "_" + filename;
                        // �ڷ���������ͬ���ļ�
                        String webPath = "/bookimage/";
                        //�����������ļ���·�����ļ�����ϳ������ķ�������·��
                        String filepath = getServletContext().getRealPath(webPath + filename);
                        // �����ļ�
                        System.out.println(filepath);
                        File file = new File(filepath);
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                        // ����ϴ��ļ���,��fileitem�ж�ȡ���ݣ�д�������file
                        InputStream in = fileitem.getInputStream();
                        // ʹ��FileOutputStream�򿪷������˵��ϴ��ļ�
                        FileOutputStream out = new FileOutputStream(file);
                        // ���ĶԿ�
                        byte[] buffer = new byte[1024];//ÿ�ζ�ȡ1024���ֽ�
                        int len;
                        //��ʼ��ȡ�ϴ��ļ����ֽڣ����������������˵��ϴ��ļ��������
                        while ((len = in.read(buffer)) > 0)
                            out.write(buffer, 0, len);//��ȡbuffer��0��len���ȵ��ֽ�
                        // �ر���
                        in.close();
                        out.close();
                        // ɾ����ʱ�ļ�
                        fileitem.delete();
                        writer.print("�ϴ��ļ��ɹ���<br>");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

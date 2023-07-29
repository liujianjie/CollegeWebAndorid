package QQcloudlet;


import java.io.File;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
public class file {

    public static void main(String[] args) throws Exception {
        JFileChooser chooser = new JFileChooser();


        chooser.setFileFilter(new Filter());


        int result = chooser.showSaveDialog(null);
    }
}


class Filter extends FileFilter {


    public boolean accept(File file) {
        if (file.getName().toUpperCase().endsWith("JPG")) {
            return true;
        }
        return false;
    }


    public String getDescription() {


        return "JPG";
    }
}

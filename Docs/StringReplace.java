import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringReplace {
    public static void docxReplace(String filename, String str1, String str2) throws Exception {
        int count = 0;
        XWPFDocument document = new XWPFDocument();
        XWPFDocument docx = new XWPFDocument(new FileInputStream(filename));
        XWPFWordExtractor we = new XWPFWordExtractor(docx);

        String textrep = we.getText() ;
        if(textrep.contains(str1)){
            textrep = textrep.replace(str1, str2);
        }

        char[] c = textrep.toCharArray();

        for(int i = 0; i < c.length; i++){

            if(c[i] == '\n'){
                count ++;
            }
        }

        StringTokenizer st = new StringTokenizer(textrep,"\n");

        XWPFParagraph para = document.createParagraph();
        para.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run;

        List<XWPFParagraph> paragraphs = new ArrayList<XWPFParagraph>();
        List<XWPFRun>runs = new ArrayList<XWPFRun>();

        int k = 0;
        for(k=0;k<count+1;k++){
            paragraphs.add(document.createParagraph());
        }
        k=0;

        while(st.hasMoreElements()){
            paragraphs.get(k).setAlignment(ParagraphAlignment.LEFT);
            paragraphs.get(k).setSpacingAfter(0);
            paragraphs.get(k).setSpacingBefore(0);
            run = paragraphs.get(k).createRun();
            run.setText(st.nextElement().toString());
            k++;
        }

        document.write(new FileOutputStream(filename));
    }
}

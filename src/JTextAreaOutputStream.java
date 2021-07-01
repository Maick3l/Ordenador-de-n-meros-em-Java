
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tyrion
 */
public class JTextAreaOutputStream extends OutputStream {

    private JTextArea txt;
        public JTextAreaOutputStream(JTextArea txt){
            this.txt = txt;
        }
        @Override
        public void write(int b) throws IOException{
            txt.append(String.valueOf((char)b));
            txt.setCaretPosition(txt.getDocument().getLength());
        }
        }

    


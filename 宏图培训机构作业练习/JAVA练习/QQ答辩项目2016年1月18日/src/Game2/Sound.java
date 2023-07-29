package Game2;
//��һ�� ����������
import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
public class Sound {
	String path=new String("music\\");//Ŀ¼
	String file=new String("flourish.mid");//Ĭ�ϵ��ļ���
	boolean sign;//�Ƿ񲥷����ֵı�־
	Sequence seq;//����
	Sequencer midi;//���ͱ��� ��������
	public Sound(){
		loadSound();//��������
		
	}
	void loadSound(){//��������
		try{
			seq=MidiSystem.getSequence(new File(path+file));
			midi=MidiSystem.getSequencer();
			midi.open();
			midi.setSequence(seq);
			midi.start();
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		sign=true;
	}
	public void mystop(){//�ر�����
		if(isplay()){
			midi.stop();//ֹͣ����
			midi.close();//�ر��豸
			sign=false;
		}
		
	}
	public boolean isplay(){//�ж�sign��ֵ
		return sign;
		
	}
	void setmusic(String e){//��ȡ�����ļ� һ��Ĭ�������ļ�
		file=e;
	}
}

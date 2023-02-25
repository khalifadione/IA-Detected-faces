import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String imgFile = "C:\\Users\\Khalifa A DIONE\\FaceDetection\\image\\imm.jpg";
		Mat src = Imgcodecs.imread(imgFile);

		CascadeClassifier cc = new CascadeClassifier("C:\\Users\\Khalifa A DIONE\\FaceDetection\\data\\haarcascade_frontalface_alt2.xml");

		MatOfRect faceDetection = new MatOfRect();
		cc.detectMultiScale(src,faceDetection);
		System.out.println(String.format("Detected faces: %d",faceDetection.toArray().length));


		for (Rect rect : faceDetection.toArray()) {
			Imgproc.rectangle(src,new Point(rect.x, rect.y),new Point(rect.x+ rect.width, rect.y + rect.height),new Scalar(0,255,0),3);
		}

		Imgcodecs.imwrite("C:\\Users\\Khalifa A DIONE\\FaceDetection\\image\\immjj.jpg",src);
		System.out.println("finsshsss");
	}

}
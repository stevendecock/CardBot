package be.decock.steven.cardbot;

import java.awt.image.BufferedImage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class VideoCap {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    VideoCapture cap;
    Mat2Image mat2Img = new Mat2Image();

    VideoCap(){
        cap = new VideoCapture();
        cap.open(0);
    }

    BufferedImage getOneFrame() {
        cap.read(mat2Img.mat);
        Mat matColorFixed = mat2Img.mat.clone();
        Imgproc.cvtColor(mat2Img.mat, matColorFixed, Imgproc.COLOR_BGR2RGB);
//        Core.flip(matColorFixed, matColorFixed, 1);
        return mat2Img.getImage(matColorFixed);
    }
}

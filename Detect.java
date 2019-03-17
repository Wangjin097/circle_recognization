
package com.example.dialogdemo;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class Detect {
	public static Mat subMat = new Mat();
	public static Mat dst = new Mat();
	//public static Mat circles = new Mat();
	public static int half = 0;
	public static Rect rect = new Rect();
	public static Mat hsvMat = new Mat();
	public static Mat mMaskMat1 = new Mat();
	public static Mat mMaskMat2 = new Mat();
	public static Mat mixhsv = new Mat();
	public static int erosion_type = 0;
	public static int erosion_size = 0;
	public static Mat result = new Mat();
	public static Mat element = new Mat();
	public static Mat mresult = new Mat();

	public static MatOfPoint2f contouri;
	public static MatOfPoint2f approx;
	public static MatOfPoint2f approx2f = new MatOfPoint2f();
	public static double maxArea = 0;
	public static double area = 0;
	public static int Area = 0;
	public static double maxCosine1 = 0;
	public static double cosine = 0;
	public static Scalar lowerThreshold1 = new Scalar(0, 100, 100); // ��ɫ��hsv
	protected Object[] elementData; 															// h:0-10,150-180
	public static Scalar upperThreshold1 = new Scalar(10, 255, 255); //
	public static Scalar lowerThreshold2 = new Scalar(150, 100, 100); // ��ɫ��hsv
																		// h:0-10,150-180
	public static Scalar upperThreshold2 = new Scalar(180, 255, 255);
public static  void detectcircle(Mat mRgb)//, List<MatOfPoint> contours)
	{

Mat dst = mRgb.clone();
		Imgproc.cvtColor(mRgb, dst, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(dst, dst, new Size(9, 9), 2, 2);
		Mat circles = new Mat();//����һ�����������������Բ��Բ������Ͱ뾶
		Imgproc.HoughCircles(dst, circles, Imgproc.HOUGH_GRADIENT , 1.5, 10, 200, 100, 0, 0);//����任���Բ
		//(dst, circles, Imgproc.HOUGH_GRADIENT , 1.5, 20, 130, 38, 0, 0);
		
		for (int i = 0; i < circles.cols();i++)//�������м�⵽��Բ
	    {
	      double[] vCircle = circles.get(0,i);
	 
	      Point center = new Point(vCircle[0], vCircle[1]);//����Բ��
	      int radius = (int) Math.round(vCircle[2]);//����뾶
	 
	      // ��mRgb�ϻ�Բ��
	      Imgproc.circle(mRgb, center, 3, new Scalar(0, 255, 0), -1, 8, 0);
	      // ��mRgb��ԲȦ
	      Imgproc.circle(mRgb, center, radius, new Scalar(0, 255, 0), 3, 8, 0);
	 
	    }
		}
}

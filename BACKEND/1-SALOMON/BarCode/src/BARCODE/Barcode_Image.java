package BARCODE;

public class Barcode_Image {
	public static void createImage(String image_name,String myString)  {
		try {
		Code128Bean code128 = new Code128Bean();
		code128.setHeight(15f);
		code128.setModuleWidth(0.3);
		code128.setQuietZone(10);
		code128.doQuietZone(true);

}

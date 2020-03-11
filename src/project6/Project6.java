/*
 * Alexis Santiago
 *Project 6: Image Pyramids
 *
 */
package project6;

import java.awt.image.BufferedImage;

/**
 *
 * @author alexi
 */
public class Project6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("___________Project06_____________");
        //read image
        BufferedImage inImage   = ImageIo.readImage("utb.jpg");
        //convert to gray
        BufferedImage grayImage = ImageIo.toGray(inImage);
        //get image values as array
        byte[][] grayInput  = ImageIo.getGrayByteImageArray2DFromBufferedImage(grayImage);
        //create array to store zoomOut image values 
        byte[][] pyramidOutput  = new byte[(grayInput.length)*2][(grayInput[0].length)*2];
        
        Pyramid pyramidObj = new Pyramid();
        //create and set starting index
        int [] index = {0,0};
       
        System.out.println("main___c: "+index[0]+" r: "+index[1]);
        pyramidObj.pRecurse(grayInput, pyramidOutput, 2, 0,index );
       
        // Output pyramid image
        BufferedImage pyramid = ImageIo.setGrayByteImageArray2DToBufferedImage(pyramidOutput);
        ImageIo.writeImage(pyramid, "jpg", "pyramid.jpg"); 
        
     
        
        
        
        
        
        
        
        
        
    }
    
}

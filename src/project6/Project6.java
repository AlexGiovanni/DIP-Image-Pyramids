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
        byte[][] zoomOut  = new byte[(grayInput.length)*2][(grayInput[0].length)*2];
        
        Pyramid pyramidObj = new Pyramid();
        
        byte[][] zOut = pyramidObj.zoomOut(grayInput);
        
        // Output Zoomed out image
        BufferedImage zoomO = ImageIo.setGrayByteImageArray2DToBufferedImage(zOut);
        ImageIo.writeImage(zoomO, "jpg", "ZoomedOut.jpg"); 
        
        
        
        
        
        
        
        
        
        
        
    }
    
}

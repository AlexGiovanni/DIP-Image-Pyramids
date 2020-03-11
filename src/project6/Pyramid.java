/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author alexi
 */
public class Pyramid {
    
    //create the zoomed out image
    public byte[][] zoomOut(byte[][]input) {

        // Gradient
       byte[][] output= new byte[(input.length)/2][(input[0].length)/2];
      
        for (int r = 0; r < output.length - 1; r++) 
        {
            for (int c = 1; c < output[0].length - 1; c++) 
            {
               
                       
               output[r][c]= (byte) ImageIo.clip((input[2*r][2*c] & 0xff +
                                                 input[2*r+1][2*c] & 0xff +
                                                 input[2*r][2*c+1] & 0xff +
                                                 input[2*r+1][2*c+1] & 0xff)/4.0f);
                
            }
        }
        return output;
    } 
    
     public void handleBorder(byte[][] input, byte[][]output, int hmask, int vmask) {
        int h = input.length;
        int w = input[0].length;
        //top rows
        for (int i = 0; i < hmask; i++) {
            for (int j = 0; j < w; j++) {
                output[i][j] = input[i][j];
            }
        }
        //bottom rows
        for (int i = h - hmask; i < h; i++) {
            for (int j = 0; j < w; j++) {
                output[i][j] = input[i][j];
            }
        }
        //left columns
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < vmask; j++) {
                output[i][j] = input[i][j];
            }
        }
        //right columns
        for (int i = 0; i < h; i++) {
            for (int j = w - vmask; j < w; j++) {
                output[i][j] = input[i][j];
            }
        }
    }
    
}

/*
 //create the zoomed out image
    public byte[][] zoomOut(byte[][]input) {

        // Gradient
       byte[][] output= new byte[(input.length)/2][(input[0].length)/2];
      
        for (int r = 0; r < output.length - 1; r++) 
        {
            for (int c = 1; c < output[0].length - 1; c++) 
            {
               float sum = input[][]
                       
               output[r][c] = (byte) input[][] & 0xff;
                
            }
        }
        return output;
    } 
*/

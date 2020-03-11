/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project6;

/**
 *
 * @author alexi
 */
public class Pyramid {
    
    /*create the zoomed out image
    *takes an image and creates a zoomed out image by
    *taking the average of 4 pixels
    *returns the zoomed out image
    */
    public byte[][] zoomOut(byte[][]input) {
        // output stores the zoomed out image
       byte[][] output= new byte[(input.length)/2][(input[0].length)/2];
      
        for (int r = 0; r < output.length - 1; r++){
            for (int c = 1; c < output[0].length - 1; c++){
               //zoom out calculations (avareges 4 pixels)  
               output[r][c]= (byte) ImageIo.clip((input[2*r][2*c] & 0xff +
                                                 input[2*r+1][2*c] & 0xff +
                                                 input[2*r][2*c+1] & 0xff +
                                                 input[2*r+1][2*c+1] & 0xff)/4.0f);
            }
        }
        return output;
    } 
    
    
    /*
    *recursive function that adds the zoom images to pyramid
    *input is the original image
    *output is the pyramid image
    *levels is the number of levels that will be zoomed out
    *counter tracks the leels
    *index tracks the botom right index of the last image added to the pyramid image
    */
    public byte[][] pRecurse(byte[][]input, byte[][]output, int levels, int counter, int index[]) {
    System.out.println("c: "+index[0]+" r: "+index[1]);
        //Base case: add original image
        if (levels > 0 && counter == 0){
          //copy the original image to pyramids image
          index = addImage( input, output, index ).clone();
          levels--;
          counter++;
        }
        else if(levels > 0 && counter == 1){//maybe >=0
            //zoom out
            byte[][] zoomedInput = zoomOut(input);
            index = addImage( zoomedInput, output, index ).clone();
            levels--;
            counter++;
        }
        
        return output;
    }
    
    /*
    *add sub image to pyramid image and return index of botom right pixel as array
    */
    public int[]  addImage(byte[][] input, byte[][]output,int index[] ){
        
        //loop that adds image
        for (int r = 0; r < input.length - 1; r++)  {
            for (int c = 1; c < input[0].length - 1; c++) {
                output[r+index[0]][c+index[1]] = input[r][c];
            }
        }
        
        index[0]= input.length - 1;//row index
        index[1]= input[0].length - 1;//colum index
        return index;
    }
    
    
    
     //handle border function
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


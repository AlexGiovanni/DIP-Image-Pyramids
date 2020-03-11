# DIP-Image-Pyramids
Project 06: Image Pyramids 

Project 06: Image Pyramids

Your goals in this project is to create two pyramid images for a given image using Java. Each image will contain L levels of the pyramid (the original image, and l other images). Each image in the pyramid will be ¼ in size of the previous pyramid level (half the number of rows and half the number of columns). So for an original image of 512x512, the next image will be 256x256, then next 128x128, the next will be 64x64, and so on. All the  l+1 images, the original and the other l images, will be displayed as one big image like a quad-tree (as shown below for L=3). You should write you function to have any number of possible levels all the way down to 2x2, not a fixed number of levels.


    

The first pyramid will contain the original image and the zoomed-out images of it. Use the notes from the geometric transformation modules to create the zoomed-out image by averaging 2x2 pixels into 1 pixel. The second pyramid will contain the Sobel gradients (the gradient of the original image, and the gradient of the zoomed-out images). Create each part as a separate function that could take:

Name: zoomedOutPyramid, GradientPyramid

Possible parameters:

Original image array, integer of the number of pyramid levels to generate

Make sure that the original image size and the smaller image sizes after zooming out are allowed. Usually the pyramid are constructed all the way down to 32x32 or 16x16 when the size is a power of two.

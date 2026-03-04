package com.example;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
         
        try {
            if (this.img == null) {
                this.img = ImageIO.read(new File(System.getProperty("user.dir")+img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    //precondition: g and currentSquare must be on-null valid objects.
    //postcondition: the image stored in the img property of this object is drawn to the screen.
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        // return null;
     //start by declaring the arrayList we wish to return at the end
	    ArrayList<Square> moves = new ArrayList<Square>();

	    //make sure the squares we are adding are in bounds. (you’d also need to check to make sure they aren’t occupied by a piece unless it’s a piece of the opposite color in which case you can capture it. I leave this bit for you to figure out.
           if(start.getRow()-2>=0 && start.getCol()-2>=0){
                //if the square is a legal move add it to the list.                    
                moves.add(board[start.getRow()-2][start.getCol()-2]);
            }
            if(start.getRow()-1>=0 && start.getCol()-1>=0){
                //if the square is a legal move add it to the list.                    
                moves.add(board[start.getRow()-1][start.getCol()-1]);
            }
            if(start.getRow()-2>=0 && start.getCol()+2<8){
                //if the square is a legal move add it to the list.                    
                moves.add(board[start.getRow()-2][start.getCol()+2]);
            }
            if(start.getRow()-1>=0 && start.getCol()+1<8){
                //if the square is a legal move add it to the list.                    
                moves.add(board[start.getRow()-1][start.getCol()+1]);
            }
            if(start.getRow()+2<8 && start.getCol()-2>=0){
                //if the square is a legal move add it to the list.                    
                moves.add(board[start.getRow()+2][start.getCol()-2]);
            }
            if(start.getRow()+1<8 && start.getCol()-1>=0){
                //if the square is a legal move add it to the list.                    
                moves.add(board[start.getRow()+1][start.getCol()-1]);
            }
            if(start.getRow()+2<8 && start.getCol()+2<8){
                //if the square is a legal move add it to the list.                    
                moves.add(board[start.getRow()+2][start.getCol()+2]);
            }
            if(start.getRow()+1<8 && start.getCol()+1<8){
                //if the square is a legal move add it to the list.                    
                moves.add(board[start.getRow()+1][start.getCol()+1]);
            }

       //dont forget to return!
       return moves;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        //return null;

        //start by declaring the arrayList we wish to return at the end
	    ArrayList<Square> moves = new ArrayList<Square>();

	    //make sure the squares we are adding are in bounds. (you’d also need to check to make sure they aren’t occupied by a piece unless it’s a piece of the opposite color in which case you can capture it. I leave this bit for you to figure out.
         

            if(start.getRow()-2>=0 && start.getCol()-2>=0){
                //if the square is a legal move add it to the list.    
                if (!b.getSquareArray()[start.getRow()-2][start.getCol()-2].isOccupied() || b.getSquareArray()[start.getRow()-2][start.getCol()-2].getOccupyingPiece().getColor()!= color) {                
                moves.add(b.getSquareArray()[start.getRow()-2][start.getCol()-2]);}
            }
            if(start.getRow()-1>=0 && start.getCol()-1>=0){
                //if the square is a legal move add it to the list.               
                if (!b.getSquareArray()[start.getRow()-1][start.getCol()-1].isOccupied() || b.getSquareArray()[start.getRow()-1][start.getCol()-1].getOccupyingPiece().getColor()!= color) {      
                moves.add(b.getSquareArray()[start.getRow()-1][start.getCol()-1]);}
            }
            if(start.getRow()-2>=0 && start.getCol()+2<8){
                //if the square is a legal move add it to the list.   
                if (!b.getSquareArray()[start.getRow()-2][start.getCol()+2].isOccupied() || b.getSquareArray()[start.getRow()-2][start.getCol()+2].getOccupyingPiece().getColor()!= color) {                  
                moves.add(b.getSquareArray()[start.getRow()-2][start.getCol()+2]);}
            }
            if(start.getRow()-1>=0 && start.getCol()+1<8){
                //if the square is a legal move add it to the list.                    
                if (!b.getSquareArray()[start.getRow()-1][start.getCol()+1].isOccupied() || b.getSquareArray()[start.getRow()-1][start.getCol()+1].getOccupyingPiece().getColor()!= color) { 
                moves.add(b.getSquareArray()[start.getRow()-1][start.getCol()+1]);}
            }
            if(start.getRow()+2<8 && start.getCol()-2>=0){
                //if the square is a legal move add it to the list.                    
                if (!b.getSquareArray()[start.getRow()+2][start.getCol()-2].isOccupied() || b.getSquareArray()[start.getRow()+2][start.getCol()-2].getOccupyingPiece().getColor()!= color) { 
                moves.add(b.getSquareArray()[start.getRow()+2][start.getCol()-2]);}
            }
            if(start.getRow()+1<8 && start.getCol()-1>=0){
                //if the square is a legal move add it to the list.                    
                if (!b.getSquareArray()[start.getRow()+1][start.getCol()-1].isOccupied() || b.getSquareArray()[start.getRow()+1][start.getCol()-1].getOccupyingPiece().getColor()!= color) { 
                moves.add(b.getSquareArray()[start.getRow()+1][start.getCol()-1]);}
            }
            if(start.getRow()+2<8 && start.getCol()+2<8){
                //if the square is a legal move add it to the list.   
                if (!b.getSquareArray()[start.getRow()+2][start.getCol()+2].isOccupied() || b.getSquareArray()[start.getRow()+2][start.getCol()+2].getOccupyingPiece().getColor()!= color) {                  
                moves.add(b.getSquareArray()[start.getRow()+2][start.getCol()+2]);}
            }
            if(start.getRow()+1<8 && start.getCol()+1<8){
                //if the square is a legal move add it to the list.     
                if (!b.getSquareArray()[start.getRow()+1][start.getCol()+1].isOccupied() || b.getSquareArray()[start.getRow()+1][start.getCol()+1].getOccupyingPiece().getColor()!= color) {                
                moves.add(b.getSquareArray()[start.getRow()+1][start.getCol()+1]);}
            }

       //dont forget to return!
       return moves;
    }
}
/**
 * Created by dmitry on 25.04.17.
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] percolationMatrix;

    private WeightedQuickUnionUF unionSites;

    private int numberOfOpenSites;

    private int size;

    private int xyTo1D(int row,int col){
        return (row)+(col);
    }

    private void validateIndices(int row, int col){
        if(row < 1 || row > size ){
            throw new IndexOutOfBoundsException("row index out of bounds");
        }
        if(col < 1 || col > size){
            throw new IndexOutOfBoundsException("col index out of bounds");
        }
    }

    private void connectToNeighbors(int row,int col){
        //Check row neighbors
        if(row > 1 && row < size){
            if(isOpen(row-1,col))
                unionSites.union(xyTo1D(row,col),xyTo1D(row-1,col));
            if(isOpen(row+1,col))
                unionSites.union(xyTo1D(row,col),xyTo1D(row+1,col));
        }
        else if(row == 1){
            if(isOpen(row+1,col))
                unionSites.union(xyTo1D(row,col),xyTo1D(row+1,col));
        }
        else{
            if(isOpen(row-1,col))
                unionSites.union(xyTo1D(row,col),xyTo1D(row-1,col));
        }

        //check coll neighbors
        if(col > 1 && col < size){
            if(isOpen(row,col-1))
                unionSites.union(xyTo1D(row,col),xyTo1D(row,col-1));
            if(isOpen(row,col+1))
                unionSites.union(xyTo1D(row,col),xyTo1D(row,col+1));
        }
        else if(col == 1){
            if(isOpen(row,col+1))
                unionSites.union(xyTo1D(row,col),xyTo1D(row,col+1));
        }
        else{
            if(isOpen(row,col-1))
                unionSites.union(xyTo1D(row,col),xyTo1D(row,col-1));
        }
    }

    public Percolation(int n){
        if (n <= 0){
            throw new IllegalArgumentException("n less than 1");
        }

        size = n;
        percolationMatrix = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j <n; j++)
                percolationMatrix[i][j] = -1; // -1 state means that cell is blocked
        }

        unionSites = new WeightedQuickUnionUF((n*n)+2);

        int virtstart = 0;
        int virtStop = n*n+1;
        for(int i = 1; i<=n; i++){
            unionSites.union(virtstart,i);
            unionSites.union(virtStop,virtStop - i);
        }

        numberOfOpenSites = 0;
    }

    public void open(int row, int col){
        validateIndices(row,col);

        if(percolationMatrix[row-1][col-1] == -1){
            percolationMatrix[row-1][col-1] = 1;
            numberOfOpenSites +=1;
        }

        connectToNeighbors(row,col);



    }
    public boolean isOpen(int row, int col){
        validateIndices(row,col);

        if (percolationMatrix[row-1][col-1] == 1){
            return true;
        }
        else
            return false;
    }

    public boolean isFull(int row,int col){
        validateIndices(row,col);
        return isOpen(row,col)&&unionSites.connected(xyTo1D(row,col),0);

    }

    public int numberOfOpenSites(){
        return numberOfOpenSites;
    }

    public boolean percolates(){
        return unionSites.connected(0,size*size+1);
    }

}

/**
 * Created by dmitry on 26.04.17.
 */

import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    private Percolation perc;

    private int size;

    private int trials;

    private double [] stat;

    private void startTrial(){
        for(int i =0; i < trials; i++) {
            while (!perc.percolates()) {
                perc.open(StdRandom.uniform(1, size), StdRandom.uniform(1, size));
            }

            int a = perc.numberOfOpenSites();

            stat[i] = a / (size*size);

        }
    }

    public PercolationStats(int n, int count){
        if(n <= 0 || count <= 0){
            throw new IllegalArgumentException("Incorrect parameters");
        }

        size = n;

        trials = count;

        perc = new Percolation(n);

        stat = new double[trials];

        startTrial();

    }

    public double mean(){
        double mean = StdStats.mean(stat);
        return mean;

    }

    public double stddev(){
        double dev = StdStats.stddev(stat);

        return 0;

    }

    public double confidenceLo() {
        double lowBorder = mean() - (1.96*stddev()/Math.sqrt(trials));
        return lowBorder;

    }
    public double confidenceHi(){
        double hightBorder = mean() + (1.96*stddev()/Math.sqrt(trials));
        return 0;

    }
}

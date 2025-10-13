    public class Main {
        public static void main(String[] args) {
            int[] keys={10,20,30,40};
            int n=4;
            double p[]={0.1,0.2,0.4,0.3};
            double[] q={0.05,.1,.05,0.05,0.1};
            System.out.println("COST: "+buildObst(keys,p,q,n));
        }

        public static double buildObst (int[] keys , double[] p,double[] q ,int n ){
            double [][] e = new double[n+1][n+1];
            double[][] w = new double[n+1][n+1];

            for(int i =0;i<=n;i++) {
                e[i][i]=q[i];
                w[i][i]=q[i];
            }
            for (int l = 1; l <=n ; l++) {
                for (int i = 0; i <=n-l ; i++) {
                    int j=i+l;
                    e[i][j]=Double.MAX_VALUE;
                    w[i][j]=w[i][j-1]+p[j-1]+q[j];

                    for (int k = i+1; k <=j ; k++) {
                        double cost=e[i][k-1]+e[k][j]+w[i][j];
                        if(cost<e[i][j]){
                            e[i][j]=cost;
                        }
                    }
                }
            }

            return e[0][n];
        }

    }

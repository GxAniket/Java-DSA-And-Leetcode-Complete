class Main {
    public static void main(String[] args) {
        
        int n = 10;
        int a= n-1;
        int m = (2*n+1)/2;
        for(int i=0;i<n;i++){
            for(int j=0;j<2*n;j++){
                if((j>=m-a)&&(j<=m+a)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
                
            }
            a--;
            System.out.println(" ");
            
        }
        
        for(int i=0;i<3;i++){
            for(int j=0;j<2*n;j++){
                if((j>=m-2)&&(j<=m+2)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
                
            }
            System.out.println(" ");
            
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<2*n;j++){
                if((j>=m-i)&&(j<=m+i)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
                
            }
            System.out.println(" ");
            
        }
    }
}
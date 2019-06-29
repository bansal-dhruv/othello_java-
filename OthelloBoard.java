public class OthelloBoard {

	private int board[][];
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public OthelloBoard() {
		board = new int[8][8];
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
	}

	public void print() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean move(int symbol, int x, int y){
      
  	boolean check=false;
        int cnt=0 , opp=1;
      
        if(symbol==1)
      		opp=2;
      	else
        	opp=1;

	int xdir[]= {-1,-1,0,1,1,1,0,-1};
	int ydir[]= {0,1,1,1,0,-1,-1,-1};
     
      
      	if( x>=8 || y>=8 ||x<0 ||y<0 || board[x][y]==opp || board[x][y]==symbol )
          return false;
      
		for(int z=0;z<xdir.length;z++)
		{
			cnt=0;
			for(int i=1; (x + i*xdir[z])>=0 && (x + i*xdir[z])<8 && (y+i*ydir[z])<8 && (y+i*ydir[z])>=0;i++)
			{
			
              	if( (i*xdir[z]!=0 || i*ydir[z]!=0) && board[x + i*xdir[z]][y+i*ydir[z]]==0)
                  break;
				else if( board[x + i*xdir[z]][y+i*ydir[z]]==opp)
                  cnt++;
              	else if(cnt==0)
                  break;
              	else if( board[x + i*xdir[z]][y+i*ydir[z]]==symbol && cnt!=0)
                {
                  	int j=0;
                     while(  j<=i)//board[x + j*xdir[z]][y+j*ydir[z]]!=symbol)
                    {
                       board[x + j*xdir[z]][y+j*ydir[z]]=symbol;
                      j++;
                    }
                  	check=true;
                  	break;
                }
              	else 
                  break;                  
			}
		}      
      return check;     
      
	}
}


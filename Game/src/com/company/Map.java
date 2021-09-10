package com.company;

public class Map {
    String[][] x;
    String[] goal;
    String[] stoune;

    public Map() {
        this.x = new String[5][5];
        this.goal=new String[5];
        this.stoune=new String[15];
    }

    public void stouneGeneration(){
        for (int i = 0; i <5 ; i++) {
            stoune[i]="0";
        }
        for (int i = 5; i <10 ; i++) {
            stoune[i]="1";
        }
        for (int i = 10; i <15 ; i++) {
            stoune[i]="2";
        }
        String prom;
        int first;
        int second;
        for (int i = 0; i <100 ; i++) {
            first=(int)(Math.random()*14);
            second=(int)(Math.random()*14);
            prom=stoune[first];
            stoune[first]=stoune[second];
            stoune[second]=prom;
        }
    }

    public void testerzap(){
        int counter=0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length ; j++) {
                if (i%2==0){
                x[j][i]=stoune[counter];
                counter++;}
                else{
                    if (j%2==0)
                        x[j][i]="X";
                    else
                        x[j][i]="-";
                }
            }
        }

    }

    public void zapGoa(){
        int first=(int)(Math.random()*3);
        int second=(int)(Math.random()*3);
        int third=(int)(Math.random()*3);
        while(first==second)
            second=(int)(Math.random()*3);
        while (third==first||third==second)
            third=(int)(Math.random()*3);

        goal[0]=Integer.toString(first);
        goal[2]=Integer.toString(second);
        goal[4]=Integer.toString(third);

        goal[1]="_";
        goal[3]="_";
    }

    public void shovMap(){
        for (int i = 0; i < goal.length; i++) {
            System.out.print(goal[i]+" ");
        }
        System.out.println();
        System.out.print("= = = = =");
        for (int i = 0; i < x.length; i++) {
            System.out.println();
            for (int j = 0; j < x.length ; j++) {
                System.out.print(x[i][j]+" ");
            }
        }
        System.out.println();;
    }

    public void swapPosition(int x1, int y1, int x2, int y2) {
        boolean neybor=false;
        boolean inrange=false;
        if ((x1>=0 && x1 <=4)&&(x2>=0 && x2 <=4)&&(y1>=0 && y1 <=4)&&(y2>=0 && y2 <=4))
            inrange=true;
        if (( Math.abs(x1-x2)==0&& Math.abs(y1-y2)==1 )||( Math.abs(x1-x2)==1&& Math.abs(y1-y2)==0 ))
            neybor=true;
        if ( inrange &&x[x2][y2].equals("-") && !x[x1][y1].equals("X") && neybor ){
            x[x2][y2]=x[x1][y1];
            x[x1][y1]="-";
        }
        else {
            System.out.println("неверные координаты");
        }
    }

    public boolean nextTurn() {
        boolean firstСolumn=false;
        boolean secondСolumn=false;
        boolean thirdСolumn=false;
        for (int i = 0; i <x.length ; i=i+2) {
            for (int j = 0; j <x.length ; j++) {
                if (!x[j][i].equals(goal[i])) {
                    System.out.println(i+" "+j+" "+goal[i]+" "+x[j][i]);
                    return true;}
            }
        }
        System.out.println("конец");
        return false;
    }
}

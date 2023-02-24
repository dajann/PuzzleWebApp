package com.example.demo.controller.model;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;



public class PuzzleGame {
    public Integer buttons[];
    int x;
    
    public PuzzleGame() {
        do{
        	buttons = createShuffleArray();
            expand(buttons);
        }while(!isSolvable());
    }
    
    public Integer[] createShuffleArray(){
        Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

		List<Integer> intList = Arrays.asList(intArray);

		Collections.shuffle(intList);

		intList.toArray(intArray);
                return intArray;
        }
    public boolean isSolvable(){
        int countInversions = 0;
        
        for(int i = 0; i < 15; i++)
            for(int j = 0; j < i; j++)
            {
                if(buttons[j] > buttons[i])
                    countInversions++;
            }
        return countInversions % 2 == 0;
    }
    public void expand(Integer[] OrigArray) {
        Integer[] newArray = new Integer[OrigArray.length + 1];
        System.arraycopy(OrigArray, 0, newArray, 0, OrigArray.length);
        OrigArray = newArray;
        buttons = newArray;
        buttons[15] = 0;
    }
    public Boolean checkWin(){
        if(buttons[0] == 1 && buttons[1] == 2 && buttons[2] == 3 && buttons[3] == 4 && buttons[4] == 5
        		&& buttons[5] == 6 && buttons[6] == 7 && buttons[7] == 8 && buttons[8] == 9 && buttons[9] == 10
        		&& buttons[10] == 11 && buttons[11] == 12 && buttons[12] == 13 && buttons[13] == 14 && buttons[14] == 15
        		&& buttons[15] == 0){
            return true;
        }
        return false;
    }

    public void button2Action(int x) {
        if(x == 2){
            if(buttons[2] != 0){
                if(buttons[1] == 0){
                	buttons[1] = buttons[2];
                	buttons[2] = 0;
                        }
                else if(buttons[3] == 0){
                	buttons[3] = buttons[2];
                	buttons[2] = 0;
                        }
                else if(buttons[6] == 0){
                	buttons[6] = buttons[2];
                	buttons[2] = 0;
                        }
                checkWin();
            }
        }
    }

    public void  button0Action(int x) {
        if(x == 0){
            if(buttons[0] != 0){
                if(buttons[1] == 0){
                	buttons[1] = buttons[0];
                	buttons[0] = 0;
                        }
                else if(buttons[4] == 0){
                    buttons[4] = buttons[0];
                    buttons[0] = 0;}
                checkWin();
            }
        }
    }

    public void button3Action(int x) {
        if(x == 3){
            if(buttons[3] != 0){
                if(buttons[2] == 0){
                	buttons[2] = buttons[3];
                	buttons[3] = 0;
                        }
                else if(buttons[7] == 0){
                	buttons[7] = buttons[3];
                	buttons[3] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button1Action(int x) {
    	 if(x == 1){
             if(buttons[1] != 0){
                 if(buttons[0] == 0){
                 	buttons[0] = buttons[1];
                 	buttons[1] = 0;
                         }
                 else if(buttons[2] == 0){
                 	buttons[2] = buttons[1];
                 	buttons[1] = 0;
                         }
                 else if(buttons[5] == 0){
                 	buttons[5] = buttons[1];
                 	buttons[1] = 0;
                         }
                 checkWin();
             }
         }
    }

    public void button5Action(int x) {
        if(x == 5){
            if(buttons[5] != 0){
                if(buttons[1] == 0){
                	buttons[1] = buttons[5];
                    buttons[5] = 0;
                        }
                else if(buttons[4] == 0){
                	buttons[4] = buttons[5];
                	buttons[5] = 0;
                        }
                else if(buttons[6] == 0){
                	buttons[6] = buttons[5];
                	buttons[5] = 0;
                        }
                else if(buttons[9] == 0){
                	buttons[9] = buttons[5];
                	buttons[5] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button4Action(int x) {
        if(x == 4){
            if(buttons[4] != 0){
                if(buttons[0] == 0){
                	buttons[0] = buttons[4];
                	buttons[4] = 0;
                        }
                else if(buttons[5] == 0){
                	buttons[5] = buttons[4];
                	buttons[4] = 0;
                        }
                else if(buttons[8] == 0){
                   buttons[8] = buttons[4];
                   buttons[4] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button6Action(int x) {
        if(x == 6){
            if(buttons[6] != 0){
                if(buttons[2] == 0){
                	buttons[2] = buttons[6];
                	buttons[6] = 0;
                        }
                else if(buttons[5] == 0){
                	buttons[5] = buttons[6];
                	buttons[6] = 0;
                        }
                else if(buttons[7] == 0){
                	buttons[7] = buttons[6];
                	buttons[6] = 0;
                        }
                else if(buttons[10] == 0){
                	buttons[10] = buttons[6];
                	buttons[6] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button7Action(int x) {
        if(x == 7){
            if(buttons[7] != 0){
                if(buttons[3] == 0){
                	buttons[3] = buttons[7];
                	buttons[7] = 0;
                        }
                else if(buttons[6] == 0){
                	buttons[6] = buttons[7];
                	buttons[7] = 0;
                        }
                else if(buttons[11] == 0){
                	buttons[11] = buttons[7];
                	buttons[7] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button8Action(int x) {
        if(x == 8){
            if(buttons[8] != 0){
                if(buttons[4] == 0){
                	buttons[4] = buttons[8];
                	buttons[8] = 0;
                        }
                else if(buttons[9] == 0){
                	buttons[9] = buttons[8];
                	buttons[8] = 0;
                }
                else if(buttons[12] == 0){
                	buttons[12] = buttons[8];
                	buttons[8] = 0;
                }
                checkWin();
            }
        }
    }

    public void button9Action(int x) {
        if(x == 9){
            if(buttons[9] != 0){
                if(buttons[8] == 0){
                	buttons[8] = buttons[9];
                	buttons[9] = 0;
                        }
                else if(buttons[5] == 0){
                	buttons[5] = buttons[9];
                	buttons[9] = 0;
                        }
                else if(buttons[10] == 0){
                	buttons[10] = buttons[9];
                	buttons[9] = 0;
                        }
                else if(buttons[13] == 0){
                	buttons[13] = buttons[9];
                	buttons[9] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button10Action(int x) {
        if(x == 10){
            if(buttons[10] != 0){
                if(buttons[9] == 0){
                	buttons[9] = buttons[10];
                	buttons[10] = 0;
                        }
                else if(buttons[6] == 0){
                	buttons[6] = buttons[10];
                	buttons[10] = 0;
                        }
                else if(buttons[11] == 0){
                    buttons[11] = buttons[10];
                    buttons[10] = 0;
                        }
                else if(buttons[14] == 0){
                	buttons[14] = buttons[10];
                	buttons[10] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button11Action(int x) {
        if(x == 11){
            if(buttons[11] != 0){
                if(buttons[7] == 0){
                	buttons[7] = buttons[11];
                	buttons[11] = 0;
                        }
                else if(buttons[10] == 0){
                	buttons[10] = buttons[11];
                	buttons[11] = 0;
                        }
                 else if(buttons[15] == 0){
                	 buttons[15] = buttons[11];
                	 buttons[11] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button12Action(int x) {
        if(x == 12 ){
            if(buttons[12] != 0){
                if(buttons[8] == 0){
                	buttons[8] = buttons[12];
                	buttons[12] = 0;
                        }
                else if(buttons[13] == 0){
                	buttons[13] = buttons[12];
                	buttons[12] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button13Action(int x) {
        if(x == 13){
            if(buttons[13] != 0){
                if(buttons[12] == 0){
                	buttons[12] = buttons[13];
                	buttons[13] = 0;
                        }
                else if(buttons[9] == 0){
                	buttons[9] = buttons[13];
                	buttons[13] = 0;
                        }
                else if(buttons[14] == 0){
                	buttons[14] = buttons[13];
                	buttons[13] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button14Action(int x) {
        if(x == 14){
            if(buttons[14] != 0){
                if(buttons[13] == 0){
                	buttons[13] = buttons[14];
                	buttons[14] = 0;
                        }
                else if(buttons[10] == 0){
                	buttons[10] = buttons[14];
                	buttons[14] = 0;
                        }
                else if(buttons[15] == 0){
                	buttons[15] = buttons[14];
                	buttons[14] = 0;
                        }
                checkWin();
            }
        }
    }

    public void button15Action(int x) {
        if(x == 15){
            if(buttons[15] != 0){
                if(buttons[11] == 0){
                	buttons[11] = buttons[15];
                	buttons[15] = 0;
                        }
                else if(buttons[14] == 0){
                	buttons[14] = buttons[15];
                	buttons[15] = 0;
                        }
                checkWin();
            }
        }
    }
}
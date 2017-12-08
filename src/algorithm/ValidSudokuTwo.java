package algorithm;

import java.util.HashMap;
import java.util.Map;

public class ValidSudokuTwo {
    public boolean isValidSudoku(char[][] board) {
        boolean vFlag=true;
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for (int i=1;i<10;i++){
            map.put((char)(i+48),0);
        }
        //hengzhe
        for (int i=0;i<9;i++){
            Map<Character,Integer> mapTemp=map;
            for (int j=0;j<9;j++){
                if (!mapTemp.containsKey(board[i][j]))
                {
                    map.replace(board[i][j],1);
                }
                else
                    return false;
            }
        }
        //shuzhe
        for (int i=0;i<9;i++){
            Map<Character,Integer> mapTemp=map;
            for (int j=0;j<9;j++){
                if (!mapTemp.containsKey(board[j][i]))
                {
                    map.replace(board[j][i],1);
                }
                else
                    return false;
            }
        }
        //jiugongge

        return vFlag;
    }
}

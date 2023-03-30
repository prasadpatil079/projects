import org.example.DFS;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class NewClass extends JFrame {
    private int [][]maze=

                {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 9, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                };
        public List<Integer> path=new ArrayList<>();

        public NewClass(){
            setTitle("Maze Solver");
            setSize(500,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DFS.searcgpath(maze,1,1,path);

        }
        @Override
        public void paint(Graphics g){
            g.translate(55,110);
         for(int i=0;i<maze.length;i++){
           for(int j=0;j<maze[0].length;j++){
               Color color;
               switch(maze[i][j]){
                   case 1: color=Color.black;break;
                   case 9: color=Color.red;break;
                   default: color=Color.white;break;
               }
               g.setColor(color);
               g.fillRect(30*j,30*i,30,30);
               g.setColor(color.RED);
               g.drawRect(30*j,30*i,30,30);
           }
         }
         for(int i=0;i<path.size();i=i+2){
             int pathx=path.get(i);
             int pathy=path.get(i+1);
             System.out.println( " xco "+pathx);
             System.out.println( " yco "+pathy);

             g.setColor(Color.blue);
             g.fillRect(30*pathx,30*pathy,20,20);
         }
        }
        public static void main(String[] args){
            NewClass view= new NewClass();
            view.setVisible(true);
        }
}

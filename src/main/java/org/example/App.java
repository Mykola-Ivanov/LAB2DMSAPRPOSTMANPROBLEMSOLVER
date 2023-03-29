package org.example;

import java.io.FileNotFoundException;

public class App
{
    static String path = "src\\main\\resources\\L2_2.txt";
    public static void main( String[] args )
    {
        try {
            int[][] graph = new GraphLoader(path ,true).getAdjacencyMatrix();
            FleuryAlgorithm fa = new FleuryAlgorithm(graph);
            var path_list = fa.findEulerPath();

            System.out.println("Послідовність ребер:");
            path_list.stream().forEach(i-> System.out.print(i.beginVertex +"->"+i.endVertex +"\t"));
            System.out.println();
            var graph_copy =  new GraphLoader(path,false).getAdjacencyMatrix();
            PathChecker checker = new PathChecker(graph_copy);

            path_list = checker.checkPath(path_list);
            System.out.println("\nЕйлерів маршрут");
            path_list.stream().forEach(i-> System.out.print(i.beginVertex +"->"+i.endVertex +"\t"));//"+i.weight+"

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

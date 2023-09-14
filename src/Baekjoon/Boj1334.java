//package Baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Boj1334 {
//
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        Stack<Integer> stack = new Stack<>();
//        Queue<Integer> queue = new LinkedList<>();
//
//        int numOfVertex = sc.nextInt();
//        int numOfEdge = sc.nextInt();
//        int startVertex = sc.nextInt();
//
//        ArrayList<Integer>[] list = new ArrayList[numOfVertex + 1];
//
//        for (int i = 0; i <= numOfVertex; i++) list[i] = new ArrayList<>();
//
//        for (int i = 1; i <= numOfEdge; i++) {
//            int v1 = sc.nextInt();
//            int v2 = sc.nextInt();
//
//            list[v1].add(v2);
//        }
//
//        for (int i = 1; i <= numOfVertex; i++) {
//            System.out.print("list[" + i + "]: ");
//            for (Integer value : list[i]) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }
//
//        while (!stack.isEmpty()) {
//            stack.push(startVertex);
//
//            if (list[startVertex].get(0) != null) {
//                stack.push(list[startVertex].get(idx));
//                startVertex = (list[startVertex].get(idx));
//                list[startVertex].remove(idx);
//            } else {
//                startVertex = stack.pop();
//            }
//
//            System.out.println(stack.peek());
//        }
//
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }
//    }
//}

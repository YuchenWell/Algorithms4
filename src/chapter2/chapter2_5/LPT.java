package chapter2.chapter2_5;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;

public class LPT {
  public static void main(String[] args) {
    // 处理器数量
    int M = Integer.parseInt(args[0]);
    // 任务数量
    int N = StdIn.readInt();

    // 创建任务数组
    Job[] jobs = new Job[N];
    for (int i = 0; i < N; i++) {
      jobs[i] = new Job(StdIn.readString(), StdIn.readDouble());
    }

    // 任务数组按运行的时间长短排序，时间长的在前。
    Arrays.sort(jobs);

    // 创建最大容量为M的优先队列 (processor的数量为M)
    MinPQ<Processor> processorPQ = new MinPQ<>(M);

    // 将所有的processor放进优先队列
    for (int i = 0; i < M; i++) {
      processorPQ.insert(new Processor());
    }

    // 遍历任务，总是将任务安排到总运行时间最短的processor中
    for (int i = N - 1; i >= 0; i--) {
      // 获得当前总运行时间最短的processor
      Processor processor = processorPQ.delMin();
      // 将任务安排的总运行时间最短的processor
      processor.insert(jobs[i]);
      // 将processor重新放回优先队列
      processorPQ.insert(processor);
    }

    // 打印processor的内容
    for (int i = 0; !processorPQ.isEmpty(); i++) {
      Processor processor = processorPQ.delMin();
      ArrayList<Job> jobList = processor.getJobs();
      System.out.println("Processor " + i + ":");
      for (int j = 0; j < jobList.size(); j++) {
        System.out.println(jobList.get(j));
      }
    }
  }
}

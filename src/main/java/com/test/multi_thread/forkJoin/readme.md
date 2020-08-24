

## Fork/Join并行执行任务框架

它的主要作用是把大任务分割成若干个小任务，再对每个小任务得到的结果进行汇总，此种开发方法也叫分治编程

Fork-Join使用了“工作窃取（work-stealing）”算法，它是指某个线程从其他队列里窃取任务来执行，

在JDK1.7中实现分治编程需要使用`ForkJoinPool`类，此类的主要作用是创建一个任务池

类`ForkJoinPool`所提供的功能是一个任务池，而执行具体任务却不是ForkJoinPool，而是`ForkJoinTask`类
`ForkJoinTask`是抽象类，不能实例化，所以需要该类的3个子类`CountedCompleter`、`RecursiveAction`和`RecursiveTask`来实现具体功能。